package vista.Proveedores;

import java.awt.event.ActionEvent;
import java.util.Vector;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

import controlador.*;


public class FormEliminarProveedor extends javax.swing.JFrame {
	private JButton btnCerrar;
	private JButton btnEliminar;

	private AbstractAction eliminarAction;
	private AbstractAction cerrarAction;

	private JLabel lblProveedor;
	private JComboBox cmbProveedores;

/** Auto-generated main method to display this JFrame
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				FormEliminarProveedor inst = new FormEliminarProveedor();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
*/
	
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
				Vector vp = getProveedoresViewVector(Restaurante.getRestaurante().getProveedoresView());
				cmbProveedores = new JComboBox(vp);
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
					String cuit = cmbProveedores.getSelectedItem().toString().substring(0,11);
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
					dispose();
				}
			};
		}
		return cerrarAction;
	}
	
	public Vector getProveedoresViewVector(Vector<ProveedorView> vpv){ 
		Vector mv = new Vector();
		for (int i= 0; i < vpv.size(); i++){
			String aux = String.valueOf(vpv.elementAt(i).getCuit()) + "   " + vpv.elementAt(i).getRazonsocial(); 
			mv.add(aux);
		}
		return mv;
	}

	
}
