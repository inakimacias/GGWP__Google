package dao;

public class Test {
	public static void main(String[] args) {
		DataAccessObject dao = DataAccessObject.getInstance();
		
		dao.mostrarUsuarios();
		
		dao.actualizarPassword("daniel@gmail.com", "amapola");
		
		dao.borrarUsuario("inaki@gmail.com");
		
		dao.mostrarUsuarios();
	}

}