package vista.Cartas;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;


public class FormABMCarta extends javax.swing.JFrame {
	private JButton btnModificar;
	private JButton btnAlta;
	private JButton btnEliminar;
//	private JButton btnCancel;

	private AbstractAction getAltaCartaAccion;
	private AbstractAction getModificarCartaAccion;
	private AbstractAction getEliminarCartaAccion;
//	private AbstractAction cancelarAccion;
	
/**
//	Auto-generated main method to display this JFrame
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				FormABMCarta inst = new FormABMCarta();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
*/
	
	public FormABMCarta() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			getContentPane().setLayout(null);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("ABM de Cartas");
			{
				btnAlta = new JButton();
				getContentPane().add(btnAlta);
				btnAlta.setText("CREAR CARTA");
				btnAlta.setAction(getAltaCartaAccion());
				btnAlta.setBounds(37, 12, 160, 35);

			}
			{
				btnModificar = new JButton();
				getContentPane().add(btnModificar);
				btnModificar.setText("MODIFICAR CARTA");
				btnModificar.setBounds(37, 57, 160, 35);
				btnModificar.setAction(getModificarCartaAccion());
			}
			{
				btnEliminar = new JButton();
				getContentPane().add(btnEliminar);
				btnEliminar.setText("ELIMINAR CARTA");
				btnEliminar.setAction(getEliminarCartaAccion());
				btnEliminar.setBounds(37, 102, 160, 35);

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
	
	private AbstractAction getAltaCartaAccion() {
		if(getAltaCartaAccion == null) {
			getAltaCartaAccion = new AbstractAction("ALTA DE CARTA", null) {
				public void actionPerformed(ActionEvent evt){
//					public static void main(String[] args) {
						SwingUtilities.invokeLater(new Runnable() {
							public void run() {
								FormAltaCarta inst = new FormAltaCarta();
								inst.setLocationRelativeTo(null);
								inst.setVisible(true);
							}
						});
					}

//				}
			};
		}
		return getAltaCartaAccion;
	}

	private AbstractAction getModificarCartaAccion() {
		if(getModificarCartaAccion== null) {
			getModificarCartaAccion= new AbstractAction("MODIFICAR CARTA", null) {
				public void actionPerformed(ActionEvent evt){
//					public static void main(String[] args) {
						SwingUtilities.invokeLater(new Runnable() {
							public void run() {
								FormModificarCarta inst = new FormModificarCarta();
								inst.setLocationRelativeTo(null);
								inst.setVisible(true);
							}
						});
					}
//				}
			};
		}
		return getModificarCartaAccion;
	}

	private AbstractAction getEliminarCartaAccion() {
		getEliminarCartaAccion = new AbstractAction("ELIMINAR CARTA", null) {
			public void actionPerformed(ActionEvent evt){
//				public static void main(String[] args) {
					SwingUtilities.invokeLater(new Runnable() {
						public void run() {
							FormEliminarCarta inst = new FormEliminarCarta();
							inst.setLocationRelativeTo(null);
							inst.setVisible(true);
						}
					});
				}
//			}
		};
		return getEliminarCartaAccion;
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