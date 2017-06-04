package domain.messages;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * Date Transfer Object for converting an incoming message format to a message
 */
public class IncommingMessageDTO implements MessageDTO{
    private int cameraId;
    private LincensePlate licensePlate;
    private LocalTime timestamp;

    public IncommingMessageDTO() {
    }

    public void setCameraId(int cameraId)                        { this.cameraId = cameraId; }
    public void setLicensePlate(LincensePlate licensePlate)    { this.licensePlate = licensePlate; }
    public void setTimestamp(LocalTime timestamp)              { this.timestamp = timestamp; }


    public int getCameraId()                      { return cameraId; }
    public LincensePlate getLicensePlate()        { return licensePlate; }
    public LocalTime getTimestamp()               { return timestamp; }

    @Override
    public String toString() {
        return String.format("Camera %-5d %-12s %s", cameraId, licensePlate,
                DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM).format(timestamp));
    }

}
