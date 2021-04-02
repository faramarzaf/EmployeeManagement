package com.spring.web.app.EmployeeManagementWebApp.exception;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class MyErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if (status != null) {
            int statusCode = Integer.parseInt(status.toString());
            switch (statusCode) {
                case 404:
                    return "error_404";

                case 500:
                    return "error_500";
            }
        }
        return "error";
    }

    @Override
    public String getErrorPath() {
        return null;
    }
}