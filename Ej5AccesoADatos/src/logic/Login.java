package logic;

import java.util.LinkedList;
import java.util.Scanner;

import data.*;
import entities.*;

public class Login {
	private DataPersona dp;
	private DataRol dr;
	Scanner s=null;
	
	public Login() {
		dp=new DataPersona();
		dr=new DataRol();
	}
	
	public Persona validate(Persona p) {
		/* para hacer más seguro el manejo de passwords este sería un lugar 
		 * adecuado para generar un hash de la password utilizando un cifrado
		 * asimétrico como sha256 y utilizar el hash en lugar de la password en plano 
		 */
		return dp.getByUser(p);
	}

	public LinkedList<Persona> getAll(){
		return dp.getAll();
	}
	
	public LinkedList<Persona> getByApellido(Persona per){
		return dp.getByApellido(per);
	}


	public Persona getByDocumento(Persona per) {
		return dp.getByDocumento(per);
		
	}
	
	public LinkedList<Rol> getAllRoles(){
		return dr.getAll();
	}
	
	public Rol getById(Rol r){
		return dr.getById(r);
	}
	
	public Persona add(Persona per) {
		return dp.add(per);
	}

	public void asignarRol(Persona p, Rol r) {
		dr.asignarRol(p, r);
	}

	public void setRoles(Persona p) {
		dr.setRoles(p);
	}

	public Persona update(Persona p) {
		return dp.update(p);
	}

	public void deleteRol(Persona p, Rol r) {
		dr.deleteRol(p, r);
	}

	public Persona delete(Persona p) {
		return dp.delete(p);		
	}

	

	
}
