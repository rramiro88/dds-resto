package vista;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import vista.Cartas.FormABMCarta;
import vista.Mesas.FormGenerarComanda;
import vista.Mozos.FormABMMozo;
import vista.Productos.FormABMProducto;
import vista.Proveedores.FormABMProveedor;
import vista.ItemsDeCarta.FormABMItemDeCarta;

public class FormMAIN extends javax.swing.JFrame {
	private JButton btnCancel;
	private JButton btnABM;
	private JButton btnProd;
	private JButton btnComandaAbrir;
	private JButton btnCarta;
	private JButton btnComandaCerrar;
	private JButton btnItemCart;
	
	private AbstractAction getABM;
	private AbstractAction getComandaAbrir;
	private AbstractAction getABMMesaAccion;
	private AbstractAction getABMCartaAccion;
	private AbstractAction getABMItemCartaAccion;
	private AbstractAction cancelarAccion;
	
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				FormMAIN inst = new FormMAIN();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public FormMAIN() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			getContentPane().setLayout(null);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("Restaurante");
			{
				btnABM = new JButton();
				getContentPane().add(btnABM);
				btnABM.setText("ABM");
				btnABM.setAction(getABM());
				btnABM.setBounds(15, 20, 125, 32);
			}
			{
				btnProd = new JButton();
				getContentPane().add(btnProd);
				btnProd.setText("PRODUCTOS");
				btnProd.setAction(getABM());
				btnProd.setBounds(160, 20, 125, 32);
			}
			{
				btnComandaAbrir = new JButton();
				getContentPane().add(btnComandaAbrir);
				btnComandaAbrir.setText("ABRIR COMANDA");
				btnComandaAbrir.setAction(getComandaAbrir());
				btnComandaAbrir.setBounds(15, 90, 125, 32);
			}
			{
				btnComandaCerrar = new JButton();
				getContentPane().add(btnComandaCerrar);
				btnComandaCerrar.setText("CERRAR COMANDA");
				btnComandaCerrar.setAction(getABMMesaAccion());
				btnComandaCerrar.setBounds(160, 90, 125, 32);
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
				btnItemCart.setText("ITEMS CARTA");
				btnItemCart.setAction(getABMItemCartaAccion());
				btnItemCart.setBounds(160, 160, 125, 32);
			}
			{
				btnCancel = new JButton();
				getContentPane().add(btnCancel);
				btnCancel.setText("SALIR");
				btnCancel.setAction(getCancelarAccion());
				btnCancel.setBounds(285, 240, 100, 20);
			}
			pack();
			setSize(400, 300);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	private AbstractAction getABM() {
		if(getABM == null) {
			getABM = new AbstractAction("ABM", null) {
				public void actionPerformed(ActionEvent evt){
					SwingUtilities.invokeLater(new Runnable() {
						public void run() {
							FormABMs inst = new FormABMs();
							inst.setLocationRelativeTo(null);
							inst.setVisible(true);
						}
					});
				}
			};
		}
		return getABM;
	}

	private AbstractAction getComandaAbrir() {
		getComandaAbrir = new AbstractAction("COMANDAS", null) {
			public void actionPerformed(ActionEvent evt){
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						FormGenerarComanda inst = new FormGenerarComanda();
						inst.setLocationRelativeTo(null);
						inst.setVisible(true);
					}
				});
			}
		};
		return getComandaAbrir;
	}

	private AbstractAction getABMMesaAccion() {
		getABMMesaAccion = new AbstractAction("MESAS", null) {
			public void actionPerformed(ActionEvent evt){
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {

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
		getABMItemCartaAccion = new AbstractAction("ITEMS CARTA", null) {
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
