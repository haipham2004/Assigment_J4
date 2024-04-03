package com.example.Assigment2_J4.service.Imp;

import com.example.Assigment2_J4.entity.GioHangChiTiet;
import com.example.Assigment2_J4.repository.GioHangChiTietRepository;
import com.example.Assigment2_J4.request.GioHangChiTietRequest;
import com.example.Assigment2_J4.service.BanHangService;

import java.util.List;

public class GioHangChiTietImp implements BanHangService<GioHangChiTiet, Integer> {
    GioHangChiTietRepository repo = new GioHangChiTietRepository();

    @Override
    public List<GioHangChiTiet> getAll() {
        return repo.getAll();
    }

    @Override
    public GioHangChiTiet getOne(int id) {
        return repo.getOne(id);
    }

    @Override
    public boolean add(GioHangChiTiet gioHangChiTiet) {
        return repo.add(gioHangChiTiet);
    }

    @Override
    public boolean update(GioHangChiTiet gioHangChiTiet) {
        return repo.update(gioHangChiTiet);
    }

    @Override
    public boolean delete(GioHangChiTiet gioHangChiTiet) {
        return repo.delete(gioHangChiTiet);
    }

    public boolean addGioHangChiTietRequest(GioHangChiTietRequest gioHangChiTietRequest) {
        GioHangChiTiet gioHangChiTiet = new GioHangChiTiet();
        gioHangChiTiet.setChiTietSanPham(gioHangChiTietRequest.getChiTietSanPham());
        gioHangChiTiet.setGioHang(gioHangChiTiet.getGioHang());
        gioHangChiTiet.setSoLuong(gioHangChiTietRequest.getSoLuong());
        gioHangChiTiet.setDonGia(gioHangChiTietRequest.getDonGia());
        gioHangChiTiet.setDonGiaKhiGiam(gioHangChiTietRequest.getDonGiaKhiGiam());
        return repo.add(gioHangChiTiet);
    }

    public boolean updateGioHangChiTietRequest(GioHangChiTietRequest gioHangChiTietRequest) {
        GioHangChiTiet gioHangChiTiet = new GioHangChiTiet();
        gioHangChiTiet.setChiTietSanPham(gioHangChiTietRequest.getChiTietSanPham());
        gioHangChiTiet.setGioHang(gioHangChiTiet.getGioHang());
        gioHangChiTiet.setSoLuong(gioHangChiTietRequest.getSoLuong());
        gioHangChiTiet.setDonGia(gioHangChiTietRequest.getDonGia());
        gioHangChiTiet.setDonGiaKhiGiam(gioHangChiTietRequest.getDonGiaKhiGiam());
        return repo.add(gioHangChiTiet);
    }
}
