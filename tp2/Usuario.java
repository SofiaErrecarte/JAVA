package tp2;

public class Usuario {

	private String usuario, clave, cajaAhorro, saldoCajaAhorro, nroCtaCte, saldoCtaCte;
	
	
	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	public String getClave() {
		return clave;
	}


	public void setClave(String clave) {
		this.clave = clave;
	}


	public String getCajaAhorro() {
		return cajaAhorro;
	}


	public void setCajaAhorro(String cajaAhorro) {
		this.cajaAhorro = cajaAhorro;
	}


	public String getSaldoCajaAhorro() {
		return saldoCajaAhorro;
	}


	public void setSaldoCajaAhorro(String saldoCajaAhorro) {
		this.saldoCajaAhorro = saldoCajaAhorro;
	}


	public String getNroCtaCte() {
		return nroCtaCte;
	}


	public void setNroCtaCte(String nroCtaCte) {
		this.nroCtaCte = nroCtaCte;
	}


	public String getSaldoCtaCte() {
		return saldoCtaCte;
	}


	public void setSaldoCtaCte(String saldoCtaCte) {
		this.saldoCtaCte = saldoCtaCte;
	}



	public Usuario (String u, String c, String cA,String saldoCA, String nroCC, String saldoCC) {
		this.setUsuario(u);
		this.setClave(c);
		this.setCajaAhorro(cA);
		this.setSaldoCajaAhorro(saldoCA);
		this.setNroCtaCte(nroCC);
		this.setSaldoCtaCte(saldoCC);
	}
	
	public void actualizarCAMenos(int n) {
		int valorNuevo = Integer.parseInt(this.getSaldoCajaAhorro()) - n;
		this.setSaldoCajaAhorro(String.valueOf(valorNuevo));
	}
	public void actualizarCCMenos(int n) {
		int valorNuevo = Integer.parseInt(this.getSaldoCtaCte()) - n;
		this.setSaldoCtaCte(String.valueOf(valorNuevo));
	}
	public void actualizarCAMas(int n) {
		int valorNuevo = Integer.parseInt(this.getSaldoCajaAhorro()) + n;
		this.setSaldoCajaAhorro(String.valueOf(valorNuevo));
	}
	public void actualizarCCMas(int n) {
		int valorNuevo = Integer.parseInt(this.getSaldoCtaCte()) + n;
		this.setSaldoCtaCte(String.valueOf(valorNuevo));
	}
	public static Usuario[] inicializarUsuarios() {
		Usuario[] users = {
	   			 new Usuario("Sofia1234", "passwor1", "100", "500", "123", "850"),
	   			 new Usuario("Dolores1234", "passwor2", "200", "700", "456", "470"),
	   			 new Usuario("Camila1234", "passwor3", "300", "900", "789", "788"),
	   			 new Usuario("Patricia1234", "passwor4", "400", "1250", "444", "999")
	   			};
    	return users;
    }
}
