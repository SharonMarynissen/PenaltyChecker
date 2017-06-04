package adapters.formatters;

import adapters.messageDTOs.LicensePlateServiceMessageDTO;
import domain.CommunicationException;
import domain.messages.IncommingMessageDTO;
import domain.messages.MessageDTO;
import domain.messages.MessageFormatter;
import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Sharon on 4/06/2017.
 */
public class JSONLicensePlateMessageFormatter implements MessageFormatter {
    private Logger logger = Logger.getLogger(JSONLicensePlateMessageFormatter.class);

    @Override
    public MessageDTO format(String messageString) throws CommunicationException {
        LicensePlateServiceMessageDTO messageDTO = new LicensePlateServiceMessageDTO();

        try {
            JSONObject body = new JSONObject(messageString);

            logger.info("Received response: " + body);

            if (body.has("error"))
                throw new CommunicationException("Error response received");

            messageDTO.setPlateId(body.getString("plateId"));
            messageDTO.setNationalNumber(body.getString("nationalNumber"));
            messageDTO.setEuroNumber(body.getInt("euroNumber"));

            logger.info("Proxy answer transformed to LicensePlateServiceMessageDTO: " + messageDTO);

        } catch (JSONException e) {
            throw new CommunicationException("Unable to transform JSON to LicensePlateServiceMessageDTO", e);
        }

        return messageDTO;
    }
}
