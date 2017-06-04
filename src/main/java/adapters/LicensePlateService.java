package adapters;

import be.kdg.se3.services.LicensePlateServiceProxy;
import com.sun.istack.internal.logging.Logger;
import domain.CommunicationException;
import domain.OutputService;
import domain.messages.MessageDTO;

import java.io.IOException;

/**
 * Created by Sharon on 4/06/2017.
 */
public class LicensePlateService implements OutputService {
    private LicensePlateServiceProxy licensePlateService = new LicensePlateServiceProxy();
    private final String URL = "www.services4se3.com/license-plate/";
    private Logger logger = Logger.getLogger(LicensePlateService.class);

    @Override
    public String sendMessage(MessageDTO messageDTO) throws CommunicationException {
        String messageReturned;

        try {
            messageReturned = licensePlateService.get(URL + messageDTO);
            logger.info("Answer recieved from CameraServiceProxy: " + messageReturned);

        } catch (IOException e) {
            throw new CommunicationException("Error during call to the LicensePlateService", e);
        }

        return messageReturned;
    }
}
