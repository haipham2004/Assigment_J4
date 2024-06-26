package com.example.Assigment2_J4.controller;

import com.example.Assigment2_J4.entity.ChucVu;
import com.example.Assigment2_J4.service.Imp.ChucVuImp;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ChucVuController", value = {
        "/HienThiChucVu",
        "/DetailChucVu",
        "/viewAddChucVu",
        "/viewUpdateChucVu",
        "/DeleteChucVu",
        "/AddChucVu",
        "/UpdateChucVu"
})
public class ChucVuController extends HttpServlet {
    ChucVuImp service = new ChucVuImp();
    List<ChucVu> list = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("HienThiChucVu")) {
            this.HienThi(request, response);
        } else if (uri.contains("DetailChucVu")) {
            this.detail(request, response);
        } else if (uri.contains("viewAddChucVu")) {
            this.viewAdd(request, response);
        } else if (uri.contains("viewUpdateChucVu")) {
            this.viewUpdate(request, response);
        } else if (uri.contains("DeleteChucVu")) {
            this.delete(request, response);
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("AddChucVu")) {
            this.Add(request, response);
        } else if (uri.contains("UpdateChucVu")) {
            this.Update(request, response);
        }
    }


    private void HienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        list = service.getAll();
        request.setAttribute("list", list);
        request.getRequestDispatcher("/view/ListChucVu.jsp").forward(request, response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        ChucVu ChucVu = service.getOne(id);
        service.delete(ChucVu);
        response.sendRedirect("/HienThiChucVu");
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        System.out.println("lalaa");
        ChucVu chucVu = service.getOne(id);
        request.setAttribute("mtam", chucVu);
        request.getRequestDispatcher("/view/UpdateChucVu.jsp").forward(request, response);
    }

    private void viewAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/view/AddChucVu.jsp").forward(request, response);
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        ChucVu ChucVu = service.getOne(id);
        request.setAttribute("mtam", ChucVu);
        request.getRequestDispatcher("/view/UpdateChucVu.jsp").forward(request, response);
    }

    private void Update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        ChucVu chucVu = ChucVu.builder().id(Integer.parseInt(id)).ma(ma).ten(ten).build();
        service.update(chucVu);
        response.sendRedirect("/HienThiChucVu");
    }

    private void Add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        ChucVu chucVu = ChucVu.builder().ma(ma).ten(ten).build();
        service.add(chucVu);
        response.sendRedirect("/HienThiChucVu");
    }


}
