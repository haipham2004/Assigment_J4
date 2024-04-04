//package com.example.Assigment2_J4.filter;
//
//import jakarta.servlet.Filter;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.FilterConfig;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.ServletRequest;
//import jakarta.servlet.ServletResponse;
//import jakarta.servlet.annotation.WebFilter;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//
//import java.io.IOException;
//
//@WebFilter({"/Login"})
//public class Filter2 implements Filter {
//    @Override
//    public void init(FilterConfig config) throws ServletException {
//        Filter.super.init(config);
//    }
//    @Override
//    public void destroy() {
//        Filter.super.destroy();
//    }
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        HttpServletRequest request = (HttpServletRequest) servletRequest;
//        HttpServletResponse response = (HttpServletResponse) servletResponse;
//        HttpSession session = request.getSession(false);
//
//        if(session != null && session.getAttribute("userName")!=null){
//            System.out.println("login ok");
//            filterChain.doFilter(request,response);
//        }else{
//            System.out.println("haha tao là filter");
//            request.getRequestDispatcher("/view/viewLogin.jsp").forward(request,response);
//        }
//    }
//}
