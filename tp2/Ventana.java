package tp2;


import java.awt.Color;
import java.awt.Container;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class Ventana extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	private JLabel txtMenuCuentas;
	private JLabel txtUser, txtClave,txtSaldo,txtcuentas;
	private JButton btnaceptar, btnborrar,btnsalir,btnvolver,btnsalir2;
	private JTextField txtFUser;
	private JPasswordField txtFClave;
	private int cont = 0;
	private Usuario[] usuariosCargados;
	Usuario usuAceptado;
	private JRadioButton rbCajaAhorro,rbCtaCte,rbSaldo,rbTransferencia,rbExtraccion,rbDeposito ;
	private ButtonGroup operacionesGroup, cuentasGroup;
	
	public void crearVentana() {
		setLayout(null);
		btnaceptar = new JButton( "Aceptar" );
		btnaceptar.setBounds(10,150,90,30);
		add( btnaceptar );
		btnaceptar.addActionListener(this);
		btnborrar = new JButton( "Borrar" );
		btnborrar.setBounds(110,150,90,30);
		add( btnborrar );
		btnborrar.addActionListener(this);
		btnsalir= new JButton( "Salir" );
		btnsalir.setBounds(210,150,90,30);
		add( btnsalir );
		btnsalir.addActionListener(this);
		txtFUser=new JTextField(20);
		txtFUser.setBounds(100,40,100,30);
		add(txtFUser);
		txtFClave=new JPasswordField(20);
		txtFClave.setBounds(100,80,100,30);
		add(txtFClave);
		//setLayout(new FlowLayout() );
		txtUser = new JLabel("Usuario");
		txtUser.setBounds(10,1,100,100);
		add(txtUser);	
		txtClave = new JLabel("Clave");
		txtClave.setBounds(10,1,200,200);	
		add(txtClave);
			
	}
	
	
	public void actionPerformed(ActionEvent e) {  	
		try {
		boolean band;
    	boolean encontrado;
    	if (e.getSource()==btnaceptar) {
        	band=validarDatos();
        	if(band==true) cont++;
        	
        	if(band==false && cont<3) {
        		encontrado=validarUsuario();
        		if(encontrado==false) cont++;
        		
        	}	
        	if(cont>=3) {
        		setVisible(false);
        		JOptionPane.showMessageDialog(null, "Privilegios Suspendidos");
        		System.exit(0);
        	}
        }
        if (e.getSource()==btnborrar) {
            txtFUser.setText("");
            txtFClave.setText("");
        }
        if (e.getSource()==btnsalir) {
            System.exit(0);
        }
        if (e.getSource()==btnsalir2) {
            System.exit(0);
        }
        
        if (e.getSource()==btnvolver) {
        	deshabilitarMenuCuentas();
        	crearVentana();
        }
        
        if ((rbCajaAhorro.isSelected()==true) && (rbSaldo.isSelected()==true)){
        		mostrarSaldoCA();    		
			}
        if ((rbCtaCte.isSelected()==true) && (rbSaldo.isSelected()==true)){
    		mostrarSaldoCC();    		
		}
        if ((rbCajaAhorro.isSelected()==true) && (rbTransferencia.isSelected()==true)) {
        	txtSaldo.setVisible(false);
        	txtcuentas.setVisible(false);
			transferenciaCajaAhorro();
			}
		if ((rbCajaAhorro.isSelected()==true) && (rbExtraccion.isSelected()==true)) {
			txtSaldo.setVisible(false);
			txtcuentas.setVisible(false);
			extraccionCajaAhorro();
			}
		if ((rbCajaAhorro.isSelected()==true) && (rbDeposito.isSelected()==true)) {
			txtSaldo.setVisible(false);
			txtcuentas.setVisible(false);
			depositoCajaAhorro();
			
			}
		if ((rbCtaCte.isSelected()==true) && (rbTransferencia.isSelected()==true)) {
			txtSaldo.setVisible(false);
			txtcuentas.setVisible(false);
			transferenciaCtaCte();
			}
		if ((rbCtaCte.isSelected()==true) && (rbExtraccion.isSelected()==true)) {
			txtSaldo.setVisible(false);
			txtcuentas.setVisible(false);
			extraccionCtaCte();
			}
		if ((rbCtaCte.isSelected()==true) && (rbDeposito.isSelected()==true)) {
			txtSaldo.setVisible(false);
			txtcuentas.setVisible(false);
			depositoCtaCte();
			}
		}
			catch(NullPointerException error1) {
	    		
	    	}       	
		catch(NumberFormatException error1) {
    		
    		}
      }
		
    

	private boolean validarDatos(){
		boolean error = true;
		if (txtFUser.getText().equals( "" ) ||
				String.valueOf((txtFClave).getPassword()).equals( "" ) ) {
				JOptionPane.showMessageDialog( this, "Por favor llene todos los campos" ); }
		
		else if ( !txtFUser.getText().matches( "[A-Z][a-zA-Z0-9]{7,20}" ) ) {
				JOptionPane.showMessageDialog( this, "Usuario inválido" );
				}
		
		else if ( ! (String.valueOf(txtFClave.getPassword())).matches( "[a-zA-Z0-9]{8}" )) {
				JOptionPane.showMessageDialog( this, "Clave inválida" );
				}
		else error=false;
		return error;		
		}
	
	private boolean validarUsuario() {
		boolean usuEncontrado = false;
		char[] pass = txtFClave.getPassword();
		String usu = txtFUser.getText();
		for(int i=0 ; i<usuariosCargados.length ; i++) {
			if ((String.valueOf(pass).equals(usuariosCargados[i].getClave())) && usu.equals(usuariosCargados[i].getUsuario()))
			{
				usuAceptado= usuariosCargados[i];
				usuEncontrado=true;
				deshabilitarVentInicial();
				menuCuentas();
				
			}
		}
		if(usuEncontrado == false){
		   		JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrecta");
		   		txtFUser.setText("");
		        txtFClave.setText("");
		        cont=cont +1;
		}
		return usuEncontrado;
		
	}
	
	public void setUsuarios(Usuario[] usuarios) {
		usuariosCargados = usuarios;
	}
	
	private void deshabilitarVentInicial()
    {
    	txtClave.setVisible(false);
    	txtFClave.setVisible(false);
    	txtUser.setVisible(false);
    	txtFUser.setVisible(false);
    	btnaceptar.setVisible(false);
    	btnborrar.setVisible(false);
    	btnsalir.setVisible(false);
    }
	

	private void menuCuentas() {
		setLayout(null);
		txtMenuCuentas = new JLabel("Menu Cuentas");
		txtMenuCuentas.setBounds(10,0,400,20);
		txtMenuCuentas.setBackground(Color.cyan);
		txtMenuCuentas.setOpaque(true);
		add(txtMenuCuentas);
		
		txtSaldo = new JLabel("Saldo");
		txtSaldo.setBounds(200,25,150,20);
		txtSaldo.setBackground(Color.CYAN);
		txtSaldo.setOpaque(true);
		add(txtSaldo);
		txtSaldo.setVisible(false);
		
		btnvolver = new JButton( "Volver" );
		btnvolver.setBounds(130,200,100,30);
		add( btnvolver );
		btnvolver.addActionListener(this);
		
		btnsalir2 = new JButton( "Salir" );
		btnsalir2.setBounds(10,200,100,30);
		add( btnsalir2 );
		btnsalir2.addActionListener(this);
		repaint();
		txtcuentas = new JLabel();
		txtcuentas.setBounds(200,50,150,30);
		txtcuentas.setBackground(Color.white);
		txtcuentas.setOpaque(true);
		add( txtcuentas );
		txtcuentas.setVisible(false);
				
		Container containerCuentas = getContentPane();
		containerCuentas.setLayout(null);
				
		rbCajaAhorro = new JRadioButton( "Caja de Ahorro", true );
		rbCajaAhorro.setBounds(10, 20, 170, 20);
		containerCuentas.add( rbCajaAhorro );
		rbCtaCte = new JRadioButton( "Cuenta Corriente", true );
		rbCtaCte.setBounds(10, 40, 150, 20);
		containerCuentas.add( rbCtaCte );
		
		cuentasGroup = new ButtonGroup();
		cuentasGroup.add( rbCajaAhorro );
		cuentasGroup.add( rbCtaCte );
		
		Container containerOperaciones = getContentPane();
		containerOperaciones.setLayout(null);
		rbSaldo = new JRadioButton( "Saldo", true );
		rbSaldo.setBounds(10, 80, 200,20);
		containerOperaciones.add( rbSaldo );
		rbTransferencia = new JRadioButton( "Transferencia", true);
		rbTransferencia.setBounds(10, 100, 200, 20);
		containerOperaciones.add( rbTransferencia );
		rbExtraccion = new JRadioButton( "Extraccion", true );
		rbExtraccion.setBounds(10, 120, 200, 20);
		containerOperaciones.add( rbExtraccion );
		rbDeposito = new JRadioButton( "Deposito", true );
		rbDeposito.setBounds(10, 140, 200, 20);
		containerOperaciones.add( rbDeposito );
		
		operacionesGroup = new ButtonGroup();
		operacionesGroup.add( rbSaldo );
		operacionesGroup.add( rbTransferencia );
		operacionesGroup.add( rbExtraccion );
		operacionesGroup.add( rbDeposito );

		rbCajaAhorro.addActionListener( this );
		rbCtaCte.addActionListener( this );
		rbSaldo.addActionListener( this );
		rbTransferencia.addActionListener( this );
		rbExtraccion.addActionListener( this );
		rbDeposito.addActionListener( this );
	}
	
	private void transferenciaCajaAhorro() {
		boolean enc = false;
		boolean salir = false;
		int s= Integer.parseInt(usuAceptado.getSaldoCajaAhorro());
		while (salir ==false) {
		String cuenta = JOptionPane.showInputDialog(this, "Su saldo disponible es:"+ s+ "\n Ingrese la cuenta a que quiere transferir:");
		for(int i=0 ; i<usuariosCargados.length ; i++) {
			if ((cuenta.equals(usuariosCargados[i].getNroCtaCte())) || cuenta.equals(usuariosCargados[i].getCajaAhorro()))
			{
				enc = true; }}
		
			if (enc==true) {	
			int dinero = Integer.parseInt(JOptionPane.showInputDialog(this, "Ingrese el dinero:"));
			if (dinero <= s) {
				usuAceptado.actualizarCAMenos(dinero);
				JOptionPane.showMessageDialog(this, "Transferencia realizada \n Saldo Disponible: "+usuAceptado.getSaldoCajaAhorro());
			}
			else {
				JOptionPane.showMessageDialog(this, "Su saldo es insuficiente para realizar esta transferencia");
			}}
			else if (enc==false) {
				JOptionPane.showMessageDialog(this, "Usuario no encontrado");
			}
		salir=true;
		}
		
		
			
	}
	
    private void extraccionCajaAhorro() {
		boolean salir = false;
		rbCajaAhorro.setSelected(false);	
		rbExtraccion.setSelected(false);
		String s= usuAceptado.getSaldoCajaAhorro();
		while (salir==false) {
		JOptionPane.showMessageDialog(this, "Su saldo disponible es: "+s);
		String dinero = JOptionPane.showInputDialog(this, "Ingrese el dinero de extracción: ");
		int d = Integer.parseInt(dinero);
		Integer sa= Integer.parseInt(s);
		if (d <= sa) {
			usuAceptado.actualizarCAMenos(d);
				JOptionPane.showMessageDialog(this, "Extraccion realizada con éxito \n Saldo Disponible: "+usuAceptado.getSaldoCajaAhorro());
			}
		else {
				JOptionPane.showMessageDialog(this, "Su saldo es insuficiente para realizar esta extraccion");
			}
		salir=true;
		}
		}

		
	private void depositoCajaAhorro() {
		boolean salir = false;
		String s= usuAceptado.getSaldoCajaAhorro();
		while (salir ==false) {
		int dinero =  Integer.parseInt(JOptionPane.showInputDialog(this,"Su saldo disponible es: "+s+ "\n Ingrese el dinero que desea depositar: "));
		usuAceptado.actualizarCAMas(dinero);
		JOptionPane.showMessageDialog(this, "Deposito realizado con éxito \n Saldo Disponible: "+usuAceptado.getSaldoCajaAhorro());
		salir=true;
	    }
		
	}
	
	private void transferenciaCtaCte() {
		boolean enc2 = false;
		int s= Integer.parseInt(usuAceptado.getSaldoCtaCte());
		boolean salir = false;
		while (salir==false) {
		String cuenta = JOptionPane.showInputDialog(this, "Su saldo disponible es: "+ s+ "\n Ingrese la cuenta a que quiere transferir:");
		for(int i=0 ; i<usuariosCargados.length ; i++) {
			if ((cuenta.equals(usuariosCargados[i].getNroCtaCte())) || cuenta.equals(usuariosCargados[i].getCajaAhorro()))
			{
				enc2 = true; }}
		if (enc2==true) {	
			int dinero = Integer.parseInt(JOptionPane.showInputDialog(this, "Ingrese el dinero:"));
			if (dinero <= s) {
				usuAceptado.actualizarCCMenos(dinero);
				JOptionPane.showMessageDialog(this, "Transferencia realizada \n Saldo Disponible: "+usuAceptado.getSaldoCtaCte());
			}
			else {
				JOptionPane.showMessageDialog(this, "Su saldo es insuficiente para realizar esta transferencia ");
			}
				
		}
		else if (enc2==false) {
			JOptionPane.showMessageDialog(this, "Usuario no encontrado");
		}
		salir=true;
		}
	}
	
    private void extraccionCtaCte() {
		int s= Integer.parseInt( usuAceptado.getSaldoCtaCte());
		boolean salir=false;
		while (salir==false) {
		int dinero = Integer.parseInt(JOptionPane.showInputDialog(this, "Su saldo disponible es: "+s+"\n Ingrese el dinero de extracción:"));
		if (dinero <= s) {
			usuAceptado.actualizarCCMenos(dinero);
				JOptionPane.showMessageDialog(this, "Extraccion realizada con éxito \n Saldo Disponible: "+usuAceptado.getSaldoCtaCte());
			}
		else {
				JOptionPane.showMessageDialog(this, "Su saldo es insuficiente para realizar esta extraccion");
			}
		salir=true;	
		}
		}
		
	
	private void depositoCtaCte() {
		boolean salir = false;
		while (salir ==false) {
		String s= usuAceptado.getSaldoCtaCte();
		int dinero = Integer.parseInt(JOptionPane.showInputDialog(this, "Su saldo disponible es: "+s+"\n Ingrese el dinero que desea depositar:"));
		usuAceptado.actualizarCCMas(dinero);
		JOptionPane.showMessageDialog(this, "Deposito realizado con éxito \n Saldo Disponible: "+usuAceptado.getSaldoCtaCte());
		salir=true;}
	}
		
	
	private void mostrarSaldoCA() {
		txtSaldo.setVisible(true);
		txtcuentas.setVisible(true);
		txtcuentas.setText(null);
		String s = usuAceptado.getSaldoCajaAhorro();
		txtcuentas.setText(s);
		
	}
	private void mostrarSaldoCC() {
		txtSaldo.setVisible(true);
		txtcuentas.setVisible(true);
		txtcuentas.setText(null);
		String s = usuAceptado.getSaldoCtaCte();
		txtcuentas.setText(s);
		
	}

	private void deshabilitarMenuCuentas() {
		txtSaldo.setOpaque(false);
		txtcuentas.setOpaque(false);
		txtSaldo.setText(null);
		btnsalir2.setVisible(false);
		btnvolver.setVisible(false);
		txtcuentas.setText(null);;
		txtMenuCuentas.setVisible(false);
		txtFClave.setText(null);
		txtFUser.setText(null);
		operacionesGroup.clearSelection();
		cuentasGroup.clearSelection();
		rbCajaAhorro.setVisible(false);
		rbCtaCte.setVisible(false);
		rbDeposito.setVisible(false);
		rbExtraccion.setVisible(false);
		rbSaldo.setVisible(false);
		rbTransferencia.setVisible(false);
		
		
	}
	
}








