package fr.doranco.jsf.entity;

public class Params {

	private Integer id;
	private Byte[] cle_cryptage_pwd;
	private Byte[] cle_cryptage_cp;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Byte[] getCle_cryptage_pwd() {
		return cle_cryptage_pwd;
	}
	public void setCle_cryptage_pwd(Byte[] cle_cryptage_pwd) {
		this.cle_cryptage_pwd = cle_cryptage_pwd;
	}
	public Byte[] getCle_cryptage_cp() {
		return cle_cryptage_cp;
	}
	public void setCle_cryptage_cp(Byte[] cle_cryptage_cp) {
		this.cle_cryptage_cp = cle_cryptage_cp;
	}
	
	
}
