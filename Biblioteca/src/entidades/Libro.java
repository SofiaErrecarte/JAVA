
package entidades;
//import java.sql.Blob; esta por la imagen 
import java.util.*;
public class Libro {
private String titulo;
private  int idLibro ;
private int isbn;
private Date fechaEdicion; 
private int nroEdicion;
private int cantDiasMaxPrestamo;
private String genero;
//private Blog imagen; ver esto

public String getTitulo() {
	return titulo;
}
public void setTitulo(String titulo) {
	this.titulo = titulo;
}
public int getIdLibro() {
	return idLibro;
}
public void setIdLibro(int idLibro) {
	this.idLibro = idLibro;
}
public int getIsbn() {
	return isbn;
}
public void setIsbn(int isbn) {
	this.isbn = isbn;
}
public Date getFechaEdicion() {
	return fechaEdicion;
}
public void setFechaEdicion(Date fechaEdicion) {
	this.fechaEdicion = fechaEdicion;
}
public int getNroEdicion() {
	return nroEdicion;
}
public void setNroEdicion(int nroEdicion) {
	this.nroEdicion = nroEdicion;
}
public int getCantDiasMaxPrestamo() {
	return cantDiasMaxPrestamo;
}
public void setCantDiasMaxPrestamo(int cantDiasMaxPrestamo) {
	this.cantDiasMaxPrestamo = cantDiasMaxPrestamo;
}
public String getGenero() {
	return genero;
}
public void setGenero(String genero) {
	this.genero = genero;
}

}
