package com.example.Assigment2_J4.request;

import jakarta.persistence.Column;
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
public class KhachHangRequest {

    private int id;

    private String ma;

    private String ten;

    private String tenDem;

    private String ho;

    private Date ngaySinh;

    private String soDienThoai;

    private String diaChi;

    private String thanhPho;

    private String quocGia;

    private String matKhau;
}
