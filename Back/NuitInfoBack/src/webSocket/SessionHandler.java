package webSocket;


import java.io.IOException;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.websocket.Session;

import org.json.JSONObject;

public class SessionHandler {
	private static final HashSet<Session> sessions = new HashSet<>();
	
	public void addSession(Session session) {
		sessions.add(session);
	}

	public void removeSession(Session session) {
		sessions.remove(session);
	}
	
	public void sendMessage(JSONObject message){
		for (Session session : sessions) {
			sendToSession(session, message);
		}
	}


	private void sendToSession(Session session, JSONObject message) {
		try {
			session.getBasicRemote().sendText(message.toString());
		} catch (IOException ex) {
			sessions.remove(session);
			Logger.getLogger(SessionHandler.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}