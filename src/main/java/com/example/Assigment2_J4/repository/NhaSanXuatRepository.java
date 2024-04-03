package com.example.Assigment2_J4.repository;

import com.example.Assigment2_J4.config.HibernateUtil;
import com.example.Assigment2_J4.entity.NhaSanXuat;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;


public class NhaSanXuatRepository {
    private List<NhaSanXuat> listNhaSanXuats =new ArrayList<>();
    public List<NhaSanXuat> getAll(){
        Session session= HibernateUtil.getFACTORY().openSession();
        listNhaSanXuats =session.createQuery("FROM NhaSanXuat", NhaSanXuat.class).getResultList();
        return listNhaSanXuats;
    }
    public NhaSanXuat getOne(int id){
        Transaction transaction=null;
        NhaSanXuat nhaSanXuat =null;
        try(Session session= HibernateUtil.getFACTORY().openSession()){
            transaction=session.beginTransaction();
            nhaSanXuat =session.get(NhaSanXuat.class,id);
            transaction.commit();
            session.close();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return nhaSanXuat;
    }

    public boolean add(NhaSanXuat nhaSanXuat){
        Transaction transaction=null;
        try(Session session= HibernateUtil.getFACTORY().openSession()){
            transaction=session.beginTransaction();
            session.save(nhaSanXuat);
            transaction.commit();
            session.close();
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean update(NhaSanXuat nhaSanXuat){
        Transaction transaction=null;
        try(Session session= HibernateUtil.getFACTORY().openSession()){
            transaction=session.beginTransaction();
            session.update(nhaSanXuat);
            transaction.commit();
            session.close();
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean delete(NhaSanXuat nhaSanXuat){
        Transaction transaction=null;
        try(Session session= HibernateUtil.getFACTORY().openSession()){
            transaction=session.beginTransaction();
            session.delete(nhaSanXuat);
            transaction.commit();
            session.close();
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
