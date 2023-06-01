package fr.doranco.jsf.control.impl;

import java.security.Key;

import fr.doranco.jsf.control.interfaces.IParamsMetier;
import fr.doranco.jsf.entity.Params;
import fr.doranco.jsf.model.dao.impl.ParamsDao;
import fr.doranco.jsf.model.dao.interfaces.IParamsDao;

public class ParamsMetier implements IParamsMetier{
	
	private static IParamsDao paramsDao = new ParamsDao();
	
	@Override
	public Integer addParams(Params params) throws Exception {
		
		return paramsDao.addParams(params);
	}
	
	@Override
	public Key getKeyPwd() throws Exception {
		return paramsDao.getKeyPwd();
	}

	@Override
	public Key getKeyCb() throws Exception {
		return paramsDao.getKeyCb();
	}

	@Override
	public Integer getKeyId() throws Exception {

		return paramsDao.getKeyId();
	}

	

}
