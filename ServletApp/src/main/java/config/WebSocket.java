package config;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/ws")
public class WebSocket {

    private Session session;

    @OnOpen
    public void connect(Session session) {
        System.out.println("Giriş " + session.getId());
        this.session = session;
    }

    @OnClose
    public void close() {
        System.out.println("Çıkış " + session.getId());
        this.session = null;
    }

    @OnMessage
    public void message(String message) {
        System.out.println("Mesaj = "+message);
        this.session.getAsyncRemote().sendText(message + " Gelen Mesaj");
    }
}
