package vista.Mesas;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import controlador.*;


public class FormEliminarMesa extends javax.swing.JFrame {
	private JButton btnEliminar;
	private JLabel lblCantidadMesas;
	private JTextField txtMesas;
	private AbstractAction aceptarAccion;

	
	public FormEliminarMesa() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
		getContentPane().setLayout(null);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("Eliminar Mesas");
			{
				btnEliminar = new JButton();
				getContentPane().add(btnEliminar);
				btnEliminar.setText("ELIMINAR");
				btnEliminar.setBounds(110, 100, 120, 35);
				btnEliminar.setAction(getAceptarAccion());
			}
			{
				txtMesas = new JTextField();
				getContentPane().add(txtMesas);
				txtMesas.setText("");
				txtMesas.setBounds(170, 30, 50, 30);
			}
			{
				lblCantidadMesas = new JLabel();
				getContentPane().add(lblCantidadMesas);
				lblCantidadMesas.setText("Nro de Mesa: ");
				lblCantidadMesas.setBounds(15, 30, 150, 35);
			}
			pack();
			setSize(340, 180);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	private AbstractAction getAceptarAccion() {
		if(aceptarAccion == null) {
			aceptarAccion = new AbstractAction("ELIMINAR", null) {
				public void actionPerformed(ActionEvent evt) {
					Restaurante.getRestaurante().bajaDeMesa(Integer.parseInt(txtMesas.getText()));
					JOptionPane.showMessageDialog(null, "Mesa nro "+txtMesas.getText().toString()+" eliminada", "Mensaje", JOptionPane.WARNING_MESSAGE);
				}
			};
		}
		return aceptarAccion;
	}

	
}
