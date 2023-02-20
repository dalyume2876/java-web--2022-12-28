//파일명이 index.확장자 일 경우
// 해당 파일이 속해 있는 폴더명으로 import가 가능

import BirthInputGroup from 'src/components/BirthInputGroup';
import ButtonGroup from 'src/components/ButtonGroup';
import InputGroup from 'src/components/InputGroup';
import './style.css'
// 한줄 주석
/* 공간 주석 가능*/

//java method 생성
//접근제어자 기타제어자 반환타입 메서드명(파라미터)

//typescript method 생성
//1. function 메서드명(파이미터[: 파라미터 타입]) [: 반환 타입] {...}
//2. 자바스크립트, 타입스크립트는 메서드를 변수로 인식
//   const 메서드명 = (파라미터[: 파라미터 타입]) [: 반환타입] => {...}


  //typescript의 데이터타입
  //숫자 타입 :number
  //문자열 타입 : String
  //논리타입 : boolean

  //typescript의 변수 선언 방식
  // var : 변수, let : 변수, const : 상수

  //java에서의 변수 선언
  //접근제어자 기타제어자 데이터타입 변수명

  //typescript에서의 변수 선언
  //var 변수명; | let 변수명 : 데이터타입;

  // var tmp;
  // let tmp2 : number;
  // let tmp4 : 10;
  // //typescript 에서의 상수 선언
  // //const 상수명 = 값;
  // const tmp3 = 'constant';

  // //typescript에서의 비교연산자
  
  //   let a : any = 10;
  //   let b : any = '10';
  
    
  //   //==, != : 값만 비교
  //   //alert(a === b);

  //   //===, !== : 값과 타입까지 비교 (>== - 이런 형태는 존재하지 않는다)

  // //typescript에서의 나눗셈 연산
  // let tmp5 = 10/3;
  // alert(tmp5); 

  function NaverSignIn() {
//!return에는 하나의 태그만 올 수 있음
//? 확장자가 .jsx / .tsx 일 때
//? 함수형 컴포넌트의 return에서 ()로
//? html 태그를 사용 할 수 있음.
//? return의 ()안에서 typescript 문법을 사용하고 싶다면
//? {}안에 작성

    return (
      <div>
        {/* <InputGroup /> */}
      {/* 가운데 레이아웃 */}
      <div>
          {/* 로고 레이아웃 */}
          <div id="logo-container">
              <a id="logo" href="https://naver.com">
                  NAVER
              </a>
          </div>
          {/* 컨테이너 레이아웃 */}
          <div id="container">
            {/*//^함수형 컴포넌트에 매개변수를 전달할 때는 */}
            {/*//^html 태그에서 속성 값을 지정하는 방식과 동일하게 사용 */}
              {/* 아이디 레이아웃 */}
              <InputGroup label='아이디' type='text'/>
              {/* 비밀번호 레이아웃 */}
              <InputGroup label='비밀번호' type='password'/>
              {/* 비밀번호 확인 레이아웃 */}
              <InputGroup label='비밀번호 확인' type='password'/>
              {/* 이름 레이아웃 */}
              <InputGroup label='이름' type='text'/>
              {/* 생년월일 레이아웃 */}
              <BirthInputGroup/>
              {/* 버튼 레이아웃 */}
              <ButtonGroup/>
          </div>
      </div>
  </div>
  );
}

//^(2)
const Description = () => {
  //^ {} 밑 공간은 TypeScript를 인식

  //^ return의 ()에는 html을 인식
  //^ return의 () 안에서 typescript를 사용하려면 {}로 해당 구문을 감싼다

  //^ {} 안에서 html 태그를 사용하려면 return()의 괄호 안에 작성
  return (
    <div></div>
  );
}

export default NaverSignIn;
