package fr.doranco.jsf.model.dao.interfaces;

import java.security.Key;

import fr.doranco.jsf.entity.Params;

public interface IParamsDao {

	Integer addParams(Params params) throws Exception;
	Key getKeyPwd() throws Exception;
	Key getKeyCb() throws Exception;
	Integer getKeyId() throws Exception;
}
