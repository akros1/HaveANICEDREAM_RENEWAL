CREATE TABLE Note
(
    note_no          NUMBER               NOT NULL, 
    note_sender      VARCHAR2(20)      NULL, 
    note_receiver    VARCHAR2(20)      NULL, 
    note_date        DATE              NULL, 
    note_content     VARCHAR2(1000)    NULL, 
    note_state       CHAR(1)           NULL, 
    CONSTRAINT NOTE_PK PRIMARY KEY (note_no)
)


CREATE SEQUENCE Note_SEQ
START WITH 1
INCREMENT BY 1;

select * from note;

INSERT INTO Note (note_no, note_sender, note_receiver, note_date, note_content, note_state) VALUES (Note_SEQ.nextval, 'a', 'b', sysdate, 'note_content 001', 'N');
INSERT INTO Note (note_no, note_sender, note_receiver, note_date, note_content, note_state) VALUES (Note_SEQ.nextval, 'b', 'a', sysdate, 'note_content 002', 'N');
INSERT INTO Note (note_no, note_sender, note_receiver, note_date, note_content, note_state) VALUES (Note_SEQ.nextval, 'a', 'v', sysdate, 'note_content 003', 'N');
INSERT INTO Note (note_no, note_sender, note_receiver, note_date, note_content, note_state) VALUES (Note_SEQ.nextval, 'b', 'a', sysdate, 'note_content 004', 'N');
INSERT INTO Note (note_no, note_sender, note_receiver, note_date, note_content, note_state) VALUES (Note_SEQ.nextval, 'a', 'b', sysdate, 'note_content 005', 'N');
INSERT INTO Note (note_no, note_sender, note_receiver, note_date, note_content, note_state) VALUES (Note_SEQ.nextval, 'v', 'a', sysdate, 'note_content 006', 'N');
INSERT INTO Note (note_no, note_sender, note_receiver, note_date, note_content, note_state) VALUES (Note_SEQ.nextval, 'a', 'v', sysdate, 'note_content 007', 'N');