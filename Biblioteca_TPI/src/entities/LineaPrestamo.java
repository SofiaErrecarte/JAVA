package entities;

import java.util.Date;

public class LineaPrestamo {
	private int idLineaPrestamo;
	private Date fechaDevolucion;
	private Boolean devuelto;
	
	public int getIdLineaPrestamo() {
		return idLineaPrestamo;
	}
	public void setIdLineaPrestamo(int idLineaPrestamo) {
		this.idLineaPrestamo = idLineaPrestamo;
	}
	public Date getFechaDevolucion() {
		return fechaDevolucion;
	}
	public void setFechaDevolucion(Date fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}
	public Boolean getDevuelto() {
		return devuelto;
	}
	public void setDevuelto(Boolean devuelto) {
		this.devuelto = devuelto;
	}
	
}
