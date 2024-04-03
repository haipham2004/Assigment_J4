package com.example.Assigment2_J4.controller;

import com.example.Assigment2_J4.entity.ChucVu;
import com.example.Assigment2_J4.entity.CuaHang;
import com.example.Assigment2_J4.entity.KhachHang;
import com.example.Assigment2_J4.request.KhachHangRequest;
import com.example.Assigment2_J4.service.Imp.KhachHangImp;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;


@WebServlet(name = "KhachHangController", value = {
        "/HienThiKhachHang",
        "/DetailKhachHang",
        "/viewAddKhachHang",
        "/viewUpdateKhachHang",
        "/DeleteKhachHang",
        "/AddKhachHang",
        "/UpdateKhachHang"
})
public class KhachHangController extends HttpServlet {
    KhachHangImp service = new KhachHangImp();
    List<KhachHang> list = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("HienThiKhachHang")) {
            this.HienThi(request, response);
        } else if (uri.contains("DetailKhachHang")) {
            this.detail(request, response);
        } else if (uri.contains("viewAddKhachHang")) {
            this.viewAdd(request, response);
        } else if (uri.contains("viewUpdateKhachHang")) {
            this.viewUpdate(request, response);
        } else if (uri.contains("DeleteKhachHang")) {
            this.delete(request, response);
        }
    }


    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("AddKhachHang")) {
            this.Add(request, response);
        } else if (uri.contains("UpdateKhachHang")) {
            this.Update(request, response);
        }
    }

    
    private void HienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        list = service.getAll();
        request.setAttribute("list", list);
        System.out.println("haha");
        request.getRequestDispatcher("/view/ListKhachHang.jsp").forward(request, response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        KhachHang KhachHang=service.getOne(id);
        service.delete(KhachHang);
        response.sendRedirect("/HienThiKhachHang");
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        KhachHang KhachHang=service.getOne(id);
        request.setAttribute("mtam",KhachHang);
        request.getRequestDispatcher("/view/UpdateKhachHang.jsp").forward(request,response);
    }

    private void viewAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/view/AddKhachHang.jsp").forward(request,response);
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        KhachHang KhachHang=service.getOne(id);
        request.setAttribute("mtam",KhachHang);
        request.getRequestDispatcher("/view/UpdateKhachHang.jsp").forward(request,response);
    }

    private void Update(HttpServletRequest request, HttpServletResponse response) throws IOException, InvocationTargetException, IllegalAccessException {
        KhachHangRequest KhachHangRequest=new KhachHangRequest();
        BeanUtils.populate(KhachHangRequest,request.getParameterMap());
        int id=Integer.parseInt(request.getParameter("id"));
        System.out.println("Ket qua: "+  service.updateKhachHangRequest(KhachHangRequest));
        response.sendRedirect("/HienThiKhachHang");
    }

    private void Add(HttpServletRequest request, HttpServletResponse response) throws IOException, InvocationTargetException, IllegalAccessException {
        KhachHangRequest KhachHangRequest=new KhachHangRequest();
        BeanUtils.populate(KhachHangRequest,request.getParameterMap());
        service.addKhachHangRequest(KhachHangRequest);
        response.sendRedirect("/HienThiKhachHang");
    }

}
