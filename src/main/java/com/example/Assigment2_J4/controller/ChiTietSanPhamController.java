package com.example.Assigment2_J4.controller;

import com.example.Assigment2_J4.entity.ChiTietSanPham;
import com.example.Assigment2_J4.entity.DongSanPham;
import com.example.Assigment2_J4.entity.MauSac;
import com.example.Assigment2_J4.entity.NhaSanXuat;
import com.example.Assigment2_J4.entity.SanPham;
import com.example.Assigment2_J4.request.ChiTietSanPhamRequest;
import com.example.Assigment2_J4.service.Imp.ChiTietSanPhamImp;
import com.example.Assigment2_J4.service.Imp.DongSanPhamImp;
import com.example.Assigment2_J4.service.Imp.MauSacImp;
import com.example.Assigment2_J4.service.Imp.NhaSanXuatImp;
import com.example.Assigment2_J4.service.Imp.NhanVienImp;
import com.example.Assigment2_J4.service.Imp.SanPhamImp;
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

@WebServlet(name = "ChiTietSanPhamController", value = {
        "/HienThiChiTietSanPham",
        "/DetailChiTietSanPham",
        "/viewAddChiTietSanPham",
        "/viewUpdateChiTietSanPham",
        "/DeleteChiTietSanPham",
        "/AddChiTietSanPham",
        "/UpdateChiTietSanPham"
})
public class ChiTietSanPhamController extends HttpServlet {
    ChiTietSanPhamImp service = new ChiTietSanPhamImp();
    List<ChiTietSanPham> list = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("HienThiChiTietSanPham")) {
            this.HienThi(request, response);
        } else if (uri.contains("DetailChiTietSanPham")) {
            this.detail(request, response);
        } else if (uri.contains("viewAddChiTietSanPham")) {
            this.viewAdd(request, response);
        } else if (uri.contains("viewUpdateChiTietSanPham")) {
            this.viewUpdate(request, response);
        } else if (uri.contains("DeleteChiTietSanPham")) {
            this.delete(request, response);
        }
    }


    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("AddChiTietSanPham")) {
            this.Add(request, response);
        } else if (uri.contains("UpdateChiTietSanPham")) {
            this.Update(request, response);
        }
    }


    private void HienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        list = service.getAll();
        request.setAttribute("list", list);
        request.getRequestDispatcher("/view/ListChiTietSanPham.jsp").forward(request, response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        ChiTietSanPham ChiTietSanPham = service.getOne(id);
        service.delete(ChiTietSanPham);
        response.sendRedirect("/HienThiChiTietSanPham");
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        System.out.println("lalaa");
        ChiTietSanPham ChiTietSanPham = service.getOne(id);
        request.setAttribute("mtam", ChiTietSanPham);
        List<SanPham> listSP=new SanPhamImp().getAll();
        request.setAttribute("listSP",listSP);
        List<NhaSanXuat> listNSX=new NhaSanXuatImp().getAll();
        request.setAttribute("listNSX",listNSX);
        List<MauSac> listMS=new MauSacImp().getAll();
        request.setAttribute("listMS",listMS);
        List<DongSanPham> listDSP=new DongSanPhamImp().getAll();
        request.setAttribute("listDSP",listDSP);
        request.getRequestDispatcher("/view/UpdateChiTietSanPham.jsp").forward(request, response);
    }

    private void viewAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<SanPham> listSP=new SanPhamImp().getAll();
        request.setAttribute("listSP",listSP);
        List<NhaSanXuat> listNSX=new NhaSanXuatImp().getAll();
        request.setAttribute("listNSX",listNSX);
        List<MauSac> listMS=new MauSacImp().getAll();
        request.setAttribute("listMS",listMS);
        List<DongSanPham> listDSP=new DongSanPhamImp().getAll();
        request.setAttribute("listDSP",listDSP);
        request.getRequestDispatcher("/view/AddChiTietSanPham.jsp").forward(request, response);
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        ChiTietSanPham ChiTietSanPham = service.getOne(id);
        request.setAttribute("mtam", ChiTietSanPham);
        request.getRequestDispatcher("/view/UpdateChiTietSanPham.jsp").forward(request, response);
    }

    private void Update(HttpServletRequest request, HttpServletResponse response) throws IOException, InvocationTargetException, IllegalAccessException {
        ChiTietSanPhamRequest chiTietSanPhamRequest = new ChiTietSanPhamRequest();
        BeanUtils.populate(chiTietSanPhamRequest, request.getParameterMap());
        int sanPhamId = Integer.parseInt(request.getParameter("sanPham.id"));
        int nhaSanXuatId = Integer.parseInt(request.getParameter("nhaSanXuat.id"));
        int mauSacId = Integer.parseInt(request.getParameter("mauSac.id"));
        int dongSanPhamId = Integer.parseInt(request.getParameter("dongSanPham.id"));
        int id=Integer.parseInt(request.getParameter("id"));
        SanPham sanPham = new SanPham();
        sanPham.setId(sanPhamId);

        NhaSanXuat nhaSanXuat = new NhaSanXuat();
        nhaSanXuat.setId(nhaSanXuatId);

        MauSac mauSac = new MauSac();
        mauSac.setId(mauSacId);

        DongSanPham dongSanPham = new DongSanPham();
        dongSanPham.setId(dongSanPhamId);
        chiTietSanPhamRequest.setSanPham(sanPham);
        chiTietSanPhamRequest.setNhaSanXuat(nhaSanXuat);
        chiTietSanPhamRequest.setMauSac(mauSac);
        chiTietSanPhamRequest.setDongSanPham(dongSanPham);
        chiTietSanPhamRequest.setId(id);
        service.updateChiTietSanPhamRequest(chiTietSanPhamRequest);
        response.sendRedirect("/HienThiChiTietSanPham");
    }

    private void Add(HttpServletRequest request, HttpServletResponse response) throws IOException, InvocationTargetException, IllegalAccessException {
        ChiTietSanPhamRequest chiTietSanPhamRequest = new ChiTietSanPhamRequest();
        BeanUtils.populate(chiTietSanPhamRequest, request.getParameterMap());
        int sanPhamId = Integer.parseInt(request.getParameter("sanPham.id"));
        int nhaSanXuatId = Integer.parseInt(request.getParameter("nhaSanXuat.id"));
        int mauSacId = Integer.parseInt(request.getParameter("mauSac.id"));
        int dongSanPhamId = Integer.parseInt(request.getParameter("dongSanPham.id"));

        SanPham sanPham = new SanPham();
        sanPham.setId(sanPhamId);

        NhaSanXuat nhaSanXuat = new NhaSanXuat();
        nhaSanXuat.setId(nhaSanXuatId);

        MauSac mauSac = new MauSac();
        mauSac.setId(mauSacId);

        DongSanPham dongSanPham = new DongSanPham();
        dongSanPham.setId(dongSanPhamId);
        chiTietSanPhamRequest.setSanPham(sanPham);
        chiTietSanPhamRequest.setNhaSanXuat(nhaSanXuat);
        chiTietSanPhamRequest.setMauSac(mauSac);
        chiTietSanPhamRequest.setDongSanPham(dongSanPham);

        System.out.println("Toi là Add: "+ service.addChiTietSanPhamRequest(chiTietSanPhamRequest));
        response.sendRedirect("/HienThiChiTietSanPham");
    }

}
//    private void Add(HttpServletRequest request, HttpServletResponse response) throws IOException, InvocationTargetException, IllegalAccessException {
//        ChiTietSanPhamRequest chiTietSanPhamRequest =new ChiTietSanPhamRequest();
//        BeanUtils.populate(chiTietSanPhamRequest,request.getParameterMap());
//
//        int sanPhamId = Integer.parseInt(request.getParameter("sanPham.id"));
//        int nhaSanXuatId = Integer.parseInt(request.getParameter("nhaSanXuat.id"));
//        int mauSacId = Integer.parseInt(request.getParameter("mauSac.id"));
//        int dongSanPhamId = Integer.parseInt(request.getParameter("dongSanPham.id"));
//
//        SanPham sanPham = new SanPham();
//        NhaSanXuat nhaSanXuat=new NhaSanXuat();
//        nhaSanXuat.setId(nhaSanXuatId);
//        MauSac mauSac=new MauSac();
//        DongSanPham dongSanPham=new DongSanPham();
//
//        sanPham.setId(sanPhamId);
//        nhaSanXuat.setId(nhaSanXuatId);
//        mauSac.setId(mauSacId);
//        dongSanPham.setId(dongSanPhamId);
//        System.out.println("SP: "+sanPhamId+"NSX " +nhaSanXuatId+"MS: "+mauSacId+"SDP: "+dongSanPhamId);
//        chiTietSanPhamRequest.setSanPham(sanPham);
//        chiTietSanPhamRequest.setNhaSanXuat(nhaSanXuat);
//        chiTietSanPhamRequest.setMauSac(mauSac);
//        chiTietSanPhamRequest.setDongSanPham(dongSanPham);
//        System.out.println("Minh tam: "+chiTietSanPhamRequest);
//        service.addChiTietSanPhamRequest(chiTietSanPhamRequest);
//        response.sendRedirect("/HienThiChiTietSanPham");
//    }