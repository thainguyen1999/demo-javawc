package com.example.demo;

import java.io.*;
import java.util.Enumeration;

import com.sun.net.httpserver.Headers;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

//@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        String name= getInitParameter("name");
        if (name!=null){
            message=name;
        }
        Cookie[] cookies=request.getCookies();
        Enumeration<String> headers= request.getHeaderNames();
        String className= request.getParameter("name");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<a href='demo-servlet'>Go to demo page</a>");
        out.println("<h1>" + message + "</h1>");
        out.println("<h1>" + className + "</h1>");
        out.println("<h1> Cookie  </h1>");
        for (int i=0; i<cookies.length;i++){
            Cookie c= cookies[i];
            out.println("<p> cookie name: "+ c.getName()+"value: "+c.getValue()+"</p>");
        }
        out.println("<h1>Header name and value </h1>");
        while (headers.hasMoreElements()){
            String headerName=headers.nextElement();
            String value=request.getHeader(headerName);
            out.println("<p>header name:"+headerName+ "header value: " +value+"</p>");
        }

        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //        String studentName = req.getParameter("studentName");
//        String studentPhone = req.getParameter("studentPhone");
//        String studentAddress = req.getParameter("studentAddress");
//        resp.sendRedirect("test-servlet");
//        PrintWriter out = resp.getWriter();;
//        resp.setContentType("text/html");
//        out.println("<html><body>");
//        out.println("<a href='demo-servlet'>Go to demo page</a>");
//        out.println("<h1>" + studentName + "</h1>");
//        out.println("<h1>" + studentPhone + "</h1>");
//        out.println("<h1>" + studentAddress + "</h1>");
//        out.println("</body></html>");
        req.setAttribute("testAttribute", "TestAttributeValue");
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/test-servlet");
        dispatcher.forward(req,resp);
    }

    public void destroy() {
    }
}