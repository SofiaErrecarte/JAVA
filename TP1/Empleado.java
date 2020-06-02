package ejercicios;

import java.text.DecimalFormat;

public class Empleado {

	String nombre;
	String apellido;
	int hs_t;
	int hs_e;
	int hs_s;
	Double sueldo_basico;
	Double descuentos;
	Double premio=100.00;
	Double sueldo;
	Double descuento_40hs = 19.5;
	DecimalFormat df = new DecimalFormat("#.##");
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getHs_t() {
		return hs_t;
	}
	public void setHs_t(int hs_t) {
		this.hs_t = hs_t;
	}
	
	public int getHs_e() {
		return hs_e;
	}
	public void setHs_e(int hs_e) {
		this.hs_e = hs_e;
	}
	public Double getSueldo_basico() {
		return sueldo_basico;
	}
	public void setSueldo_basico(Double sueldo_basico) {
		this.sueldo_basico = sueldo_basico;
	}
	public Double getDescuentos() {
		return descuentos;
	}
	public void setDescuentos(Double descuentos) {
		this.descuentos = descuentos;
	}
	public Double getPremio() {
		return premio;
	}
	public void setPremio(Double premio) {
		this.premio = premio;
	}
	public Double getSueldo() {
		return sueldo;
	}
	public void setSueldo(Double sueldo) {
		this.sueldo = sueldo;
	}
	
	public int getHs_s() {
		return hs_s;
	}
	public void setHs_s(int hs_s) {
		this.hs_s = hs_s;
	}
	public void cargarDatos (String n, String a, int ht, int hss, int hse, Double sueldo_b, Double d, Double s)
	{
		this.setNombre(n);
		this.setApellido(a);
		this.setHs_t(ht);
		this.setHs_s(hss);
		this.setHs_e(hse);
		this.setSueldo_basico(sueldo_b);
		this.setDescuentos(d);
		this.setSueldo(s);
	}
	public void mostrarDatos() {
		System.out.println("Nombre: "+this.getNombre());
		System.out.println("Apellido: "+this.getApellido());
		System.out.println("Horas trabajadas: "+this.getHs_t());
		System.out.println("Horas simples: "+this.getHs_s());
		System.out.println("Horas excedidas: "+this.getHs_e());
		System.out.println("Sueldo basico: $"+df.format(this.getSueldo_basico()));
		System.out.println("Premio: $"+df.format(this.getPremio()));
		System.out.println("Descuentos: $"+df.format(this.getDescuentos()));
		System.out.println("Sueldo a cobrar: $"+df.format(this.getSueldo()));
	}
	public Empleado (String n, String a , int hs)
	{
		this.setNombre(n);
		this.setApellido(a);
		this.setHs_t(hs);
	}
	
	public void calcularSueldo(int hs)
	{
		if (hs<40) {
			this.setHs_e(0);
			this.setHs_s(hs);
			Double sb=(double) (25*hs);
			this.setSueldo_basico(sb);
			Double d = ((25*hs)*descuento_40hs/100);
			this.setDescuentos(d);
			Double s = sb-d;
			this.setSueldo(s);
			this.setPremio(0.00);
		}
		else if(hs>=40) {
			int hs_e= (40-hs);
			int hs_s= 40;
			this.setHs_s(hs_s);
			this.setHs_e(hs_e);
			Double sb=(double) ((25*40)+(30*hs_e));
			this.setSueldo_basico(sb);
			Double d = ((25*hs)*descuento_40hs/100);
			this.setDescuentos(d);
			Double s = (sb-d)+premio;
			this.setSueldo(s);
		}
	}
	
}
	
