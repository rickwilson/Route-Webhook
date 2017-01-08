package core.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.util.ArrayList;

@Entity
public class EmailLogger {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Column(nullable = false)
    private String server;

    @NotNull
    @Column(nullable = false)
    private ArrayList<String> emailAddressTo;

    @NotNull
    @Column(nullable = false)
    private String emailAddressFrom;

    @NotNull
    @Column(nullable = false)
    private String emailSubject;

    @Lob
    @Column(length=100000)
    private byte[] emailBody;

    private String category;

    private String note;

    @NotNull
    @Column(nullable = false)
    private boolean sent;

    @NotNull
    @Column(nullable = false)
    private boolean failed;

    @NotNull
    @Column(nullable = false)
    private Timestamp created;

    public EmailLogger() {
    }

    public EmailLogger(String server, ArrayList<String> emailAddressTo, String emailAddressFrom, String emailSubject, String emailBody, String category) {
        this.server = server;
        this.emailAddressTo = emailAddressTo;
        this.emailAddressFrom = emailAddressFrom;
        this.emailSubject = emailSubject;
        this.emailBody = emailBody.getBytes(StandardCharsets.UTF_8);
        this.category = category;
        this.sent = false;
        this.failed = false;
        this.created = new Timestamp(System.currentTimeMillis());
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public ArrayList<String> getEmailAddressTo() {
        return emailAddressTo;
    }

    public void setEmailAddressTo(ArrayList<String> emailAddressTo) {
        this.emailAddressTo = emailAddressTo;
    }

    public String getEmailAddressFrom() {
        return emailAddressFrom;
    }

    public void setEmailAddressFrom(String emailAddressFrom) {
        this.emailAddressFrom = emailAddressFrom;
    }

    public String getEmailSubject() {
        return emailSubject;
    }

    public void setEmailSubject(String emailSubject) {
        this.emailSubject = emailSubject;
    }

    public byte[] getEmailBody() {
        return emailBody;
    }

    public void setEmailBody(byte[] emailBody) {
        this.emailBody = emailBody;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public boolean isSent() {
        return sent;
    }

    public void setSent(boolean sent) {
        this.sent = sent;
    }

    public boolean isFailed() {
        return failed;
    }

    public void setFailed(boolean failed) {
        this.failed = failed;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }
}
