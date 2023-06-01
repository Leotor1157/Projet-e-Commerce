package fr.doranco.jsf.control.interfaces;

import java.security.Key;

import fr.doranco.jsf.entity.Params;

public interface IParamsMetier {

	Integer addParams(Params params) throws Exception;
	Key getKeyPwd() throws Exception;
	Key getKeyCb() throws Exception;
	Integer getKeyId() throws Exception;
}
