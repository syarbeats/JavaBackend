package com.backend.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.backend.model.*;
import com.backend.model.dao.KelurahanDAO;

public class DomisiliServices {

	
	static List<Kelurahan> dataKelurahan=getDataKelurahanMap();


	public DomisiliServices() {
		
	}

	
	public List<Kelurahan> getAllDataKelurahan()
	{
		KelurahanDAO kelurahanDAO =  new KelurahanDAO();
		List<Kelurahan> kelurahan = kelurahanDAO.getAllDataKelurahan();
		
		return kelurahan;
	}


	public List<Kelurahan> getKelurahan(int id)
	{
		
		KelurahanDAO kelurahanDAO =  new KelurahanDAO();
		List<Kelurahan> kelurahan = kelurahanDAO.getDataKelurahan(id);
		
		return kelurahan;
	}
		
	
	public Kelurahan addKelurahan(Kelurahan kelurahan)
	{
		KelurahanDAO kelurahanDAO = new KelurahanDAO();
		kelurahanDAO.addKelurahan(kelurahan);
		
		return kelurahan;
	}
	
	
	public Kelurahan updateKelurahan(Kelurahan kelurahan)
	{
		if(kelurahan.getId()<=0)
			return null;
		
		KelurahanDAO kelurahanDAO = new KelurahanDAO();
		kelurahanDAO.updateKelurahan(kelurahan.getId(), kelurahan);
		
		return kelurahan;

	}
	
	public void deleteKelurahan(int id)
	{
		KelurahanDAO kelurahanDAO = new KelurahanDAO();
		kelurahanDAO.deleteKelurahan(id);
		
	}

	
	public static List<Kelurahan> getDataKelurahanMap()
	{
		KelurahanDAO kelurahanDAO = new KelurahanDAO();
		
		return kelurahanDAO.getAllDataKelurahan();
	}
}
