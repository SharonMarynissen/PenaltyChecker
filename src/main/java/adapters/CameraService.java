package adapters;

import be.kdg.se3.services.CameraServiceProxy;
import com.sun.istack.internal.logging.Logger;
import domain.CommunicationException;
import domain.OutputService;
import domain.messages.MessageDTO;

import java.io.IOException;

/**
 * Created by Sharon on 4/06/2017.
 */
public class CameraService implements OutputService {
    private CameraServiceProxy cameraService = new CameraServiceProxy();
    private final String URL = "www.services4se3.com/camera/";
    Logger logger = Logger.getLogger(CameraService.class);

    @Override
    public String sendMessage(MessageDTO messageDTO) throws CommunicationException {
        String messageReturned;

        try {
            messageReturned = cameraService.get(URL + messageDTO);
            logger.info("Answer recieved from CameraServiceProxy: " + messageReturned);
        } catch (IOException e) {
            throw new CommunicationException("Error during call of the CameraService", e);
        }

        return messageReturned;
    }
}
