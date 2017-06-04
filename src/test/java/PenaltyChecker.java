import adapters.*;
import adapters.formatters.JSONCameraMessageFormatter;
import adapters.formatters.XMLMessageFormatter;
import adapters.messageDTOs.LicensePlateServiceMessageDTO;
import adapters.outputservices.CameraService;
import domain.*;
import domain.messages.MessageFormatter;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Sharon on 3/06/2017.
 */
public class PenaltyChecker {
    public static void main(String[] args) {
        String uri = "amqp://garalhym:6TYjhiUm_wXY47k0MZ8YQGuLYAtS-65U@puma.rmq.cloudamqp.com/garalhym";
        MessageFormatter formatter = new XMLMessageFormatter();
        InputService inputService = new RabbitMQ(uri, "CAMERA MESSAGES", formatter);
        OutputService outputService = new CameraService(new DTOMerger(), new JSONCameraMessageFormatter());

        Manager manager = new Manager(inputService);
        manager.setOutputService(outputService);
        manager.start();

/*
        LicensePlateServiceMessageDTO messageDTO = new LicensePlateServiceMessageDTO();
        String messageString = "{\"plateId\":\"8-DIO-927\",\"nationalNumber\":\"56.11.01-332.09\",\"euroNumber\":3}";

        try {
            JSONObject body = new JSONObject(messageString);

            if (body == null)
                System.out.println("No JSON LicensePlateServiceMessage received");

            System.out.println("Received response: " + body);

            if (body.has("error"))
                System.out.println("Error response received");

            messageDTO.setPlateId(body.getString("plateId"));
            messageDTO.setNationalNumber(body.getString("nationalNumber"));
            messageDTO.setEuroNumber(body.getInt("euroNumber"));

            System.out.println("Proxy answer transformed to LicensePlateServiceMessageDTO: " + messageDTO);

        } catch (JSONException e) {
            System.out.println("Unable to transform JSON to LicensePlateServiceMessageDTO");
        }

        System.out.println(messageDTO.toString());
*/
    }
}
