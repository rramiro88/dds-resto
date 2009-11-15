package vista.Productos;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;


public class FormABMProducto extends javax.swing.JFrame {
	private JButton btnAlta;
	private JButton btnModificar;
	private JButton btnEliminar;
	
	private AbstractAction getAltaProductoAccion;
	private AbstractAction getModificarProductoAccion;
	private AbstractAction getEliminarProductoAccion;
	
/** Auto-generated main method to display this JFrame
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				FormABMProducto inst = new FormABMProducto();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
*/
	
	public FormABMProducto() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			getContentPane().setLayout(null);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("ABM de Productos");
			{
				btnAlta = new JButton();
				getContentPane().add(btnAlta);
				btnAlta.setText("CREAR PRODUCTO");
				btnAlta.setAction(getAltaProductoAccion());
				btnAlta.setBounds(37, 12, 200, 35);

			}
			{
				btnModificar = new JButton();
				getContentPane().add(btnModificar);
				btnModificar.setText("MODIFICAR PRODUCTO");
				btnModificar.setBounds(37, 57, 200, 35);
				btnModificar.setAction(getModificarProductoAccion());
			}
			{
				btnEliminar = new JButton();
				getContentPane().add(btnEliminar);
				btnEliminar.setText("ELIMINAR PRODUCTO");
				btnEliminar.setAction(getEliminarProductoAccion());
				btnEliminar.setBounds(37, 102, 200, 35);

			}

			pack();
			setSize(274, 200);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private AbstractAction getAltaProductoAccion() {
		if(getAltaProductoAccion == null) {
			getAltaProductoAccion = new AbstractAction("ALTA DE PRODUCTO", null) {
				public void actionPerformed(ActionEvent evt){
						SwingUtilities.invokeLater(new Runnable() {
							public void run() {
								FormAltaProducto inst = new FormAltaProducto();
								inst.setLocationRelativeTo(null);
								inst.setVisible(true);
							}
						});
					}

			};
		}
		return getAltaProductoAccion;
	}

	private AbstractAction getModificarProductoAccion() {
		if(getModificarProductoAccion== null) {
			getModificarProductoAccion= new AbstractAction("MODIFICAR PRODUCTO", null) {
				public void actionPerformed(ActionEvent evt){
						SwingUtilities.invokeLater(new Runnable() {
							public void run() {
								FormModificarProducto inst = new FormModificarProducto();
								inst.setLocationRelativeTo(null);
								inst.setVisible(true);
							}
						});
					}
			};
		}
		return getModificarProductoAccion;
	}

	private AbstractAction getEliminarProductoAccion() {
		getEliminarProductoAccion = new AbstractAction("ELIMINAR PRODUCTO", null) {
			public void actionPerformed(ActionEvent evt){
					SwingUtilities.invokeLater(new Runnable() {
						public void run() {
							FormEliminarProducto inst = new FormEliminarProducto();
							inst.setLocationRelativeTo(null);
							inst.setVisible(true);
						}
					});
				}
		};
		return getEliminarProductoAccion;
	}

	
}