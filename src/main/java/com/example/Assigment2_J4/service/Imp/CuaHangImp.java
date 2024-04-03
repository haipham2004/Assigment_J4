package com.example.Assigment2_J4.service.Imp;

import com.example.Assigment2_J4.entity.CuaHang;
import com.example.Assigment2_J4.repository.CuaHangRepository;
import com.example.Assigment2_J4.service.BanHangService;

import java.util.List;

public class CuaHangImp  implements BanHangService<CuaHang,Integer> {
    CuaHangRepository repo=new CuaHangRepository();
    @Override
    public List<CuaHang> getAll() {
        return repo.getAll();
    }

    @Override
    public CuaHang getOne(int id) {
        return repo.getOne(id);
    }

    @Override
    public boolean add(CuaHang cuaHang) {
        return repo.add(cuaHang);
    }

    @Override
    public boolean update(CuaHang cuaHang) {
        return repo.update(cuaHang);
    }

    @Override
    public boolean delete(CuaHang cuaHang) {
        return repo.delete(cuaHang);
    }
}
