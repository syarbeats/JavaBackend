package com.backend.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.backend.model.*;
import com.backend.model.dao.KelurahanDAO;
import com.backend.model.dao.PasienDAO;

public class RegistrasiPasienServices {
	
	static List<Pasien> dataPasien=getDataPasienMap();


	public RegistrasiPasienServices() {
		
	}

	public List<Pasien> getAllDataPasien()
	{
		PasienDAO pasienDAO =  new PasienDAO();
		List<Pasien> pasien = pasienDAO.getAllDataPasien();
		
		return pasien;
	}

	public List<Pasien> getPasien(int id)
	{
		
		PasienDAO pasienDAO =  new PasienDAO();
		List<Pasien> pasien = pasienDAO.getDataPasien(id);
		
		return pasien;
	}
		
	
	public Pasien addPasien(Pasien pasien)
	{
		PasienDAO pasienDAO = new PasienDAO();
		pasienDAO.addPasien(pasien);;
		
		return pasien;
	}
	
	
	public Pasien updatePasien(Pasien pasien)
	{
		if(pasien.getId()<=0)
			return null;
		
		PasienDAO pasienDAO = new PasienDAO();
		pasienDAO.updatePasien(pasien.getId(), pasien);
		
		return pasien;

	}
	
	public void deletePasien(int id)
	{
		PasienDAO pasienDAO = new PasienDAO();
		pasienDAO.deletePasien(id);
		
	}

	
	public static List<Pasien> getDataPasienMap()
	{
		PasienDAO pasienDAO = new PasienDAO();
		
		return pasienDAO.getAllDataPasien();
	}

}
