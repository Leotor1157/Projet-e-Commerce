package fr.doranco.jsf.entity;

import java.security.Key;

public class Params {

	private Integer id;
	private Key cle_cryptage_pwd;
	private Key cle_cryptage_cp;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Key getCle_cryptage_pwd() {
		return cle_cryptage_pwd;
	}
	public void setCle_cryptage_pwd(Key cle_cryptage_pwd) {
		this.cle_cryptage_pwd = cle_cryptage_pwd;
	}
	public Key getCle_cryptage_cp() {
		return cle_cryptage_cp;
	}
	public void setCle_cryptage_cp(Key cle_cryptage_cp) {
		this.cle_cryptage_cp = cle_cryptage_cp;
	}
	
	
}
