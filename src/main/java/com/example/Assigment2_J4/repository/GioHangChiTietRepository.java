package com.example.Assigment2_J4.repository;

import com.example.Assigment2_J4.config.HibernateUtil;
import com.example.Assigment2_J4.entity.GioHang;
import com.example.Assigment2_J4.entity.GioHangChiTiet;
import com.oracle.wls.shaded.org.apache.regexp.RE;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class GioHangChiTietRepository {
    private List<GioHangChiTiet> list=new ArrayList<>();
    public List<GioHangChiTiet> getAll(){
        Session session= HibernateUtil.getFACTORY().openSession();
        list=session.createQuery("FROM GioHangChiTiet",GioHangChiTiet.class).getResultList();
        return list;
    }
    public GioHangChiTiet getOne(int id){
        Transaction transaction=null;
        GioHangChiTiet gioHangChiTiet=null;
        try(Session session= HibernateUtil.getFACTORY().openSession()){
            transaction=session.beginTransaction();
            gioHangChiTiet=session.get(GioHangChiTiet.class,id);
            transaction.commit();
            session.close();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return gioHangChiTiet;
    }

    public boolean add(GioHangChiTiet gioHangChiTiet){
        Transaction transaction=null;
        try(Session session= HibernateUtil.getFACTORY().openSession()){
            transaction=session.beginTransaction();
            session.save(gioHangChiTiet);
            transaction.commit();
            session.close();
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean update(GioHangChiTiet gioHangChiTiet){
        Transaction transaction=null;
        try(Session session= HibernateUtil.getFACTORY().openSession()){
            transaction=session.beginTransaction();
            session.update(gioHangChiTiet);
            transaction.commit();
            session.close();
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean delete(GioHangChiTiet gioHangChiTiet){
        Transaction transaction=null;
        try(Session session= HibernateUtil.getFACTORY().openSession()){
            transaction=session.beginTransaction();
            session.delete(gioHangChiTiet);
            transaction.commit();
            session.close();
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        GioHangChiTietRepository repo=new GioHangChiTietRepository();
        List<GioHangChiTiet> list=repo.getAll();
        System.out.println("hi");
       for(GioHangChiTiet gh:list){
           System.out.println("123: "+gh);
       }
    }
}
