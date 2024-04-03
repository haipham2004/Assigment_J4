package com.example.Assigment2_J4.controller;

import com.example.Assigment2_J4.entity.CuaHang;
import com.example.Assigment2_J4.service.Imp.CuaHangImp;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet(name = "CuaHangController", value = {
        "/HienThiCuaHang",
        "/DetailCuaHang",
        "/viewAddCuaHang",
        "/viewUpdateCuaHang",
        "/DeleteCuaHang",
        "/AddCuaHang",
        "/UpdateCuaHang"
})
public class CuaHangController extends HttpServlet {
    CuaHangImp service = new CuaHangImp();
    List<CuaHang> list = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("HienThiCuaHang")) {
            this.HienThi(request, response);
        } else if (uri.contains("DetailCuaHang")) {
            this.detail(request, response);
        } else if (uri.contains("viewAddCuaHang")) {
            this.viewAdd(request, response);
        } else if (uri.contains("viewUpdateCuaHang")) {
            this.viewUpdate(request, response);
        } else if (uri.contains("DeleteCuaHang")) {
            this.delete(request, response);
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("AddCuaHang")) {
            this.Add(request, response);
        } else if (uri.contains("UpdateCuaHang")) {
            this.Update(request, response);
        }
    }

    
    private void HienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        list = service.getAll();
        request.setAttribute("list", list);
        System.out.println("haha");
        request.getRequestDispatcher("/view/ListCuaHang.jsp").forward(request, response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        CuaHang CuaHang=service.getOne(id);
        service.delete(CuaHang);
        response.sendRedirect("/HienThiCuaHang");
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        CuaHang CuaHang=service.getOne(id);
        request.setAttribute("mtam",CuaHang);
        request.getRequestDispatcher("/view/UpdateCuaHang.jsp").forward(request,response);
    }

    private void viewAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/view/AddCuaHang.jsp").forward(request,response);
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        CuaHang cuaHang=service.getOne(id);
        request.setAttribute("mtam",cuaHang);
        request.getRequestDispatcher("/view/UpdateCuaHang.jsp").forward(request,response);
    }

    private void Update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        String ma=request.getParameter("ma");
        String ten=request.getParameter("ten");
        String diaChi=request.getParameter("diaChi");
        String thanhPho=request.getParameter("thanhPho");
        String quocGia=request.getParameter("quocGia");
        CuaHang cuaHang=CuaHang.builder().id(id).ma(ma).ten(ten).diaChi(diaChi).thanhPho(thanhPho).quocGia(quocGia).build();
        service.update(cuaHang);
        response.sendRedirect("/HienThiCuaHang");
    }

    private void Add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String ma=request.getParameter("ma");
        String ten=request.getParameter("ten");
        String diaChi=request.getParameter("diaChi");
        String thanhPho=request.getParameter("thanhPho");
        String quocGia=request.getParameter("quocGia");
        CuaHang cuaHang=CuaHang.builder().ma(ma).ten(ten).diaChi(diaChi).thanhPho(thanhPho).quocGia(quocGia).build();
        service.add(cuaHang);
        response.sendRedirect("/HienThiCuaHang");
    }

}
