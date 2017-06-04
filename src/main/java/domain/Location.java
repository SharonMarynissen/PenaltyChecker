package domain;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Sharon on 4/06/2017.
 */
public class Location {
    private int lat;
    private int longtitude;

    public int getLat()              { return lat; }
    public int getLongtitude()       { return longtitude; }

    public void setLat(int lat)         { this.lat = lat; }
    public void setLongtitude(int longtitude)     { this.longtitude = longtitude; }
}
