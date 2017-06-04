package domain;

import adapters.CameraService;
import domain.messages.Message;
import domain.messages.MessageDTO;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sharon on 3/06/2017.
 */
public class Manager implements InputListener {
    private InputService inputService;
    private Logger logger = Logger.getLogger(Manager.class);
    private final List<OutputService> outputServices = new ArrayList<>();

    public Manager(InputService inputService){
        this.inputService = inputService;
    }

    public void start() {
        try {
            inputService.initialize(this);
        } catch (CommunicationException e) {
            logger.fatal("Unable to initialize communication channel", e);
        }
    }

    public void stop() {
        try {
            inputService.shutdown();
        } catch (CommunicationException e) {
            logger.warn("Unable to properly shut down communication channel");
        }
    }

    @Override
    public void onReceive(MessageDTO messageDTO) {
        logger.info("Received message from InputService");
        Message message = new Message(messageDTO);

        for(OutputService out : outputServices){
            if (out.equals(CameraService.class))
                logger.info("true");

        }

    }

    public void addOutputService(OutputService outputService){
        outputServices.add(outputService);
    }

    public void removeOutputService(OutputService outputService){
        outputServices.remove(outputService);
    }

}
