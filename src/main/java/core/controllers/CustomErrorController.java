package core.controllers;

import core.entities.ErrorJson;
import core.security.PrintHttpReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RestController
public class CustomErrorController implements ErrorController {

    private static final String PATH = "/error";
    private final ErrorAttributes errorAttributes;
    private final PrintHttpReport printHttpReport;

    @Autowired
    public CustomErrorController(ErrorAttributes errorAttributes, PrintHttpReport printHttpReport) {
        Assert.notNull(errorAttributes, "ErrorAttributes must not be null!");
        Assert.notNull(printHttpReport, "PrintHttpReport must not be null!");
        this.errorAttributes = errorAttributes;
        this.printHttpReport = printHttpReport;
    }

    @RequestMapping(value = PATH)
    ErrorJson error(HttpServletRequest request, HttpServletResponse response) {
        // Appropriate HTTP response code (e.g. 404 or 500) is automatically set by Spring.
        // Here we just define response body.
        int status = response.getStatus();
        Map<String, Object> errorAttributes = getErrorAttributes(request, true);

        printHttpReport.emailReport(PrintHttpReport.ReportType.ERROR,status, PrintHttpReport.getIp(request), errorAttributes,request.getParameterMap(),PrintHttpReport.getReqBody(request), "/error in CustomErrorController was triggered.", "MVC ERROR");
        return new ErrorJson(status, errorAttributes);
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }

    private Map<String, Object> getErrorAttributes(HttpServletRequest request, boolean includeStackTrace) {
        RequestAttributes requestAttributes = new ServletRequestAttributes(request);
        return errorAttributes.getErrorAttributes(requestAttributes, includeStackTrace);
    }
}
