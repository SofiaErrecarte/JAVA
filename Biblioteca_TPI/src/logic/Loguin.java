package logic;

import java.util.LinkedList;

import data.DataPoliticaPrestamo;
import entities.Persona;
import entities.PoliticaPrestamo;

public class Login {
	private DataPoliticaPrestamo dpp;
	public Login() {
		dpp=new DataPoliticaPrestamo();
	}
	public LinkedList<PoliticaPrestamo> ppGetAll(){
		return dpp.getAll();
	}
	public PoliticaPrestamo newPerson(PoliticaPrestamo pp) {
		return dpp.add(pp);
	}
}
