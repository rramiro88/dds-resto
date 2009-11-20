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
	private JButton btnCargar;
	private JButton btnDescargar;
	
	private AbstractAction getAltaCartaAccion;
	private AbstractAction getModificarCartaAccion;
	private AbstractAction getEliminarCartaAccion;
	private AbstractAction getCargarCartaAccion;
	private AbstractAction getDescargarCartaAccion;
	
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
				btnAlta.setBounds(40, 10, 160, 35);

			}
			{
				btnModificar = new JButton();
				getContentPane().add(btnModificar);
				btnModificar.setText("MODIFICAR CARTA");
				btnModificar.setBounds(40, 50, 160, 35);
				btnModificar.setAction(getModificarCartaAccion());
			}
			{
				btnEliminar = new JButton();
				getContentPane().add(btnEliminar);
				btnEliminar.setText("ELIMINAR CARTA");
				btnEliminar.setAction(getEliminarCartaAccion());
				btnEliminar.setBounds(40, 90, 160, 35);

			}
			{
				btnCargar = new JButton();
				getContentPane().add(btnCargar);
				btnCargar.setText("Agregar Plato/Bebida");
				btnCargar.setAction(getCargarCartaAccion());
				btnCargar.setBounds(40, 160, 160, 35);
			}
			{
				btnDescargar = new JButton();
				getContentPane().add(btnDescargar);
				btnDescargar.setText("Borrar Plato/Bebida");
				btnDescargar.setAction(getDescargarCartaAccion());
				btnDescargar.setBounds(40, 200, 160, 35);
			}
			pack();
			setSize(250, 280);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private AbstractAction getAltaCartaAccion() {
		if(getAltaCartaAccion == null) {
			getAltaCartaAccion = new AbstractAction("ALTA DE CARTA", null) {
				public void actionPerformed(ActionEvent evt){
					SwingUtilities.invokeLater(new Runnable() {
						public void run() {
							FormAltaCarta inst = new FormAltaCarta();
							inst.setLocationRelativeTo(null);
							inst.setVisible(true);
						}
					});
				}
			};
		}
		return getAltaCartaAccion;
	}

	private AbstractAction getModificarCartaAccion() {
		if(getModificarCartaAccion== null) {
			getModificarCartaAccion= new AbstractAction("MODIFICAR CARTA", null) {
			public void actionPerformed(ActionEvent evt){
					SwingUtilities.invokeLater(new Runnable() {
						public void run() {
							FormModificarCarta inst = new FormModificarCarta();
							inst.setLocationRelativeTo(null);
							inst.setVisible(true);
						}
					});
				}
			};
		}
		return getModificarCartaAccion;
	}

	private AbstractAction getEliminarCartaAccion() {
		getEliminarCartaAccion = new AbstractAction("ELIMINAR CARTA", null) {
			public void actionPerformed(ActionEvent evt){
					SwingUtilities.invokeLater(new Runnable() {
						public void run() {
							FormEliminarCarta inst = new FormEliminarCarta();
							inst.setLocationRelativeTo(null);
							inst.setVisible(true);
						}
					});
				}
		};
		return getEliminarCartaAccion;
	}

	private AbstractAction getCargarCartaAccion() {
		getCargarCartaAccion = new AbstractAction("Agregar Plato/Bebida", null) {
			public void actionPerformed(ActionEvent evt){
					SwingUtilities.invokeLater(new Runnable() {
						public void run() {
							FormCargarCarta inst = new FormCargarCarta();
							inst.setLocationRelativeTo(null);
							inst.setVisible(true);

						}
					});
				}
		};
		return getCargarCartaAccion;
	}

	private AbstractAction getDescargarCartaAccion() {
		getDescargarCartaAccion = new AbstractAction("Borrar Plato/Bebida", null) {
			public void actionPerformed(ActionEvent evt){
					SwingUtilities.invokeLater(new Runnable() {
						public void run() {
							FormDescargarCarta inst = new FormDescargarCarta();
							inst.setLocationRelativeTo(null);
							inst.setVisible(true);
						}
					});
				}
		};
		return getDescargarCartaAccion;
	}
	
	
}