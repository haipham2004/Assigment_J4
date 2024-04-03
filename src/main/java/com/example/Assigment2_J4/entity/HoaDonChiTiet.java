//package com.example.hibernate_example.entity;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//import jakarta.persistence.Table;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import java.io.Serializable;
//import java.math.BigDecimal;
//
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//
//
//@Entity
//@Table(name = "HoaDonChiTiet")
//public class HoaDonChiTiet implements Serializable {
//    @Id
//    @ManyToOne
//    @JoinColumn(name = "IdHoaDon")
//    private HoaDon hoaDon;
//
//    @Id
//    @ManyToOne
//    @JoinColumn(name = "IdChiTietSP")
//    private ChiTietSP chiTietSP;
//
//    @Column(name = "SoLuong")
//    private Integer soLuong;
//
//    @Column(name = "DonGia")
//    private BigDecimal donGia;
//}
