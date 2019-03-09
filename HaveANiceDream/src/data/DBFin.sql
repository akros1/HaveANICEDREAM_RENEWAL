CREATE TABLE member
(
    user_id                 VARCHAR2(30)     NOT NULL, 
    user_pw                 VARCHAR2(20)     NULL, 
    user_email              VARCHAR2(20)     NULL, 
    user_name               VARCHAR2(20)     NULL, 
    user_zipcode            VARCHAR2(5)      NULL, 
    user_addr               VARCHAR2(90)     NULL, 
    user_addr_detail        VARCHAR2(20)     NULL, 
    user_tel                VARCHAR2(20)     NULL, 
    user_sigdate            DATE             NULL, 
    user_log_type           VARCHAR2(20)     NULL, 
    user_last_login_time    DATE             NULL, 
    user_image              VARCHAR2(100)    NULL, 
    point_total             NUMBER           NULL, 
    user_type               VARCHAR2(20)     NULL, 
    CONSTRAINT MEMBER_PK PRIMARY KEY (user_id)
);

        
ALTER TABLE member MODIFY(user_addr_detail VARCHAR2(200));

CREATE TABLE blame
(
    blame_no           NUMBER            NOT NULL, 
    blame_date         DATE              NULL, 
    user_id_blamere    VARCHAR2(30)      NULL, 
    user_id_blamee     VARCHAR2(30)      NULL, 
    blame_type         VARCHAR2(100)     NULL, 
    product_no         NUMBER            NULL, 
    attached_file      VARCHAR2(100)     NULL, 
    blame_title        VARCHAR2(100)     NULL, 
    blame_content      VARCHAR2(1000)    NULL, 
    blame_answer       VARCHAR2(20)      NULL, 
    CONSTRAINT BLAME_PK PRIMARY KEY (blame_no)
);

CREATE SEQUENCE blame_SEQ
START WITH 1
INCREMENT BY 1;

ALTER TABLE blame
    ADD CONSTRAINT FK_blame_user_id_blamere_membe FOREIGN KEY (user_id_blamere)
        REFERENCES member (user_id);

ALTER TABLE blame
    ADD CONSTRAINT FK_blame_user_id_blamee_member FOREIGN KEY (user_id_blamee)
        REFERENCES member (user_id);
        
CREATE TABLE Manager_blame
(
    answer_no         NUMBER            NOT NULL, 
    blame_no          NUMBER            NULL, 
    user_id           VARCHAR2(30)      NULL, 
    answer_title      VARCHAR2(100)     NULL, 
    answer_content    VARCHAR2(1000)    NULL, 
    answer_date       DATE              NULL, 
    CONSTRAINT MANAGER_BLAME_PK PRIMARY KEY (answer_no)
);

CREATE SEQUENCE Manager_blame_SEQ
START WITH 1
INCREMENT BY 1;

ALTER TABLE Manager_blame
    ADD CONSTRAINT FK_Manager_blame_user_id_membe FOREIGN KEY (user_id)
        REFERENCES member (user_id);

ALTER TABLE Manager_blame
    ADD CONSTRAINT FK_Manager_blame_blame_no_blam FOREIGN KEY (blame_no)
        REFERENCES blame (blame_no);

CREATE TABLE category
(
    category_no      NUMBER          NOT NULL, 
    category_name    VARCHAR2(30)    NULL, 
    CONSTRAINT CATEGORY_PK PRIMARY KEY (category_no)
);

CREATE SEQUENCE category_SEQ
START WITH 1
INCREMENT BY 1;

CREATE TABLE category_detail
(
    category_detail_no      NUMBER          NOT NULL, 
    category_detail_name    VARCHAR2(30)    NULL, 
    category_no             NUMBER          NULL, 
    CONSTRAINT CATEGORY_DETAIL_PK PRIMARY KEY (category_detail_no)
);

CREATE SEQUENCE category_detail_SEQ
START WITH 1
INCREMENT BY 1;

ALTER TABLE category_detail
    ADD CONSTRAINT FK_category_detail_category_no FOREIGN KEY (category_no)
        REFERENCES category (category_no);
        
CREATE TABLE Product
(
    product_no            NUMBER            NOT NULL, 
    user_id               VARCHAR2(30)      NULL, 
    category_no           NUMBER            NULL, 
    product_name          VARCHAR2(50)      NULL, 
    product_price         NUMBER            NULL, 
    product_content       VARCHAR2(2000)    NULL, 
    product_grade         VARCHAR2(20)      NULL, 
    product_title         VARCHAR2(200)     NULL, 
    product_date          DATE              NULL, 
    product_state         NUMBER            NULL, 
    product_exf_date      NUMBER            NULL, 
    trade_type            VARCHAR2(20)      NULL, 
    category_detail_no    NUMBER            NULL, 
    CONSTRAINT PRODUCT_PK PRIMARY KEY (product_no)
);

