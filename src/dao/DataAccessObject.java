package dao;

import java.util.Map;
import java.util.HashMap;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class DataAccessObject {
	private static Logger LOGGER;
	private static DataAccessObject instance = new DataAccessObject();
	private HashMap<String,String> usuarios;
	
	public DataAccessObject() {
		BasicConfigurator.configure();
		LOGGER = Logger.getLogger("Logger");
		usuarios = new HashMap<String,String>();
		usuarios.put("daniel@gmail.com","elDani");
		usuarios.put("inaki@gmail.com","elInaki");
		usuarios.put("ruben@gmail.com","elRuben");
		usuarios.put("alberto@gmail.com","elAlberto");
	}
	
	public static DataAccessObject getInstance() {
		return instance;
	}
	
	public void guardarUsuario(String email, String password) {
		LOGGER.info("-DAO- Guardando usuario");
		usuarios.put(email, password);
	}
	
	public void borrarUsuario(String email) {
		LOGGER.info("-DAO- Borrando usuario");
		usuarios.remove(email);
	}
	
	public void mostrarUsuarios() {
		LOGGER.info("-DAO- Mostrando todos los usuarios");
		for(Map.Entry<String,String> entry : usuarios.entrySet()) {
			System.out.println("email: "+entry.getKey()+"\npassword: "+entry.getValue());
		}
	}
	
//	public boolean validarUsuario(String email, String password) {
//		boolean result = false;
//		System.out.println("HI THERE");
//		LOGGER.info("-DAO- Validando usuario");
//		if(usuarios.containsKey(email)) {
//			if(usuarios.get(email).equals(password)) {
//				result = true;
//			}
//		}
//		return result;
//	}
	
	public HashMap<String, String> getUsuarios() {
		return usuarios;
	}
	
	public void actualizarPassword(String email, String newPass) {
		LOGGER.info("-DAO- Actualizando password");
		usuarios.replace(email, newPass);
	}
	
	public void deleteData() {
		LOGGER.info("-DAO- Borrando todos los usuarios");
		usuarios.clear();
	}
}
