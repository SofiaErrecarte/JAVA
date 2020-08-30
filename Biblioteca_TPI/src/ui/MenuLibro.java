package ui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import entities.*;
import logic.*;

public class MenuLibro {
	Scanner s=null;
	LibroController ctrlLibro = new LibroController();
	ProveedorController ctrlProv = new ProveedorController();
	SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd0");
	
	public void start() {
		s = new Scanner(System.in);
		String command;
		do {
			System.out.print("------------------------------------------------------------------------------- \nMEN�\n");
			command=getCommand();
			executeCommand(command);
			System.out.println();
			
		}while(!command.equalsIgnoreCase("exit"));
		
		s.close();
	}
	private void executeCommand(String command) {
		switch (command) {			
		case "new":
			System.out.print("------------------------------------------------------------------------------- \nNUEVO Libro\n");
			System.out.println(newLibro());
			break;	
		case "list":
			System.out.print("------------------------------------------------------------------------------- \nLISTADO DE Libros\n");
			System.out.println(ctrlLibro.getAllLibros());
			break;
		case "search":
			System.out.print("------------------------------------------------------------------------------- \nB�SQUEDA POR ID LIBRO\n");
			System.out.println(getByIdLibro());
			break;
		case "edit":
			System.out.print("------------------------------------------------------------------------------- \nMODIFICAR Libro\n");
			editLibro();
			break;
		case "delete":
			System.out.print("------------------------------------------------------------------------------- \nELIMINAR Libro\n");
			deleteLibro();
			break;
		default:
			break;
		}
	}

	
	private void deleteLibro() {
		Libro lib=new Libro();
		System.out.println("Ingrese los datos del Libro que desea eliminar: ");
		lib=getByIdLibro();
		while (lib==null) {
			System.out.println("Libro inesxistente. Ingrese los datos del Libro que desea eliminar: ");
			lib=getByIdLibro();
		}
		System.out.println("Libro que desea eliminar: "+lib);
		System.out.println("Est� seguro que desea elminar a este Libro? si / no: ");
		switch(s.nextLine()) {
		case "no":
			System.out.println("Libro no eliminado.");
			break;
		case "si":
			ctrlLibro.deleteLibro(lib);
			System.out.println("El Libro fue eliminado con �xito!");
		}
		
	}
	private void editLibro() {
		Libro lib = new Libro();
		Proveedor p = new Proveedor();
		System.out.println(ctrlLibro.getAllLibros());
		System.out.println("Ingrese los datos del Libro que desea editar: ");
		lib=getByIdLibro();
		while (lib==null) {
			System.out.println("Libro inesxistente. Ingrese los datos del Libro que desea editar: ");
			lib=getByIdLibro();
		}
		System.out.println("Libro que desea editar: "+lib);
		System.out.print("Ingrese el nuevo ISBN: ");
		lib.setIsbn(Integer.parseInt(s.nextLine()));
		System.out.print("Ingrese el t�tulo: ");
		lib.setTitulo(s.nextLine());
		/*System.out.print("Ingrese la nueva fecha de edici�n: ");
		try {
			lib.setFechaEdicion(formato.parse(s.nextLine()));
		} catch (ParseException e) {
			e.printStackTrace();
		} */
		System.out.print("Ingrese el nuevo n�mero de edici�n: ");
		lib.setNroEdicion(Integer.parseInt(s.nextLine()));
		System.out.print("Ingrese la nueva cantidad de d�as m�xima de pr�stamo : ");
		lib.setCantDiasMaxPrestamo(Integer.parseInt(s.nextLine()));
		System.out.print("Ingrese el nuevo g�nero: ");
		lib.setGenero(s.nextLine());
		System.out.println("---------------Listado de proveeores disponibles---------------");
		System.out.println(ctrlProv.getAllProveedores());
		System.out.print("Ingrese el nuevo CUIT del proveedor correspondiente: ");
		p.setCUIT(s.nextLine());
		p=ctrlProv.getByCUIT(p);
		while(p==null) {
			System.out.println("CUIT Incorrecto. Ingrese el nuevo CUIT del proveedor que desea: ");
			p=new Proveedor();
			p.setCUIT(s.nextLine());
			p=ctrlProv.getByCUIT(p);
		}
		
		System.out.println("Proveedor escogido:"+p);
		lib.setCUIT(p.getCUIT());
		ctrlLibro.editLibro(lib);
		System.out.println("Los datos fueron editados con �xito!");
		System.out.print("Libro: "+lib);
	}
	
	
	private String getCommand() {
		System.out.println("Ingrese el comando seg�n la opci�n que desee realizar");
		System.out.println("new\t\tNuevo Libro");
		System.out.println("list\t\tListar Libros");
		System.out.println("search\t\tBuscar Libros");
		System.out.println("edit\t\tEditar Libros");
		System.out.println("delete\t\tEliminar Libros");
		System.out.println();
		System.out.print("comando: ");
		return s.nextLine();
	}
	
	private Libro getByIdLibro() {
		System.out.println();
		Libro lib=new Libro();
		System.out.print("Id Libro: ");
		lib.setIdLibro(Integer.parseInt(s.nextLine()));
		return ctrlLibro.getByIdLibro(lib);
	}
	
	private Libro newLibro() {
		System.out.println();
		Libro lib=new Libro();
		Proveedor p = new Proveedor();
		lib.setFechaEdicion(new Date());
		System.out.print("Ingrese el ISBN: ");
		lib.setIsbn(Integer.parseInt(s.nextLine()));
		System.out.print("Ingrese el t�tulo: ");
		lib.setTitulo(s.nextLine());
		/*System.out.print("Ingrese la fecha de edici�n: ");
		try {
			lib.setFechaEdicion(formato.parse(s.nextLine()));
		} catch (ParseException e) {
			e.printStackTrace();
		}*/
		System.out.print("Ingrese el n�mero de edici�n: ");
		lib.setNroEdicion(Integer.parseInt(s.nextLine()));
		System.out.print("Ingrese la cantidad de d�as m�xima de pr�stamo : ");
		lib.setCantDiasMaxPrestamo(Integer.parseInt(s.nextLine()));
		System.out.print("Ingrese el g�nero: ");
		lib.setGenero(s.nextLine());
		System.out.println("---------------Listado de proveeores disponibles---------------");
		System.out.println(ctrlProv.getAllProveedores());
		System.out.print("Ingrese el CUIT del proveedor correspondiente: ");
		p.setCUIT(s.nextLine());
		p=ctrlProv.getByCUIT(p);
		while(p==null) {
			System.out.println("CUIT Incorrecto. Ingrese el CUIT del proveedor que desea: ");
			p=new Proveedor();
			p.setCUIT(s.nextLine());
			p=ctrlProv.getByCUIT(p);
		}
		
		System.out.println("Proveedor escogido:"+p);
		// listar prov, pedir cuit, verificar con el getBy, y a�adir al arreglo de proveedores
		lib.setCUIT(p.getCUIT());
		ctrlLibro.createLibro(lib);
		System.out.println("\nEl Libro fue ingresado con �xito!");
		return lib;
	}

}
