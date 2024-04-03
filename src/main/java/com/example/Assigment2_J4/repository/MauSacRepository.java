package com.example.Assigment2_J4.repository;

import com.example.Assigment2_J4.config.HibernateUtil;
import com.example.Assigment2_J4.entity.MauSac;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class MauSacRepository {
    private List<MauSac> list=new ArrayList<>();
    public List<MauSac> getAll(){
        Session session= HibernateUtil.getFACTORY().openSession();
        list=session.createQuery("FROM MauSac",MauSac.class).getResultList();
        return list;
    }
    public MauSac getOne(int id){
        Transaction transaction=null;
        MauSac mauSac=null;
        try(Session session= HibernateUtil.getFACTORY().openSession()){
            transaction=session.beginTransaction();
            mauSac=session.get(MauSac.class,id);
            transaction.commit();
            session.close();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return mauSac;
    }

    public boolean add(MauSac mauSac){
        Transaction transaction=null;
        try(Session session= HibernateUtil.getFACTORY().openSession()){
            transaction=session.beginTransaction();
            session.save(mauSac);
            transaction.commit();
            session.close();
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean update(MauSac mauSac){
        Transaction transaction=null;
        try(Session session= HibernateUtil.getFACTORY().openSession()){
            transaction=session.beginTransaction();
            session.update(mauSac);
            transaction.commit();
            session.close();
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean delete(MauSac mauSac){
        Transaction transaction=null;
        try(Session session= HibernateUtil.getFACTORY().openSession()){
            transaction=session.beginTransaction();
            session.delete(mauSac);
            transaction.commit();
            session.close();
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
