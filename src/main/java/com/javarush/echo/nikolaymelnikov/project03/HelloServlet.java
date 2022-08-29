package com.javarush.echo.nikolaymelnikov.project03;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;


@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger("rollingFile");
    static {
        System.setOut(new java.io.PrintStream(new java.io.FileOutputStream(java.io.FileDescriptor.out), true, java.nio.charset.StandardCharsets.UTF_8));
    }

    private Book book;

    private Map<String, User> userBook = new HashMap<>();
    private User user;

    public void init() {
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession currentSession = request.getSession();
        String name = request.getParameter("name");
        if (user == null) {
            if (userBook.containsKey(name)) {
                user = userBook.get(name);
            } else {
                user = new User(name);
            }
            response.sendRedirect("/index.jsp");
            currentSession.setAttribute("user", user);
            return;
        }

        String id = request.getParameter("id");
        if ("end".equals(id)) {
            response.sendRedirect("/index.jsp");
            return;
        }
        if (id == null) {
            id = "start";
        }

        response.setContentType("text/html; charset=UTF-8");


        // Hello

        currentSession.setAttribute("text", book.getBlockById(id).prepareForHtml());
        currentSession.setAttribute("answers", book.getBlockById(id).showAnswers());
        currentSession.setAttribute("book", book);
        response.sendRedirect("/Game.jsp");


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String journey = req.getParameter("journey");
        HttpSession session = req.getSession();
        book = Book.initialize(journey);
        doGet(req, resp);

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String name = req.getParameter("name");
        if (userBook.containsKey(name)) {
            user = userBook.get(req.getParameter("name"));
        } else {
            user = new User(req.getParameter("name"));
        }
        session.setAttribute("user", user);
        resp.sendRedirect("/index.jsp");
    }

    public void destroy() {
    }
}