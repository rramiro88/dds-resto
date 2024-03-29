package vista;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import vista.Cartas.FormABMCarta;
import vista.Mozos.FormABMMozo;
import vista.Mesas.FormABMMesa;
import vista.Productos.FormABMProducto;
import vista.Proveedores.FormABMProveedor;
import vista.ItemsDeCarta.FormABMItemDeCarta;

public class FormABMs extends javax.swing.JFrame {
//	private JButton btnCancel;
	private JButton btnProv;
	private JButton btnProd;
	private JButton btnMozo;
	private JButton btnCarta;
	private JButton btnMesa;
	private JButton btnItemCart;
	
	private AbstractAction getABMProveedorAccion;
	private AbstractAction getABMProductoAccion;
	private AbstractAction getABMMozoAccion;
	private AbstractAction getABMMesaAccion;
	private AbstractAction getABMCartaAccion;
	private AbstractAction getABMItemCartaAccion;
	

	public FormABMs() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			getContentPane().setLayout(null);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("Altas - Bajas - Modificaciones");
			{
				btnProv = new JButton();
				getContentPane().add(btnProv);
				btnProv.setText("PROVEEDORES");
				btnProv.setAction(getABMProveedorAccion());
				btnProv.setBounds(15, 20, 125, 32);
			}
			{
				btnProd = new JButton();
				getContentPane().add(btnProd);
				btnProd.setText("PRODUCTOS");
				btnProd.setAction(getABMProductoAccion());
				btnProd.setBounds(160, 20, 125, 32);
			}
			{
				btnMozo = new JButton();
				getContentPane().add(btnMozo);
				btnMozo.setText("MOZOS");
				btnMozo.setAction(getABMMozoAccion());
				btnMozo.setBounds(15, 90, 125, 32);
			}
			{
				btnMesa = new JButton();
				getContentPane().add(btnMesa);
				btnMesa.setText("MESAS");
				btnMesa.setAction(getABMMesaAccion());
				btnMesa.setBounds(160, 90, 125, 32);
			}
			{
				btnCarta = new JButton();
				getContentPane().add(btnCarta);
				btnCarta.setText("CARTAS");
				btnCarta.setAction(getABMCartaAccion());
				btnCarta.setBounds(15, 160, 125, 32);

			}
			{
				btnItemCart = new JButton();
				getContentPane().add(btnItemCart);
				btnItemCart.setText("PLATOS / BEBIDAS");
				btnItemCart.setFont(new java.awt.Font("Tahoma",1,8));
				btnItemCart.setAction(getABMItemCartaAccion());
				btnItemCart.setBounds(160, 160, 125, 32);
			}
			pack();
			setSize(320, 240);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	private AbstractAction getABMProveedorAccion() {
		if(getABMProveedorAccion == null) {
			getABMProveedorAccion = new AbstractAction("PROVEEDORES", null) {
				public void actionPerformed(ActionEvent evt){
					SwingUtilities.invokeLater(new Runnable() {
						public void run() {
							FormABMProveedor inst = new FormABMProveedor();
							inst.setLocationRelativeTo(null);
							inst.setVisible(true);
						}
					});
				}
			};
		}
		return getABMProveedorAccion;
	}

	private AbstractAction getABMProductoAccion() {
		if(getABMProductoAccion== null) {
			getABMProductoAccion= new AbstractAction("PRODUCTOS", null) {
				public void actionPerformed(ActionEvent evt){
					SwingUtilities.invokeLater(new Runnable() {
						public void run() {
							FormABMProducto inst = new FormABMProducto();
							inst.setLocationRelativeTo(null);
							inst.setVisible(true);
						}
					});
				}
			};
		}
		return getABMProductoAccion;
	}

	private AbstractAction getABMMozoAccion() {
		getABMMozoAccion = new AbstractAction("MOZOS", null) {
			public void actionPerformed(ActionEvent evt){
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						FormABMMozo inst = new FormABMMozo();
						inst.setLocationRelativeTo(null);
						inst.setVisible(true);
					}
				});
			}
		};
		return getABMMozoAccion;
	}

//	FALTA CARGARLE EL MAIN DE MESAS ABM
	private AbstractAction getABMMesaAccion() {
		getABMMesaAccion = new AbstractAction("MESAS", null) {
			public void actionPerformed(ActionEvent evt){
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						FormABMMesa inst = new FormABMMesa();
						inst.setLocationRelativeTo(null);
						inst.setVisible(true);

					}
				});
			}
		};
		return getABMMesaAccion;
	}
	
	private AbstractAction getABMCartaAccion() {
		getABMCartaAccion = new AbstractAction("CARTAS", null) {
			public void actionPerformed(ActionEvent evt){
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						FormABMCarta inst = new FormABMCarta();
						inst.setLocationRelativeTo(null);
						inst.setVisible(true);
					}
				});
			}
		};
		return getABMCartaAccion;
	}

	private AbstractAction getABMItemCartaAccion() {
		getABMItemCartaAccion = new AbstractAction("PLATOS / BEBIDAS", null) {
			public void actionPerformed(ActionEvent evt){
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						FormABMItemDeCarta inst = new FormABMItemDeCarta();
						inst.setLocationRelativeTo(null);
						inst.setVisible(true);
					}
				});
			}
		};
		return getABMItemCartaAccion;
	}


}
