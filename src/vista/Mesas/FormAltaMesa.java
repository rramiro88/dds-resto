package vista.Mesas;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import controlador.*;


public class FormAltaMesa extends javax.swing.JFrame {
	private JButton btnCrear;
	private JLabel lblCantidadMesas;
	private JTextField txtMesas;
	private AbstractAction aceptarAccion;

	
	public FormAltaMesa() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
		getContentPane().setLayout(null);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("Crear Mesas");
			{
				btnCrear = new JButton();
				getContentPane().add(btnCrear);
				btnCrear.setText("CREAR MESA");
				btnCrear.setBounds(110, 100, 120, 35);
				btnCrear.setAction(getAceptarAccion());
			}
			{
				txtMesas = new JTextField();
				getContentPane().add(txtMesas);
				txtMesas.setText(Integer.toString(Restaurante.getRestaurante().cantidadMesas()));
				txtMesas.setBounds(190, 30, 50, 30);
				txtMesas.setEditable(false);
			}
			{
				lblCantidadMesas = new JLabel();
				getContentPane().add(lblCantidadMesas);
				lblCantidadMesas.setText("Cantidad Actual de Mesas: ");
				lblCantidadMesas.setBounds(15, 30, 170, 35);
			}
			pack();
			setSize(340, 180);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	private AbstractAction getAceptarAccion() {
		if(aceptarAccion == null) {
			aceptarAccion = new AbstractAction("CREAR MESA", null) {
				public void actionPerformed(ActionEvent evt) {
					Restaurante.getRestaurante().altaDeMesa(false);
					JOptionPane.showMessageDialog(null, "Mesa creada con exito", "Mensaje", JOptionPane.WARNING_MESSAGE);
					txtMesas.setText(Integer.toString(Restaurante.getRestaurante().cantidadMesas()));
				}
			};
		}
		return aceptarAccion;
	}


}
