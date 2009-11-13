package vista.Proveedores;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;


public class FormABMProveedor extends javax.swing.JFrame {
	private JButton btnCancel;
	private JButton btnAlta;
	private JButton btnModificar;
	private JButton btnEliminar;

	private AbstractAction getAltaProveedorAccion;
	private AbstractAction getModificarProveedorAccion;
	private AbstractAction getEliminarProveedorAccion;
	private AbstractAction cancelarAccion;
	
/** Auto-generated main method to display this JFrame
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				FormABMProveedor inst = new FormABMProveedor();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
*/
	
	public FormABMProveedor() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			getContentPane().setLayout(null);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("ABM de Proveedors");
			{
				btnAlta = new JButton();
				getContentPane().add(btnAlta);
				btnAlta.setText("CREAR PROVEEDOR");
				btnAlta.setAction(getAltaProveedorAccion());
				btnAlta.setBounds(37, 12, 200, 35);

			}
			{
				btnModificar = new JButton();
				getContentPane().add(btnModificar);
				btnModificar.setText("MODIFICAR PROVEEDOR");
				btnModificar.setBounds(37, 57, 200, 35);
				btnModificar.setAction(getModificarProveedorAccion());
			}
			{
				btnEliminar = new JButton();
				getContentPane().add(btnEliminar);
				btnEliminar.setText("ELIMINAR PROVEEDOR");
				btnEliminar.setAction(getEliminarProveedorAccion());
				btnEliminar.setBounds(37, 102, 200, 35);

			}
			{
				btnCancel = new JButton();
				getContentPane().add(btnCancel);
				btnCancel.setText("SALIR");
				btnCancel.setBounds(229, 224, 150, 35);
				btnCancel.setAction(getCancelarAccion());
			}
			pack();
			setSize(400, 300);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private AbstractAction getAltaProveedorAccion() {
		if(getAltaProveedorAccion == null) {
			getAltaProveedorAccion = new AbstractAction("ALTA DE PROVEEDOR", null) {
				public void actionPerformed(ActionEvent evt){
//					public static void main(String[] args) {
						SwingUtilities.invokeLater(new Runnable() {
							public void run() {
								FormAltaProveedor inst = new FormAltaProveedor();
								inst.setLocationRelativeTo(null);
								inst.setVisible(true);
							}
						});
					}

//				}
			};
		}
		return getAltaProveedorAccion;
	}

	private AbstractAction getModificarProveedorAccion() {
		if(getModificarProveedorAccion== null) {
			getModificarProveedorAccion= new AbstractAction("MODIFICAR PROVEEDOR", null) {
				public void actionPerformed(ActionEvent evt){
//					public static void main(String[] args) {
						SwingUtilities.invokeLater(new Runnable() {
							public void run() {
								FormModificarProveedor inst = new FormModificarProveedor();
								inst.setLocationRelativeTo(null);
								inst.setVisible(true);
							}
						});
					}
//				}
			};
		}
		return getModificarProveedorAccion;
	}

	private AbstractAction getEliminarProveedorAccion() {
		getEliminarProveedorAccion = new AbstractAction("ELIMINAR PROVEEDOR", null) {
			public void actionPerformed(ActionEvent evt){
//				public static void main(String[] args) {
					SwingUtilities.invokeLater(new Runnable() {
						public void run() {
							FormEliminarProveedor inst = new FormEliminarProveedor();
							inst.setLocationRelativeTo(null);
							inst.setVisible(true);
						}
					});
				}
//			}
		};
		return getEliminarProveedorAccion;
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