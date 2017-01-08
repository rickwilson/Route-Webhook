package core.controllers;

import core.security.PrintHttpReport;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
public class DefaultController {

    private final ErrorAttributes errorAttributes;
    private final PrintHttpReport printHttpReport;

    public DefaultController(ErrorAttributes errorAttributes, PrintHttpReport printHttpReport) {
        Assert.notNull(errorAttributes, "ErrorAttributes must not be null!");
        Assert.notNull(printHttpReport, "PrintHttpReport must not be null!");
        this.errorAttributes = errorAttributes;
        this.printHttpReport = printHttpReport;
    }

    private Map<String, Object> getErrorAttributes(HttpServletRequest request, boolean includeStackTrace) {
        RequestAttributes requestAttributes = new ServletRequestAttributes(request);
        return errorAttributes.getErrorAttributes(requestAttributes, includeStackTrace);
    }

    @RequestMapping(value="/")
    public String jspIndex() {
        return "index";
    }

    @RequestMapping(value="/login")
    public String login(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> errorAttributes = getErrorAttributes(request, true);
        printHttpReport.emailReport(PrintHttpReport.ReportType.INFO,response.getStatus(),PrintHttpReport.getIp(request),errorAttributes,request.getParameterMap(), PrintHttpReport.getReqBody(request),"Request was sent to login by Spring Security","WebhookShipping-Route Spring Security Redirect");
        return "login";
    }

    @RequestMapping(value="/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        request.setAttribute("logout","logout");
        return "login";
    }
}
