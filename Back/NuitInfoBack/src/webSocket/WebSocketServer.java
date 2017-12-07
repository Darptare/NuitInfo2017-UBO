package webSocket;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Date;

import javax.inject.Inject;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.json.JSONException;
import org.json.JSONObject;

import dao.DAO;
import jSonGestion.JSonGenerator;
	
@ServerEndpoint("/actions")
public class WebSocketServer {
	
	@Inject
	private SessionHandler sessionHandler = new SessionHandler();

	@OnOpen
		public void open(Session session) {
		sessionHandler.addSession(session);
	}

	@OnClose
		public void close(Session session) {
		sessionHandler.removeSession(session);
	}

	@OnError
		public void onError(Throwable error, Session session) {
		sessionHandler.removeSession(session);
		//Logger.getLogger(WebSocketServer.class.getName()).log(Level.SEVERE, "test", error);
	}

	@OnMessage
		public void handleMessage(String message, Session session) throws JSONException {
		
	}

	public void sendMessage(String values) {
		//System.out.println("send message "+room);
		try {
			sessionHandler.sendMessage(new JSONObject(values));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}   