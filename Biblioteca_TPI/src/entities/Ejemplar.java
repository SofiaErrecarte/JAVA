package entities;

public class Ejemplar {
	private int idEjemplar;
	private int idLibro;
	private int idLineaPrestamo;
	Libro lib;
	public int getIdEjemplar() {
		return idEjemplar;
	}

	public void setIdEjemplar(int idEjemplar) {
		this.idEjemplar = idEjemplar;
	}
	
	
	public int getIdLibro() {
		return idLibro;
	}

	public void setIdLibro(int idLibro) {
		this.idLibro = idLibro;
	}

	public int getIdLineaPrestamo() {
		return idLineaPrestamo;
	}

	public void setIdLineaPrestamo(int idLineaPrestamo) {
		this.idLineaPrestamo = idLineaPrestamo;
	}
	
	
	@Override
	public String toString() {
		return "Ejemplar [Id Ejemplar=" + idEjemplar + ", Id Libro=" + idLibro + ", id LineaPrestamo=" + idLineaPrestamo +"]";
	}
}
