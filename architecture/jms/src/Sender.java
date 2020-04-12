import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;

public class Sender {

    public static void main(String[] args) {
        try {
            SessionMaker maker = new SessionMaker();
            TopicSession session = maker.getSession();
            Topic topic = (Topic) maker.getContext().lookup("myTopic");
            TopicPublisher publisher = session.createPublisher(topic);
            TextMessage message = session.createTextMessage();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                System.out.println("Enter Msg, end to terminate:");
                String string = bufferedReader.readLine();
                if (string.equals("end"))
                    break;
                message.setText(string);
                publisher.publish(message);
                System.out.println("Message successfully sent.");
            }
            maker.getConnection().close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
