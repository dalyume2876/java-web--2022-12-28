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

#User레코드를 삽입
#아이디는 자동값을 그대로 사용, 
#비밀번호는 'P!ssw0rd', 이름 : '고길동', 전화번호는 '010-4488-9944'인 데이터를 생성

# -- 회원가입 할 때 사용 --
insert into User(password, name, telNumber) values ('P!ssw0rd', '고길동', '010-4488-9944');
select * from User;

# User 테이블에서 이름이 '고길동'인 레코드의 비밀번호를 'qwer1234!!'로 수정 

#각종 회원 정보 수정시 사용
update User set password = 'qwer1234!!' where name = '고길동';

#User 테이블에서 id가 1인 레코드를 삭제한다.
delete from User where id = 3;

insert into Board(boardTitle, boardContent, boardDate, boardWriter)
values('안녕히 가세요.', '안녕하세요. 반갑습니다. 안녕히 가세요.', '2023-01-11', 3);

select * from Board;

#게시물 새로 작성 
#최신 글 순으로 보기
select * from Board order by boardDate desc;

#오래된 글 순으로 보기
select * from Board order by boardDate asc;

#10일 이내에 작성된 글 보기
select * from Board where boardDate >= '2023-01-08';

#10일 이내에 작성된 글을 최신순으로 보기
select * from Board where boardDate >= '2023-01-08' order by boardDate desc;

# 작성자가 1 이면서 10이내에 작성된 글을 최신 순으로 보기
select * from Board where boardWriter = 1 and boardDate >= '2023-01-08' order by boardDate desc;

#게시물 새로 작성
#게시물 제목에 '안녕하세요'가 포함된 게시글 보기 
select * from Board where boardTitle like '%안녕하세요%';

#게시물 내용에 '반갑습니다'가 포함된 게시글 보기
select * from Board where boardContent like '%반갑습니다%';

#게시물 제목 + 내용에 '안녕히 가세요'가 포함된 게시글 보기
select * from Board where boardTitle like '%안녕히 가세요%' or boardContent like '%안녕히 가세요%';	

select * from Board where boardtitle like '%%';

#1. or연산 사용
select * from Board where boardWriter = 1 or boardWriter = 2;
#2 in연산 사용
select * from Board where boardWriter in (1, 2);

#Board 테이블에서 boardDate가 2023-01-03 부터 2023-01-10 까지의 레코드 중 모든 컬럼을 선택
select * from Board where boardDate between '2023-01-03' and '2023-01-10';

#Board 테이블에서 작성일자가 1월달인 레코드에서 모든 컬럼을 선택
#1 like _ 연산 사용
select * from Board where boardDate like '____-01-__';
#2 like % 
select * from Board where boardDate like '%-01-%';
#3. between 연산 사용 (2월 사용 불가)
select * from Board where boardDate between '2023-01-01' and '2023-01-31';

drop table Board;

create table Board(
	id int auto_increment primary key,
    boardTitle varchar(200) not null,
    boardContent text not null,
    boardDateTime datetime not null,
    boardLike int default 0,
    boardWriter int not null,
    
    constraint board_FK foreign key (boardWriter)
    references User (id)
);

select * from User;

insert into User (password, name, telNumber) values('p!ssw0rd', 'John', '010-1111-4444');
insert into User (password, name, telNumber) values('qwer1234!!', 'Alies', '010-2222-8888');
insert into User (password, name, telNumber) values('sojfhbsuo', 'Brown', '010-3333-6666');

select * from Board;

insert into Board (boardTitle, boardContent, boardDateTime, boardWriter)
values ('HelloWorld','Hello MySQL',now(),2);

insert into Board (boardTitle, boardContent, boardDateTime, boardWriter)
values ('HelloWorld','Hello MySQL@',now(),2);

insert into Board (boardTitle, boardContent, boardDateTime, boardWriter)
values ('Good Bye World','Good Bye MySQL',now(),3);

# 게시물을 작성한 경험이 있는 유저의 이름과 전화번호, 작성한 게시물 제목을 구하시오
select U.name, U.telNumber, B.boardTitle 
from User as U, Board as B
where U.id = B.boardWriter;

select U.name, U.telNumber, B.boardTitle 
from User as U right join Board as B
on U.id = B.boardWriter;

# 게시물을 작성한 경험이 있는 유저의 이름과 전화번호를 구하시오. 
select U.name, U.telNumber
from User as U, Board as B
where U.id = B.boardWriter;

select name, telNumber
from User
where id in (
	select distinct boardWriter
    from Board
);

