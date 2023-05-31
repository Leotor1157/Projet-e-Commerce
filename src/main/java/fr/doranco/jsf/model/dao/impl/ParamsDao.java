package fr.doranco.jsf.model.dao.impl;

import java.security.Key;

public class ParamsDao {

	
	public Key getClePwd() throws Exception {
		
		// requete JPQL pour récupérer la clé de la table
		// si null alors créer une clé et la stocker
		Key key = GenerateKey.getKey();
		//requete inser into de la clé dans la table
		
		return key;
	}
}
