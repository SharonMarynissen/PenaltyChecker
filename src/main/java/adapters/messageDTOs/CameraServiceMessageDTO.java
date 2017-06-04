package adapters.messageDTOs;

import domain.Location;
import domain.Segment;
import domain.messages.MessageDTO;

/**
 * Message Data Transfer Object that contains all the information returned by a CameraService
 */
public class CameraServiceMessageDTO implements MessageDTO {
    private int cameraId;
    private Location location;
    private Segment segment;
    private int euroNormAllowed = -1;

    public CameraServiceMessageDTO(){ }

    public int getId()               { return cameraId; }
    public Location getLocation()    { return location; }
    public Segment getSegment()      { return segment; }
    public int getEuroNormAllowed()  { return euroNormAllowed; }

    public void setCameraId(int cameraId)                   { this.cameraId = cameraId; }
    public void setEuroNormAllowed(int euroNormAllowed)     { this.euroNormAllowed = euroNormAllowed; }
    public void setLocation(Location location)              { this.location = location; }
    public void setSegment(Segment segment)                 { this.segment = segment; }

    @Override
    public String toString() {
        return String.format("CameraId: %d\tLocation:(%d;%d) %s %s",
                cameraId, location.getLat(), location.getLongtitude(),
                segment == null ? " " : "\tConnected camera: " + segment.getConnectedCameraId()
                        + " (distance: " + segment.getDistance() + " ; speedlimit: " + segment.getSpeedlimit() + ")",
                euroNormAllowed == -1 ? " " : "\tEuroNorm allowed: " + euroNormAllowed);
    }
}
