package vista.Proveedores;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import controlador.*;

public class FormAltaProveedor extends javax.swing.JFrame {
	private JButton btnCancel;
	private JButton btnAceptar;

	private JTextField txtDomicilio;
	private JTextField txtCuit;
	private JTextField txtRazonSocial;
	
	private AbstractAction cancelarAccion;
	private AbstractAction aceptarAccion;
	
	private JLabel lblRazonSocial;
	private JLabel jLabel2;
	private JLabel jLabel1;

/** Auto-generated main method to display this JFrame
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				FormAltaProveedor inst = new FormAltaProveedor();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
*/
	
	public FormAltaProveedor() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			getContentPane().setLayout(null);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("Alta de Proveedores");
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
				txtCuit = new JTextField();
				getContentPane().add(txtCuit);
				txtCuit.setBounds(134, 12, 244, 34);
			}
			{
				txtDomicilio = new JTextField();
				getContentPane().add(txtDomicilio);
				txtDomicilio.setBounds(134, 58, 244, 34);
			}
			{
				txtRazonSocial = new JTextField();
				getContentPane().add(txtRazonSocial);
				txtRazonSocial.setBounds(134, 108, 244, 34);
			}
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("Cuit");
				jLabel1.setBounds(12, 13, 110, 33);
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("Domicilio");
				jLabel2.setBounds(12, 59, 110, 33);
			}
			{
				lblRazonSocial = new JLabel();
				getContentPane().add(lblRazonSocial);
				lblRazonSocial.setText("Razon Social");
				lblRazonSocial.setBounds(12, 109, 110, 33);
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
					Restaurante.getRestaurante().altaDeProveedor(txtCuit.getText(), txtRazonSocial.getText(), txtDomicilio.getText());
					txtCuit.setText("");
					txtRazonSocial.setText("");
					txtDomicilio.setText("");
					JOptionPane.showMessageDialog(null, "Proveedor creado con exito.", "Resultado", JOptionPane.INFORMATION_MESSAGE);
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
