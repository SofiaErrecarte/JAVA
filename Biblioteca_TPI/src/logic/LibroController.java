package logic;

import data.*;
import entities.*;

import java.util.LinkedList;
import java.util.Scanner;

public class LibroController {
	
	private DataLibro dl;
	
	public LibroController() {
		dl=new DataLibro();
	}
	
	public LinkedList<Libro> getAllLibros(){
		return dl.getAll();
	}
	
	public Libro getByIdLibro(Libro lib) {
		return dl.getById(lib);
	}
	
	public Libro createLibro(Libro lib) {
		return dl.add(lib);
	}

	public Libro editLibro(Libro lib) {
		return dl.editLibro(lib);
	}

	public Libro deleteLibro(Libro lib) {
		return dl.deleteLibro(lib);
	}
	public EjemplarController() {
		de=new DataEjemplar();
	}
	public LinkedList<Ejemplar> getByIdLibro (Libro lib) {
		return de.getByIdLibro(lib);
	}
	
	public Ejemplar newEjemplar(Ejemplar ej) {
		return de.addEjemplar(ej);
	}
	
	public Ejemplar deleteEjemplar(Ejemplar ej) {
		return de.deleteEjemplar(ej);		
	}
	
	public LinkedList<Ejemplar> getAllEjemplares(){
		return de.getAll();
	}
	
	public Ejemplar getByIdEjemplar(Ejemplar ej) {
		return de.getByIdEjemplar(ej);
	}
	
	
}
