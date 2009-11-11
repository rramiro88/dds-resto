package vista.ItemsDeCarta;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import controlador.*;


public class FormAltaPlato extends javax.swing.JFrame {
	private JButton btnCancel;
	private JButton btnAceptar;
	private AbstractAction cancelarAccion;
	private AbstractAction aceptarAccion;
	private JLabel lblRazonSocial;
	private JLabel jLabel2;
	private JLabel jLabel1;
	private JTextField txtPrecio;
	private JTextField txtNombre;
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				FormAltaPlato inst = new FormAltaPlato();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public FormAltaPlato() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			getContentPane().setLayout(null);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("Alta de Platos");
			{
				btnCancel = new JButton();
				getContentPane().add(btnCancel);
				btnCancel.setText("CANCELAR");
				btnCancel.setBounds(261, 225, 118, 34);
				btnCancel.setAction(getCancelarAccion());
			}
			{
				btnAceptar = new JButton();
				getContentPane().add(btnAceptar);
				btnAceptar.setText("ACEPTAR");
				btnAceptar.setBounds(132, 225, 118, 34);
				btnAceptar.setAction(getAceptarAccion());
			}
			{
				txtNombre = new JTextField();
				getContentPane().add(txtNombre);
				txtNombre.setBounds(134, 12, 244, 34);
			}
			{
				txtPrecio = new JTextField();
				getContentPane().add(txtPrecio);
				txtPrecio.setBounds(134, 58, 244, 34);
			}
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("Nombre del Plato");
				jLabel1.setBounds(12, 17, 110, 33);
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("Precio");
				jLabel2.setBounds(12, 59, 110, 33);
			}
			pack();
			setSize(400, 300);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private AbstractAction getAceptarAccion() {
		if(aceptarAccion == null) {
			aceptarAccion = new AbstractAction("ACEPTAR", null) {
				public void actionPerformed(ActionEvent evt) {
					//aca va el codigo de lo que hace el boton
					Restaurante.getRestaurante().altaDePlato(txtNombre.getText(), Integer.parseInt(txtPrecio.getText()));
					txtNombre.setText("");
					txtPrecio.setText("");
				}
			};
		}
		return aceptarAccion;
	}
			
	private AbstractAction getCancelarAccion() {
		if(cancelarAccion == null) {
			cancelarAccion = new AbstractAction("CANCELAR", null) {
				public void actionPerformed(ActionEvent evt) {
					//aca va el codigo de lo que hace el boton
					System.exit(0);
				}
			};
		}
		return cancelarAccion;
	}
}
