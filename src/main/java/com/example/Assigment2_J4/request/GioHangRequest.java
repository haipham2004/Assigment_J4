package com.example.Assigment2_J4.request;

import com.example.Assigment2_J4.entity.KhachHang;
import com.example.Assigment2_J4.entity.NhanVien;
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
public class GioHangRequest {

    private int id;

    private KhachHang khachHang;

    private NhanVien nhanVien;

    private String ma;

    private Date ngayTao;

    private Date ngayThanhToan;

    private String tenNguoiNhan;

    private String diaChi;

    private String soDienThoai;

    private int tinhTrang;
}
