package fr.doranco.cryptage.keys;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import fr.doranco.jsf.control.impl.ParamsMetier;
import fr.doranco.jsf.control.interfaces.IParamsMetier;
public final class GenerateKey {
	
	private static KeyGenerator keyGen = null;
	private static IParamsMetier paramsMetier = new ParamsMetier();
	
	private GenerateKey() {
	}

	public final static SecretKey getKey(String algorithm, int keysize) throws Exception {
		
		switch (algorithm) {
			case "DES":
				Integer keyId = paramsMetier.getKeyId();
				if(keyId == -1 || keyId == null) {
					keyGen = KeyGenerator.getInstance(algorithm);
					keyGen.init(keysize);
					//Params params = new Params();
					//params.setCle_cryptage_cp(keyGen);
					//paramsMetier.addParams(keyGen);
					break;
				}
				break;
	
			default:
				break;
		}
		return keyGen.generateKey();
	}
}

