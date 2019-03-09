package blame.query;


/*Name                                      Null?    Type
----------------------------------------- -------- ----------------------------
BLAME_NO                                  NOT NULL NUMBER
BLAME_DATE                                         DATE
USER_ID_BLAMERE                                    VARCHAR2(20)
USER_ID_BLAMEE                                     VARCHAR2(20)
BLAME_TYPE                                         VARCHAR2(20)
ATTACHED_FILE                                      VARCHAR2(20)
BLAME_TITLE                                        VARCHAR2(20)
BLAME_CONTENT                                      VARCHAR2(20)*/

public class BlameQuery {
	public static final String BLAME_INSERT = "insert into blame values(BLAME_SEQ.nextval,sysdate,?,?,?,?,?,?,'답변대기')";
	public static final String BLAME_LIST = "select * from blame";
	public static final String BLAME_LIST2 = "select * from blame where USER_ID_BLAMERE = ?";
	public static final String BLAME_SELECT = "select * from blame where BLAME_NO = ?";
	public static final String BLAME_UPDATE = "update blame set BLAME_ANSWER = '답변완료' where BLAME_NO = ?";
	//public static final String BLAME_IMG_INSERT = "insert into blame values(BLAME_IMAGE_SEQ.nextval,product_seq.currval,?)";
}
