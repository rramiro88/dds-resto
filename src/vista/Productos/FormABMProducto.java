package vista.Productos;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;


public class FormABMProducto extends javax.swing.JFrame {
//	private JButton btnCancel;
	private JButton btnAlta;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnIngresar;
	
	private AbstractAction getAltaProductoAccion;
	private AbstractAction getModificarProductoAccion;
	private AbstractAction getEliminarProductoAccion;
	private AbstractAction getIngresarMercaderiaAccion;
	private AbstractAction cancelarAccion;
	
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
			{
				btnIngresar = new JButton();
				getContentPane().add(btnIngresar);
				btnIngresar.setText("INGRESAR MERCADERIA");
				btnIngresar.setAction(getIngresarMercaderiaAccion());
				btnIngresar.setBounds(37, 200, 200, 35);

			}

/*			{
				btnCancel = new JButton();
				getContentPane().add(btnCancel);
				btnCancel.setText("SALIR");
				btnCancel.setBounds(229, 224, 150, 35);
				btnCancel.setAction(getCancelarAccion());
			}
*/			pack();
			setSize(400, 300);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private AbstractAction getAltaProductoAccion() {
		if(getAltaProductoAccion == null) {
			getAltaProductoAccion = new AbstractAction("ALTA DE PRODUCTO", null) {
				public void actionPerformed(ActionEvent evt){
//					public static void main(String[] args) {
						SwingUtilities.invokeLater(new Runnable() {
							public void run() {
								FormAltaProducto inst = new FormAltaProducto();
								inst.setLocationRelativeTo(null);
								inst.setVisible(true);
							}
						});
					}

//				}
			};
		}
		return getAltaProductoAccion;
	}

	private AbstractAction getModificarProductoAccion() {
		if(getModificarProductoAccion== null) {
			getModificarProductoAccion= new AbstractAction("MODIFICAR PRODUCTO", null) {
				public void actionPerformed(ActionEvent evt){
//					public static void main(String[] args) {
						SwingUtilities.invokeLater(new Runnable() {
							public void run() {
								FormModificarProducto inst = new FormModificarProducto();
								inst.setLocationRelativeTo(null);
								inst.setVisible(true);
							}
						});
					}
//				}
			};
		}
		return getModificarProductoAccion;
	}

	private AbstractAction getEliminarProductoAccion() {
		getEliminarProductoAccion = new AbstractAction("ELIMINAR PRODUCTO", null) {
			public void actionPerformed(ActionEvent evt){
//				public static void main(String[] args) {
					SwingUtilities.invokeLater(new Runnable() {
						public void run() {
							FormEliminarProducto inst = new FormEliminarProducto();
							inst.setLocationRelativeTo(null);
							inst.setVisible(true);
						}
					});
				}
//			}
		};
		return getEliminarProductoAccion;
	}

	private AbstractAction getIngresarMercaderiaAccion() {
		getIngresarMercaderiaAccion = new AbstractAction("INGRESAR MERCADERIA", null) {
			public void actionPerformed(ActionEvent evt){
//				public static void main(String[] args) {
					SwingUtilities.invokeLater(new Runnable() {
						public void run() {
							FormIngresarMercaderia inst = new FormIngresarMercaderia();
							inst.setLocationRelativeTo(null);
							inst.setVisible(true);
						}
					});
				}
			};
		return getIngresarMercaderiaAccion;
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