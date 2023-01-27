# 한 줄 주석(#)
-- 한 줄 주석(--) 이 주석은 반드시 띄어쓰기가 포함되어 있어야 함
/*
여러줄 주석 
SQL
*/

/*
DB생성 쿼리
CREATE DATABASE DB명
*/

CREATE DATABASE HOTEL;

#생성된 데이터베이스 목록 보기
#SHOW DATABASES

SHOW databases; 	

#DB 선택 
#USE DB명

use HOTEL;

#테이블 생성
#create table 테이블명 (
#필드명 필드타입 제약조건,
#...
#);

create table Reservation(
	id INT auto_increment primary key,
    name varchar(30) not null,
    reservationDate DATE not null,
    roomNumber INT
);

#선택된 데이터베이스의 테이블 조회
show tables;

#테이블 수정
# - 컬럼 추가
#ALTER TABLE 테이블 명 ADD 필드명 필드타입 [제약 조건];

alter table Reservation add telNumber varchar(20);

#컬럼 삭제 
#ALTER TABLE 테이블명 DROP 필드명;

alter table Reservation drop roomNumber;

#컬럼 수정
#ALTER TABLE 테이블명 MODIFY COLUMN 필드명 필드타입[제약조건];

alter table Reservation modify column reservationDate varchar(20) not null; 

#테이블 삭제
#DROP
#DROP TABLE 테이블명;

drop table Reservation;

#TRUNCATE
#TRUNCATE TABLE 테이블명
#해당 테이블을 생성 직후의 상태로 되돌림.

insert into Reservation(name, reservationDate) values('홍길동', now());
select * from Reservation;

truncate table Reservation;

#DELETE FROM 테이블명
#레코드만 삭제

delete from Reservation;

### DML ###

#insert
#데이터 삽입
#insert into 테이블명(컬럼명1, 2, ...) values (값1, 값2, ...);
#insert into 테이블명(값1, 값2, ...);
#각 컬럼에 매칭되는 값을 순서에 맞게 작성하여야 함

insert into Reservation(name, reservationDate, roomNumber) values ('철수', '2023-01-17', 2124);
insert into Reservation values(4, '이영희', '2022-10-11', 902);
#NOT NULL 조건으로  걸린 name 컬럼 값을 지정 하지 않았기 때문에 삽입 에러가 발생
insert into Reservation(reservationDate, roomNumber) values('1999-02-10', 1002);

#update
#데이터 수정
#update 테이블명 set 컬럼1 = 값1 , ... [where 컬럼 = 값]
#where : 조건을 지정해주는 키워드. 조건에 해당하는 대한 레코드에만 명령을 실행

#is null : where 조건에서 해당 컬럼이 null 인 레코드를 고를 때 사용
update Reservation set roomNumber = 502 where roomNumber is null;
update Reservation set reservationDate = '2023-01-30' where name = '철수';
update Reservation set roomNumber = 1001;

#데이터 삭제 
#delete
#delete from 테이블명 [whrere 컬럼 = 값]

delete from Reservation where id = 7;

insert into Reservation(name, reservationDate, roomNumber) values('임꺽정', '2023-02-12', 2102);
insert into Reservation(name, reservationDate) values('홍길동', '2023-09-07');
insert into Reservation values(20, '고길동', '2023-03-02',3414);

#데이터 검색
#select
#select 컬럼명1 [, 컬럼명2, ...] from 테이블명 [where 조건];
#지정한 테이블에서 선택한 컬럼을 검색할 때 사용

select name from Reservation;
select name, roomNumber from Reservation;
select name, roomNumber from Reservation where reservationDate = '2023-09-07';

#select * 으로 모든 컬럼을 선택 할 수 있음

select * from Reservation;
select * from Reservation where name = '홍길동';

#where 문 뒤에 비교연산자 및 논리연산자로 조건을 추가하여 검색할 수 있음.

select * from Reservation where name = '홍길동' and reservationDate < '2023-04-01';
select * from Reservation where name = '홍길동' or reservationDate < '2023-04-01';
select * from Reservation where roomNumber is not null;
select * from Reservation where roomNumber is null;
select * from Reservation where name like '%길동' and roomNumber is not null;

