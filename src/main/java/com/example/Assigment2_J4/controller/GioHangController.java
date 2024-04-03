package com.example.Assigment2_J4.controller;

import com.example.Assigment2_J4.entity.GioHang;
import com.example.Assigment2_J4.entity.KhachHang;
import com.example.Assigment2_J4.entity.NhanVien;
import com.example.Assigment2_J4.request.GioHangRequest;
import com.example.Assigment2_J4.service.Imp.GioHangImp;
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


@WebServlet(name = "GioHangController", value = {
        "/HienThiGioHang",
        "/DetailGioHang",
        "/viewAddGioHang",
        "/viewUpdateGioHang",
        "/DeleteGioHang",
        "/AddGioHang",
        "/UpdateGioHang"
})
public class GioHangController extends HttpServlet {
    GioHangImp service = new GioHangImp();
    List<GioHang> list = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("HienThiGioHang")) {
            this.HienThi(request, response);
        } else if (uri.contains("DetailGioHang")) {
            this.detail(request, response);
        } else if (uri.contains("viewAddGioHang")) {
            this.viewAdd(request, response);
        } else if (uri.contains("viewUpdateGioHang")) {
            this.viewUpdate(request, response);
        } else if (uri.contains("DeleteGioHang")) {
            this.delete(request, response);
        }
    }


    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("AddGioHang")) {
            this.Add(request, response);
        } else if (uri.contains("UpdateGioHang")) {
            this.Update(request, response);
        }
    }

    
    private void HienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        list = service.getAll();
        request.setAttribute("list", list);
        System.out.println("haha");
        request.getRequestDispatcher("/view/ListGioHang.jsp").forward(request, response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        GioHang GioHang=service.getOne(id);
        service.delete(GioHang);
        response.sendRedirect("/HienThiGioHang");
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        GioHang GioHang=service.getOne(id);
        request.setAttribute("mtam",GioHang);
        request.getRequestDispatcher("/view/UpdateGioHang.jsp").forward(request,response);
    }

    private void viewAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/view/AddGioHang.jsp").forward(request,response);
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        GioHang GioHang=service.getOne(id);
        request.setAttribute("mtam",GioHang);
        request.getRequestDispatcher("/view/UpdateGioHang.jsp").forward(request,response);
    }

    private void Update(HttpServletRequest request, HttpServletResponse response) throws IOException, InvocationTargetException, IllegalAccessException {
        GioHangRequest gioHangRequest=new GioHangRequest();
        BeanUtils.populate(gioHangRequest,request.getParameterMap());
        int id=Integer.parseInt(request.getParameter("id"));
        int KhachHangID=Integer.parseInt(request.getParameter("khachHang.id"));
        int NhanVienID=Integer.parseInt(request.getParameter("nhanVien.id"));
        KhachHang khachHang=new KhachHang();
        khachHang.setId(KhachHangID);
        NhanVien nhanVien=new NhanVien();
        nhanVien.setId(NhanVienID);
        gioHangRequest.setKhachHang(khachHang);
        gioHangRequest.setNhanVien(nhanVien);
        System.out.println("UpdateGioHang: "+id+KhachHangID+NhanVienID+gioHangRequest);
        System.out.println("Ket qua: "+  service.updateGioHangRequest(gioHangRequest));
        response.sendRedirect("/HienThiGioHang");
    }

    private void Add(HttpServletRequest request, HttpServletResponse response) throws IOException, InvocationTargetException, IllegalAccessException {
        GioHangRequest gioHangRequest=new GioHangRequest();
        BeanUtils.populate(gioHangRequest,request.getParameterMap());
        int KhachHangID=Integer.parseInt(request.getParameter("khachHang.id"));
        int NhanVienID=Integer.parseInt(request.getParameter("nhanVien.id"));
        KhachHang khachHang=new KhachHang();
        khachHang.setId(KhachHangID);
        NhanVien nhanVien=new NhanVien();
        nhanVien.setId(NhanVienID);
        gioHangRequest.setKhachHang(khachHang);
        gioHangRequest.setNhanVien(nhanVien);
        service.addGioHangRequest(gioHangRequest);
        response.sendRedirect("/HienThiGioHang");
    }

}
