package ui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import entities.*;
import logic.Login;

public class Menu {
	Scanner s=null;
	Login ctrlLogin = new Login();

	public void start() {
		s = new Scanner(System.in);
		String command;
		do {
			System.out.print("------------------------------------------------------------------------------- \nMENÚ\n");
			command=getCommand();
			executeCommand(command);
			System.out.println();
			
		}while(!command.equalsIgnoreCase("exit"));
		
		s.close();
	}
	private void executeCommand(String command) {
		switch (command) {
		case "list":
			System.out.print("------------------------------------------------------------------------------- \nLISTADO DE POLITICAS DE PRESTAMO\n");
			System.out.println(ctrlLogin.ppGetAll());
			break;
		case "find":
			
		case "search":
			
		case "new":
			System.out.print("------------------------------------------------------------------------------- \nNUEVA POLITCA DE PRESTAMO\n");
			System.out.println(newPerson());
			break;
		case "edit":
			
		case "delete":
			
		default:
			break;
		}
	}

	private String getCommand() {
		System.out.println("Ingrese el comando según la opción que desee realizar");
		System.out.println("list\t\tlistar todos");
		System.out.println("find\t\tbuscar por tipo y nro de documento"); //solo debe devolver 1
		System.out.println("search\t\tlistar por apellido"); //puede devolver varios
		System.out.println("new\t\tcrea una nueva persona y asigna un rol existente");
		System.out.println("edit\t\tbusca por tipo y nro de documento y actualiza todos los datos");
		System.out.println("delete\t\tborra por tipo y nro de documento");
		System.out.println();
		System.out.print("comando: ");
		return s.nextLine();
	}
	private PoliticaPrestamo newPerson() {
		System.out.println();
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaDate = null;
		PoliticaPrestamo pp = new PoliticaPrestamo();
		Date fecha = new Date();
		System.out.print("Ingrese el id: ");
		pp.setIdPoliticaPrestamo(Integer.parseInt(s.nextLine()));
		System.out.print("Ingrese el número máximo de libros que puede retirar el socio: ");
		pp.setCantMaximaSocio(Integer.parseInt(s.nextLine()));
		System.out.print("Ingrese el número máximo de libros que puede retirar el no socio: ");
		pp.setCantMaximaNoSocio(Integer.parseInt(s.nextLine()));
		System.out.println("Ingrese la fecha de hoy:");
		try {
			pp.setFechaAlta(formato.parse(s.nextLine()));
		} catch (ParseException e) {
			e.printStackTrace();
		} 
		ctrlLogin.newPerson(pp);
		return pp;
		
	}

}
	

