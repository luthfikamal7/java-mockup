package com.xadmin.mockup.bean;

public class Biodata {
	private int id;
	private String userId;
	private String nama;
	private String posisi;
	private String noktp;
	private String ttl;
	private String gender;
	private String agama;
	private String golDarah;
	private String status;
	private String alamatKtp;
	private String alamatTinggal;
	private String email;
	private String nohp;
	private String orgTerdekat;
	
	
	
	public Biodata(String userId, String nama, String posisi, String noktp, String ttl, String gender, String agama,
			String golDarah, String status, String alamatKtp, String alamatTinggal, String email, String nohp,
			String orgTerdekat) {
		super();
		this.userId = userId;
		this.nama = nama;
		this.posisi = posisi;
		this.noktp = noktp;
		this.ttl = ttl;
		this.gender = gender;
		this.agama = agama;
		this.golDarah = golDarah;
		this.status = status;
		this.alamatKtp = alamatKtp;
		this.alamatTinggal = alamatTinggal;
		this.email = email;
		this.nohp = nohp;
		this.orgTerdekat = orgTerdekat;
	}
	public Biodata(int id, String userId, String nama, String posisi, String noktp, String ttl, String gender,
			String agama, String golDarah, String status, String alamatKtp, String alamatTinggal, String email,
			String nohp, String orgTerdekat) {
		super();
		this.id = id;
		this.userId = userId;
		this.nama = nama;
		this.posisi = posisi;
		this.noktp = noktp;
		this.ttl = ttl;
		this.gender = gender;
		this.agama = agama;
		this.golDarah = golDarah;
		this.status = status;
		this.alamatKtp = alamatKtp;
		this.alamatTinggal = alamatTinggal;
		this.email = email;
		this.nohp = nohp;
		this.orgTerdekat = orgTerdekat;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getNama() {
		return nama;
	}
	public void setNama(String nama) {
		this.nama = nama;
	}
	public String getPosisi() {
		return posisi;
	}
	public void setPosisi(String posisi) {
		this.posisi = posisi;
	}
	public String getNoktp() {
		return noktp;
	}
	public void setNoktp(String noktp) {
		this.noktp = noktp;
	}
	public String getTtl() {
		return ttl;
	}
	public void setTtl(String ttl) {
		this.ttl = ttl;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAgama() {
		return agama;
	}
	public void setAgama(String agama) {
		this.agama = agama;
	}
	public String getGolDarah() {
		return golDarah;
	}
	public void setGolDarah(String golDarah) {
		this.golDarah = golDarah;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAlamatKtp() {
		return alamatKtp;
	}
	public void setAlamatKtp(String alamatKtp) {
		this.alamatKtp = alamatKtp;
	}
	public String getAlamatTinggal() {
		return alamatTinggal;
	}
	public void setAlamatTinggal(String alamatTinggal) {
		this.alamatTinggal = alamatTinggal;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNohp() {
		return nohp;
	}
	public void setNohp(String nohp) {
		this.nohp = nohp;
	}
	public String getOrgTerdekat() {
		return orgTerdekat;
	}
	public void setOrgTerdekat(String orgTerdekat) {
		this.orgTerdekat = orgTerdekat;
	}
	
}
