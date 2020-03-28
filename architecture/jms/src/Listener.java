import javax.jms.*;

public class Listener implements MessageListener {
    public void onMessage(Message m) {
        try {
            TextMessage message = (TextMessage) m;
            System.out.println("following message is received: " + message.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
