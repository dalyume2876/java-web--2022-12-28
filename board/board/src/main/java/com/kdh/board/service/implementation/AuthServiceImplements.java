package com.kdh.board.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.kdh.board.common.constant.ResponseMessage;
import com.kdh.board.dto.request.auth.SignInDto;
import com.kdh.board.dto.request.auth.SignUpDto;
import com.kdh.board.dto.response.ResponseDto;
import com.kdh.board.dto.response.auth.SignInResponseDto;
import com.kdh.board.dto.response.auth.SignUpResponseDto;
import com.kdh.board.entity.UserEntity;
import com.kdh.board.provider.TokenProvider;
import com.kdh.board.repository.UserRepository;
import com.kdh.board.service.AuthService;

@Service
public class AuthServiceImplements implements AuthService {
    
    @Autowired private UserRepository userRepository;
    @Autowired private TokenProvider tokenProvider;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public ResponseDto<SignUpResponseDto> signUp(SignUpDto dto){

        SignUpResponseDto data = null;

        String email = dto.getEmail();
        String telNumber = dto.getTelNumber();
        String password = dto.getPassword();

        UserEntity userEntity = new UserEntity(dto);

        try {
            boolean hasEmail = userRepository.existsByEmail(email);
            if(hasEmail) return ResponseDto.setFailed(ResponseMessage.EXIST_EMAIL);

            boolean hasTelNumber = userRepository.existsByTelNumber(telNumber);
            if(hasTelNumber) return ResponseDto.setFailed(ResponseMessage.EXIST_TEL_NUMBER);

            String encodedPassword = passwordEncoder.encode(password);
            userEntity.setPassword(encodedPassword);
            userRepository.save(userEntity);

            data = new SignUpResponseDto(true);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);

    }

    public ResponseDto<SignInResponseDto> signIn(SignInDto dto){

        UserEntity userEntity = null;

        SignInResponseDto data = null;

        String email = dto.getEmail();
        String password = dto.getPassword();

        try {
            userEntity = userRepository.findByEmail(email);
            if (userEntity == null) return ResponseDto.setFailed(ResponseMessage.FAIL_SIGN_IN);

            boolean isEqualPassword = passwordEncoder.matches(password, userEntity.getPassword());
            if (!isEqualPassword) return ResponseDto.setFailed(ResponseMessage.FAIL_SIGN_IN);


        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }

        try {
            String token = tokenProvider.create(email);
            data = new SignInResponseDto(userEntity, token);
        } catch(Exception exception) {
            exception.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.FAIL_SIGN_IN);
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
    }
}
