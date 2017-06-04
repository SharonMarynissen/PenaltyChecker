package domain;

import domain.messages.IncommingMessageDTO;
import domain.messages.MessageDTO;
import org.apache.log4j.Logger;

/**
 * Created by Sharon on 3/06/2017.
 */
public class Manager implements InputListener {
    private InputService inputService;
    private Logger logger = Logger.getLogger(Manager.class);
    private OutputService outputService;

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

        if(outputService != null){
            try {
               outputService.sendMessage(messageDTO);
            } catch (CommunicationException e) {
               logger.error("Unable to send message to OutputService", e);
            }
        }

    }

    public void setOutputService(OutputService outputService) {
        this.outputService = outputService;
    }
}
