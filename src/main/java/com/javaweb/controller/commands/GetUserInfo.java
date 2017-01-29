package com.javaweb.controller.commands;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

import static com.javaweb.util.Attributes.REFERER;
import static com.javaweb.util.Pages.USER_ACCOUNT_PAGE;

/**
 * @author Andrii Chernysh on 29-Jan-17.
 *         E-Mail : itcherry97@gmail.com
 */
public class GetUserInfo implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        setPathForBackButton(request);

        return USER_ACCOUNT_PAGE;
    }

    private void setPathForBackButton(HttpServletRequest request) {
        String refererPage = request.getHeader(REFERER);
        Enumeration<String> requestPath = request.getHeaderNames();
        //Enumeration<String> servletPath = request.getHeader();
        Enumeration<String> headerNames = request.getHeaderNames();

        request.setAttribute(REFERER, refererPage);
    }
}
