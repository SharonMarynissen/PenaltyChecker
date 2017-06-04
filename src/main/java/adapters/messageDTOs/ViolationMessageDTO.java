package adapters.messageDTOs;

import domain.messages.IncommingMessageDTO;
import domain.messages.MessageDTO;

/**
 * Created by Sharon on 4/06/2017.
 */
public class ViolationMessageDTO implements MessageDTO {
    private int cameraId;
    private int locationLatitude;
    private int locationLongtitude;
    private int connectedCameraId;
    private int distance;
    private int speedlimit;
    private int euroNormAllowed;
    private String nationalNumber;
    private int euroNormVehicle;

    public ViolationMessageDTO(){ }

    public int getId()                { return cameraId; }
    public int getLocationLatitude()        { return locationLatitude; }
    public int getLocationLongtitude()      { return locationLongtitude; }
    public int getConnectedCameraId()       { return connectedCameraId; }
    public int getDistance()                { return distance; }
    public int getSpeedlimit()              { return speedlimit; }
    public int getEuroNormAllowed()         { return euroNormAllowed; }
    public String getNationalNumber()       { return nationalNumber; }
    public int getEuroNormVehicle()         { return euroNormVehicle; }

    public void setCameraId(int cameraId)                       { this.cameraId = cameraId; }
    public void setLocationLatitude(int locationLatitude)       { this.locationLatitude = locationLatitude; }
    public void setLocationLongtitude(int locationLongtitude)   { this.locationLongtitude = locationLongtitude; }
    public void setConnectedCameraId(int connectedCameraId)     { this.connectedCameraId = connectedCameraId; }
    public void setDistance(int distance)                       { this.distance = distance; }
    public void setSpeedlimit(int speedlimit)                   { this.speedlimit = speedlimit; }
    public void setEuroNormAllowed(int euroNormAllowed)         { this.euroNormAllowed = euroNormAllowed; }
    public void setNationalNumber(String nationalNumber)        { this.nationalNumber = nationalNumber; }
    public void setEuroNormVehicle(int euroNormVehicle)         { this.euroNormVehicle = euroNormVehicle; }
}
