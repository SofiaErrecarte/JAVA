package entities;

import java.util.Arrays;

public class Socio extends Persona {
 private int idSocio;
 private Arrays[] cuotas;
public int getIdSocio() {
	return idSocio;
}
public void setIdSocio(int idSocio) {
	this.idSocio = idSocio;
}
public Arrays[] getCuotas() {
	return cuotas;
}
public void setCuotas(Arrays[] cuotas) {
	this.cuotas = cuotas;
}
}
