package vista.Proveedores;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import controlador.*;
import modelo.*;

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
public class FormEliminarProveedor extends javax.swing.JFrame {
	private JLabel lblProveedor;
	private AbstractAction eliminarAction;
	private AbstractAction cerrarAction;
	private JButton btnCerrar;
	private JButton btnEliminar;
	private JComboBox cmbProveedores;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				FormEliminarProveedor inst = new FormEliminarProveedor();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public FormEliminarProveedor() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("Eliminar Proveedor");
			this.setPreferredSize(new java.awt.Dimension(400, 150));
			{
				lblProveedor = new JLabel();
				getContentPane().add(lblProveedor);
				lblProveedor.setText("SELEC PROVEEDOR: ");
				lblProveedor.setBounds(6, 22, 138, 14);
			}
			{
				cmbProveedores = new JComboBox(Restaurante.getRestaurante().getProveedoresViewVector());
				getContentPane().add(cmbProveedores);
				cmbProveedores.setBounds(156, 19, 225, 21);
			}
			{
				btnEliminar = new JButton();
				getContentPane().add(btnEliminar);
				btnEliminar.setText("Eliminar");
				btnEliminar.setBounds(86, 66, 92, 33);
				btnEliminar.setFont(new java.awt.Font("Tahoma",1,11));
				btnEliminar.setAction(getEliminarAction());
			}
			{
				btnCerrar = new JButton();
				getContentPane().add(btnCerrar);
				btnCerrar.setText("Cerrar");
				btnCerrar.setBounds(214, 67, 92, 32);
				btnCerrar.setFont(new java.awt.Font("Tahoma",1,11));
				btnCerrar.setAction(getCerrarAction());
			}
			pack();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private AbstractAction getEliminarAction() {
		if(eliminarAction == null) {
			eliminarAction = new AbstractAction("Eliminar", null) {
				public void actionPerformed(ActionEvent evt) {
					String cuit = cmbProveedores.getSelectedItem().toString().substring(1,12);
					Restaurante.getRestaurante().bajaDeProveedor(cuit);
					cmbProveedores.removeItemAt(cmbProveedores.getSelectedIndex());
					JOptionPane.showMessageDialog(null, "Proveedor eliminado con exito.", "Resultado", JOptionPane.INFORMATION_MESSAGE);
				}
			};
		}
		return eliminarAction;
	}
	
	private AbstractAction getCerrarAction() {
		if(cerrarAction == null) {
			cerrarAction = new AbstractAction("Cerrar", null) {
				public void actionPerformed(ActionEvent evt) {
					System.exit(0);
				}
			};
		}
		return cerrarAction;
	}

}
