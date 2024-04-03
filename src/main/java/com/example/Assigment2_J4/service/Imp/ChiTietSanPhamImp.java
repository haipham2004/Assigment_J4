package com.example.Assigment2_J4.service.Imp;

import com.example.Assigment2_J4.entity.ChiTietSanPham;
import com.example.Assigment2_J4.repository.ChiTietSanPhamRepository;
import com.example.Assigment2_J4.request.ChiTietSanPhamRequest;
import com.example.Assigment2_J4.service.BanHangService;

import java.util.List;


public class ChiTietSanPhamImp implements BanHangService<ChiTietSanPham, Integer> {
    ChiTietSanPhamRepository repo=new ChiTietSanPhamRepository();
    @Override
    public List<ChiTietSanPham> getAll() {
        return repo.getAll();
    }

    @Override
    public ChiTietSanPham getOne(int id) {
        return repo.getOne(id);
    }

    @Override
    public boolean add(ChiTietSanPham chiTietSanPham) {
        return repo.add(chiTietSanPham);
    }

    @Override
    public boolean update(ChiTietSanPham chiTietSanPham) {
        return repo.update(chiTietSanPham);
    }

    @Override
    public boolean delete(ChiTietSanPham chiTietSanPham) {
        return repo.delete(chiTietSanPham);
    }

    public boolean addChiTietSanPhamRequest(ChiTietSanPhamRequest chiTietSanPhamRequest){
        ChiTietSanPham chiTietSanPham=new ChiTietSanPham();
        chiTietSanPham.setSanPham(chiTietSanPhamRequest.getSanPham());
        chiTietSanPham.setDongSanPham(chiTietSanPhamRequest.getDongSanPham());
        chiTietSanPham.setNhaSanXuat(chiTietSanPhamRequest.getNhaSanXuat());
        chiTietSanPham.setMauSac(chiTietSanPhamRequest.getMauSac());
        chiTietSanPham.setNamBH(chiTietSanPhamRequest.getNamBH());
        chiTietSanPham.setMoTa(chiTietSanPhamRequest.getMoTa());
        chiTietSanPham.setSoLuongTon(chiTietSanPhamRequest.getSoLuongTon());
        chiTietSanPham.setGiaNhap(chiTietSanPhamRequest.getGiaNhap());
        chiTietSanPham.setGiaBan(chiTietSanPhamRequest.getGiaBan());
       return repo.add(chiTietSanPham);
    }

    public boolean updateChiTietSanPhamRequest(ChiTietSanPhamRequest chiTietSanPhamRequest){
        ChiTietSanPham chiTietSanPham=new ChiTietSanPham();
        chiTietSanPham.setId(chiTietSanPhamRequest.getId());
        chiTietSanPham.setSanPham(chiTietSanPhamRequest.getSanPham());
        chiTietSanPham.setDongSanPham(chiTietSanPhamRequest.getDongSanPham());
        chiTietSanPham.setNhaSanXuat(chiTietSanPhamRequest.getNhaSanXuat());
        chiTietSanPham.setMauSac(chiTietSanPhamRequest.getMauSac());
        chiTietSanPham.setNamBH(chiTietSanPhamRequest.getNamBH());
        chiTietSanPham.setMoTa(chiTietSanPhamRequest.getMoTa());
        chiTietSanPham.setSoLuongTon(chiTietSanPhamRequest.getSoLuongTon());
        chiTietSanPham.setGiaNhap(chiTietSanPhamRequest.getGiaNhap());
        chiTietSanPham.setGiaBan(chiTietSanPhamRequest.getGiaBan());
        return repo.update(chiTietSanPham);
    }
}
