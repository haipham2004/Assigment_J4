package com.example.Assigment2_J4.repository;

import com.example.Assigment2_J4.config.HibernateUtil;
import com.example.Assigment2_J4.entity.DongSanPham;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class DongSanPhamRepository {
    private List<DongSanPham> list=new ArrayList<>();
    public List<DongSanPham> getAll(){
        Session session= HibernateUtil.getFACTORY().openSession();
        list=session.createQuery("FROM DongSanPham", DongSanPham.class).getResultList();
        return list;
    }
    public DongSanPham getOne(int id){
        Transaction transaction=null;
        DongSanPham dongSanPham =null;
        try(Session session= HibernateUtil.getFACTORY().openSession()){
            transaction=session.beginTransaction();
            dongSanPham =session.get(DongSanPham.class,id);
            transaction.commit();
            session.close();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return dongSanPham;
    }

    public boolean add(DongSanPham dongSanPham){
        Transaction transaction=null;
        try(Session session= HibernateUtil.getFACTORY().openSession()){
            transaction=session.beginTransaction();
            session.save(dongSanPham);
            transaction.commit();
            session.close();
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean update(DongSanPham dongSanPham){
        Transaction transaction=null;
        try(Session session= HibernateUtil.getFACTORY().openSession()){
            transaction=session.beginTransaction();
            session.update(dongSanPham);
            transaction.commit();
            session.close();
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean delete(DongSanPham dongSanPham){
        Transaction transaction=null;
        try(Session session= HibernateUtil.getFACTORY().openSession()){
            transaction=session.beginTransaction();
            session.delete(dongSanPham);
            transaction.commit();
            session.close();
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
