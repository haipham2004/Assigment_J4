package com.example.Assigment2_J4.request;

import com.example.Assigment2_J4.entity.ChucVu;
import com.example.Assigment2_J4.entity.CuaHang;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class NhanVienRequest {

    private int id;

    private String ma;

    private String ten;

    private String tenDem;

    private String ho;

    private String gioiTinh;

    private Date ngaySinh;

    private String diaChi;

    private String soDienThoai;

    private String matKhau;

    private CuaHang cuaHang;

    private ChucVu chucVu;


    private int trangThai;
}
