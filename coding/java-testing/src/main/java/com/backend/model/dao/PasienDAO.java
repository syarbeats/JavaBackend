package com.backend.model.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.backend.hibernate.*;
import com.backend.model.Kelurahan;
import com.backend.model.Pasien;
import com.backend.hibernate.*;;


public class PasienDAO {
	
	

	public void addPasien(Pasien pasien){
        Session session = SessionUtil.getSession();        
        Transaction tx = session.beginTransaction();
        addPasien(session,pasien);        
        tx.commit();
        session.close();
        
    }
    
    private void addPasien(Session session, Pasien pasien){
        Pasien dataPasien = new Pasien();
        
        dataPasien.setNama(pasien.getNama());
        dataPasien.setAlamat(pasien.getAlamat());
        dataPasien.setKelurahan(pasien.getKelurahan());
        dataPasien.setNo_telepon(pasien.getNo_telepon());
        dataPasien.setRTRW(pasien.getRTRW());
        dataPasien.setTanggal_lahir(pasien.getTanggal_lahir());
        dataPasien.setJenis_kelamin(pasien.getJenis_kelamin());
        
        session.save(dataPasien);
    }
    
    public List<Pasien> getAllDataPasien(){
        Session session = SessionUtil.getSession();    
        Query query = session.createQuery("from Pasien");
        List<Pasien> dataPasien =  query.list();
        return dataPasien;
    }
    
    public List<Pasien> getDataPasien(int id){
        Session session = SessionUtil.getSession();    
        Query query = session.createQuery("from Pasien where id = :id");
        query.setParameter("id", id);
        List<Pasien> dataPasien =  query.list();
        return dataPasien;
    }
 
    public int deletePasien(int id) {
        Session session = SessionUtil.getSession();
        Transaction tx = session.beginTransaction();
        String hql = "delete from Pasien where id = :id";
        Query query = session.createQuery(hql);
        query.setInteger("id",id);
        int rowCount = query.executeUpdate();
        System.out.println("Rows affected: " + rowCount);
        tx.commit();
        session.close();
        return rowCount;
    }
    
    public int updatePasien(int id, Pasien pasien){
    	
         if(id <=0)  
               return 0;  
         
         Session session = SessionUtil.getSession();
            Transaction tx = session.beginTransaction();
            String hql = "update Pasien set nama = :nama, alamat = :alamat, RTRW = :RTRW, kelurahan = :kelurahan, no_telepon = :no_telepon, jenis_kelamin = :jenis_kelamin, tanggal_lahir = :tanggal_lahir where id = :id";
            Query query = session.createQuery(hql);
            
            query.setInteger("id",id);
            query.setString("nama",pasien.getNama());
            query.setString("alamat",pasien.getAlamat());
            query.setString("RTRW",pasien.getRTRW());
            query.setString("kelurahan",pasien.getKelurahan());
            query.setString("tanggal_lahir",pasien.getTanggal_lahir());
            query.setString("jenis_kelamin",pasien.getJenis_kelamin());
            query.setString("no_telepon",pasien.getNo_telepon());
                 
            int rowCount = query.executeUpdate();
            System.out.println("Rows affected: " + rowCount);
            tx.commit();
            session.close();
            
            return rowCount;
    }
	
}
