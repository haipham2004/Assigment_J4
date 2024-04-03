package com.example.Assigment2_J4.controller;

import com.example.Assigment2_J4.entity.DongSanPham;
import com.example.Assigment2_J4.service.Imp.DongSanPhamImp;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet(name = "DongSPController", value = {
        "/HienThiDongSP",
        "/DetailDongSP",
        "/viewAddDongSP",
        "/viewUpdateDongSP",
        "/DeleteDongSP",
        "/AddDongSP",
        "/UpdateDongSP"
})
public class DongSPController extends HttpServlet {
    DongSanPhamImp service=new DongSanPhamImp();
    List<DongSanPham> list=new ArrayList<>();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     String uri=request.getRequestURI();
     if(uri.contains("HienThiDongSP")){
         this.HienThi(request,response);
     }else if(uri.contains("DetailDongSP")){
         this.detail(request,response);
     }else if(uri.contains("viewAddDongSP")){
         this.viewAdd(request,response);
     }else if(uri.contains("viewUpdateDongSP")){
         this.viewUpdate(request,response);
     }else if(uri.contains("DeleteDongSP")){
         this.delete(request,response);
     }
    }




    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri=request.getRequestURI();
        if(uri.contains("AddDongSP")){
            this.Add(request,response);
        }else if(uri.contains("UpdateDongSP")){
            this.Update(request,response);
        }
    }



    private void HienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        list=service.getAll();
        request.setAttribute("list",list);
        request.getRequestDispatcher("/view/ListDongSanPham.jsp").forward(request,response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("Haha345");
        int id=Integer.parseInt(request.getParameter("id"));
        DongSanPham dongSanPham =service.getOne(id);
        service.delete(dongSanPham);
        response.sendRedirect("/HienThiDongSP");
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        DongSanPham dongSanPham =service.getOne(id);
        request.setAttribute("mtam", dongSanPham);
        request.getRequestDispatcher("/view/UpdateDongSanPham.jsp").forward(request,response);
    }

    private void viewAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Lala");
        request.getRequestDispatcher("/view/AddDongSanPham.jsp").forward(request,response);
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        DongSanPham dongSanPham =service.getOne(id);
        request.setAttribute("mtam", dongSanPham);
        request.getRequestDispatcher("/view/UpdateDongSanPham.jsp").forward(request,response);
    }

    private void Update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id=request.getParameter("id");
        String ma=request.getParameter("ma");
        String ten=request.getParameter("ten");
        DongSanPham dongSanPham = DongSanPham.builder().id(Integer.parseInt(id)).ma(ma).ten(ten).build();
        service.update(dongSanPham);
        response.sendRedirect("/HienThiDongSP");
    }

    private void Add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String ma=request.getParameter("ma");
        String ten=request.getParameter("ten");
        DongSanPham dongSanPham = DongSanPham.builder().ma(ma).ten(ten).build();
        service.add(dongSanPham);
        response.sendRedirect("/HienThiDongSP");
    }

}
