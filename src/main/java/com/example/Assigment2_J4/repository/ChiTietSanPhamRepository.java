package com.example.Assigment2_J4.repository;

import com.example.Assigment2_J4.config.HibernateUtil;
import com.example.Assigment2_J4.entity.ChiTietSanPham;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class ChiTietSanPhamRepository {
    private List<ChiTietSanPham> list=new ArrayList<>();
    public List<ChiTietSanPham> getAll(){
        Session session= HibernateUtil.getFACTORY().openSession();
        list=session.createQuery("FROM ChiTietSanPham", ChiTietSanPham.class).getResultList();
        return list;
    }

    public ChiTietSanPham getOne(int id){
        Transaction transaction=null;
        ChiTietSanPham chiTietSanPham =null;
        try(Session session= HibernateUtil.getFACTORY().openSession()){
            transaction=session.beginTransaction();
            chiTietSanPham =session.get(ChiTietSanPham.class,id);
            transaction.commit();
            session.close();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return chiTietSanPham;
    }

    public boolean add(ChiTietSanPham chiTietSanPham){
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.save(chiTietSanPham);
            transaction.commit();
            session.close();
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean update(ChiTietSanPham chiTietSanPham){
        Transaction transaction=null;
        try(Session session= HibernateUtil.getFACTORY().openSession()){
            transaction=session.beginTransaction();
            session.update(chiTietSanPham);
            transaction.commit();
            session.close();
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean delete(ChiTietSanPham chiTietSanPham){
        Transaction transaction=null;
        try(Session session= HibernateUtil.getFACTORY().openSession()){
            transaction=session.beginTransaction();
            session.delete(chiTietSanPham);
            transaction.commit();
            session.close();
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
