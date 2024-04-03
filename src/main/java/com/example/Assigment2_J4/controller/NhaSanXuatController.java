package com.example.Assigment2_J4.controller;

import com.example.Assigment2_J4.entity.NhaSanXuat;
import com.example.Assigment2_J4.service.Imp.NhaSanXuatImp;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "NSXController", value = {
        "/HienThiNSX",
        "/DetailNSX",
        "/viewAddNSX",
        "/viewUpdateNSX",
        "/DeleteNSX",
        "/AddNSX",
        "/UpdateNSX"
})
public class NhaSanXuatController extends HttpServlet {
    NhaSanXuatImp service=new NhaSanXuatImp();
    List<NhaSanXuat> list=new ArrayList<>();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     String uri=request.getRequestURI();
     if(uri.contains("HienThiNSX")){
         this.HienThi(request,response);
     }else if(uri.contains("DetailNSX")){
         this.detail(request,response);
     }else if(uri.contains("viewAddNSX")){
         this.viewAdd(request,response);
     }else if(uri.contains("viewUpdateNSX")){
         this.viewUpdate(request,response);
     }
     else if(uri.contains("DeleteNSX")){
         this.delete(request,response);
     }
    }




    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri=request.getRequestURI();
        if(uri.contains("AddNSX")){
            this.Add(request,response);
        }else if(uri.contains("UpdateNSX")){
            this.Update(request,response);
        }
    }

    private void HienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        list=service.getAll();
        request.setAttribute("list",list);
        request.getRequestDispatcher("/view/ListNhaSanXuat.jsp").forward(request,response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("Haha345");
        int id=Integer.parseInt(request.getParameter("id"));
        NhaSanXuat nhaSanXuat =service.getOne(id);
        service.delete(nhaSanXuat);
        response.sendRedirect("/HienThiNSX");
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        NhaSanXuat nhaSanXuat =service.getOne(id);
        System.out.println("toi là 2: "+ nhaSanXuat);
        request.setAttribute("mtam", nhaSanXuat);
        request.getRequestDispatcher("/view/UpdateNhanSanXuat.jsp").forward(request,response);
    }

    private void viewAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/view/AddNhanSanXuat.jsp").forward(request,response);
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        NhaSanXuat nhaSanXuat =service.getOne(id);
        request.setAttribute("mtam", nhaSanXuat);
        request.getRequestDispatcher("/view/UpdateNhanSanXuat.jsp").forward(request,response);
    }

    private void Update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id=request.getParameter("id");
        String ma=request.getParameter("ma");
        String ten=request.getParameter("ten");
        NhaSanXuat nhaSanXuat = NhaSanXuat.builder().id(Integer.parseInt(id)).ma(ma).ten(ten).build();
        service.update(nhaSanXuat);
        response.sendRedirect("/HienThiNSX");
    }

    private void Add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String ma=request.getParameter("ma");
        String ten=request.getParameter("ten");
        NhaSanXuat nhaSanXuat = NhaSanXuat.builder().ma(ma).ten(ten).build();
        service.add(nhaSanXuat);
        response.sendRedirect("/HienThiNSX");
    }

}
