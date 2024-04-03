package com.example.Assigment2_J4.service.Imp;

import com.example.Assigment2_J4.entity.NhaSanXuat;
import com.example.Assigment2_J4.repository.NhaSanXuatRepository;
import com.example.Assigment2_J4.service.BanHangService;

import java.util.List;


public class NhaSanXuatImp implements BanHangService<NhaSanXuat, Integer> {
    NhaSanXuatRepository repo=new NhaSanXuatRepository();
    @Override
    public List<NhaSanXuat> getAll() {
        return repo.getAll();
    }

    @Override
    public NhaSanXuat getOne(int id) {
        return repo.getOne(id);
    }

    @Override
    public boolean add(NhaSanXuat nhaSanXuat) {
        return repo.add(nhaSanXuat);
    }

    @Override
    public boolean update(NhaSanXuat nhaSanXuat) {
        return repo.update(nhaSanXuat);
    }

    @Override
    public boolean delete(NhaSanXuat nhaSanXuat) {
        return repo.delete(nhaSanXuat);
    }
}
