package clases;

public class Usuario {
	String usuario;
	String clave;
	String nroCajaAhorro;
	Double saldoCajaAhorro;
	String nroCtaCte;
	Double saldoCtaCte;
	
	
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
	public String getNroCajaAhorro() {
		return nroCajaAhorro;
	}
	public void setNroCajaAhorro(String nroCajaAhorro) {
		this.nroCajaAhorro = nroCajaAhorro;
	}
	public Double getSaldoCajaAhorro() {
		return saldoCajaAhorro;
	}
	public void setSaldoCajaAhorro(Double saldoCajaAhorro) {
		this.saldoCajaAhorro = saldoCajaAhorro;
	}
	public String getNroCtaCte() {
		return nroCtaCte;
	}
	public void setNroCtaCte(String nroCtaCte) {
		this.nroCtaCte = nroCtaCte;
	}
	public Double getSaldoCtaCte() {
		return saldoCtaCte;
	}
	public void setSaldoCtaCte(Double saldoCtaCte) {
		this.saldoCtaCte = saldoCtaCte;
	}
	
	
	public Usuario(String usuario, String clave, String nroCajaAhorro, Double saldoCajaAhorro, String nroCtaCte,
			Double saldoCtaCte) {
		this.setUsuario(usuario);
		this.setClave(clave);
		this.setNroCajaAhorro(nroCajaAhorro);
		this.setSaldoCajaAhorro(saldoCajaAhorro);
		this.setNroCtaCte(nroCtaCte);
		this.setSaldoCtaCte(saldoCtaCte);
	}
	
	
	
	
	
}
