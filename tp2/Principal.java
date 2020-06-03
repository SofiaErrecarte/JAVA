package tp2;

public class Principal {
	
	static Usuario[] usuarios;
	public static void main(String[] args) {
		usuarios=Usuario.inicializarUsuarios();
		Ventana ventana = new Ventana();
		ventana.crearVentana();
		ventana.setTitle("Bienvenido al banco");
		ventana.setSize(400,400);
		ventana.setVisible(true);		
		ventana.setUsuarios(usuarios);
		
	}

}
