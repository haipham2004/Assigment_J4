package com.example.Assigment2_J4.service.Imp;

import com.example.Assigment2_J4.entity.DongSanPham;
import com.example.Assigment2_J4.repository.DongSanPhamRepository;
import com.example.Assigment2_J4.service.BanHangService;

import java.util.List;


public class DongSanPhamImp implements BanHangService<DongSanPham,Integer> {
    DongSanPhamRepository repo=new DongSanPhamRepository();
    @Override
    public List<DongSanPham> getAll() {
        return repo.getAll();
    }

    @Override
    public DongSanPham getOne(int id) {
        return repo.getOne(id);
    }

    @Override
    public boolean add(DongSanPham dongSanPham) {
        return repo.add(dongSanPham);
    }

    @Override
    public boolean update(DongSanPham dongSanPham) {
        return repo.update(dongSanPham);
    }

    @Override
    public boolean delete(DongSanPham dongSanPham) {
        return repo.delete(dongSanPham);
    }

}
