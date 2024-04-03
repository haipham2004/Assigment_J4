package com.example.Assigment2_J4.controller;

import com.example.Assigment2_J4.entity.HoaDon;
import com.example.Assigment2_J4.entity.KhachHang;
import com.example.Assigment2_J4.entity.NhanVien;
import com.example.Assigment2_J4.request.HoaDonRequest;
import com.example.Assigment2_J4.service.Imp.HoaDonImp;
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


@WebServlet(name = "HoaDonController", value = {
        "/HienThiHoaDon",
        "/DetailHoaDon",
        "/viewAddHoaDon",
        "/viewUpdateHoaDon",
        "/DeleteHoaDon",
        "/AddHoaDon",
        "/UpdateHoaDon"
})
public class HoaDonController extends HttpServlet {
    HoaDonImp service = new HoaDonImp();
    List<HoaDon> list = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("HienThiHoaDon")) {
            this.HienThi(request, response);
        } else if (uri.contains("DetailHoaDon")) {
            this.detail(request, response);
        } else if (uri.contains("viewAddHoaDon")) {
            this.viewAdd(request, response);
        } else if (uri.contains("viewUpdateHoaDon")) {
            this.viewUpdate(request, response);
        } else if (uri.contains("DeleteHoaDon")) {
            this.delete(request, response);
        }
    }


    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("AddHoaDon")) {
            this.Add(request, response);
        } else if (uri.contains("UpdateHoaDon")) {
            this.Update(request, response);
        }
    }

    
    private void HienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        list = service.getAll();
        request.setAttribute("list", list);
        System.out.println("haha");
        request.getRequestDispatcher("/view/ListHoaDon.jsp").forward(request, response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        HoaDon hoaDon=service.getOne(id);
        service.delete(hoaDon);
        response.sendRedirect("/HienThiHoaDon");
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        HoaDon hoaDon=service.getOne(id);
        request.setAttribute("mtam",hoaDon);
        request.getRequestDispatcher("/view/UpdateHoaDon.jsp").forward(request,response);
    }

    private void viewAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/view/AddHoaDon.jsp").forward(request,response);
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        HoaDon hoaDon=service.getOne(id);
        request.setAttribute("mtam",hoaDon);
        request.getRequestDispatcher("/view/UpdateHoaDon.jsp").forward(request,response);
    }

    private void Update(HttpServletRequest request, HttpServletResponse response) throws IOException, InvocationTargetException, IllegalAccessException {
        HoaDonRequest HoaDonRequest=new HoaDonRequest();
        BeanUtils.populate(HoaDonRequest,request.getParameterMap());
        int id=Integer.parseInt(request.getParameter("id"));
        int KhachHangID=Integer.parseInt(request.getParameter("khachHang.id"));
        int NhanVienID=Integer.parseInt(request.getParameter("nhanVien.id"));
        KhachHang khachHang=new KhachHang();
        khachHang.setId(KhachHangID);
        NhanVien nhanVien=new NhanVien();
        nhanVien.setId(NhanVienID);
        HoaDonRequest.setKhachHang(khachHang);
        HoaDonRequest.setNhanVien(nhanVien);
        System.out.println("UpdateHoaDon: "+id+KhachHangID+NhanVienID+HoaDonRequest);
        System.out.println("Ket qua: "+  service.updateHoaDonRequest(HoaDonRequest));
        response.sendRedirect("/HienThiHoaDon");
    }

    private void Add(HttpServletRequest request, HttpServletResponse response) throws IOException, InvocationTargetException, IllegalAccessException {
        HoaDonRequest HoaDonRequest=new HoaDonRequest();
        BeanUtils.populate(HoaDonRequest,request.getParameterMap());
        int KhachHangID=Integer.parseInt(request.getParameter("khachHang.id"));
        int NhanVienID=Integer.parseInt(request.getParameter("nhanVien.id"));
        KhachHang khachHang=new KhachHang();
        khachHang.setId(KhachHangID);
        NhanVien nhanVien=new NhanVien();
        nhanVien.setId(NhanVienID);
        HoaDonRequest.setKhachHang(khachHang);
        HoaDonRequest.setNhanVien(nhanVien);
        service.addHoaDonRequest(HoaDonRequest);
        response.sendRedirect("/HienThiHoaDon");
    }

}
