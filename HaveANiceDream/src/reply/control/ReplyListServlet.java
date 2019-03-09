package reply.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import reply.dto.ReplyDTO;
import reply.service.ReplyService;
import reply.service.ReplyServiceImpl;

import user.dto.MemberDTO;

@WebServlet(name = "reply/list", urlPatterns = { "/reply/list.do" })
public class ReplyListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");

		HttpSession ses = request.getSession(false);

		String boardNo = request.getParameter("boardNo");
		String replyContent = request.getParameter("replyContent");
		String viewpath = "";

		if (ses != null) {
			MemberDTO user = (MemberDTO) ses.getAttribute("user");
			String sesuserId = user.getUserId();
			ReplyService service = new ReplyServiceImpl();
			ArrayList<ReplyDTO> replyList = null;
			ReplyDTO reply = null;
			JSONObject replyroot = new JSONObject();
			JSONArray replyjsonlist = new JSONArray();
			replyList = service.replyList(Integer.parseInt(boardNo));
			System.out.println(replyList);
			int size = replyList.size();
			for (int i = 0; i < size; i++) {
				JSONObject replyjson = new JSONObject();
				reply = replyList.get(i);
				replyjson.put("ReplyNo", reply.getReplyNo());
				replyjson.put("BorderNo", reply.getBorderNo());
				replyjson.put("ReplyContent", reply.getReplyContent());
				replyjson.put("UserId", reply.getUserId());
				replyjson.put("ReplyEditDate", reply.getReplyEditDate() + "");
				replyjsonlist.add(replyjson);
			}
			replyroot.put("replylist", replyjsonlist);

			System.out.println(replyroot.toJSONString());

			response.setHeader("cache-control", "no-cache,no-store");
			PrintWriter pw = response.getWriter();
			pw.print(replyroot.toJSONString());

		} else {

			response.sendRedirect("/HaveANiceDream/user/login.html");

		}

	}

}