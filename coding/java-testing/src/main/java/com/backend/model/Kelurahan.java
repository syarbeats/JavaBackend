package com.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "kelurahan", catalog = "jasamedika")
public class Kelurahan implements java.io.Serializable{

	
	private Integer id;
	private String kelurahan;
	private String kecamatan;
	private String kota;
	
	public Kelurahan()
	{
		
		
	}

	public Kelurahan(String nama_kelurahan, String nama_kecamatan, String nama_kota)
	{
	
		this.kelurahan = nama_kelurahan;
		this.kecamatan = nama_kecamatan;
		this.kota = nama_kota;
		
	}
	
	@Id
    @GeneratedValue(strategy = IDENTITY)

    @Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name = "kelurahan", length = 100, nullable = false)
	public String getkelurahan() {
		return kelurahan;
	}
	
	public void setkelurahan(String nama_kelurahan) {
		this.kelurahan = nama_kelurahan;
	}
	
	@Column(name = "kecamatan", length = 100, nullable = false)
	public String getkecamatan() {
		return kecamatan;
	}
	
	public void setkecamatan(String nama_kecamatan) {
		this.kecamatan = nama_kecamatan;
	}
	
	@Column(name = "kota", length = 100, nullable = false)
	public String getkota() {
		return kota;
	}
	
	public void setkota(String nama_kota) {
		this.kota = nama_kota;
	}
	
	
}
