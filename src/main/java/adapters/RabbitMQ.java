package adapters;

import com.rabbitmq.client.*;
import domain.CommunicationException;
import domain.InputListener;
import domain.InputService;
import domain.messages.MessageFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Adapts a RabbitMQ queue endpoint to the domains InputService
 */
public class RabbitMQ implements InputService {
    private final String connectionstring;
    private final String queueName;
    private final MessageFormatter formatter;

    private Connection connection = null;
    private Channel channel = null;

    private Logger logger = LoggerFactory.getLogger(RabbitMQ.class);

    public RabbitMQ(String connectionstring, String queueName, MessageFormatter formatter){
        this.connectionstring = connectionstring;
        this.queueName = queueName;
        this.formatter = formatter;
    }

    @Override
    public void initialize(InputListener listener) throws CommunicationException {
        try {
            ConnectionFactory factory = new ConnectionFactory();
            factory.setUri(connectionstring);

            //Recommended settings
            factory.setRequestedHeartbeat(30);
            factory.setConnectionTimeout(30000);

            connection = factory.newConnection();
            channel = connection.createChannel();
            channel.queueDeclare(queueName, false, false, false, null);

            logger.info("Using uri '" + connectionstring + "'");
            logger.info("Using queue '" + queueName + "'");

            Consumer consumer = new DefaultConsumer(channel){
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                    logger.info("Received message from RabbitMQ queue " + queueName);
                    String content = new String(body, "UTF-8");
                    logger.debug("Message content: " + content);
                    if(listener != null){
                        try {
                            listener.onReceive(formatter.format(content));
                            logger.info("Delivered message to listener");
                        } catch (Exception e){
                            logger.error("Exception during callback to listener", e);
                        }
                    }
                }
            };

            channel.basicConsume(queueName, true, consumer);

        } catch (Exception e){
            throw new CommunicationException("Error during RabbitMQ channel initialisation", e);
        }
    }

    @Override
    public void shutdown() throws CommunicationException {
        try {
            channel.close();;
            connection.close();
        } catch (Exception e){
            throw new CommunicationException("Unable to close connection to RabbitMQ", e);
        }
    }
}
