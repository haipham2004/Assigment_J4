package com.example.Assigment2_J4.repository;

import com.example.Assigment2_J4.config.HibernateUtil;
import com.example.Assigment2_J4.entity.NhanVien;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class NhanVienRepository {
    private List<NhanVien> list=new ArrayList<>();
    public List<NhanVien> getAll(){
        Session session= HibernateUtil.getFACTORY().openSession();
        list=session.createQuery("FROM NhanVien",NhanVien.class).getResultList();
        return list;
    }
    public NhanVien getOne(int id){
        Transaction transaction=null;
        NhanVien nhanVien=null;
        try(Session session= HibernateUtil.getFACTORY().openSession()){
            transaction=session.beginTransaction();
            nhanVien=session.get(NhanVien.class,id);
            transaction.commit();
            session.close();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return nhanVien;
    }

    public boolean add(NhanVien nhanVien){
        Transaction transaction=null;
        try(Session session= HibernateUtil.getFACTORY().openSession()){
            transaction=session.beginTransaction();
            session.save(nhanVien);
            transaction.commit();
            session.close();
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean update(NhanVien nhanVien){
        Transaction transaction=null;
        try(Session session= HibernateUtil.getFACTORY().openSession()){
            transaction=session.beginTransaction();
            session.update(nhanVien);
            transaction.commit();
            session.close();
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean delete(NhanVien nhanVien){
        Transaction transaction=null;
        try(Session session= HibernateUtil.getFACTORY().openSession()){
            transaction=session.beginTransaction();
            session.delete(nhanVien);
            transaction.commit();
            session.close();
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public NhanVien login(String usernames,String passwords){
        Transaction transaction=null;
        NhanVien nhanVien=null;
        try(Session session= HibernateUtil.getFACTORY().openSession()){
            transaction= session.beginTransaction();
            Query query=session.createQuery("From NhanVien where ma=:usernames and MatKhau=:passwords",NhanVien.class);
            query.setParameter("usernames",usernames);
            query.setParameter("passwords",passwords);
            nhanVien= (NhanVien) query.getSingleResult();
            transaction.commit();
            session.close();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return nhanVien;
    }

    public static void main(String[] args) {
        NhanVienRepository repository=new NhanVienRepository();
        NhanVien tk=repository.login("NV32","Hoilamgia");
        System.out.println("Ghéc: "+tk);
    }
}
