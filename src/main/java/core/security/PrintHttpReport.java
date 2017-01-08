package core.security;

import core.outbound.MailedIt;
import core.services.EnvVariablesService;
import core.util.PrettyDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

@Service
public class PrintHttpReport {

    public enum ReportType { INFO, ERROR, SUCCESS  };

    private final MailedIt mailedIt;
    private final EnvVariablesService envVariablesService;

    @Autowired
    public PrintHttpReport(MailedIt mailedIt, EnvVariablesService envVariablesService) {
        Assert.notNull(mailedIt, "MailedIt must not be null!");
        Assert.notNull(envVariablesService, "EnvVariablesService must not be null!");
        this.mailedIt = mailedIt;
        this.envVariablesService = envVariablesService;
    }

    public void emailReport(ReportType reportType, int status, String ipAddress, Map<String, Object> errorAttributes, Map<String, String[]> params, String reqBody, String note, String emailSubject) {
        String emailBody = "";
        System.out.println("---------------------------------------- "+reportType.toString()+" ----------------------------------------");
        String prettyNote = "---------- Note: "+note;
        System.out.println(prettyNote);
        emailBody+=prettyNote+"<br>";
        String prettyServer = "---------- On Server: "+ envVariablesService.getEnvName();
        System.out.println(prettyServer);
        emailBody+=prettyServer+"<br>";
        String prettyDateTime = "---------- Date/Time: "+ PrettyDate.currentDateTimeUtah();
        System.out.println(prettyDateTime);
        emailBody+=prettyDateTime+"<br>";
        String prettyStatus = "---------- Status: "+status;
        System.out.println(prettyStatus);
        emailBody+=prettyStatus+"<br>";
        String prettyIP = "---------- FROM IP Address: "+ipAddress;
        System.out.println(prettyIP);
        emailBody+=prettyIP+"<br>";
        if(errorAttributes != null) {
            for(String key : errorAttributes.keySet()) {
                String prettyAttribute = "---------- Attribute-"+key+": "+errorAttributes.get(key);
                System.out.println(prettyAttribute);
                emailBody+=prettyAttribute+"<br>";
            }
        }
        for(String key : params.keySet()) {
            String param = "---------- Parameter-"+key+":";
            for(String subParam : params.get(key)) {
                param+="    "+subParam;
            }
            System.out.println(param);
            emailBody+=param+"<br>";
        }
        System.out.println("------------------ Body Start");
        emailBody+="------------------ Body Start<br>";
        System.out.println(reqBody);
        emailBody+=reqBody+="<br>";
        System.out.println("------------------ Body End");
        emailBody+="------------------ Body End";
        System.out.println("-------------------------------------- END "+reportType.toString()+" --------------------------------------");

        mailedIt.generateAndSendEmail(envVariableService.getAdminEmailAddress(),emailSubject,emailBody,false, "Email Report ("+reportType.toString()+")");
    }

    public static String getReqBody(HttpServletRequest request) {
        String payloadRequest = "";
        try {
            payloadRequest = getBody(request);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return payloadRequest;
    }

    private static String getBody(HttpServletRequest request) throws IOException {

        String body = null;
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = null;

        try {
            InputStream inputStream = request.getInputStream();
            if (inputStream != null) {
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                char[] charBuffer = new char[128];
                int bytesRead = -1;
                while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
                    stringBuilder.append(charBuffer, 0, bytesRead);
                }
            } else {
                stringBuilder.append("");
            }
        } catch (IOException ex) {
            throw ex;
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException ex) {
                    throw ex;
                }
            }
        }

        body = stringBuilder.toString();
        return body;
    }

    public static String getIp(HttpServletRequest request) {
        String ipAddress = request.getHeader("X-FORWARDED-FOR");
        if (ipAddress == null) {
            ipAddress = request.getRemoteAddr();
        }
        return ipAddress;
    }

}
