package corba;

import java.util.*;
import corba.ChatInterface.*;

public class ChatServerImpl extends corba.ChatInterface.ChatServerPOA {
    protected class Client {
        public corba.ChatInterface.ChatClient chatclient;
        public String nick;
        public Client(String nick, ChatInterface.ChatClient chatclient) {
            this.chatclient = chatclient;
            this.nick = nick;
        }
    }

    protected Map<String, Client> clients = new HashMap<String, Client>();
    protected List<String> nicks = new Vector<String>();

    public String subscribe(String nick, ChatInterface.ChatClient c)
            throws ChatInterface.NameAlreadyUsed {
        if (nicks.contains(nick)) throw new ChatInterface.NameAlreadyUsed();
        nicks.add(nick);
        String id = UUID.randomUUID().toString();
        System.out.println("subscribe: " + nick + " -> " + id);
        clients.put(id, new Client(nick, c));
        return id;
    }

    public void unsubscribe(String id) throws ChatInterface.UnknownID {
        System.out.println("unsubscribe: " + id);
        Client c = clients.remove(id);
        if (c == null) throw new ChatInterface.UnknownID();
        nicks.remove(c.nick);
    }

    public void send(String id, String text) throws ChatInterface.UnknownID {
        Client from = clients.get(id);
        if (from == null) throw new ChatInterface.UnknownID();
        System.out.println(
                "comment: " + text + " by " + id+ " [" + from.nick + "]");
        for (Client to : clients.values()) {
            to.chatclient.update(from.nick, text);
        }
    }

}