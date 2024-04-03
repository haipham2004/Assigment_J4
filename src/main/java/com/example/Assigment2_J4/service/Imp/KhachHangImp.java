package com.example.Assigment2_J4.service.Imp;

import com.example.Assigment2_J4.entity.KhachHang;
import com.example.Assigment2_J4.repository.KhachHangRepository;
import com.example.Assigment2_J4.request.KhachHangRequest;
import com.example.Assigment2_J4.service.BanHangService;

import java.util.List;

public class KhachHangImp implements BanHangService<KhachHang,Integer> {
    KhachHangRepository repo=new KhachHangRepository();
    @Override
    public List<KhachHang> getAll() {
        return repo.getAll();
    }

    @Override
    public KhachHang getOne(int id) {
        return repo.getOne(id);
    }

    @Override
    public boolean add(KhachHang khachHang) {
        return repo.add(khachHang);
    }

    @Override
    public boolean update(KhachHang khachHang) {
        return repo.update(khachHang);
    }

    @Override
    public boolean delete(KhachHang khachHang) {
        return repo.delete(khachHang);
    }
    public boolean addKhachHangRequest(KhachHangRequest khachHangRequest){
        KhachHang khachHang=new KhachHang();
        khachHang.setMa(khachHangRequest.getMa());
        khachHang.setTen(khachHangRequest.getTen());
        khachHang.setTenDem(khachHangRequest.getTenDem());
        khachHang.setHo(khachHangRequest.getHo());
        khachHang.setNgaySinh(khachHangRequest.getNgaySinh());
        khachHang.setDiaChi(khachHangRequest.getDiaChi());
        khachHang.setSoDienThoai(khachHangRequest.getSoDienThoai());
        khachHang.setMatKhau(khachHangRequest.getMatKhau());
        khachHang.setThanhPho(khachHangRequest.getThanhPho());
        khachHang.setQuocGia(khachHangRequest.getQuocGia());
        return repo.add(khachHang);
    }

    public boolean updateKhachHangRequest(KhachHangRequest khachHangRequest){
        KhachHang khachHang=new KhachHang();
        khachHang.setId(khachHangRequest.getId());
        khachHang.setMa(khachHangRequest.getMa());
        khachHang.setTen(khachHangRequest.getTen());
        khachHang.setTenDem(khachHangRequest.getTenDem());
        khachHang.setHo(khachHangRequest.getHo());
        khachHang.setNgaySinh(khachHangRequest.getNgaySinh());
        khachHang.setDiaChi(khachHangRequest.getDiaChi());
        khachHang.setSoDienThoai(khachHangRequest.getSoDienThoai());
        khachHang.setMatKhau(khachHangRequest.getMatKhau());
        khachHang.setThanhPho(khachHangRequest.getThanhPho());
        khachHang.setQuocGia(khachHangRequest.getQuocGia());
        return repo.update(khachHang);
    }
}
