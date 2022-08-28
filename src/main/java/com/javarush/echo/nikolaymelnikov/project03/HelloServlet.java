package com.javarush.echo.nikolaymelnikov.project03;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;
import javax.servlet.http.*;
import javax.servlet.annotation.*;


@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    static {
        System.setOut(new java.io.PrintStream(new java.io.FileOutputStream(java.io.FileDescriptor.out), true, java.nio.charset.StandardCharsets.UTF_8));
    }

    private String message;

    private Book book;

    public void init() {
        book = Book.initialize();
        message = book.getTitle();

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession currentSession = request.getSession();
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
        PrintWriter out = response.getWriter();
        book.getBlockById(id).getNext();
        currentSession.setAttribute("text", book.getBlockById(id).prepareForHtml());
        currentSession.setAttribute("answers", book.getBlockById(id).showAnswers());
        currentSession.setAttribute("book", book);
        response.sendRedirect("/Game.jsp");


    }

    public void destroy() {
    }
}