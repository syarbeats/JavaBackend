package com.backend.model.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.backend.hibernate.*;
import com.backend.model.Kelurahan;
import com.backend.hibernate.*;;


public class KelurahanDAO {
	
	
	public void addKelurahan(Kelurahan kelurahan){
        Session session = SessionUtil.getSession();        
        Transaction tx = session.beginTransaction();
        addKelurahan(session,kelurahan);        
        tx.commit();
        session.close();
        
    }
    
    private void addKelurahan(Session session, Kelurahan kelurahan){
        Kelurahan dataKelurahan = new Kelurahan();
        
        dataKelurahan.setkelurahan(kelurahan.getkelurahan());
        dataKelurahan.setkecamatan(kelurahan.getkecamatan());
        dataKelurahan.setkota(kelurahan.getkota());
        
        session.save(dataKelurahan);
    }
    
    public List<Kelurahan> getAllDataKelurahan(){
        Session session = SessionUtil.getSession();    
        Query query = session.createQuery("from Kelurahan");
        List<Kelurahan> dataKelurahan =  query.list();
        return dataKelurahan;
    }
    
    public List<Kelurahan> getDataKelurahan(int id){
        Session session = SessionUtil.getSession();    
        Query query = session.createQuery("from Kelurahan where id = :id");
        query.setParameter("id", id);
        List<Kelurahan> dataKelurahan =  query.list();
        return dataKelurahan;
    }
 
    public int deleteKelurahan(int id) {
        Session session = SessionUtil.getSession();
        Transaction tx = session.beginTransaction();
        String hql = "delete from Kelurahan where id = :id";
        Query query = session.createQuery(hql);
        query.setInteger("id",id);
        int rowCount = query.executeUpdate();
        System.out.println("Rows affected: " + rowCount);
        tx.commit();
        session.close();
        return rowCount;
    }
    
    public int updateKelurahan(int id, Kelurahan kelurahan){
    	
         if(id <=0)  
               return 0;  
         
         Session session = SessionUtil.getSession();
            Transaction tx = session.beginTransaction();
            String hql = "update Kelurahan set kelurahan = :nama_kelurahan, kecamatan = :nama_kecamatan, kota = :nama_kota where id = :id";
            Query query = session.createQuery(hql);
            
            query.setInteger("id",id);
            query.setString("nama_kelurahan",kelurahan.getkelurahan());
            query.setString("nama_kecamatan",kelurahan.getkecamatan());
            query.setString("nama_kota",kelurahan.getkota());
            
            int rowCount = query.executeUpdate();
            System.out.println("Rows affected: " + rowCount);
            tx.commit();
            session.close();
            
            return rowCount;
    }
	
}
