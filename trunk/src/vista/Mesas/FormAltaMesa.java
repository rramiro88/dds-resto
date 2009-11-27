package vista.Mesas;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

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
public class FormAltaMesa extends javax.swing.JFrame {
	private JButton btnCrear;
	private JLabel lblCantidadMesas;
	private AbstractAction crearHabilitadaAccion;
	private JButton btnCrearMesaHabilitada;
	private JTextField txtMesas;
	private AbstractAction crearDeshabilitadaAccion;

	
	public FormAltaMesa() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
		getContentPane().setLayout(null);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("Crear Mesas");
			this.setPreferredSize(new java.awt.Dimension(350, 200));
			{
				btnCrear = new JButton();
				getContentPane().add(btnCrear);
				btnCrear.setText("CREAR MESA");
				btnCrear.setBounds(79, 115, 185, 27);
				btnCrear.setAction(getCrearDeshabilitadaAccion());
			}
			{
				txtMesas = new JTextField();
				getContentPane().add(txtMesas);
				txtMesas.setText(Integer.toString(Restaurante.getRestaurante().cantidadMesas()));
				txtMesas.setBounds(256, 30, 50, 30);
				txtMesas.setEditable(false);
			}
			{
				lblCantidadMesas = new JLabel();
				getContentPane().add(lblCantidadMesas);
				getContentPane().add(getBtnCrearMesaHabilitada());
				lblCantidadMesas.setText("Cantidad Actual de Mesas: ");
				lblCantidadMesas.setBounds(24, 27, 220, 35);
				lblCantidadMesas.setFont(new java.awt.Font("Tahoma",1,11));
			}
			pack();
			this.setSize(350, 200);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	private AbstractAction getCrearDeshabilitadaAccion() {
		if(crearDeshabilitadaAccion == null) {
			crearDeshabilitadaAccion = new AbstractAction("Crear Mesa Deshabilitada", null) {
				public void actionPerformed(ActionEvent evt) {
					Restaurante.getRestaurante().altaDeMesa(false);
					JOptionPane.showMessageDialog(null, "Mesa creada con exito. Estado: deshabilitada", "Mensaje", JOptionPane.WARNING_MESSAGE);
					txtMesas.setText(Integer.toString(Restaurante.getRestaurante().cantidadMesas()));
				}
			};
		}
		return crearDeshabilitadaAccion;
	}
	
	private JButton getBtnCrearMesaHabilitada() {
		if(btnCrearMesaHabilitada == null) {
			btnCrearMesaHabilitada = new JButton();
			btnCrearMesaHabilitada.setText("Crear Mesa Habilitada");
			btnCrearMesaHabilitada.setBounds(79, 83, 185, 27);
			btnCrearMesaHabilitada.setAction(getCrearHabilitadaAccion());
		}
		return btnCrearMesaHabilitada;
	}
	
	private AbstractAction getCrearHabilitadaAccion() {
		if(crearHabilitadaAccion == null) {
			crearHabilitadaAccion = new AbstractAction("Crear Mesa Habilitada", null) {
				public void actionPerformed(ActionEvent evt) {
					Restaurante.getRestaurante().altaDeMesa(true);
					JOptionPane.showMessageDialog(null, "Mesa creada con exito. Estado: habilitada", "Mensaje", JOptionPane.WARNING_MESSAGE);
					txtMesas.setText(Integer.toString(Restaurante.getRestaurante().cantidadMesas()));
				}
			};
		}
		return crearHabilitadaAccion;
	}

}
