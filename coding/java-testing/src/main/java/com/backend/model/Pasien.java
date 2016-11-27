package com.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "pasien", catalog = "jasamedika")
public class Pasien {

	private Integer id;
	private String nama;
	private String alamat;
	private String no_telepon;
	private String RTRW;
	private String kelurahan;
	private String tanggal_lahir;
	private String jenis_kelamin;


	public Pasien()
	{
		super();	
	}
	
	public Pasien(int id, String nama, String alamat, String no_telepon, String RTRW, String kelurahan, String tanggal_lahir, String jenis_kelamin)
	{
		super();	
		
		this.setId(id);
		this.nama = nama;
		this.alamat = alamat;
		this.no_telepon = no_telepon;
		this.RTRW = RTRW;
		this.kelurahan = kelurahan;
		this.tanggal_lahir = tanggal_lahir;
		this.jenis_kelamin = jenis_kelamin;
		
	}
	
	@Column(name = "nama", length = 100, nullable = false)
	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	@Column(name = "alamat", length = 300, nullable = false)
	public String getAlamat() {
		return alamat;
	}

	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}

	@Column(name = "no_telepon", length = 50, nullable = false)
	public String getNo_telepon() {
		return no_telepon;
	}

	public void setNo_telepon(String no_telepon) {
		this.no_telepon = no_telepon;
	}

	@Column(name = "RTRW", length = 10, nullable = false)
	public String getRTRW() {
		return RTRW;
	}

	public void setRTRW(String rTRW) {
		RTRW = rTRW;
	}

	@Column(name = "kelurahan", length = 100, nullable = false)
	public String getKelurahan() {
		return kelurahan;
	}

	public void setKelurahan(String kelurahan) {
		this.kelurahan = kelurahan;
	}

	@Column(name = "tanggal_lahir", length = 100, nullable = false)
	public String getTanggal_lahir() {
		return tanggal_lahir;
	}

	public void setTanggal_lahir(String tanggal_lahir) {
		this.tanggal_lahir = tanggal_lahir;
	}

	@Column(name = "jenis_kelamin", length = 30, nullable = false)
	public String getJenis_kelamin() {
		return jenis_kelamin;
	}

	public void setJenis_kelamin(String jenis_kelamin) {
		this.jenis_kelamin = jenis_kelamin;
	}

	
	@Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
}
