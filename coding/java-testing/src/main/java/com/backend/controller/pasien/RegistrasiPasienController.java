package com.backend.controller.pasien;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import com.backend.model.*;
import com.backend.service.*;

@Path("/datapasien")
public class RegistrasiPasienController {
	
	RegistrasiPasienServices registrasiService=new RegistrasiPasienServices();
	
    @GET
    @Produces(MediaType.APPLICATION_JSON)
	public List<Pasien> getAllDataPasien()
	{
		
		List<Pasien> listOfPasien=registrasiService.getAllDataPasien();
		return listOfPasien;
	}

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
	public List<Pasien> getPasienById(@PathParam("id") int id)
	{
		return registrasiService.getPasien(id);
	}
   
    @POST
    @Produces(MediaType.APPLICATION_JSON)
	public Pasien addPasien(Pasien pasien)
	{
		return registrasiService.addPasien(pasien);
	}

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
	public Pasien updatePasien(Pasien pasien)
	{
		return registrasiService.updatePasien(pasien);
		
	}
	
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
	public void deletePasien(@PathParam("id") int id)
	{
    	registrasiService.deletePasien(id);;
		
	}
	
}
