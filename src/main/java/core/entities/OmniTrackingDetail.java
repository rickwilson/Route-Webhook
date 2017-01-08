package core.entities;

import core.thirdParty.aftership.enums.ISO3Country;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
public class OmniTrackingDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Column(nullable = false)
    private long omniTrackingId;

    @NotNull
    @Column(nullable = false)
    private long accountId;

    /** Date and time of the tracking created. */
    private String createdAt;

    /** Date and time of the checkpoint, provided by courier. Value may be:
     Empty String,
     YYYY-MM-DD,
     YYYY-MM-DDTHH:MM:SS, or
     YYYY-MM-DDTHH:MM:SS+TIMEZONE */
    private String checkpointTime;

    /** Location info (if any) */
    private String city;

    /** Country ISO Alpha-3 (three letters) of the checkpoint */
    private ISO3Country countryISO3;

    /** Country name of the checkpoint, may also contain other location info. */
    private String countryName;

    /** Checkpoint message */
    private String message;

    /** Location info (if any) */
    private String state;

    /** Status of the checkpoint */
    private String tag;

    /** Location info (if any) */
    private String zip;

    /** Location info (if any) */
    private String location;

    private LocalDateTime createdByDateTime;

    public OmniTrackingDetail() {
    }

    public OmniTrackingDetail(long omniTrackingId, long accountId, String createdAt, String checkpointTime, String city, ISO3Country countryISO3, String countryName, String message, String state, String tag, String zip, String location) {
        this.omniTrackingId = omniTrackingId;
        this.accountId = accountId;
        this.createdAt = createdAt;
        this.checkpointTime = checkpointTime;
        this.city = city;
        this.countryISO3 = countryISO3;
        this.countryName = countryName;
        this.message = message;
        this.state = state;
        this.tag = tag;
        this.zip = zip;
        this.location = location;
        this.createdByDateTime = LocalDateTime.now();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getOmniTrackingId() {
        return omniTrackingId;
    }

    public void setOmniTrackingId(long omniTrackingId) {
        this.omniTrackingId = omniTrackingId;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getCheckpointTime() {
        return checkpointTime;
    }

    public void setCheckpointTime(String checkpointTime) {
        this.checkpointTime = checkpointTime;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public ISO3Country getCountryISO3() {
        return countryISO3;
    }

    public void setCountryISO3(ISO3Country countryISO3) {
        this.countryISO3 = countryISO3;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDateTime getCreatedByDateTime() {
        return createdByDateTime;
    }

    public void setCreatedByDateTime(LocalDateTime createdByDateTime) {
        this.createdByDateTime = createdByDateTime;
    }
}
