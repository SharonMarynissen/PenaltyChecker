import adapters.CameraService;
import adapters.RabbitMQ;
import adapters.XMLMessageFormatter;
import domain.InputService;
import domain.Manager;
import domain.OutputService;
import domain.messages.MessageFormatter;

/**
 * Created by Sharon on 3/06/2017.
 */
public class PenaltyChecker {
    public static void main(String[] args) {
        String uri = "amqp://garalhym:6TYjhiUm_wXY47k0MZ8YQGuLYAtS-65U@puma.rmq.cloudamqp.com/garalhym";
        MessageFormatter formatter = new XMLMessageFormatter();
        InputService inputService = new RabbitMQ(uri, "CAMERA MESSAGES", formatter);
        OutputService outputService = new CameraService();

        Manager manager = new Manager(inputService);
        manager.addOutputService(outputService);

        manager.start();
    }
}
