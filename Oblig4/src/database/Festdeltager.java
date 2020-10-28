package database;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "dat108oblig4", name = "festdeltager")
public class Festdeltager {

	@Id
	private String fornavn;
	
	@Id
	private String etternavn;
	
	private Integer mobil;
	private String passord;
	private String kjonn;
	
	public Festdeltager() {}
	
	public Festdeltager(String fornavn, String etternavn, Integer mobil, String passord, String kjonn) {
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.mobil = mobil;
		this.passord = BCrypt.hashpw(passord, BCrypt.gensalt(12));
		this.kjonn = kjonn;
	}

	public String getFornavn() {
		return fornavn;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}

	public Integer getMobil() {
		return mobil;
	}

	public void setMobil(Integer mobil) {
		this.mobil = mobil;
	}

	public String getPassord() {
		return passord;
	}

	public void setPassord(String passord) {
		this.passord = passord;
	}

	public String getKjonn() {
		return kjonn;
	}

	public void setKjonn(String kjonn) {
		this.kjonn = kjonn;
	}
	
}
