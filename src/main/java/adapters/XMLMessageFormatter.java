package adapters;

import domain.CommunicationException;
import domain.messages.LincensePlate;
import domain.messages.MessageDTO;
import domain.messages.MessageFormatter;
import org.apache.log4j.Logger;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.IOException;
import java.io.StringReader;
import java.time.LocalTime;


/**
 * A formatter that uses JDOM to transfer an XML string into a {@link MessageDTO}
 */
public class XMLMessageFormatter implements MessageFormatter {
    private Logger logger = Logger.getLogger(XMLMessageFormatter.class);

    @Override
    public MessageDTO format(String messageString) throws CommunicationException {
        MessageDTO out = new MessageDTO();

        try {
            SAXBuilder sb = new SAXBuilder();
            Document doc = sb.build(new StringReader(messageString));
            Element rootElement = doc.getRootElement();

            out.setCameraId(Integer.parseInt(rootElement.getChildText("camera-id")));
            out.setTimestamp(LocalTime.parse(rootElement.getChildText("timestamp")));
            out.setLicensePlate(new LincensePlate(rootElement.getChildText("license-plate")));

            logger.info("Tranformed XML string to MessageDTO: '" + out.toString() + "'");
        } catch (JDOMException | IOException e) {
            throw new CommunicationException("Error during conversion to DTO", e);
        }

        return out;
    }
}