CREATE SEQUENCE Product_SEQ
START WITH 1
INCREMENT BY 1;

ALTER TABLE Product
    ADD CONSTRAINT FK_Product_user_id_member_user FOREIGN KEY (user_id)
        REFERENCES member (user_id);

ALTER TABLE Product
    ADD CONSTRAINT FK_Product_category_detail_no_ FOREIGN KEY (category_detail_no)
        REFERENCES category_detail (category_detail_no);

ALTER TABLE Product
    ADD CONSTRAINT FK_Product_category_no_like_ca FOREIGN KEY (category_no)
        REFERENCES category (category_no);

CREATE TABLE product_image
(
    image_no      NUMBER           NOT NULL, 
    product_no    NUMBER           NULL, 
    image_src     VARCHAR2(100)    NULL, 
    CONSTRAINT PRODUCT_IMAGE_PK PRIMARY KEY (image_no)
);

CREATE SEQUENCE product_image_SEQ
START WITH 1
INCREMENT BY 1;

ALTER TABLE product_image
    ADD CONSTRAINT FK_product_image_product_no_Pr FOREIGN KEY (product_no)
        REFERENCES Product (product_no);

CREATE TABLE attendance
(
    att_no       NUMBER          NOT NULL, 
    user_id      VARCHAR2(30)    NULL, 
    att_point    NUMBER          NULL, 
    att_date     DATE            NULL, 
    CONSTRAINT ATTENDANCE_PK PRIMARY KEY (att_no)
);

CREATE SEQUENCE attendance_SEQ
START WITH 1
INCREMENT BY 1;

ALTER TABLE attendance
    ADD CONSTRAINT FK_attendance_user_id_member_u FOREIGN KEY (user_id)
        REFERENCES member (user_id);

CREATE TABLE Trade
(
    trade_no            NUMBER          NOT NULL, 
    trade_start_date    DATE            NULL, 
    trade_end_date      DATE            NULL, 
    user_id_buy         VARCHAR2(20)    NULL, 
    user_id_sell        VARCHAR2(20)    NULL, 
    product_no          NUMBER          NULL, 
    trade_state         VARCHAR2(30)    NULL, 
    CONSTRAINT TRADE_PK PRIMARY KEY (trade_no)
);

CREATE SEQUENCE Trade_SEQ
START WITH 1
INCREMENT BY 1;

ALTER TABLE Trade
    ADD CONSTRAINT FK_Trade_user_id_buy_member_us FOREIGN KEY (user_id_buy)
        REFERENCES member (user_id);

ALTER TABLE Trade
    ADD CONSTRAINT FK_Trade_user_id_sell_member_u FOREIGN KEY (user_id_sell)
        REFERENCES member (user_id);

ALTER TABLE Trade
    ADD CONSTRAINT FK_Trade_product_no_Product_pr FOREIGN KEY (product_no)
        REFERENCES Product (product_no);
        
CREATE TABLE Note
(
    note_no          NUMBER            NOT NULL, 
    note_sender      VARCHAR2(30)      NULL, 
    note_receiver    VARCHAR2(30)      NULL, 
    note_date        DATE              NULL, 
    note_content     VARCHAR2(1000)    NULL, 
    note_state       CHAR(1)           NULL, 
    CONSTRAINT NOTE_PK PRIMARY KEY (note_no)
);

CREATE SEQUENCE Note_SEQ
START WITH 1
INCREMENT BY 1;

ALTER TABLE Note
    ADD CONSTRAINT FK_Note_note_sender_member_use FOREIGN KEY (note_sender)
        REFERENCES member (user_id);

ALTER TABLE Note
    ADD CONSTRAINT FK_Note_note_receiver_member_u FOREIGN KEY (note_receiver)
        REFERENCES member (user_id);

CREATE TABLE board
(
    board_no           NUMBER            NOT NULL, 
    user_id            VARCHAR2(30)      NULL, 
    write_date         DATE              NULL, 
    board_title        VARCHAR2(200)     NULL, 
    board_content      VARCHAR2(2000)    NULL, 
    board_type         VARCHAR2(20)      NULL, 
    board_state        CHAR(1)           NULL, 
    board_count        VARCHAR2(20)      NULL, 
    board_parent_no    NUMBER            NULL, 
    board_level        NUMBER            NULL, 
    borad_order        NUMBER            NULL, 
    CONSTRAINT BOARD_PK PRIMARY KEY (board_no)
);

