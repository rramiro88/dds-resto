package vista.Productos;

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
public class FormEliminarProducto extends javax.swing.JFrame {
	private JLabel lblProducto;
	private AbstractAction eliminarAction;
	private AbstractAction cerrarAction;
	private JButton btnCerrar;
	private JButton btnEliminar;
	private JComboBox cmbProductos;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				FormEliminarProducto inst = new FormEliminarProducto();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public FormEliminarProducto() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("Eliminar Producto");
			this.setPreferredSize(new java.awt.Dimension(400, 150));
			{
				lblProducto = new JLabel();
				getContentPane().add(lblProducto);
				lblProducto.setText("SELECCIONAR PRODUCTO: ");
				lblProducto.setBounds(6, 22, 144, 14);
			}
			{
				cmbProductos = new JComboBox(Restaurante.getRestaurante().getProductosViewVector());
				getContentPane().add(cmbProductos);
				cmbProductos.setBounds(150, 19, 230, 21);
			}
			{
				btnEliminar = new JButton();
				getContentPane().add(btnEliminar);
				btnEliminar.setText("Eliminar");
				btnEliminar.setBounds(76, 66, 92, 33);
				btnEliminar.setFont(new java.awt.Font("Tahoma",1,11));
				btnEliminar.setAction(getEliminarAction());
			}
			{
				btnCerrar = new JButton();
				getContentPane().add(btnCerrar);
				btnCerrar.setText("Cerrar");
				btnCerrar.setBounds(194, 67, 92, 32);
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
					String nombre = cmbProductos.getSelectedItem().toString().substring(1,4);
					Restaurante.getRestaurante().bajaDeProducto(nombre);
					cmbProductos.removeItemAt(cmbProductos.getSelectedIndex());
					JOptionPane.showMessageDialog(null, "Producto eliminado con exito.", "Resultado", JOptionPane.INFORMATION_MESSAGE);
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
