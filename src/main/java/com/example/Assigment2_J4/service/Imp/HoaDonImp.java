package com.example.Assigment2_J4.service.Imp;

import com.example.Assigment2_J4.entity.GioHang;
import com.example.Assigment2_J4.entity.HoaDon;
import com.example.Assigment2_J4.repository.HoaDonRepository;
import com.example.Assigment2_J4.request.GioHangRequest;
import com.example.Assigment2_J4.request.HoaDonRequest;
import com.example.Assigment2_J4.service.BanHangService;

import java.util.List;

public class HoaDonImp implements BanHangService<HoaDon,Integer> {
    HoaDonRepository repo=new HoaDonRepository();
    @Override
    public List<HoaDon> getAll() {
        return repo.getAll();
    }

    @Override
    public HoaDon getOne(int id) {
        return repo.getOne(id);
    }

    @Override
    public boolean add(HoaDon hoaDon) {
        return repo.add(hoaDon);
    }

    @Override
    public boolean update(HoaDon hoaDon) {
        return repo.update(hoaDon);
    }

    @Override
    public boolean delete(HoaDon hoaDon) {
        return repo.delete(hoaDon);
    }

    public boolean addHoaDonRequest(HoaDonRequest hoaDonRequest){
        HoaDon hoaDon=new HoaDon();
        hoaDon.setKhachHang(hoaDonRequest.getKhachHang());
        hoaDon.setNhanVien(hoaDonRequest.getNhanVien());
        hoaDon.setMa(hoaDonRequest.getMa());
        hoaDon.setNgayTao(hoaDonRequest.getNgayTao());
        hoaDon.setNgayThanhToan(hoaDonRequest.getNgayThanhToan());
        hoaDon.setTenNguoiNhan(hoaDonRequest.getTenNguoiNhan());
        hoaDon.setDiaChi(hoaDonRequest.getDiaChi());
        hoaDon.setSoDienThoai(hoaDonRequest.getSoDienThoai());
        hoaDon.setTinhTrang(hoaDonRequest.getTinhTrang());
        hoaDon.setNgayShip(hoaDonRequest.getNgayShip());
        hoaDon.setNgayNhan(hoaDonRequest.getNgayNhan());
        return repo.add(hoaDon);
    }

    public boolean updateHoaDonRequest(HoaDonRequest hoaDonRequest){
        HoaDon hoaDon=new HoaDon();
        hoaDon.setId(hoaDonRequest.getId());
        hoaDon.setNhanVien(hoaDonRequest.getNhanVien());
        hoaDon.setKhachHang(hoaDonRequest.getKhachHang());
        hoaDon.setMa(hoaDonRequest.getMa());
        hoaDon.setNgayTao(hoaDonRequest.getNgayTao());
        hoaDon.setNgayThanhToan(hoaDonRequest.getNgayThanhToan());
        hoaDon.setTenNguoiNhan(hoaDonRequest.getTenNguoiNhan());
        hoaDon.setDiaChi(hoaDonRequest.getDiaChi());
        hoaDon.setSoDienThoai(hoaDonRequest.getSoDienThoai());
        hoaDon.setTinhTrang(hoaDonRequest.getTinhTrang());
        hoaDon.setNgayShip(hoaDonRequest.getNgayShip());
        hoaDon.setNgayNhan(hoaDonRequest.getNgayNhan());
        return repo.update(hoaDon);
    }
}
