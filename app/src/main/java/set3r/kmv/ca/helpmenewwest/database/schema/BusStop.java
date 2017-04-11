package set3r.kmv.ca.helpmenewwest.database.schema;

import android.location.Location;
import com.google.android.gms.maps.model.LatLng;
import org.greenrobot.greendao.annotation.*;

// THIS CODE IS GENERATED BY greenDAO, EDIT ONLY INSIDE THE "KEEP"-SECTIONS

// KEEP INCLUDES - put your custom includes here
// KEEP INCLUDES END

/**
 * Entity mapped to table "BUS_STOP".
 */
@Entity
public class BusStop {

    @Id(autoincrement = true)
    private Long id;
    private String address;
    private String description;
    private double lat;
    private double lng;

    // KEEP FIELDS - put your custom fields here
    // KEEP FIELDS END

    @Generated
    public BusStop() {
    }

    public BusStop(Long id) {
        this.id = id;
    }

    @Generated
    public BusStop(Long id, String address, String description, double lat, double lng) {
        this.id = id;
        this.address = address;
        this.description = description;
        this.lat = lat;
        this.lng = lng;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    // KEEP METHODS - put your custom methods here

    public String toString(){
        return getAddress();
    }
    public LatLng getLatLng() {
        return new LatLng(this.getLat(), this.getLng());
    }

    public Location getLocation() {
        Location temp = new Location(this.getAddress());
        temp.setLatitude(this.getLat());
        temp.setLongitude(this.getLng());
        return temp;
    }
    // KEEP METHODS END

}