#특정 컬럼의 중복 제거 distinct
select distinct name, roomNumber from  Reservation;

#정렬 특정 컬럼을 기준으로 정렬 order by
#옵션 - ASC : 오름차순 / DESC : 내림차순
select * from Reservation order by reservationDate;
select * from Reservation order by reservationDate desc;
select * from Reservation order by reservationDate;
select * from Reservation order by reservationDate desc, roomNumber desc;

#별칭사용 AS
select name as eman, roomNumber from Reservation;
select name, roomNumber from Reservation as R;

#MySQL 데이터타입
#문자열 타입 CHAR
#고정길이 문자열 / 길이로 지정할 수 있는 값의 범위 0 ~ 255
alter table Reservation add note char(4);

#describe 테이블명 : 테이블의 정보를 볼 수 있음.
describe Reservation;

select (note) from Reservation where name = '노트';

insert into Reservation(name, reservationDate, note) values('노트', now(), '');

#비교 연산자
#동등 비교연산
#좌항이 우항과 같으면 1을 반환 아니면 0

select 1 = 2;

#Reservation 테이블에서 roomNumber가 1001인 레코드의 모든 컬럼을 선택.
select * from Reservation where roomNumber = 1001;

#not 연산
#좌항이 우항과 다르면 1 아니면 0

select 1 != 1;

#Reservation 테이블에서 roomNumber가 1001이 아닌 레코드의 모든 컬럼을 선택
select * from Reservation where roomNumber != 1001;

#great, great than 연산 (>, >=)
#좌항이 우항보다 크면 1을 반환 아니면 0
#좌항이 우항보다 크거나 같으면 1 아님 0

select 1 > 1, 1 >= 1;

#Reservation 테이블에서 reservationDate가 2023년 01월 01일보다 크거나 같은(이후의) 모든 컬럼을 선택.
select * from Reservation where reservationDate >= '2023-01-01';

#Less than, less than equal(<, <=)
#좌항이 우항보다 작으면 1을 반환 아니면 0
#좌항이 우항보다 작거나 같으면 1 아님 0

select 1 < 1, 1 <= 1;

#Reservation 테이블에서 reservationDate가 2023-02-28보다 작거나 같은 (이전인) 모든 컬럼 선택
select * from Reservation where reservationDate <= '2023-02-28';

#null 확인 (<=>)
#좌항과 우항이 모두 null이면 참(1) 아니면 거짓(0)

select null <=> null;

#Reservation 테이블에서 roomNumber와 note가 모두 null인 레코드
select * from Reservation where roomNumber <=> note;

#Equal 연산( IS ) 
#좌항이 우항과 같으면 1을 반환, 아니면 0
#우항이 true, false, unknown일때 사용 

select 'home' is true;

#Not Equal 연산( IS NOT ) 
#좌항이 우항과 다르면 1을 반환, 아니면 0
#우항이 true, false, unknown일때 사용 

select false is not true;

#null 비교연산
#좌항이 null이면 1, 아니면 0

select 1 is null;

#Reservation 테이블에서 note 컬럼에 값이 없는 레코드의 모든 값을 선택
select * from Reservation where note is null;

#좌항이 null이 아니면 1을 반환하고 아니면 0을 반환

select 1 is not null;

#Reservation 테이블에서 roomNumber 컬럼에 값이 존재하는 레코드의 모든 값을 선택
select * from Reservation where roomNumber is not null;

#사이값 비교 연산(between a and b, not between a and b)
#좌항이 a보다 크거나 같으면서 b보다 작거나 같으면 1, 아니면 0
#좌항이 a보다 작거나 b보다 크면 1을 반환하고 아니면 0을 반환

select 10 between 5 and 15, 10 not between 3 and 8;
 
#Reservation 테이블에서 reservationDate가 2023-01-01부터 2023-02-28 까지인 레코드의 모든 컬럼을 선택
select * from Reservation where reservationDate between '2023-01-01' and '2023-02-28';

#in 연산(in, not in)
#좌항이 우항에 해당하는 배열 값 중 하나라도 같다면 1을, 아니면 0
#좌항이 우항에 해당하는 배열 값이 포함되어 있지 않다면 1을, 아니면 0

