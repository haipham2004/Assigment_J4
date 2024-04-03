package com.example.Assigment2_J4.config;

import com.example.Assigment2_J4.entity.ChiTietSanPham;
import com.example.Assigment2_J4.entity.ChucVu;
import com.example.Assigment2_J4.entity.CuaHang;
import com.example.Assigment2_J4.entity.DongSanPham;
import com.example.Assigment2_J4.entity.GioHang;
import com.example.Assigment2_J4.entity.GioHangChiTiet;
import com.example.Assigment2_J4.entity.HoaDon;
import com.example.Assigment2_J4.entity.KhachHang;
import com.example.Assigment2_J4.entity.MauSac;
import com.example.Assigment2_J4.entity.NhaSanXuat;
import com.example.Assigment2_J4.entity.NhanVien;
import com.example.Assigment2_J4.entity.SanPham;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class HibernateUtil {
    private static final SessionFactory FACTORY;

    public HibernateUtil() {
    }

    public static SessionFactory getFACTORY() {
        return FACTORY;
    }

    public static void main(String[] args) {
        System.out.println(getFACTORY());
        System.out.println("Kết nối thành công");
    }

    static {
        Configuration conf = new Configuration();
        Properties properties = new Properties();
        properties.put("hibernate.dialect", "org.hibernate.dialect.SQLServerDialect");
        properties.put("hibernate.connection.driver_class", "com.microsoft.sqlserver.jdbc.SQLServerDriver");
        properties.put("hibernate.connection.url", "jdbc:sqlserver://localhost:1433;databaseName=FINALASS_FPOLYSHOP_FA22_SOF205__SOF2041");
        properties.put("hibernate.connection.username", "sa");
        properties.put("hibernate.connection.password", "Haitam77");
        properties.put("hibernate.show_sql", "true");
        conf.setProperties(properties);
        conf.addAnnotatedClass(NhaSanXuat.class);
        conf.addAnnotatedClass(DongSanPham.class);
        conf.addAnnotatedClass(MauSac.class);
        conf.addAnnotatedClass(ChucVu.class);
        conf.addAnnotatedClass(SanPham.class);
        conf.addAnnotatedClass(ChiTietSanPham.class);
        conf.addAnnotatedClass(CuaHang.class);
        conf.addAnnotatedClass(GioHang.class);
        conf.addAnnotatedClass(KhachHang.class);
        conf.addAnnotatedClass(HoaDon.class);
        conf.addAnnotatedClass(KhachHang.class);
        conf.addAnnotatedClass(NhanVien.class);
        conf.addAnnotatedClass(GioHangChiTiet.class);
        ServiceRegistry registry = (new StandardServiceRegistryBuilder()).applySettings(conf.getProperties()).build();
        FACTORY = conf.buildSessionFactory(registry);
    }
}
