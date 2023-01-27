#Board 데이터베이스 만들기
create database PEED;
use PEED;

#User 테이블 생성
create table User (
	id INT primary key auto_increment, 		# 아이디 / 정수형태 / 기본키 / 자동 증가 
    password varchar(30) not null, 	   		# 패스워드 / 길이 30의 가변문자열 / 필수 값
    name varchar(50) not null,		   		# 이름 / 길이 50의 가변 문자열 / 필수 값
    telNumber varchar(15) not null unique	# 전화번호 / 길이 15의 가변 문자열 / 필수 값 / 중복 불가능
);

# Board 테이블 생성
#게시물 번호(BoardNumber)가 존재하고, 정수현태 및 자동 증가로 관리,
#게시물 번호로 각 데이터를 구분
#게시물 제목(boardTitle)이 존재하고 200의 가변 문자열 및 필수 값으로 관리
#게시물 내용(boardContent)이 존재하고 길이의 제한이 없는 문자열 및 필수 값으로 관리.
#게시물 작성일(boardDate)이 존재하고 날짜 타입 및 필수 값으로 관리 
#게시물 작성자(boardWriter)가 존재하고 정수 형태 및 필수 값으로 관리

create table Board(
	boardNumber int auto_increment primary key,
    boardTitle varchar(200) not null,
    boardContent text not null,
    boardDate date not null,
    boardWriter int not null
);

