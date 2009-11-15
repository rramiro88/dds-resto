package vista;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import controlador.Restaurante;

import vista.Cartas.FormABMCarta;
import vista.Mesas.FormGenerarComanda;
import vista.OrdenesDeCompra.FormOrdenesDeCompra;
import vista.ItemsDeCarta.FormABMItemDeCarta;


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
public class FormMAIN extends javax.swing.JFrame {
	private JButton btnCancel;
	private JButton btnABM;
	private JButton btnIngresar;
	private JButton btnComandaAbrir;
	private JButton btnCarta;
	private JButton btnComandaCerrar;
	private JButton btnItemCart;
	
	private AbstractAction getABM;
	private AbstractAction getComandaAbrir;
	private AbstractAction getOrdenesDeCompra;
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
				btnABM.setBounds(10, 30, 180, 30);
			}
			{
				btnIngresar = new JButton();
				getContentPane().add(btnIngresar);
				btnIngresar.setText("ORDENES DE COMPRA");
				btnIngresar.setAction(getOrdenesDeCompra());
				btnIngresar.setBounds(205, 30, 180, 30);
			}
			{
				btnComandaAbrir = new JButton();
				getContentPane().add(btnComandaAbrir);
				btnComandaAbrir.setText("ABRIR COMANDA");
				btnComandaAbrir.setAction(getComandaAbrir());
				btnComandaAbrir.setBounds(10, 90, 180, 30);
			}
			{
				btnComandaCerrar = new JButton();
				getContentPane().add(btnComandaCerrar);
				btnComandaCerrar.setText("CERRAR COMANDA");
				//btnComandaCerrar.setAction(getABMMesaAccion());
				btnComandaCerrar.setBounds(205, 90, 180, 30);
			}
			{
				btnCarta = new JButton();
				getContentPane().add(btnCarta);
				btnCarta.setText("sin asignar");
				//btnCarta.setAction(getABMCartaAccion());
				btnCarta.setBounds(10, 150, 180, 30);

			}
			{
				btnItemCart = new JButton();
				getContentPane().add(btnItemCart);
				btnItemCart.setText("sin asignar");
				//btnItemCart.setAction(getABMItemCartaAccion());
				btnItemCart.setBounds(205, 150, 180, 30);
			}
			{
				btnCancel = new JButton();
				getContentPane().add(btnCancel);
				btnCancel.setText("SALIR");
				btnCancel.setAction(getCancelarAccion());
				btnCancel.setBounds(205, 240, 175, 25);
			}
			pack();
			this.setSize(400, 350);
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
							//	Revisa que el dia no halla sido abierto
							if (!Restaurante.getRestaurante().isOpen()){
								FormABMs inst = new FormABMs();
								inst.setLocationRelativeTo(null);
								inst.setVisible(true);
							}else{
								//	Si el dia esta abierto, no permite modificar los objetos
								JOptionPane.showMessageDialog(null, "Negocio abierto. No se puede modificar.", "Prohibido", JOptionPane.WARNING_MESSAGE);
							}
						}
					});
				}
			};
		}
		return getABM;
	}
	private AbstractAction getOrdenesDeCompra() {
		getOrdenesDeCompra = new AbstractAction("ORDENES DE COMPRA", null) {
			public void actionPerformed(ActionEvent evt){
//				public static void main(String[] args) {
					SwingUtilities.invokeLater(new Runnable() {
						public void run() {
							FormOrdenesDeCompra inst = new FormOrdenesDeCompra();
							inst.setLocationRelativeTo(null);
							inst.setVisible(true);
						}
					});
				}
			};
		return getOrdenesDeCompra;
	}


	private AbstractAction getComandaAbrir() {
		getComandaAbrir = new AbstractAction("ABRIR COMANDA", null) {
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
			cancelarAccion = new AbstractAction("SALIR", null) {
				public void actionPerformed(ActionEvent evt) {
					System.exit(0);
				}
			};
		}
		return cancelarAccion;
	}


}
