package webSocket;


import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.json.JSONException;
import org.json.JSONObject;

import bean.article;
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
		article art1 = new article(1, "Accident a Belle-vue", "Un accident de trotinette à Belle-vue a fait 12 blessés graves lorsque le trotineur à perdu le controle de son véhicule...");
		article art2 = new article(2, "Boire ou conduire, il faut choisir", "Ivre, un nouveau renanais controlé a 180km/h au niveau de la Penfeld");
		article art3 = new article(2, "Ivre, l'unijambiste sans permis conduisait avec un balai", "Ce multi-recidiviste à été controlé par les services de polices de la ville de brest.");

			List<article> lst = new ArrayList<>();
			
			lst.add(art1);
			lst.add(art2);
			lst.add(art3);
			String json = JSonGenerator.listArticleToJSon(lst);
	    	sendMessage(json);
		
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