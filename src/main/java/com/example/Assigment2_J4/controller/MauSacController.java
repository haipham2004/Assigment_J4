package com.example.Assigment2_J4.controller;

import com.example.Assigment2_J4.entity.MauSac;
import com.example.Assigment2_J4.service.Imp.MauSacImp;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "MauSacController", value = {
        "/HienThiMauSac",
        "/DetailMauSac",
        "/viewAddMauSac",
        "/viewUpdateMauSac",
        "/DeleteMauSac",
        "/AddMauSac",
        "/UpdateMauSac"
})
public class MauSacController extends HttpServlet {
    MauSacImp service=new MauSacImp();
    List<MauSac> list=new ArrayList<>();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     String uri=request.getRequestURI();
     if(uri.contains("HienThiMauSac")){
         this.HienThi(request,response);
     }else if(uri.contains("DetailMauSac")){
         this.detail(request,response);
     }else if(uri.contains("viewAddMauSac")){
         this.viewAdd(request,response);
     }else if(uri.contains("viewUpdateMauSac")){
         this.viewUpdate(request,response);
     }else if(uri.contains("DeleteMauSac")){
         this.delete(request,response);
     }
    }




    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri=request.getRequestURI();
        if(uri.contains("AddMauSac")){
            this.Add(request,response);
        }else if(uri.contains("UpdateMauSac")){
            this.Update(request,response);
        }
    }



    private void HienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        list=service.getAll();
        request.setAttribute("list",list);
        System.out.println("haha");
        request.getRequestDispatcher("/view/ListGioHangChiTiets.jsp").forward(request,response);
    }


    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        MauSac MauSac=service.getOne(id);
        service.delete(MauSac);
        response.sendRedirect("/HienThiMauSac");
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        MauSac mauSac=service.getOne(id);
        request.setAttribute("mtam",mauSac);
        request.getRequestDispatcher("/view/UpdateGioHangChiTiet.jsp").forward(request,response);
    }

    private void viewAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Lala");
        request.getRequestDispatcher("/view/AddGioHangChiTiet.jsp").forward(request,response);
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        MauSac mauSac=service.getOne(id);
        request.setAttribute("mtam",mauSac);
        request.getRequestDispatcher("/view/UpdateGioHangChiTiet.jsp").forward(request,response);
    }

    private void Update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id=request.getParameter("id");
        String ma=request.getParameter("ma");
        String ten=request.getParameter("ten");
        MauSac mauSac=MauSac.builder().id(Integer.parseInt(id)).ma(ma).ten(ten).build();
        service.update(mauSac);
        response.sendRedirect("/HienThiMauSac");
    }

    private void Add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String ma=request.getParameter("ma");
        String ten=request.getParameter("ten");
        MauSac mauSac=MauSac.builder().ma(ma).ten(ten).build();
        service.add(mauSac);
        response.sendRedirect("/HienThiMauSac");
    }

}
