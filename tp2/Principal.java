package tp2;

import javax.swing.JFrame;

public class Principal {
	
	static Usuario[] usuarios = crearUsuarios();
	public static void main(String[] args) {
		Ventana ventana = new Ventana();
		ventana.crearVentana();
		ventana.setTitle("Bienvenido al banco");
		ventana.setSize(400,400);
		ventana.setVisible(true);		
		ventana.setUsuarios(usuarios);
		
	}

	public static Usuario[] crearUsuarios() {
		Usuario[] users = {
   			 new Usuario("Sofia1234", "passwor1", "100", "500", "123", "850"),
   			 new Usuario("Dolores1234", "passwor2", "200", "700", "456", "470"),
   			 new Usuario("Camila1234", "passwor3", "300", "900", "789", "788"),
   			 new Usuario("Patricia1234", "passwor4", "400", "1250", "444", "999")
   			};
   	return users;
	}
}
