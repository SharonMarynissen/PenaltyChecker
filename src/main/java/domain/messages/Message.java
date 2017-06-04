package domain.messages;

import java.time.LocalTime;

/**
 * Entity representing a camera message
 */
public class Message{
    private int cameraId;
    private LocalTime timestamp;
    private LincensePlate licensePlate;

    public Message(MessageDTO messageDTO){
        this.cameraId = messageDTO.getCameraId();
        this.timestamp = messageDTO.getTimestamp();
        this.licensePlate = messageDTO.getLicensePlate();
    }

    public int getCameraId()                { return cameraId; }
    public LocalTime getTimestamp()         { return timestamp; }
    public LincensePlate getLicensePlate()  { return licensePlate; }


}
