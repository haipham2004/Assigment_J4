package com.example.Assigment2_J4.service.Imp;

import com.example.Assigment2_J4.entity.SanPham;
import com.example.Assigment2_J4.repository.SanPhamRepository;
import com.example.Assigment2_J4.service.BanHangService;

import java.util.List;

public class SanPhamImp implements BanHangService<SanPham, Integer> {
    SanPhamRepository repo=new SanPhamRepository();
    @Override
    public List<SanPham> getAll() {
        return repo.getAll();
    }

    @Override
    public SanPham getOne(int id) {
        return repo.getOne(id);
    }

    @Override
    public boolean add(SanPham sanPham) {
        return repo.add(sanPham);
    }

    @Override
    public boolean update(SanPham sanPham) {
        return repo.update(sanPham);
    }

    @Override
    public boolean delete(SanPham sanPham) {
        return repo.delete(sanPham);
    }
}
