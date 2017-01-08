package core.services;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class EnvVariablesService {
    @Cacheable("getEnvName")
    public String getEnvName() {
        if(System.getProperty("ENV_NAME")!=null&&System.getProperty("ENV_NAME").trim().length()>0) {
            return System.getProperty("ENV_NAME");
        } else if(System.getenv("ENV_NAME")!=null&&System.getenv("ENV_NAME").trim().length()>0) {
            return System.getenv("ENV_NAME");
        } else {
            return "UNKNOWN ENV_NAME";
        }
    }

    @Cacheable("getBugsnagApiKey")
    public String getBugsnagApiKey() {
        if(System.getProperty("BUGSNAG_API_KEY")!=null&&System.getProperty("BUGSNAG_API_KEY").trim().length()>0) {
            return System.getProperty("BUGSNAG_API_KEY");
        } else if(System.getenv("BUGSNAG_API_KEY")!=null&&System.getenv("BUGSNAG_API_KEY").trim().length()>0) {
            return System.getenv("BUGSNAG_API_KEY");
        } else {
            return "UNKNOWN BUGSNAG_API_KEY";
        }
    }

    @Cacheable("getFromEmailAddress")
    public String getFromEmailAddress() {
        if(System.getProperty("FROM_EMAIL_ADDRESS")!=null&&System.getProperty("FROM_EMAIL_ADDRESS").trim().length()>0) {
            return System.getProperty("FROM_EMAIL_ADDRESS");
        } else if(System.getenv("FROM_EMAIL_ADDRESS")!=null&&System.getenv("FROM_EMAIL_ADDRESS").trim().length()>0) {
            return System.getenv("FROM_EMAIL_ADDRESS");
        } else {
            return "UNKNOWN FROM_EMAIL_ADDRESS";
        }
    }

    @Cacheable("getEmailSmtpUrl")
    public String getEmailSmtpUrl() {
        if(System.getProperty("EMAIL_SMTP_URL")!=null&&System.getProperty("EMAIL_SMTP_URL").trim().length()>0) {
            return System.getProperty("EMAIL_SMTP_URL");
        } else if(System.getenv("EMAIL_SMTP_URL")!=null&&System.getenv("EMAIL_SMTP_URL").trim().length()>0) {
            return System.getenv("EMAIL_SMTP_URL");
        } else {
            return "UNKNOWN EMAIL_SMTP_URL";
        }
    }

    @Cacheable("getEmailSmtpPassword")
    public String getEmailSmtpPassword() {
        if(System.getProperty("EMAIL_SMTP_PASSWORD")!=null&&System.getProperty("EMAIL_SMTP_PASSWORD").trim().length()>0) {
            return System.getProperty("EMAIL_SMTP_PASSWORD");
        } else if(System.getenv("EMAIL_SMTP_PASSWORD")!=null&&System.getenv("EMAIL_SMTP_PASSWORD").trim().length()>0) {
            return System.getenv("EMAIL_SMTP_PASSWORD");
        } else {
            return "UNKNOWN EMAIL_SMTP_PASSWORD";
        }
    }

    @Cacheable("getAdminEmailAddress")
    public String getAdminEmailAddress() {
        if(System.getProperty("ADMIN_EMAIL_ADDRESS")!=null&&System.getProperty("ADMIN_EMAIL_ADDRESS").trim().length()>0) {
            return System.getProperty("ADMIN_EMAIL_ADDRESS");
        } else if(System.getenv("ADMIN_EMAIL_ADDRESS")!=null&&System.getenv("ADMIN_EMAIL_ADDRESS").trim().length()>0) {
            return System.getenv("ADMIN_EMAIL_ADDRESS");
        } else {
            return "UNKNOWN ADMIN_EMAIL_ADDRESS";
        }
    }
}
