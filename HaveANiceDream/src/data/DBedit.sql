select * from member;
select * from tab;
select * from board;

drop table member;
drop table board;
Delete from board where board_no = 29;

CREATE TABLE member
(
    user_id                 VARCHAR2(20)    NOT NULL, 
    user_pw                 VARCHAR2(20)    NULL, 
    user_email              VARCHAR2(20)    NULL, 
    user_name               VARCHAR2(20)    NULL, 
    user_zipcode            VARCHAR2(5)     NULL, 
    user_addr               VARCHAR2(90)    NULL, 
    user_addr_detail        VARCHAR2(20)    NULL, 
    user_tel                VARCHAR2(20)    NULL, 
    user_sigdate            DATE            NULL, 
    user_log_type           VARCHAR2(20)    NULL, 
    user_last_login_time    DATE            NULL, 
    user_image              VARCHAR2(20)    NULL, 
    point_total             NUMBER          NULL, 
    user_type               VARCHAR2(20)    NULL, 
    CONSTRAINT MEMBER_PK PRIMARY KEY (user_id)
);

ALTER TABLE member MODIFY(USER_TYPE VARCHAR2(20));
ALTER TABLE member MODIFY(USER_ADDR VARCHAR2(200));
ALTER TABLE member MODIFY(USER_EMAIL VARCHAR2(200));

ALTER TABLE blame MODIFY(ATTACHED_FILE VARCHAR2(100));
ALTER TABLE blame MODIFY(BLAME_TYPE VARCHAR2(100));
ALTER TABLE blame MODIFY(BLAME_TITLE VARCHAR2(100));
ALTER TABLE blame MODIFY(BLAME_CONTENT VARCHAR2(1000));
ALTER TABLE manager_blame MODIFY(ANSWER_TITLE VARCHAR2(100));
ALTER TABLE manager_blame MODIFY(ANSWER_CONTENT VARCHAR2(1000));
delete from BLAME where BLAME_NO = 63;

ALTER TABLE product MODIFY(trade_type VARCHAR2(20));
ALTER TABLE product RENAME COLUMN PRODUCT_COUNT TO PRODUCT_GRADE;
ALTER TABLE product MODIFY(PRODUCT_GRADE VARCHAR2(20));
ALTER TABLE product MODIFY(trade_type VARCHAR2(20));
ALTER TABLE product MODIFY(PRODUCT_STATE number);
ALTER TABLE product_image MODIFY(IMAGE_SRC VARCHAR2(50));
ALTER TABLE product add(category_detail_no number);
insert into category values(category_seq.nextval,'유아용품');
insert into category values(category_seq.nextval,'핸드폰');
insert into category values(category_seq.nextval,'가전제품');
insert into category values(category_seq.nextval,'가구');
insert into category values(category_seq.nextval,'생활용품');

ALTER TABLE board MODIFY(BOARD_COUNT number);



create table category(category_no number,
category_name varchar2 (30)
);
create table category_detail(category_detail_no number,
category_detail_name varchar2 (30),
category_no number
);

insert into category_detail values(category_detail_seq.nextval,'기저귀',1);
insert into category_detail values(category_detail_seq.nextval,'유모차',1);
insert into category_detail values(category_detail_seq.nextval,'유아용옷',1);
insert into category_detail values(category_detail_seq.nextval,'장난감',1);
insert into category_detail values(category_detail_seq.nextval,'유아용변기커버',1);
insert into category_detail values(category_detail_seq.nextval,'유아용신발',1);
insert into category_detail values(category_detail_seq.nextval,'유아용의자',1);
insert into category_detail values(category_detail_seq.nextval,'유아용퍼즐',1);
insert into category_detail values(category_detail_seq.nextval,'유아용이불',1);
insert into category_detail values(category_detail_seq.nextval,'유아용가방',1);
insert into category_detail values(category_detail_seq.nextval,'유아로션',1);



insert into category_detail values(category_detail_seq.nextval,'갤럭시S6',2);
insert into category_detail values(category_detail_seq.nextval,'갤럭시S7',2);
insert into category_detail values(category_detail_seq.nextval,'갤럭시S8',2);
insert into category_detail values(category_detail_seq.nextval,'IPhone5',2);
insert into category_detail values(category_detail_seq.nextval,'IPhoneX',2);
insert into category_detail values(category_detail_seq.nextval,'IPhoneSE',2);
insert into category_detail values(category_detail_seq.nextval,'IPhone8Plus',2);

insert into category_detail values(category_detail_seq.nextval,'냉장고',3);
insert into category_detail values(category_detail_seq.nextval,'세탁기',3);
insert into category_detail values(category_detail_seq.nextval,'모니터',3);


insert into category_detail values(category_detail_seq.nextval,'식탁',4);
insert into category_detail values(category_detail_seq.nextval,'의자',4);
insert into category_detail values(category_detail_seq.nextval,'책상',4);

insert into category_detail values(category_detail_seq.nextval,'섬유유연제',5);
insert into category_detail values(category_detail_seq.nextval,'롤화장지',5);
insert into category_detail values(category_detail_seq.nextval,'멀티탭',5);
insert into category_detail values(category_detail_seq.nextval,'주방세제',5);
insert into category_detail values(category_detail_seq.nextval,'물티슈',5);
insert into category_detail values(category_detail_seq.nextval,'건조대',5);
insert into category_detail values(category_detail_seq.nextval,'슬리퍼',5);
insert into category_detail values(category_detail_seq.nextval,'물티슈',5);

create  SEQUENCE  category_detail_seq;

create SEQUENCE  category_seq;
DROP SEQUENCE  category_detail_seq;
DROP SEQUENCE  category_seq;
drop table category;
drop table category_detail;

select * from BLAME;
select * from ATTENDANCE;
select * from MANAGER_BLAME;
select * from PRODUCT;


CREATE TABLE block
(
    user_id         VARCHAR2(20)    NOT NULL, 
    block_reason    VARCHAR2(20)    NULL, 
    block_date      DATE            NULL   
);
alter table blame drop column product_no;
create  SEQUENCE board_no_seq;

alter table [해당테이블명] drop column [삭제할필드명];
alter table board drop column board_type;
ALTER TABLE board MODIFY(BOARD_STATE VARCHAR2(20));

CREATE TABLE board
(
	board_No 		VARCHAR2(20)    NOT NULL, 
    user_Id	 		VARCHAR2(20)    NULL, 
    write_Date 		DATE    		NULL, 
    board_Title	 	VARCHAR2(200)   NULL, 
    board_Content 	VARCHAR2(2000)  NULL, 
    board_State 		VARCHAR2(20)    NULL, 
    board_Count	 	NUMBER   		NULL, 
    board_Parent_No  NUMBER    		NULL, 
    board_Level  	NUMBER   		NULL, 
    borad_Order  	NUMBER    		NULL, 
    border_imageSrc  VARCHAR2(60)    NULL, 
    board_Type1 		VARCHAR2(20)    NULL, 
    board_Type2	 	VARCHAR2(20)    NULL,
 	CONSTRAINT BOARD_PK PRIMARY KEY (board_No)
);

