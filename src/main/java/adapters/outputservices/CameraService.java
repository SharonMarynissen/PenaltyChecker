package adapters.outputservices;

import adapters.formatters.JSONLicensePlateMessageFormatter;
import adapters.messageDTOs.CameraServiceMessageDTO;
import adapters.formatters.JSONCameraMessageFormatter;
import be.kdg.se3.services.CameraServiceProxy;
import com.sun.istack.internal.logging.Logger;
import domain.CommunicationException;
import domain.MessageMerger;
import domain.OutputService;
import domain.messages.IncommingMessageDTO;
import domain.messages.MessageDTO;
import domain.messages.MessageFormatter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Sharon on 4/06/2017.
 */
public class CameraService implements OutputService {
    private CameraServiceProxy cameraService = new CameraServiceProxy();
    private final String URL = "www.services4se3.com/camera/";
    private MessageFormatter formatter;

    private final List<OutputService> children = new ArrayList<>();
    private MessageMerger merger;
    private Logger logger = Logger.getLogger(CameraService.class);

    public CameraService(MessageMerger merger, MessageFormatter formatter){
        this.merger = merger;
        this.formatter = formatter;
    }

    @Override
    public MessageDTO sendMessage(MessageDTO messageDTO) throws CommunicationException {
        IncommingMessageDTO dto = (IncommingMessageDTO) messageDTO;
        Collection<MessageDTO> messageDTOs = new ArrayList<>();
        messageDTOs.add(messageDTO);

        try {
            String messageReturned = cameraService.get(URL + dto.getCameraId());
            logger.info("Answer received from CameraServiceProxy: " + messageReturned);
            CameraServiceMessageDTO cameraServiceMessageDTO = (CameraServiceMessageDTO) formatter.format(messageReturned);
            messageDTOs.add(cameraServiceMessageDTO);

            if (cameraServiceMessageDTO.getEuroNormAllowed() != -1){
                LicensePlateService licensePlateService = new LicensePlateService(new JSONLicensePlateMessageFormatter());
                messageDTOs.add(licensePlateService.sendMessage(messageDTO));
            }

        } catch (IOException e) {
            throw new CommunicationException("Error during call of the CameraService", e);
        }

         return merger.mergeMessageDTOs(messageDTOs);
    }

    public void addOutputService(OutputService outputService) {
        children.add(outputService);
    }
}
