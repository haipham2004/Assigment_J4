package com.example.Assigment2_J4.service.Imp;

import com.example.Assigment2_J4.entity.GioHang;
import com.example.Assigment2_J4.repository.GioHangRepository;
import com.example.Assigment2_J4.request.GioHangRequest;
import com.example.Assigment2_J4.service.BanHangService;

import java.util.List;

public class GioHangImp implements BanHangService<GioHang,Integer> {
    GioHangRepository repo=new GioHangRepository();
    @Override
    public List<GioHang> getAll() {
        return repo.getAll();
    }

    @Override
    public GioHang getOne(int id) {
        return repo.getOne(id);
    }

    @Override
    public boolean add(GioHang gioHang) {
        return repo.add(gioHang);
    }

    @Override
    public boolean update(GioHang gioHang) {
        return repo.update(gioHang);
    }

    @Override
    public boolean delete(GioHang gioHang) {
        return repo.delete(gioHang);
    }

    public boolean addGioHangRequest(GioHangRequest gioHangRequest){
        GioHang gioHang=new GioHang();
        gioHang.setKhachHang(gioHangRequest.getKhachHang());
        gioHang.setNhanVien(gioHangRequest.getNhanVien());
        gioHang.setMa(gioHangRequest.getMa());
        gioHang.setNgayTao(gioHangRequest.getNgayTao());
        gioHang.setNgayThanhToan(gioHangRequest.getNgayThanhToan());
        gioHang.setTenNguoiNhan(gioHangRequest.getTenNguoiNhan());
        gioHang.setDiaChi(gioHangRequest.getDiaChi());
        gioHang.setSoDienThoai(gioHangRequest.getSoDienThoai());
        gioHang.setTinhTrang(gioHangRequest.getTinhTrang());
        return repo.add(gioHang);
    }

    public boolean updateGioHangRequest(GioHangRequest gioHangRequest){
        GioHang gioHang=new GioHang();
        gioHang.setId(gioHangRequest.getId());
        gioHang.setKhachHang(gioHangRequest.getKhachHang());
        gioHang.setNhanVien(gioHangRequest.getNhanVien());
        gioHang.setMa(gioHangRequest.getMa());
        gioHang.setNgayTao(gioHangRequest.getNgayTao());
        gioHang.setNgayThanhToan(gioHangRequest.getNgayThanhToan());
        gioHang.setTenNguoiNhan(gioHangRequest.getTenNguoiNhan());
        gioHang.setDiaChi(gioHangRequest.getDiaChi());
        gioHang.setSoDienThoai(gioHangRequest.getSoDienThoai());
        gioHang.setTinhTrang(gioHangRequest.getTinhTrang());
        return repo.update(gioHang);
    }
}
