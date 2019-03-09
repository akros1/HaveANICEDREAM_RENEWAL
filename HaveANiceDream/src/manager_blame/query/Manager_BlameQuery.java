package manager_blame.query;


/*Name                                      Null?    Type
----------------------------------------- -------- ----------------------------
ANSWER_NO                                 NOT NULL NUMBER
BLAME_NO                                           NUMBER
USER_ID                                            VARCHAR2(20)
ANSWER_TITLE                                       VARCHAR2(20)
ANSWER_CONTENT                                     VARCHAR2(20)
ANSWER_DATE                                        DATE*/

public class Manager_BlameQuery {
	public static final String ANSWER_INSERT = "insert into manager_blame values(manager_blame_SEQ.nextval,?,?,?,?,sysdate)";
	public static final String ANSWER_SELECT = "select b.blame_no, b.blame_date, b.blame_title, "
			+ "b.blame_content, a.answer_title, a.answer_content, a.answer_date "
			+ "from blame b, manager_blame a "
			+ "where b.blame_no=a.blame_no and b.blame_no = ?";
	public static final String ANSWER_SEARCH ="select * from blame where userIdBlamere like ?";
}
