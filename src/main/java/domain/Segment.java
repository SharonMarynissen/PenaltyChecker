package domain;

/**
 * Created by Sharon on 4/06/2017.
 */
public class Segment {
    private int connectedCameraId;
    private int distance;
    private int speedLimit;

    public Segment(){ }

    public int getConnectedCameraId()       { return connectedCameraId; }
    public int getDistance()                { return distance; }
    public int getSpeedlimit()              { return speedLimit; }

    public void setConnectedCameraId(int connectedCameraId)     { this.connectedCameraId = connectedCameraId; }
    public void setDistance(int distance)                       { this.distance = distance; }
    public void setSpeedlimit(int speedLimit)                   { this.speedLimit = speedLimit; }
}
