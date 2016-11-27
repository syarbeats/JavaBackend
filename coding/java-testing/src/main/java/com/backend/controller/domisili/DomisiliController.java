package com.backend.controller.domisili;

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

@Path("/datakelurahan")
public class DomisiliController {
	
	DomisiliServices domisiliService=new DomisiliServices();
	
    @GET
    @Produces(MediaType.APPLICATION_JSON)
	public List<Kelurahan> getAllDataKelurahan()
	{
		
		List<Kelurahan> listOfKelurahan=domisiliService.getAllDataKelurahan();
		return listOfKelurahan;
	}
    

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
	public List<Kelurahan> getKelurahanById(@PathParam("id") int id)
	{
		return domisiliService.getKelurahan(id);
	}
   
    @POST
    @Produces(MediaType.APPLICATION_JSON)
	public Kelurahan addKelurahan(Kelurahan kelurahan)
	{
		return domisiliService.addKelurahan(kelurahan);
	}

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
	public Kelurahan updateKelurahan(Kelurahan kelurahan)
	{
		return domisiliService.updateKelurahan(kelurahan);
		
	}
	
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
	public void deleteKelurahan(@PathParam("id") int id)
	{
		 domisiliService.deleteKelurahan(id);
		
	}
	
}
