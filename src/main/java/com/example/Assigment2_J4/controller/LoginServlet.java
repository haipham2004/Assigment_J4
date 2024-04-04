package com.example.Assigment2_J4.controller;

import com.example.Assigment2_J4.entity.NhanVien;
import com.example.Assigment2_J4.repository.NhanVienRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "LoginServlet", value = {
        "/viewLogin",
        "/FormLogin",
        "/Logins14"
})
public class LoginServlet extends HttpServlet {
    NhanVienRepository repo=new NhanVienRepository();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String uri= request.getRequestURI();
            if(uri.contains("viewLogin")){
                viewLogin(request,response);
            }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri= request.getRequestURI();
        if(uri.contains("FormLogin")){
            formLogin(request,response);
        }

    }
    private void viewLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/view/viewLogin.jsp").forward(request,response);
    }

    private void formLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName=request.getParameter("userName");
        String password=request.getParameter("password");
        request.setAttribute("userName",userName);
        request.setAttribute("password",password);
        NhanVien nhanVien=repo.login(userName,password);
        System.out.println("Login: "+nhanVien);
        boolean check=false;
        if(userName.isEmpty()){
            check=true;
            request.setAttribute("baoLoiUser","Nhập user đi");
        }
        if(password.isEmpty()){
            check=true;
            request.setAttribute("baoLoiPassword","Nhập password đi");

        }
        if(check==true){
            request.getRequestDispatcher("/view/viewLogin.jsp").forward(request,response);
        }else{
            if(nhanVien!=null){
                HttpSession session=request.getSession();
                session.setAttribute("userName",userName);
                System.out.println("USER NAME: "+userName);
                session.setAttribute("nhanVienTaiKhoan",nhanVien);
                request.getRequestDispatcher("/view/ATrangChu.jsp").forward(request,response);
            }else{
                request.setAttribute("baoLoiTaiKhoan","Tài khoản không tồn tại");
                request.getRequestDispatcher("/view/viewLogin.jsp").forward(request,response);
            }
        }

    }
}
