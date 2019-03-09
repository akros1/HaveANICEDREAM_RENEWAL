package chatting;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import note.dto.NoteDTO;
import note.service.NoteService;
import note.service.NoteServiceImpl;

@ServerEndpoint("/user/chat")
public class ChatServer {
	private static final Set<ChatServer> connections = new CopyOnWriteArraySet<ChatServer>();

	private String nickname;
	private Session session;

	@OnOpen // 누군가 접속했따!!!!
	public void start(Session session) {
		this.session = session;
		connections.add(this);
	}

	@OnClose // 누군가 나갔어여!!
	public void end() {
		connections.remove(this);
	}

	@OnMessage // 메시지 왔숑!
	public void incoming(String message) {
		System.out.println(message);

		JSONParser parser = new JSONParser();
		try {
			JSONObject object = (JSONObject) parser.parse(message);
			if (object.get("type").equals("text")) {
				String to = (String) object.get("to");
				NoteDTO dto = new NoteDTO((String) object.get("from"), to, (String) object.get("text"));
				NoteService service = new NoteServiceImpl();
				service.noteInsert(dto);
				sendTo(message, to);
			} else if (object.get("type").equals("info")) {
				nickname = (String) object.get("id");
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

	@OnError // 에러났어요!!!!
	public void onError(Throwable t) throws Throwable {

	}

	private void sendTo(String message, String to) {
		for (ChatServer client : connections) {
			if (client.nickname.equals(to)) {
				
				try {
					
					synchronized (client) {
						client.session.getBasicRemote().sendText(message);
					}
					
				} catch (IOException e) {
					e.printStackTrace();

					connections.remove(client);

					try {
						client.session.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}

				} 
				
				break;
				
			} // if end
			
		} // for end
	}
}
