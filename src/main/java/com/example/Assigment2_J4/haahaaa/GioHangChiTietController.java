package com.example.Assigment2_J4.haahaaa;

import com.example.Assigment2_J4.entity.ChiTietSanPham;
import com.example.Assigment2_J4.entity.GioHangChiTiet;
import com.example.Assigment2_J4.entity.DongSanPham;
import com.example.Assigment2_J4.entity.MauSac;
import com.example.Assigment2_J4.entity.NhaSanXuat;
import com.example.Assigment2_J4.entity.SanPham;
import com.example.Assigment2_J4.request.GioHangChiTietRequest;
import com.example.Assigment2_J4.service.Imp.GioHangChiTietImp;
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

@WebServlet(name = "GioHangChiTietController", value = {
        "/HienThiGioHangChiTiet",
        "/DetailGioHangChiTiet",
        "/viewAddGioHangChiTiet",
        "/viewUpdateGioHangChiTiet",
        "/DeleteGioHangChiTiet",
        "/AddGioHangChiTiet",
        "/UpdateGioHangChiTiet"
})
public class GioHangChiTietController extends HttpServlet {
    GioHangChiTietImp service = new GioHangChiTietImp();
    List<GioHangChiTiet> list = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("HienThiGioHangChiTiet")) {
            this.HienThi(request, response);
        } else if (uri.contains("DetailGioHangChiTiet")) {
            this.detail(request, response);
        } else if (uri.contains("viewAddGioHangChiTiet")) {
            this.viewAdd(request, response);
        } else if (uri.contains("viewUpdateGioHangChiTiet")) {
            this.viewUpdate(request, response);
        } else if (uri.contains("DeleteGioHangChiTiet")) {
            this.delete(request, response);
        }
    }


    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("AddGioHangChiTiet")) {
            this.Add(request, response);
        } else if (uri.contains("UpdateGioHangChiTiet")) {
            this.Update(request, response);
        }
    }


    private void HienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        list = service.getAll();
        request.setAttribute("list", list);
        System.out.println("Ban tam day: "+list);
        request.getRequestDispatcher("/view/ListGioHangChiTiets.jsp").forward(request, response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        GioHangChiTiet GioHangChiTiet = service.getOne(id);
        service.delete(GioHangChiTiet);
        response.sendRedirect("/HienThiGioHangChiTiet");
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        System.out.println("lalaa");
        GioHangChiTiet GioHangChiTiet = service.getOne(id);
        request.setAttribute("mtam", GioHangChiTiet);
        request.getRequestDispatcher("/view/UpdateGioHangChiTiet.jsp").forward(request, response);
    }

    private void viewAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/view/AddGioHangChiTiet.jsp").forward(request, response);
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        GioHangChiTiet GioHangChiTiet = service.getOne(id);
        request.setAttribute("mtam", GioHangChiTiet);
        request.getRequestDispatcher("/view/UpdateGioHangChiTiet.jsp").forward(request, response);
    }

    private void Update(HttpServletRequest request, HttpServletResponse response) throws IOException, InvocationTargetException, IllegalAccessException {
        GioHangChiTietRequest gioHangChiTietRequest = new GioHangChiTietRequest();
        BeanUtils.populate(gioHangChiTietRequest, request.getParameterMap());
        int idCTSP=Integer.parseInt(request.getParameter("chiTietSanPham.id"));
//        ChiTietSanPham chiTietSanPham=new ChiTietSanPham();
//        chiTietSanPham.setId(idCTSP);
//        gioHangChiTietRequest.setChiTietSP(chiTietSanPham);
        System.out.println("Toi là Add: "+ service.updateGioHangChiTietRequest(gioHangChiTietRequest));
        response.sendRedirect("/HienThiGioHangChiTiet");
    }

    private void Add(HttpServletRequest request, HttpServletResponse response) throws IOException, InvocationTargetException, IllegalAccessException {
        GioHangChiTietRequest gioHangChiTietRequest = new GioHangChiTietRequest();
        BeanUtils.populate(gioHangChiTietRequest, request.getParameterMap());
//        int idCTSP=Integer.parseInt(request.getParameter("chiTietSanPham.id"));
//        ChiTietSanPham chiTietSanPham=new ChiTietSanPham();
//        chiTietSanPham.setId(idCTSP);
//        gioHangChiTietRequest.setChiTietSP(chiTietSanPham);
//        System.out.println("Tao là: "+idCTSP);
        System.out.println("Toi là Add: "+ service.addGioHangChiTietRequest(gioHangChiTietRequest));
        response.sendRedirect("/HienThiGioHangChiTiet");
    }

}
