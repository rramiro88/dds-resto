package vista.ItemsDeCarta;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;


public class FormABMItemDeCarta extends javax.swing.JFrame {
	private JButton btnAltaBebida;
	private JButton btnAltaPlato;
	private JButton btnModificar;
	private JButton btnEliminar;
//	private JButton btnCancel;

	private AbstractAction getAltaBebidaAccion;
	private AbstractAction getAltaPlatoAccion;
	private AbstractAction getModificarItemDeCartaAccion;
	private AbstractAction getEliminarItemDeCartaAccion;
//	private AbstractAction cancelarAccion;
	

/*//	Auto-generated main method to display this JFrame
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				FormABMItemDeCarta inst = new FormABMItemDeCarta();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
*/	
	public FormABMItemDeCarta() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			getContentPane().setLayout(null);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("ABM de Platos y Bebidas");
			{
				btnAltaBebida = new JButton();
				getContentPane().add(btnAltaBebida);
				btnAltaBebida.setText("ALTA de BEBIDA");
				btnAltaBebida.setAction(getAltaBebidaAccion());
				btnAltaBebida.setBounds(30, 12, 160, 35);

			}
			{
				btnAltaPlato = new JButton();
				getContentPane().add(btnAltaPlato);
				btnAltaPlato.setText("ALTA PLATO");
				btnAltaPlato.setAction(getAltaPlatoAccion());
				btnAltaPlato.setBounds(200, 12, 160, 35);
			}
			{
				btnModificar = new JButton();
				getContentPane().add(btnModificar);
				btnModificar.setText("MODIFICAR BEBIDA/PLATO");
				btnModificar.setAction(getModificarItemDeCartaAccion());
				btnModificar.setBounds(30, 57, 160, 35);
			}
			{
				btnEliminar = new JButton();
				getContentPane().add(btnEliminar);
				btnEliminar.setText("ELIMINAR BEBIDA/PLATO");
				btnEliminar.setAction(getEliminarItemDeCartaAccion());
				btnEliminar.setBounds(30, 102, 160, 35);
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
	
	private AbstractAction getAltaBebidaAccion() {
		if(getAltaBebidaAccion == null) {
			getAltaBebidaAccion = new AbstractAction("ALTA BEBIDA", null) {
				public void actionPerformed(ActionEvent evt){
//					public static void main(String[] args) {
						SwingUtilities.invokeLater(new Runnable() {
							public void run() {
								FormAltaBebida inst = new FormAltaBebida();
								inst.setLocationRelativeTo(null);
								inst.setVisible(true);
							}
						});
					}

//				}
			};
		}
		return getAltaBebidaAccion;
	}

	private AbstractAction getAltaPlatoAccion() {
		if(getAltaPlatoAccion == null) {
			getAltaPlatoAccion = new AbstractAction("ALTA PLATO", null) {
				public void actionPerformed(ActionEvent evt){
//					public static void main(String[] args) {
						SwingUtilities.invokeLater(new Runnable() {
							public void run() {
								FormAltaPlato inst = new FormAltaPlato();
								inst.setLocationRelativeTo(null);
								inst.setVisible(true);
							}
						});
					}

//				}
			};
		}
		return getAltaPlatoAccion;
	}

	private AbstractAction getModificarItemDeCartaAccion() {
		if(getModificarItemDeCartaAccion== null) {
			getModificarItemDeCartaAccion= new AbstractAction("MODIFICAR CARTA", null) {
				public void actionPerformed(ActionEvent evt){
//					public static void main(String[] args) {
						SwingUtilities.invokeLater(new Runnable() {
							public void run() {
								FormModificarItemDeCarta inst = new FormModificarItemDeCarta();
//								inst.setLocationRelativeTo(null);
//								inst.setVisible(true);
							}
						});
					}
//				}
			};
		}
		return getModificarItemDeCartaAccion;
	}

	private AbstractAction getEliminarItemDeCartaAccion() {
		getEliminarItemDeCartaAccion = new AbstractAction("ELIMINAR CARTA", null) {
			public void actionPerformed(ActionEvent evt){
//				public static void main(String[] args) {
					SwingUtilities.invokeLater(new Runnable() {
						public void run() {
							FormEliminarItemDeCarta inst = new FormEliminarItemDeCarta();
//							inst.setLocationRelativeTo(null);
//							inst.setVisible(true);
						}
					});
				}
//			}
		};
		return getEliminarItemDeCartaAccion;
	}
			
/*	private AbstractAction getCancelarAccion() {
		if(cancelarAccion == null) {
			cancelarAccion = new AbstractAction("CANCELAR", null) {
				public void actionPerformed(ActionEvent evt) {
					System.exit(0);
				}
			};
		}
		return cancelarAccion;
	}
*/
	
}