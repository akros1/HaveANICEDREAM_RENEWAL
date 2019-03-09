package blame.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import blame.dto.BlameDTO;
import blame.service.BlameService;
import blame.service.BlameServiceimpl;
import user.dto.MemberDTO;


@WebServlet(name = "blame/insert", urlPatterns = {"/blame/insert.do"})
public class BlameInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		//업로드폴더
		String saveFolder="/uploadresources/blame";
		String encType = "utf-8";
		int size = 5*1024*1024;
		String realFolder="";
		ServletContext context = getServletContext();
		realFolder = context.getRealPath(saveFolder);
		HttpSession session = request.getSession(false);
		MemberDTO user = (MemberDTO) session.getAttribute("user");
	//	System.out.println(realFolder);
		ArrayList<String> filelist = new ArrayList<String>();
		MultipartRequest multipart = 
				new MultipartRequest(request,
						realFolder, size, encType, 
						new DefaultFileRenamePolicy());
		Enumeration<String> files =  multipart.getFileNames();
		String fileName = "";
		while(files.hasMoreElements()){
			String file = files.nextElement();
			fileName = multipart.getFilesystemName(file);
			//System.out.println(fileName);
		//System.out.println(fileName);
		}
		String blameType = multipart.getParameter("blameType");
		String userIdBlamere = user.getUserId();
		String userIdBlamee = multipart.getParameter("userIdBlamee");
		String attachedFile = fileName;
		String blameTitle = multipart.getParameter("blameTitle");
		String blameContent = multipart.getParameter("blameContent");
		
		/*HttpSession session = request.getSession(false);
		MemberDTO user = (MemberDTO) session.getAttribute("user");
		String blameType = request.getParameter("blameType");
		String userIdBlamere = user.getUserId();
		String userIdBlamee = request.getParameter("userIdBlamee");
		String attachedFile = request.getParameter("attachedFile");
		String blameTitle = request.getParameter("blameTitle");
		String blameContent = request.getParameter("blameContent");*/
		
		
		BlameDTO blame = new BlameDTO(blameType,userIdBlamere,userIdBlamee,attachedFile,blameTitle,blameContent);
		BlameService service = new BlameServiceimpl();
		System.out.println(blame);
		int result = service.insert(blame);
		
		if(result>0){
			response.sendRedirect("/HaveANiceDream/blame/list.do?state=1");
		}else{
			String viewpath = "../blame/report_boss.jsp";
			request.setAttribute("viewpath", viewpath);
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/main/main_layout.jsp");
			requestDispatcher.forward(request, response);
		}
	}

}
