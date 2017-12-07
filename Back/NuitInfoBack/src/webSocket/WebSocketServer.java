package webSocket;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Date;
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
		
		String[] lstData = message.split(";");
		String ipClient = "";
		String idProduit = "";
		int quantite = -1;
		String action = "";
		Date currentTime = new Date();;
		
		for (String string : lstData) {
			if(string.contains("ip")){
				ipClient = string.split("=")[1];
			}
			if(string.contains("id")){
				idProduit = string.split("=")[1];
			}
			if(string.contains("nb")){
				quantite = (int) Integer.parseInt(string.split("=")[1]);
			}
			if(string.contains("action")){
				action = string.split("=")[1];
			}
		}
		
		@SuppressWarnings("deprecation")
		String logLine = "--->> "+ currentTime.getHours()+":"+currentTime.getMinutes()+" "+ ipClient +" : idProduit = "+idProduit+"; quantite = "+quantite+"; action = "+action;
        System.out.println(logLine);
        
        logLine += "\n";
        
        try {
            Files.write(Paths.get("D:/CaissePress2Play.log"), logLine.getBytes(), StandardOpenOption.APPEND);
        }catch (IOException e) {
            //exception handling left as an exercise for the reader
        }

    	DAO dao = new DAO(); 
    	dao.ouvrir();
    	if(action.equals("add")){
      	  	dao.updateProduct(idProduit, quantite, true);
    	}else{
      	  	dao.updateProduct(idProduit, quantite, false);
    	}

    	sendMessage(JSonGenerator.listProduitToJSon(dao.listerProduits()));
    	dao.fermer();

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