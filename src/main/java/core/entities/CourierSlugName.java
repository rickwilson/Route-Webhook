package core.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.ArrayList;

@Entity
public class CourierSlugName {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String slug;
    /** Name of courier */
    private String name;
    /** Other name of courier, if several they will be separated by commas */
    private String other_name;
    /** Require fields for this courier */
    private ArrayList<String> requireFields;

    @NotNull
    @Column(nullable = false)
    private Timestamp created;

    @NotNull
    @Column(nullable = false)
    private Timestamp updated;

    private int updateCount;

    public CourierSlugName() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOther_name() {
        return other_name;
    }

    public void setOther_name(String other_name) {
        this.other_name = other_name;
    }

    public ArrayList<String> getRequireFields() {
        return requireFields;
    }

    public void setRequireFields(ArrayList<String> requireFields) {
        this.requireFields = requireFields;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public Timestamp getUpdated() {
        return updated;
    }

    public void setUpdated(Timestamp updated) {
        this.updated = updated;
    }

    public int getUpdateCount() {
        return updateCount;
    }

    public void setUpdateCount(int updateCount) {
        this.updateCount = updateCount;
    }
}
