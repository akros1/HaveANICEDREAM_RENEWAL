package note.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import note.dto.NoteDTO;
import note.service.NoteService;
import note.service.NoteServiceImpl;
import user.dto.MemberDTO;
import user.service.UserService;
import user.service.UserServiceImpl;

@WebServlet(name = "note/talklist", urlPatterns = { "/note/talklist.do" })
public class NoteGetTalkListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setHeader("cache-control", "no-cache,no-store");
		String me = request.getParameter("me");
		String you = request.getParameter("you");

		PrintWriter printWriter = response.getWriter();

		NoteService service = new NoteServiceImpl();
		ArrayList<NoteDTO> list = service.noteList(me, you);
		//System.out.println("dto => "+list);
		if (list != null) {
			UserService userService = new UserServiceImpl();
			MemberDTO memberDTO = userService.userSelect(you);

			Collections.sort(list, new Comparator<NoteDTO>() {

				@Override
				public int compare(NoteDTO o1, NoteDTO o2) {
					return o1.getNoteDate().compareTo(o2.getNoteDate());
				}
			});

			// System.out.println(list);
			JSONObject jsonObject = new JSONObject();
			JSONArray array = new JSONArray();
			int size = list.size();
			for (int i = 0; i < size; i++) {
				JSONObject object = new JSONObject();
				NoteDTO dto = list.get(i);
				
				if (dto.getNoteReceiver().equals(me)) {
					service.noteUpdateState(dto.getNoteNo());
				}

				object.put("from", dto.getNoteSender());
				object.put("date", dto.getNoteDate().toString());
				object.put("content", dto.getNoteContent());

				array.add(object);
			}

			jsonObject.put("list", array);
			if (memberDTO != null) {
				jsonObject.put("yourimg", memberDTO.getUserImage());
			}
			//System.out.println("json => "+jsonObject.toJSONString());

			printWriter.println(jsonObject.toJSONString());
		} else {
			printWriter.println(" ");
		}
	}

}
