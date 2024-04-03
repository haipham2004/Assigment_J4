package com.example.Assigment2_J4.request;
import com.example.Assigment2_J4.entity.ChiTietSanPham;
import com.example.Assigment2_J4.entity.GioHang;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class GioHangChiTietRequest {

    private GioHang gioHang;

    private ChiTietSanPham chiTietSanPham;

    private int soLuong;

    private long donGia;

    private long donGiaKhiGiam;
}