ALTER TABLE board add(border_IMAGESRC VARCHAR2(60));
ALTER TABLE board add(board_type1 VARCHAR2(20));
ALTER TABLE board add(board_type2 VARCHAR2(20));

CREATE SEQUENCE board_SEQ
START WITH 1
INCREMENT BY 1;

ALTER TABLE board
    ADD CONSTRAINT FK_board_user_id_member_user_i FOREIGN KEY (user_id)
        REFERENCES member (user_id);

CREATE TABLE reply
(
    reply_no           NUMBER          NOT NULL, 
    board_no           NUMBER          NULL, 
    reply_content      VARCHAR2(20)    NULL, 
    user_id            VARCHAR2(30)    NULL, 
    reply_edit_date    DATE            NULL, 
    CONSTRAINT REPLY_PK PRIMARY KEY (reply_no)
);

CREATE SEQUENCE reply_SEQ
START WITH 1
INCREMENT BY 1;

ALTER TABLE reply
    ADD CONSTRAINT FK_reply_user_id_member_user_i FOREIGN KEY (user_id)
        REFERENCES member (user_id);

ALTER TABLE reply
    ADD CONSTRAINT FK_reply_board_no_board_board_ FOREIGN KEY (board_no)
        REFERENCES board (board_no);
        
ALTER TABLE reply MODIFY(reply_content VARCHAR2(200));
        
CREATE TABLE point
(
    point_no      NUMBER          NOT NULL, 
    user_id       VARCHAR2(30)    NULL, 
    point_date    DATE            NULL, 
    point_type    VARCHAR2(20)    NULL, 
    point         NUMBER          NULL, 
    CONSTRAINT POINT_PK PRIMARY KEY (point_no)
);

CREATE SEQUENCE point_SEQ
START WITH 1
INCREMENT BY 1;

ALTER TABLE point
    ADD CONSTRAINT FK_point_user_id_member_user_i FOREIGN KEY (user_id)
        REFERENCES member (user_id);
        
CREATE TABLE Grade
(
    grade_no         NUMBER           NOT NULL, 
    user_id          VARCHAR2(30)     NULL, 
    trade_no         NUMBER           NULL, 
    grade            VARCHAR2(30)     NULL, 
    grade_type       VARCHAR2(20)     NULL, 
    grade_content    VARCHAR2(300)    NULL, 
    grade_date       DATE             NULL, 
    grade_User_Id    VARCHAR2(30)     NULL, 
    CONSTRAINT GRADE_PK PRIMARY KEY (grade_no)
);

CREATE SEQUENCE Grade_SEQ
START WITH 1
INCREMENT BY 1;

ALTER TABLE Grade
    ADD CONSTRAINT FK_Grade_user_id_member_user_i FOREIGN KEY (user_id)
        REFERENCES member (user_id);

ALTER TABLE Grade
    ADD CONSTRAINT FK_Grade_trade_no_Trade_trade_ FOREIGN KEY (trade_no)
        REFERENCES Trade (trade_no);

ALTER TABLE Grade
    ADD CONSTRAINT FK_Grade_grade_User_Id_member_ FOREIGN KEY (grade_User_Id)
        REFERENCES member (user_id);
        
CREATE TABLE Text
(
    Text_no         NUMBER           NOT NULL, 
    trade_no        NUMBER           NULL, 
    user_id         VARCHAR2(30)     NULL, 
    Text_date       DATE             NULL, 
    Text_content    varchar2(400)    NULL, 
    CONSTRAINT TEXT_PK PRIMARY KEY (Text_no)
);

CREATE SEQUENCE Text_SEQ
START WITH 1
INCREMENT BY 1;

ALTER TABLE Text
    ADD CONSTRAINT FK_Text_user_id_member_user_id FOREIGN KEY (user_id)
        REFERENCES member (user_id);

ALTER TABLE Text
    ADD CONSTRAINT FK_Text_trade_no_Trade_trade_n FOREIGN KEY (trade_no)
        REFERENCES Trade (trade_no);
        
CREATE TABLE block
(
    user_id         VARCHAR2(30)    NOT NULL, 
    block_reason    VARCHAR2(50)    NULL, 
    block_date      DATE            NULL   
);

ALTER TABLE block
    ADD CONSTRAINT FK_block_user_id_member_user_i FOREIGN KEY (user_id)
        REFERENCES member (user_id);