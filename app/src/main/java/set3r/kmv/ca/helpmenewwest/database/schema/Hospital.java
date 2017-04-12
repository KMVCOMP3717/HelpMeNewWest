package set3r.kmv.ca.helpmenewwest.database.schema;

import android.location.Location;

import com.google.android.gms.maps.model.LatLng;


import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;

import org.greenrobot.greendao.annotation.*;


// THIS CODE IS GENERATED BY greenDAO, EDIT ONLY INSIDE THE "KEEP"-SECTIONS

// KEEP INCLUDES - put your custom includes here
// KEEP INCLUDES END

/**
 * Entity mapped to table "HOSPITAL".
 */
@Entity
public class Hospital {

    @Id(autoincrement = true)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String address;
    private double lat;
    private double lng;

    // KEEP FIELDS - put your custom fields here
    // KEEP FIELDS END

    @Generated
    public Hospital() {
    }

    public Hospital(Long id) {
        this.id = id;
    }

    @Generated
    public Hospital(Long id, String name, String address, double lat, double lng) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.lat = lat;
        this.lng = lng;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NotNull
    public String getName() {
        return name;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setName(@NotNull String name) {
        this.name = name;
    }

    @NotNull
    public String getAddress() {
        return address;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setAddress(@NotNull String address) {
        this.address = address;
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
    public String toString() {
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
