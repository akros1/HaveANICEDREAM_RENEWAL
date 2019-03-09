package grade.service;


import java.util.ArrayList;


import grade.dto.GradeDTO;



public interface GradeService {
	int gradeInsert(GradeDTO gradewrite);
	
	ArrayList<GradeDTO> gradeList1();
	
	ArrayList<GradeDTO> gradeSelectType(String userid,String gradeType);
}

