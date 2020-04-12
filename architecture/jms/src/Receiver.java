import javax.jms.*;
import javax.naming.InitialContext;

public class Receiver {
    public static void main(String[] args) {
        try {
            SessionMaker maker = new SessionMaker();
            TopicSession session = maker.getSession();
            Topic topic = (Topic) maker.getContext().lookup("myTopic");
            TopicSubscriber receiver = session.createSubscriber(topic);
            Listener listener = new Listener();
            receiver.setMessageListener(listener);
            System.out.println("Subscriber1 is ready, waiting for messages...");
            System.out.println("press Ctrl+c to shutdown...");
            while (true) {
                Thread.sleep(100);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
