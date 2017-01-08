package core.outbound;

import com.bugsnag.Bugsnag;
import core.entities.EmailLogger;
import core.entities.EmailLoggerDAO;
import core.services.EnvVariablesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Properties;

@Service
public class MailedIt{

    private final EmailLoggerDAO emailLoggerDAO;
    private final Bugsnag bugsnag;
    private final EnvVariablesService envVariablesService;

    @Autowired
    public MailedIt(EmailLoggerDAO emailLoggerDAO, Bugsnag bugsnag, EnvVariablesService envVariablesService) {
        Assert.notNull(emailLoggerDAO, "EmailLoggerDAO must not be null!");
        Assert.notNull(bugsnag, "Bugsnag must not be null!");
        Assert.notNull(envVariablesService, "EnvVariablesService must not be null!");
        this.emailLoggerDAO = emailLoggerDAO;
        this.bugsnag = bugsnag;
        this.envVariablesService = envVariablesService;
    }

    public void generateAndSendEmail(ArrayList<String> emailAddressTo, String emailSubject, String emailBody, boolean sendNow, String category) {
        if(!envVariablesService.getEnvName().startsWith("PROD")) {
            emailAddressTo.clear();
            emailAddressTo.add(envVariableService.getAdminEmailAddress());
        }
        EmailLogger emailLogger = new EmailLogger(envVariablesService.getEnvName(),emailAddressTo,envVariablesService.getFromEmailAddress(),emailSubject,emailBody,category);
        emailLoggerDAO.save(emailLogger);
        if(sendNow) {
            sendNow(emailLogger);
        }
    }

    public void generateAndSendEmail(String emailAddressTo, String emailSubject, String emailBody, boolean sendNow, String category) {
        ArrayList<String> emailAddressToArrayList = new ArrayList();
        emailAddressToArrayList.add(emailAddressTo);
        generateAndSendEmail(emailAddressToArrayList,emailSubject,emailBody,sendNow,category);
    }

    public void sendNow(EmailLogger emailLogger) {
        Properties mailServerProperties;
        String emailAddressFrom = envVariablesService.getFromEmailAddress();
        mailServerProperties = System.getProperties();
        mailServerProperties.put("mail.smtp.port", "587");
        mailServerProperties.put("mail.smtp.auth", "true");
        mailServerProperties.put("mail.smtp.starttls.enable", "true");
        MimeMessage generateMailMessage;
        try {
            Session getMailSession = Session.getDefaultInstance(mailServerProperties, null);
            generateMailMessage = new MimeMessage(getMailSession);
            generateMailMessage.setFrom(new InternetAddress(emailAddressFrom));
            for(String emailAddressTo : emailLogger.getEmailAddressTo()) {
                generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(emailAddressTo));
            }
            generateMailMessage.setSubject(emailLogger.getEmailSubject());
            String body = new String(emailLogger.getEmailBody(), StandardCharsets.UTF_8);
            generateMailMessage.setContent(body, "text/html");

            Transport transport = getMailSession.getTransport("smtp");
            transport.connect(envVariablesService.getEmailSmtpUrl(), emailAddressFrom, envVariablesService.getEmailSmtpPassword());
            transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
            transport.close();
            emailLogger.setSent(true);
        } catch (MessagingException emailException) {
            String trimmedError = emailException.getMessage();
            if(trimmedError.length() > 251) {
                trimmedError = trimmedError.substring(0,250);
            }
            emailLogger.setNote(trimmedError);
            emailLogger.setFailed(true);
            bugsnag.notify(emailException);
        }
        emailLoggerDAO.save(emailLogger);
    }
}
