package adapters.outputservices;

import be.kdg.se3.services.LicensePlateServiceProxy;
import com.sun.istack.internal.logging.Logger;
import domain.CommunicationException;
import domain.OutputService;
import domain.messages.IncommingMessageDTO;
import domain.messages.Message;
import domain.messages.MessageDTO;
import domain.messages.MessageFormatter;

import java.io.IOException;

/**
 * Created by Sharon on 4/06/2017.
 */
public class LicensePlateService implements OutputService {
    private LicensePlateServiceProxy licensePlateService = new LicensePlateServiceProxy();
    private final String URL = "www.services4se3.com/license-plate/";
    private Logger logger = Logger.getLogger(LicensePlateService.class);
    private MessageFormatter formatter;

    public LicensePlateService(MessageFormatter formatter) {
        this.formatter = formatter;
    }

    @Override
    public MessageDTO sendMessage(MessageDTO messageDTO) throws CommunicationException {
        IncommingMessageDTO dto = (IncommingMessageDTO) messageDTO;
        String messageReturned;

        try {
            messageReturned = licensePlateService.get(URL + dto.getLicensePlate().getPlate());
            logger.info("Answer received from LicensePlateServiceProxy: " + messageReturned);
            logger.info("Answer transformed to LicensePlateServiceMessageDTO: " + formatter.format(messageReturned));
        } catch (IOException e) {
            throw new CommunicationException("Error during call to the LicensePlateService", e);
        }

        return formatter.format(messageReturned);
    }
}
