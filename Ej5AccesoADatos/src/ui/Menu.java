package ui;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

import entities.*;
import logic.Login;

public class Menu {
	Scanner s=null;
	Login ctrlLogin = new Login();

	public void start() {
		s = new Scanner(System.in);
		Persona p=login();
		System.out.println("\n\nBienvenido "+p.getNombre()+" "+p.getApellido());
		System.out.println();
		
		String command;
		do {
			command=getCommand();
			executeCommand(command);
			System.out.println();
			
		}while(!command.equalsIgnoreCase("exit"));
		
		s.close();
	}

	private void executeCommand(String command) {
		switch (command) {
		case "list":
			System.out.println(ctrlLogin.getAll());
			break;
		case "find":
			System.out.println(find());
			break;
		case "search":
			System.out.println(search());
			break;
		case "new":
			System.out.println(add());
			break;
		case "edit":
			update();
			break;
		case "delete":
			delete();
			break;
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
	
	public Persona login() {
		Persona p=new Persona();
		
		System.out.print("Email: ");
		p.setEmail(s.nextLine());

		System.out.print("password: ");
		p.setPassword(s.nextLine());
		
		p=ctrlLogin.validate(p);
		
		return p;
		
	}
	
	private Persona find() {
		System.out.println();
		Persona p=new Persona();
		Documento d=new Documento();
		p.setDocumento(d);
		System.out.print("Tipo doc: ");
		d.setTipo(s.nextLine());

		System.out.print("Nro doc: ");
		d.setNro(s.nextLine());
		
		return ctrlLogin.getByDocumento(p);
	}
	
	private LinkedList<Persona> search() {
		System.out.println();
		Persona p=new Persona();
		Documento d=new Documento();
		p.setDocumento(d);
		System.out.print("Ingrese el apellido: ");
		p.setApellido(s.nextLine());
		
		return ctrlLogin.getByApellido(p);
	}
	
	private Persona add() {
			System.out.println();
			Persona p=new Persona();
			Documento d=new Documento();
			Rol r=new Rol();
			p.setDocumento(d);
			System.out.print("Tipo doc: ");
			d.setTipo(s.nextLine());
			System.out.print("Nro doc: ");
			d.setNro(s.nextLine());
			System.out.print("Nombre: ");
			p.setNombre(s.nextLine());
			System.out.print("Apellido: ");
			p.setApellido(s.nextLine());
			System.out.print("Email: ");
			p.setEmail(s.nextLine());
			System.out.print("Password: ");
			p.setPassword(s.nextLine());
			System.out.print("Telefono: ");
			p.setTel(s.nextLine());
			//System.out.print("Habilitado: ");
			
			//if (s.nextLine()=="si") {p.setHabilitado(true);}
			//else {p.setHabilitado(false);}
			//System.out.print("Id Rol admin - user: ");
			//r.setDescripcion(s.nextLine());;
			//if (s.nextLine()=="admin") {r.setId(1);}
			//else {r.setId(2);}
			//r.setDescripcion("admin");
			//r.setId(1);
			
			//ctrlLogin.insertarNuevo(p,r);
			System.out.print("Habilitado: true - false: ");
			p.setHabilitado(Boolean.valueOf(s.nextLine()));
			System.out.println("Roles disponibles:");
			System.out.println(ctrlLogin.getAllRoles());
			System.out.println("Id del rol: ");
			r.setId(Integer.parseInt(s.nextLine()));
			r=ctrlLogin.getById(r);
			ctrlLogin.add(p);
			ctrlLogin.asignarRol(p, r); 
			ctrlLogin.setRoles(p);
			return p;
			
		}

	private void update() {
		System.out.println("EDITAR: ");
		Persona p=new Persona();
		HashMap<Integer, Rol> roles=new HashMap<Integer, Rol>();
		System.out.println("DNI de la persona que desea editar: ");
		p=find();
		roles=p.getRoles();
		System.out.println(p);
		System.out.println("Datos de persona: ");
		System.out.print("Nuevo nombre: ");
		p.setNombre(s.nextLine());
		System.out.print("Nuevo apellido: ");
		p.setApellido(s.nextLine());
		System.out.print("Nuevo email: ");
		p.setEmail(s.nextLine());
		System.out.print("Nuevo password: ");
		p.setPassword(s.nextLine());
		System.out.print("Nuevo telefono: ");
		p.setTel(s.nextLine());
		System.out.print("Habilitado? true - false: ");
		p.setHabilitado(Boolean.valueOf(s.nextLine()));
		ctrlLogin.update(p);
		System.out.println("Roles de la persona: "+roles);
		System.out.println("Desea editar los roles: \n 1 Si \n 2 No");
		if(s.nextLine()=="1") {
		System.out.println("1 Borrar un rol \n2 Agregar un rol");
		switch (s.nextLine()) {
		case "1":
			editDeleteRol(p);
			break;
		case "2":
			editInsertRol(p);
		}
		}
		System.out.print("Persona: "+p);
		System.out.print("Roles: "+p.getRoles());
	}
	
	private void editDeleteRol(Persona p) {
		Rol r = new Rol();
		System.out.println("Roles asignados: "+p.getRoles());
		System.out.println("Ingrese el id del rol a eliminar: ");
		r.setId(Integer.parseInt(s.nextLine()));
		r=ctrlLogin.getById(r);
		p.removeRol(r);
		ctrlLogin.deleteRol(p, r);
		System.out.println("Rol eliminado"+r);
	}
	
	private void editInsertRol(Persona p) {
		Rol r= new Rol();
		System.out.println("Ingrese el id del rol: ");
		r.setId(Integer.parseInt(s.nextLine()));
		r=ctrlLogin.getById(r);
		while (p.hasRol(r)==true){
			System.out.println("Ya tiene asignado el rol");
			System.out.println("Ingrese el id del rol: ");
			r.setId(Integer.parseInt(s.nextLine()));
			r=ctrlLogin.getById(r);}
		p.addRol(r);
		ctrlLogin.asignarRol(p, r);
		System.out.println(p);
		
	}

	private void delete() {
		Persona p=new Persona();
		p=find();
		System.out.println("Persona que desea eliminar: "+p);
		System.out.println("Roles: "+p.getRoles());
		ctrlLogin.delete(p);
		System.out.println("Eliminada con éxito");
		}
		
	
}

