package com.example.Assigment2_J4.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
@WebFilter({"/*"})
public class AuthenFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }
    public void destroy() {
        Filter.super.destroy();
        System.out.println("Khi destroy ");
    }
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        String name = (String) session.getAttribute("userName");
        System.out.println("name đây: "+null);
        if(name==null){
            System.out.println("haha tao là filter");
            request.getRequestDispatcher("/view/viewLogin.jsp").forward(request,response);
        }else{
            System.out.println("login ok");
            filterChain.doFilter(request,response);
        }
    }


}
