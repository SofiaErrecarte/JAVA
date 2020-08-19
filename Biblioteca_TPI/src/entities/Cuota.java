package entities;

import java.util.Date;

public class Cuota {
private Date fecha;
private int importe;

public Date getFecha() {
	return fecha;
}
public void setFecha(Date fecha) {
	this.fecha = fecha;
}
public int getImporte() {
	return importe;
}
public void setImporte(int importe) {
	this.importe = importe;
}

}
