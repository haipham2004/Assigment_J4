package com.example.Assigment2_J4.controller;

import com.example.Assigment2_J4.entity.CuaHang;
import com.example.Assigment2_J4.entity.NhanVien;
import com.example.Assigment2_J4.request.NhanVienRequest;
import com.example.Assigment2_J4.service.Imp.NhanVienImp;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import com.example.Assigment2_J4.entity.ChucVu;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;


@WebServlet(name = "NhanVienController", value = {
        "/HienThiNhanVien",
        "/DetailNhanVien",
        "/viewAddNhanVien",
        "/viewUpdateNhanVien",
        "/DeleteNhanVien",
        "/AddNhanVien",
        "/UpdateNhanVien",
        "/LoginNhanVien"
})
public class NhanVienController extends HttpServlet {
    NhanVienImp service = new NhanVienImp();
    List<NhanVien> list = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("HienThiNhanVien")) {
            this.HienThi(request, response);
        } else if (uri.contains("DetailNhanVien")) {
            this.detail(request, response);
        } else if (uri.contains("viewAddNhanVien")) {
            this.viewAdd(request, response);
        } else if (uri.contains("viewUpdateNhanVien")) {
            this.viewUpdate(request, response);
        } else if (uri.contains("DeleteNhanVien")) {
            this.delete(request, response);
        }
    }


    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("AddNhanVien")) {
            this.Add(request, response);
        } else if (uri.contains("UpdateNhanVien")) {
            this.Update(request, response);
        }
    }

    
    private void HienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        list = service.getAll();
        request.setAttribute("list", list);
        System.out.println("haha");
        request.getRequestDispatcher("/view/ListNhanVien.jsp").forward(request, response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        NhanVien NhanVien=service.getOne(id);
        service.delete(NhanVien);
        response.sendRedirect("/HienThiNhanVien");
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        NhanVien NhanVien=service.getOne(id);
        request.setAttribute("mtam",NhanVien);
        request.getRequestDispatcher("/view/UpdateNhanVien.jsp").forward(request,response);
    }

    private void viewAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/view/AddNhanVien.jsp").forward(request,response);
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        NhanVien NhanVien=service.getOne(id);
        request.setAttribute("mtam",NhanVien);
        request.getRequestDispatcher("/view/UpdateNhanVien.jsp").forward(request,response);
    }

    private void Update(HttpServletRequest request, HttpServletResponse response) throws IOException, InvocationTargetException, IllegalAccessException {
        NhanVienRequest nhanVienRequest=new NhanVienRequest();
        BeanUtils.populate(nhanVienRequest,request.getParameterMap());
        int id=Integer.parseInt(request.getParameter("id"));
        int CuaHangID=Integer.parseInt(request.getParameter("cuaHang.id"));
        int ChucVuID=Integer.parseInt(request.getParameter("chucVu.id"));
        CuaHang cuaHang=new CuaHang();
        cuaHang.setId(CuaHangID);
        ChucVu chucVu=new ChucVu();
        chucVu.setId(ChucVuID);
        nhanVienRequest.setChucVu(chucVu);
        nhanVienRequest.setCuaHang(cuaHang);
        System.out.println("Ket qua: "+  service.updateNhanVienRequest(nhanVienRequest));
        response.sendRedirect("/HienThiNhanVien");
    }

    private void Add(HttpServletRequest request, HttpServletResponse response) throws IOException, InvocationTargetException, IllegalAccessException {
        NhanVienRequest nhanVienRequest=new NhanVienRequest();
        BeanUtils.populate(nhanVienRequest,request.getParameterMap());
        int CuaHangID=Integer.parseInt(request.getParameter("cuaHang.id"));
        int ChucVuID=Integer.parseInt(request.getParameter("chucVu.id"));
        CuaHang cuaHang=new CuaHang();
        cuaHang.setId(CuaHangID);
        ChucVu chucVu=new ChucVu();
        chucVu.setId(ChucVuID);
        nhanVienRequest.setChucVu(chucVu);
        nhanVienRequest.setCuaHang(cuaHang);
        service.addNhanVienRequest(nhanVienRequest);
        response.sendRedirect("/HienThiNhanVien");
    }

//    private void Login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String user=request.getParameter("userName");
//        String pass=request.getParameter("password");
//        request.setAttribute("user",user);
//        request.setAttribute("pass",pass);
//        NhanVien tk=repo.login(user,pass);
//        boolean check=false;
//        if(user.isEmpty()){
//            check=true;
//            request.setAttribute("baoLoiUser","Nhập user đi");
//        }
//        if(pass.isEmpty()){
//            check=true;
//            request.setAttribute("baoLoiPassword","Nhập password đi");
//
//        }
//        if(check==true){
//            request.getRequestDispatcher("/view/viewLogin.jsp").forward(request,response);
//        }else{
//            if(tk!=null){
//                list=repo2.getAll();
//                request.setAttribute("listGV",listGV);
//                request.getRequestDispatcher("/view/ListGiangVien.jsp").forward(request,response);
//            }else{
//                request.setAttribute("baoLoiTaiKhoan","Tài khoản không tồn tại");
//                request.getRequestDispatcher("/view/viewLogin.jsp").forward(request,response);
//            }
//        }
//    }

}
