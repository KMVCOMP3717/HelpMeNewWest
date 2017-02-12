package set3r.kmv.ca.helpmenewwest.database.schema;

import org.greenrobot.greendao.annotation.*;

// THIS CODE IS GENERATED BY greenDAO, EDIT ONLY INSIDE THE "KEEP"-SECTIONS

// KEEP INCLUDES - put your custom includes here
// KEEP INCLUDES END

/**
 * Entity mapped to table "HOSPITALS".
 */
@Entity
public class hospitals {

    @Id(autoincrement = true)
    private Long id;

    @NotNull
    private String name;
    private String building_id;
    private String map_ref;

    @NotNull
    private String street_num;

    @NotNull
    private String street_name;

    // KEEP FIELDS - put your custom fields here
    // KEEP FIELDS END

    @Generated
    public hospitals() {
    }

    public hospitals(Long id) {
        this.id = id;
    }

    @Generated
    public hospitals(Long id, String name, String building_id, String map_ref, String street_num, String street_name) {
        this.id = id;
        this.name = name;
        this.building_id = building_id;
        this.map_ref = map_ref;
        this.street_num = street_num;
        this.street_name = street_name;
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

    public String getBuilding_id() {
        return building_id;
    }

    public void setBuilding_id(String building_id) {
        this.building_id = building_id;
    }

    public String getMap_ref() {
        return map_ref;
    }

    public void setMap_ref(String map_ref) {
        this.map_ref = map_ref;
    }

    @NotNull
    public String getStreet_num() {
        return street_num;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setStreet_num(@NotNull String street_num) {
        this.street_num = street_num;
    }

    @NotNull
    public String getStreet_name() {
        return street_name;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setStreet_name(@NotNull String street_name) {
        this.street_name = street_name;
    }

    // KEEP METHODS - put your custom methods here
    // KEEP METHODS END

}
