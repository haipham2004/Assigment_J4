package com.example.Assigment2_J4.request;

import com.example.Assigment2_J4.entity.DongSanPham;
import com.example.Assigment2_J4.entity.MauSac;
import com.example.Assigment2_J4.entity.NhaSanXuat;
import com.example.Assigment2_J4.entity.SanPham;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ChiTietSanPhamRequest {
    private int id;

    private SanPham sanPham;

    private NhaSanXuat nhaSanXuat;

    private MauSac mauSac;

    private DongSanPham dongSanPham;

    private int namBH;

    private String moTa;

    private int soLuongTon;

    private double giaNhap;

    private double giaBan;
}
