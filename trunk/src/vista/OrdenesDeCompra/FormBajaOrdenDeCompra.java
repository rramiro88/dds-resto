package vista.OrdenesDeCompra;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import controlador.*;
	

public class FormBajaOrdenDeCompra extends javax.swing.JFrame {
//	private JButton btnCancel;
	private JButton btnGenerar;

	private AbstractAction cancelarAccion;
	private AbstractAction eliminarAccion;

	private JLabel lblProveedor;
	private JLabel lblFecha;

	private JTextField txtProveedor;
	private JTextField txtFecha;

/**
//	Auto-generated main method to display this JFrame
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				FormBajaOrdenDeCompra inst = new FormBajaOrdenDeCompra();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
*/
		
	public FormBajaOrdenDeCompra() {
		super();
		initGUI();
	}
		
	private void initGUI() {
		try {
			getContentPane().setLayout(null);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("Baja de Orden de Compra");
/*			{
				btnCancel = new JButton();
				getContentPane().add(btnCancel);
				btnCancel.setText("CANCELAR");
				btnCancel.setBounds(261, 225, 118, 34);
				btnCancel.setAction(getCancelarAccion());
			}
*/			{
				btnGenerar = new JButton();
				getContentPane().add(btnGenerar);
				btnGenerar.setText("ELIMINAR");
				btnGenerar.setBounds(132, 225, 118, 34);
				btnGenerar.setAction(generarAccion());
			}
			{
				txtFecha = new JTextField();
				getContentPane().add(txtFecha);
				txtFecha.setBounds(150, 20, 230, 35);
			}
			{
				lblFecha = new JLabel();
				getContentPane().add(lblFecha);
				lblFecha.setText("Fecha (dd/mm/aaaa):");
				lblFecha.setBounds(12, 20, 120, 35);
			}
			{
				txtProveedor = new JTextField();
				getContentPane().add(txtProveedor);
				txtProveedor.setBounds(150, 80, 230, 35);
			}
			{
				lblProveedor = new JLabel();
				getContentPane().add(lblProveedor);
				lblProveedor.setText("Proveedor:");
				lblProveedor.setBounds(12, 80, 120, 35);
			}
			pack();
			setSize(400, 300);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private AbstractAction generarAccion() {
		if(eliminarAccion == null) {
			eliminarAccion = new AbstractAction("ELIMINAR", null) {
				public void actionPerformed(ActionEvent evt) {
					Restaurante.getRestaurante().bajaDeOrdenDeCompra(txtProveedor.getText(), txtFecha.getText());
					txtFecha.setText("");
					txtProveedor.setText("");
				}
			};
		}
		return eliminarAccion;
	}

	private AbstractAction getCancelarAccion() {
		if(cancelarAccion == null) {
			cancelarAccion = new AbstractAction("CANCELAR", null) {
				public void actionPerformed(ActionEvent evt) {
					System.exit(0);
				}
			};
		}
		return cancelarAccion;
	}
}
