package set3r.kmv.ca.helpmenewwest.database.schema;

import android.location.Location;

import com.google.android.gms.maps.model.LatLng;

import org.greenrobot.greendao.annotation.*;

import set3r.kmv.ca.helpmenewwest.CompareDistance;

// THIS CODE IS GENERATED BY greenDAO, EDIT ONLY INSIDE THE "KEEP"-SECTIONS

// KEEP INCLUDES - put your custom includes here
// KEEP INCLUDES END

/**
 * Entity mapped to table "SKYTRAIN".
 */
@Entity
public class Skytrain implements CompareDistance {

    @Id(autoincrement = true)
    private Long id;
    private String address;
    private String name;
    private Double lat;
    private Double lng;

    // KEEP FIELDS - put your custom fields here
    // KEEP FIELDS END

    @Generated
    public Skytrain() {
    }

    public Skytrain(Long id) {
        this.id = id;
    }

    @Generated
    public Skytrain(Long id, String address, String name, Double lat, Double lng) {
        this.id = id;
        this.address = address;
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    // KEEP METHODS - put your custom methods here
    public String toString(){
        return getName();
    }

    public LatLng getLatLng() {
        return new LatLng(this.getLat(), this.getLng());
    }

    public Location getLocation() {
        Location temp = new Location(this.getName());
        temp.setLatitude(this.getLat());
        temp.setLongitude(this.getLng());
        return temp;
    }

    // KEEP METHODS END

}
