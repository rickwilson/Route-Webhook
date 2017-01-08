package core.entities;

import core.entities.enums.MarkupType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Entity
public class ApiKey {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Column(nullable = false)
    private long accountId;

    private String name;

    private String widgetKey;

    @NotNull
    @Column(nullable = false)
    private String apiKey;

    private String secret;

    private String testWidgetKey;

    private String testApiKey;

    private String testSecret;

    private long billingId;

    private MarkupType markupType;

    private int markupPercent;

    private float markupFixed;

    @NotNull
    @Column(nullable = false)
    private boolean shippingNotifications = false;

    @NotNull
    @Column(nullable = false)
    private boolean systemAdmin;

    @NotNull
    @Column(nullable = false)
    private boolean active;

    @NotNull
    @Column(nullable = false)
    private Timestamp created;

    private Timestamp deactivated;

    private long addedByUserId;

    private String addedByName;

    private String description;

    // ----------------------------------------------


    public ApiKey() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWidgetKey() {
        return widgetKey;
    }

    public void setWidgetKey(String widgetKey) {
        this.widgetKey = widgetKey;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getTestWidgetKey() {
        return testWidgetKey;
    }

    public void setTestWidgetKey(String testWidgetKey) {
        this.testWidgetKey = testWidgetKey;
    }

    public String getTestApiKey() {
        return testApiKey;
    }

    public void setTestApiKey(String testApiKey) {
        this.testApiKey = testApiKey;
    }

    public String getTestSecret() {
        return testSecret;
    }

    public void setTestSecret(String testSecret) {
        this.testSecret = testSecret;
    }

    public long getBillingId() {
        return billingId;
    }

    public void setBillingId(long billingId) {
        this.billingId = billingId;
    }

    public MarkupType getMarkupType() {
        return markupType;
    }

    public void setMarkupType(MarkupType markupType) {
        this.markupType = markupType;
    }

    public int getMarkupPercent() {
        return markupPercent;
    }

    public void setMarkupPercent(int markupPercent) {
        this.markupPercent = markupPercent;
    }

    public float getMarkupFixed() {
        return markupFixed;
    }

    public void setMarkupFixed(float markupFixed) {
        this.markupFixed = markupFixed;
    }

    public boolean isShippingNotifications() {
        return shippingNotifications;
    }

    public void setShippingNotifications(boolean shippingNotifications) {
        this.shippingNotifications = shippingNotifications;
    }

    public boolean isSystemAdmin() {
        return systemAdmin;
    }

    public void setSystemAdmin(boolean systemAdmin) {
        this.systemAdmin = systemAdmin;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public Timestamp getDeactivated() {
        return deactivated;
    }

    public void setDeactivated(Timestamp deactivated) {
        this.deactivated = deactivated;
    }

    public long getAddedByUserId() {
        return addedByUserId;
    }

    public void setAddedByUserId(long addedByUserId) {
        this.addedByUserId = addedByUserId;
    }

    public String getAddedByName() {
        return addedByName;
    }

    public void setAddedByName(String addedByName) {
        this.addedByName = addedByName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
