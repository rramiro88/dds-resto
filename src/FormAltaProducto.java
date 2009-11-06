import javax.swing.*;

import java.awt.*;
import java.awt.event.*;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class FormAltaProducto extends JFrame implements ActionListener {
	
	//private JTextField txtCodigo;
	//private JLabel lblCodigo; 
	private JTextField txtNombre;
	private JLabel lblNombre;
	private JTextField txtCantidad;
	private JLabel lblCantidad;
	private JTextField txtPtoPedido;
	private JLabel lblPtoPedido;
	private JTextField txtPtoRefill;
	private JLabel lblPtoRefill;
	private JComboBox cmbProveedores;
	private JLabel lblProveedores;
	private JButton btnAceptar;
	private JButton btnListar;
	
	
	public FormAltaProducto (){
		this.setVisible (true);   //Por defecto se abre como no visible.
		this.setSize(350,550);
		this.setTitle("Alta de Producto");
		//txtCodigo = new JTextField (10); //Crea un cuadro de texto.
		//lblCodigo = new JLabel ("Código");
		txtNombre = new JTextField (50); //Crea un cuadro de texto.
		lblNombre = new JLabel ("Nombre");
		txtCantidad = new JTextField (10); //Crea un cuadro de texto.
		lblCantidad = new JLabel ("Cantidad");
		txtPtoPedido = new JTextField (10); //Crea un cuadro de texto.
		lblPtoPedido = new JLabel ("Pto. de Pedido");
		txtPtoRefill = new JTextField (10); //Crea un cuadro de texto.
		lblPtoRefill = new JLabel ("Pto. de Reabastecimiento");
		cmbProveedores = new JComboBox (Restaurante.getRestaurante().getProveedoresView());
		lblProveedores = new JLabel ("Proveedores");
		
		Container panel = this.getContentPane(); //Me devuelve un objeto que sera la bolsa donde voy a meter los controles.
		panel.setLayout(new GridLayout (6,2)); //Me hace una division virtual en la pantalla y puedo colocar los objetos donde quiera. Primer num filas, seg. columnas, terc. separacion horiz, cuarto sep. vert.
		//panel.setLayout(new FlowLayout());
		
		btnAceptar = new JButton ("Aceptar");//Me agrega el boton aceptar.
	    btnAceptar.addActionListener(this);
	    btnListar = new JButton ("Listar");
	    btnListar.addActionListener(this);
		
	    panel.add(lblNombre);
	    lblNombre.setBounds(21, 42, 63, 28);
	   	panel.add (txtNombre);
	   	txtNombre.setBounds(70, 42, 110, 28);
	    panel.add (lblCantidad);
	    lblCantidad.setBounds(21, 62, 63, 28);
	    panel.add (txtCantidad);
	    panel.add (lblPtoPedido);
	    lblPtoPedido.setBounds(21, 82, 63, 28);
	    panel.add (txtPtoPedido);
	    panel.add (lblPtoRefill);
	    lblPtoRefill.setBounds(21, 102, 63, 28);
	    panel.add (txtPtoRefill);
	    panel.add (lblProveedores);
	    lblProveedores.setBounds(21, 122, 63, 28);
	    panel.add(cmbProveedores);
	    panel.add (btnAceptar);
	    btnAceptar.setBounds(21, 1422, 63, 28);
	    panel.add(btnListar);
	    
	    setDefaultCloseOperation (EXIT_ON_CLOSE);
	    this.pack(); //Me define la ventana del tamaño de los controles.
	    //this.move(400, 270); //Mueve la ventana a la posicion que el indico.
	}
	
	public void actionPerformed (ActionEvent e){
		if (e.getActionCommand().equals("Aceptar")){
			// Hay que validar que sean cantidades enteras !!!!
			Restaurante.getRestaurante().altaDeProducto(txtNombre.getText(), Integer.parseInt(txtCantidad.getText()), Integer.parseInt(txtPtoPedido.getText()), Integer.parseInt(txtPtoRefill.getText()),(Proveedor)cmbProveedores.getSelectedItem()); //Cargo en el vector los datos que el usuario cargo en la ventana.
			txtNombre.setText("");
			txtCantidad.setText("");
			txtPtoPedido.setText("");
			txtPtoRefill.setText("");
			//System.out.println("Còdigo: " + txtCodigo.getText () + "\n" + "Precio: " + txtPrecio.getText () + "\n" + "Descripción: " + txtDesc.getText()); //Muestro por pantalla lo que cargo el usuario.
		}
		if (e.getActionCommand().equals("Listar")){
			System.out.println(Restaurante.getRestaurante().getProductosView());
		}
	}
}