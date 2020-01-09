package services;

import java.util.HashMap;

import dao.DataAccessObject;

public class ValidationService {
	
	public static ValidationService instance = null;

	public static ValidationService getInstance() {
		if (instance == null) {
			instance = new ValidationService();
		}
		return instance;
	}

	public ValidationService() {
	}
	
	public synchronized String loginAutenticar(String email, String password){
		System.out.println(" - ValidationService - Attempting to log in");
		HashMap<String, String> Husuarios;
		Husuarios=DataAccessObject.getInstance().getUsuarios();
		String result = "false";
		
		if(Husuarios.containsKey(email)) {
			if(Husuarios.get(email).equals(password)) {
				System.out.println(" - ValidationService - Log in succesful");
				result = "true;"+email;
			}
		}
		return result;
	}
}
