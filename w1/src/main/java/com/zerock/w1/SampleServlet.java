package com.zerock.w1;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "sampleServlet", urlPatterns = "/sample")
public class SampleServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("doGet.... 객체: " + this);

    }

    @Override
    public void destroy() {

        System.out.println("destroy...............");

    }

    @Override
    public void init(ServletConfig config) throws ServletException {

        System.out.println("init(ServletConfig)...........");

    }

}
