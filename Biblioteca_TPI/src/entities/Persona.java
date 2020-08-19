package entities;

import java.util.ArrayList;

public class Persona {
	private String idPersona;
	private String apellido; 
	private String nombre;
	private String telefono;
	private String email;
	private String dni;
	private String direccion;
	private String montoAPagar;
	private ArrayList <Cuota> cuotas_socio= new ArrayList();
	
	public String getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(String idPersona) {
		this.idPersona = idPersona;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getMontoAPagar() {
		return montoAPagar;
	}
	public void setMontoAPagar(String montoAPagar) {
		this.montoAPagar = montoAPagar;
	} 
	
	
}