select 1 in (1, 2, 3, 4, 5), 10 not in (1, 2, 3, 4, 5);

#Reservation 테이블에서 name이 '홍길동', '고길동' 중 하나라도 해당되는 레코드의 모든 값을 선택 
select * from  Reservation where name in(1, 2, 3, 4, 5);

#논리 연산

#AND 연산( AND, && )
#좌항과 우항이 모두 참(1)이면 1, 아니면 0

select 1 and 1;

#Reservation 테이블에서 이름이 '고길동'이면서 note 컬럼에 값이 지정이 되어 있지않은 모든 컬럼 선택.
select * from Reservation where name = '고길동' and note is null;

#Reservation 테이블에서 note컬럼에 값이 지정되어있지 않고 / reservationDate가 2023-01-01부터 2023-02-28 까지인 레코드의 모든 컬럼 선택
select * from Reservation where note is null and (reservationDate between '2023-01-01' and '2023-02-28');

#OR 연산 (OR, ||)
#좌항과 우항 중 하나라도 참이면 1을, 아니면 0
#여기서 비교되는 1과 0은 비교 연산의 결과이다.

select 1 or 0;

#Reservation 테이블 중 name이 '고수' 이거나 note값이 존재하는 레코드의 모든 컬럼을 선택
select * from Reservation where name = '고수' or note is not null;

# XOR 연산 (XOR)
#좌항과 우항이 다르면 1을, 같으면 0;
select 1 xor 1;

#AND연산과 OR연산에서 주의할 점
#실제로 구하고자하는 값을 정확히 파악

#Reservation테이블에서
#name이 고길동 이면서 note값이 존재하지 않거나 roomNumber가 1000 이상인 레코드 중 모든 컬럼을 선택.
select * from Reservation where name = '고길동' and (note is null or roomNumber >= 1000);

#ifnull(검사할 인수, null일 때의 값)
#검사할 인수가 null이면 null일 때의 값을 반환
select ifnull(null, '값이 지정되지 않았습니다.');

#Reservation  테이블에서 모든 레코드 중 name과 roomNumber를 선택하는데 roomNumber가 null이면 '아직 방이 배정되지 않았습니다'를 출력.
select name, ifnull(roomNumber, '아직 방이 배정되지 않았습니다.') from Reservation;

#패턴 매칭(%, _)
#데이터의  특정 패턴에 해당하는 데이터를 조건으로 사용하기 위한 용도
#like 연산자를 사용

#Reservation 테이블에서 name 값 중 성이 '고'인 레코드에서 모든 컬럼을 선택
select * from Reservation where name like '고%';

# % : 0개 이상의 문자를 대체
# _ : 1개 문자를 대체

select * from Reservation where name like '%';
select * from Reservation where name like '_';


#foreign key
#해당 테이블이 외부 테이블을 참조할 때 특정 컬럼을 외부 테이블의 컬럼 값으로 지정하는 키
#참조의 기준

#constraint 제약조건명 foreign key (해당 필드에서 참조키로 지정할 컬럼)
#References 참조할 테이블 명 (참조할 테이블의 기본키)

#주의사항
# 1. 참조할 테이블이 존재해야함.
# 2. 참조할 컬럼이 참조할 테이블의 기본키여야함.

# [constraint 제약조건명]은 생략 가능

create table Room(
	roomNumber int primary key,
    roomSize int not null,
    roomName varchar(20) not null
);

create table Reservation2 (
	id int auto_increment primary key,
    name varchar(30) not null,
    reservationDate date not null,
    note text,
    roomNumber int, 
    
    constraint Reservation_RoomNumber_DY foreign key (roomNumber)
    references Room(roomNumber)
);

#참조 제약조건을 설정하면 
#참조하는 테이블에 해당 컬럼의 값이 존재해야 참조할 수 있음

insert into Reservation(name, reservationDate, roomNumber)
values('김철수', '2023-01-24', 2902);

insert into Reservation2(name, reservationDate, roomNumber)
values('김철수', '2023-01-24', 2901);

insert into Room values(2901, 28, 'VIP');

select * from Reservation2;

delete from Room where roomNumber = 2901;