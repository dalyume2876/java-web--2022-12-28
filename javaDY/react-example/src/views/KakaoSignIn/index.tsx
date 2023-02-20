import { Alert } from '@mui/material'
import React, { useState } from 'react'
import './style.css'

export default function KakaoSignIn() {

    const [email, setEmail] = useState<string>("");

  return (
    <div className='kakao-container'>
        {/* 로그인 폼 레이아웃 */}
        <div className='kakao-login-form'>
            {/* 로고 레이아웃 */}
            <div className='kakao-logo'>
                <div className='kakao-logo-img'></div>
            </div>
            {/* 로그인 레이아웃 */}
            <div className='kakao-login'>
                {/* 인풋 레이아웃 */}
                <div className='kakao-input-layout'>
                    {/* 아이디 인풋 */}
                    <div className='kakao-input-box'>
                        <input className='kakao-input' type='text' placeholder='카카오메일 아이디, 이메일, 전화번호' onChange={(event) => setEmail(event.target.value)}/>
                    </div>
                    { email  && (
                        <Alert severity="info">카카오메일이 있다면 메일 아이디만 입력해 보세요.</Alert>
                    )}
                    {/* 비밀번호 인풋 */}
                    <div className='kakao-input-box'>
                        <input className='kakao-input' type='password' placeholder='비밀번호'/>
                    </div>
                    {/* 로그인 상태 유지 인풋 */}
                    <div className='kakao-checkbox-box'>
                        <input className='kakao-checkbox' type='checkbox'/> 
                        {' 로그인 상태 유지 '}
                    </div>
                </div>
                {/* 버튼 레이아웃 */}
                <div className='kakao-button-layout'>
                    {/* 로그인 버튼 */}
                    <button type='button' className='kakao-login-button'>로그인</button>
                    <div className='kakao-divider'></div>
                    {/* QR코드로 로그인 버튼 */}
                    <button type='button' className='kakao-qr-button'>QR코드로 로그인</button>
                </div>
                {/* 링크 레이아웃 */}
                <div className='kakao-link-layout'>
                    {/* 회원가입 링크 */}
                    <a className='kakao-link' href="https://accounts.kakao.com/weblogin/create_account?app_type=web&continue=https%3A%2F%2Fkauth.kakao.com%2Foauth%2Fauthorize%3Fproxy%3DeasyXDM_Kakao_pbbcdj1ij5a_provider%26ka%3Dsdk%252F1.43.1%2520os%252Fjavascript%2520sdk_type%252Fjavascript%2520lang%252Fko-KR%2520device%252FWin32%2520origin%252Fhttps%25253A%25252F%25252Fwww.epis.or.kr%26origin%3Dhttps%253A%252F%252Fwww.epis.or.kr%26response_type%3Dcode%26redirect_uri%3Dkakaojs%26state%3D6avipjeofoszzg4zqy1c7h%26through_account%3Dtrue%26client_id%3D950f3ae1f2f550e5ba7ff7d9fffc7781&lang=ko">회원가입</a>
                    {/* 정보찾기 링크 */}
                    <a className='kakao-link' href="https://accounts.kakao.com/weblogin/find_password?app_type=web&continue=https%3A%2F%2Fkauth.kakao.com%2Foauth%2Fauthorize%3Fproxy%3DeasyXDM_Kakao_pbbcdj1ij5a_provider%26ka%3Dsdk%252F1.43.1%2520os%252Fjavascript%2520sdk_type%252Fjavascript%2520lang%252Fko-KR%2520device%252FWin32%2520origin%252Fhttps%25253A%25252F%25252Fwww.epis.or.kr%26origin%3Dhttps%253A%252F%252Fwww.epis.or.kr%26response_type%3Dcode%26redirect_uri%3Dkakaojs%26state%3D6avipjeofoszzg4zqy1c7h%26through_account%3Dtrue%26client_id%3D950f3ae1f2f550e5ba7ff7d9fffc7781&lang=ko">정보찾기</a>
                </div>
            </div>
        
        </div>
    
    </div>

  )
}
