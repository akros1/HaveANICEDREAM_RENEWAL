package note.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import note.service.NoteService;
import note.service.NoteServiceImpl;
import user.dto.MemberDTO;

@WebServlet(name = "note/getyoulist", urlPatterns = { "/note/getyoulist.do" })
public class NoteGetTalkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setHeader("cache-control", "no-cache,no-store");
		String userId = request.getParameter("userId");

		NoteService service = new NoteServiceImpl();
		ArrayList<MemberDTO> list = service.noteToList(userId);
		//System.out.println(list);

		JSONObject jsonObject = new JSONObject();
		JSONArray array = new JSONArray();

		if (list != null) {

			int size = list.size();
			for (int i = 0; i < size; i++) {
				MemberDTO dto = list.get(i);
				JSONObject object = new JSONObject();

				object.put("id", dto.getUserId());
				object.put("name", dto.getUserName());
				object.put("img", dto.getUserImage());

				array.add(object);
			}

			jsonObject.put("list", array);
			//System.out.println(jsonObject.toJSONString());
		}
		PrintWriter printWriter = response.getWriter();
		printWriter.println(jsonObject.toJSONString());
	}

}
