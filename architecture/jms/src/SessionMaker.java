import javax.jms.Session;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicSession;
import javax.naming.InitialContext;

public class SessionMaker {
    private InitialContext context;
    private TopicConnection connection;
    private TopicSession session;

    public SessionMaker() {
        try {
            this.context = new InitialContext();
            TopicConnectionFactory factory = (TopicConnectionFactory) context.lookup("myTopicConnectionFactory");
            this.connection = factory.createTopicConnection();
            this.connection.start();
            this.session = connection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public TopicConnection getConnection() {
        return this.connection;
    }

    public InitialContext getContext() {
        return this.context;
    }

    public TopicSession getSession() {
        return session;
    }
}
