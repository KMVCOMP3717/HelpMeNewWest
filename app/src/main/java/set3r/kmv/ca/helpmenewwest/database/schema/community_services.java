package set3r.kmv.ca.helpmenewwest.database.schema;

import org.greenrobot.greendao.annotation.*;

// THIS CODE IS GENERATED BY greenDAO, EDIT ONLY INSIDE THE "KEEP"-SECTIONS

// KEEP INCLUDES - put your custom includes here
// KEEP INCLUDES END

/**
 * Entity mapped to table "COMMUNITY_SERVICES".
 */
@Entity
public class community_services {

    @Id(autoincrement = true)
    private Long id;

    @NotNull
    private String name;
    private String description;
    private String hours;
    private String location;
    private String postal_code;
    private Long phone;
    private String email;
    private String website;
    private long category_id;

    // KEEP FIELDS - put your custom fields here
    // KEEP FIELDS END

    @Generated
    public community_services() {
    }

    public community_services(Long id) {
        this.id = id;
    }

    @Generated
    public community_services(Long id, String name, String description, String hours, String location, String postal_code, Long phone, String email, String website, long category_id) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.hours = hours;
        this.location = location;
        this.postal_code = postal_code;
        this.phone = phone;
        this.email = email;
        this.website = website;
        this.category_id = category_id;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(long category_id) {
        this.category_id = category_id;
    }

    // KEEP METHODS - put your custom methods here
    // KEEP METHODS END

}
