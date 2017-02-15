package com.javaweb.controller.commands.get;

import com.javaweb.controller.commands.Command;
import com.javaweb.model.entity.Test;
import com.javaweb.model.services.SubjectService;
import com.javaweb.model.services.TestService;
import com.javaweb.model.services.impl.SubjectServiceImpl;
import com.javaweb.model.services.impl.TestServiceImpl;
import com.javaweb.util.Attributes;
import com.javaweb.util.Pages;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static com.javaweb.controller.CommandRegexAndPatterns.LETTERS_BEFORE_INDEX_REGEX;

/**
 * @author Andrii Chernysh on 25-Jan-17. E-Mail : itcherry97@gmail.com
 */
public class GetTestsCommand implements Command {
    private SubjectService subjectService = SubjectServiceImpl.getInstance();
    private TestService testService = TestServiceImpl.getInstance();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String requestedURI = request.getRequestURI();
        int subjectId = Integer.parseInt(requestedURI.replaceAll(LETTERS_BEFORE_INDEX_REGEX, ""));

        List<Test> testsList = testService.getAllTestsForSubjectWithId(subjectId);
        request.setAttribute(Attributes.TESTS, testsList);
        return Pages.TESTS_PAGE;
    }
}