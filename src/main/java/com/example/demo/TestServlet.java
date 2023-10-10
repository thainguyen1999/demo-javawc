package com.example.demo;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class TestServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String studentName = req.getParameter("studentName");
        String studentPhone = req.getParameter("studentPhone");
        String studentAddress = req.getParameter("studentAddress");
        PrintWriter out = resp.getWriter();;
        resp.setContentType("text/html");
        out.println("<html><body>");
        out.println("<h1> Test servlet do get</h1>");
        out.println("<h1>" + studentName + "</h1>");
        out.println("<h1>" + studentPhone + "</h1>");
        out.println("<h1>" + studentAddress + "</h1>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String studentName = req.getParameter("studentName");
        String studentPhone = req.getParameter("studentPhone");
        String studentAddress = req.getParameter("studentAddress");
        String attributeValue = (String)req.getAttribute("testAttribute");
        PrintWriter out = resp.getWriter();;
        resp.setContentType("text/html");
        out.println("<html><body>");
        out.println("<h1> Test servlet do post</h1>");
        out.println("<h1>" + studentName + "</h1>");
        out.println("<h1>" + studentPhone + "</h1>");
        out.println("<h1>" + studentAddress + "</h1>");
        out.println("<h1>" + attributeValue + "</h1>");
        out.println("</body></html>");
    }
}
