package entidades;

import java.time.LocalDateTime;
import java.util.Date;

public class Prestamo {
	private int idPrestamo;
	private LocalDateTime fechaHoraPrestamo;
	private int diasPrestamo;
	private Date fechaADevolver;
	public int getIdPrestamo() {
		return idPrestamo;
	}
	public void setIdPrestamo(int idPrestamo) {
		this.idPrestamo = idPrestamo;
	}
	public LocalDateTime getFechaHoraPrestamo() {
		return fechaHoraPrestamo;
	}
	public void setFechaHoraPrestamo(LocalDateTime fechaHoraPrestamo) {
		this.fechaHoraPrestamo = fechaHoraPrestamo;
	}
	public int getDiasPrestamo() {
		return diasPrestamo;
	}
	public void setDiasPrestamo(int diasPrestamo) {
		this.diasPrestamo = diasPrestamo;
	}
	public Date getFechaADevolver() {
		return fechaADevolver;
	}
	public void setFechaADevolver(Date fechaADevolver) {
		this.fechaADevolver = fechaADevolver;
	}
	
}
