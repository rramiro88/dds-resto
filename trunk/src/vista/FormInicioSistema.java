package vista;

import java.awt.event.ActionEvent; 
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import controlador.*;



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
public class FormInicioSistema extends javax.swing.JFrame {
	private JButton btnIngresar;
	private JButton btnSalir;

	private JLabel lblDia;
	private JLabel lblFecha;
	
	private JTextField txtFecha;
	private JTextField txtDiaActual;
	
	private AbstractAction ingresarAccion;
	private AbstractAction salirAccion;
	

/** */	//	Auto-generated main method to display this JFrame
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				FormInicioSistema inst = new FormInicioSistema();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	//	Metodo que genera la fecha y dia actual en texto
	//	Para cargarlos al inicio en Restaurante.java.
	Date date = Calendar.getInstance().getTime();
	DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	String fecha = formatter.format(date);
	DateFormat formatterDia = new SimpleDateFormat("EEEE");
	String dia = formatterDia.format(date);
	
	public FormInicioSistema() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			getContentPane().setLayout(null);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("Ingreso");
			{
				btnIngresar = new JButton();
				getContentPane().add(btnIngresar);
				btnIngresar.setText("INGRESAR");
				btnIngresar.setAction(ingresarAccion());
				btnIngresar.setBounds(40, 167, 120, 35);
			}			
			{
				btnSalir = new JButton();
				getContentPane().add(btnSalir);
				btnSalir.setText("SALIR");
				btnSalir.setAction(salirAccion());
				btnSalir.setBounds(190, 167, 120, 35);
			}
			{
				lblFecha = new JLabel();
				getContentPane().add(lblFecha);
				lblFecha.setText("Fecha (dd/mm/aaaa):");
				lblFecha.setBounds(12, 22, 150, 35);
				lblFecha.setFont(new java.awt.Font("Tahoma",1,11));
			}
			{
				txtFecha = new JTextField();
				getContentPane().add(txtFecha);
				txtFecha.setBounds(180, 22, 150, 35);
				txtFecha.setText(fecha);
				txtFecha.setEditable(false);
			}
			{
				lblDia = new JLabel();
				getContentPane().add(lblDia);
				lblDia.setText("Dia Actual:");
				lblDia.setBounds(12, 67, 150, 35);
				lblDia.setFont(new java.awt.Font("Tahoma",1,11));
			}
			{
				txtDiaActual = new JTextField();
				getContentPane().add(txtDiaActual);
				txtDiaActual.setBounds(180, 67, 150, 35);
				txtDiaActual.setText(dia);
				txtDiaActual.setEditable(false);
			}
			pack();
			setSize(350, 300);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private AbstractAction ingresarAccion() {
		if(ingresarAccion == null) {
			ingresarAccion = new AbstractAction("INGRESAR", null) {
				public void actionPerformed(ActionEvent evt) {
					if (Restaurante.getRestaurante().diaValido(txtDiaActual.getText())){
						Restaurante.getRestaurante().setFecha(fecha);
						Restaurante.getRestaurante().setDia(dia);
						JOptionPane.showMessageDialog(null, "Bienvenido al Restaurante.", "Hola!", JOptionPane.WARNING_MESSAGE);
						FormMAIN inst = new FormMAIN();
						inst.setLocationRelativeTo(null);
						inst.setVisible(true);
					}else{
						JOptionPane.showMessageDialog(null, "Dia actual no es un dia de la semana.", "ERROR", JOptionPane.WARNING_MESSAGE);
						txtDiaActual.setText("");
						//	txtFecha.setText("");
					}
				}
			};
		}
		return ingresarAccion;
	}
	
	private AbstractAction salirAccion() {
		if(salirAccion == null) {
			salirAccion = new AbstractAction("SALIR", null) {
				public void actionPerformed(ActionEvent evt) {
					JOptionPane.showMessageDialog(null, "Se cerrar� el sistema. Que tenga un buen dia.", "ADIOS", JOptionPane.WARNING_MESSAGE);
					System.exit(0);
				}
			};
		}
		return salirAccion;
	}
	

}
