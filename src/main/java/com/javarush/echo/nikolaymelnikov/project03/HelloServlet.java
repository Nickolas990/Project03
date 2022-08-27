package com.javarush.echo.nikolaymelnikov.project03;

import java.io.*;
import java.nio.charset.StandardCharsets;
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
        response.setContentType("text/html; charset=UTF-8");
        System.out.println(book.getTitle());


        // Hello
        PrintWriter out = response.getWriter();
//        out.println("<html><body>");
//        out.println("<h1>" + message + "</h1>");
//        out.printf("<p>" + book.getBlockById("4")+ "</p>");
//        out.println("<p>" + "Привет!"+ "</p>");
//        out.println("</body></html>");

        currentSession.setAttribute("book", book);
        response.sendRedirect("/index.jsp");



    }

    public void destroy() {
    }
}