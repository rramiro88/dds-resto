package vista.ItemsDeCarta;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;


public class FormABMItemDeCarta extends javax.swing.JFrame {
	private JButton btnAltaItem;
	private JButton btnModificarItem;
	private JButton btnEliminarItem;
	private JButton btnCargar;
	private JButton btnDescargar;

	private AbstractAction getAltaItemDeCartaAccion;
	private AbstractAction getModificarItemDeCartaAccion;
	private AbstractAction getEliminarItemDeCartaAccion;
	private AbstractAction getCargarItemAccion;
	private AbstractAction getDescargarItemAccion;
	

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
				btnAltaItem = new JButton();
				getContentPane().add(btnAltaItem);
				btnAltaItem.setText("Alta de Plato/Bebida");
				btnAltaItem.setAction(getAltaItemDeCartaAccion());
				btnAltaItem.setBounds(35, 10, 170, 35);

			}
			{
				btnModificarItem = new JButton();
				getContentPane().add(btnModificarItem);
				btnModificarItem.setText("Modificar Plato/Bebida");
				btnModificarItem.setAction(getModificarItemDeCartaAccion());
				btnModificarItem.setBounds(35, 50, 170, 35);
			}
			{
				btnEliminarItem = new JButton();
				getContentPane().add(btnEliminarItem);
				btnEliminarItem.setText("Eliminar Plato/Bebida");
				btnEliminarItem.setAction(getEliminarItemDeCartaAccion());
				btnEliminarItem.setBounds(35, 90, 170, 35);
			}
			{
				btnCargar = new JButton();
				getContentPane().add(btnCargar);
				btnCargar.setText("Agregar Ingrediente");
				btnCargar.setAction(getCargarItemAccion());
				btnCargar.setBounds(35, 160, 170, 35);
			}
			{
				btnDescargar = new JButton();
				getContentPane().add(btnDescargar);
				btnDescargar.setText("Borrar Ingrediente");
				btnDescargar.setAction(getDescargarItemAccion());
				btnDescargar.setBounds(35, 200, 170, 35);
			}
			pack();
			setSize(250, 280);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	private AbstractAction getAltaItemDeCartaAccion() {
		if(getAltaItemDeCartaAccion == null) {
			getAltaItemDeCartaAccion = new AbstractAction("Alta de Plato/Bebida", null) {
				public void actionPerformed(ActionEvent evt){
					SwingUtilities.invokeLater(new Runnable() {
						public void run() {
							FormAltaItemDeCarta inst = new FormAltaItemDeCarta();
							inst.setLocationRelativeTo(null);
							inst.setVisible(true);
						}
					});
				}
			};
		}
		return getAltaItemDeCartaAccion;
	}


	private AbstractAction getModificarItemDeCartaAccion() {
		if(getModificarItemDeCartaAccion== null) {
			getModificarItemDeCartaAccion= new AbstractAction("Modificar Plato/Bebida", null) {
				public void actionPerformed(ActionEvent evt){
					SwingUtilities.invokeLater(new Runnable() {
						public void run() {
							FormModificarItemDeCarta inst = new FormModificarItemDeCarta();
							inst.setLocationRelativeTo(null);
							inst.setVisible(true);						
						}
					});
				}
			};
		}
		return getModificarItemDeCartaAccion;
	}

	private AbstractAction getEliminarItemDeCartaAccion() {
		getEliminarItemDeCartaAccion = new AbstractAction("Eliminar Plato/Bebida", null) {
			public void actionPerformed(ActionEvent evt){
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						FormEliminarItemDeCarta inst = new FormEliminarItemDeCarta();
						inst.setLocationRelativeTo(null);
						inst.setVisible(true);
					}
				});
			}
		};
		return getEliminarItemDeCartaAccion;
	}

	
	private AbstractAction getCargarItemAccion() {
		getCargarItemAccion = new AbstractAction("Agregar Ingrediente", null) {
			public void actionPerformed(ActionEvent evt){
					SwingUtilities.invokeLater(new Runnable() {
						public void run() {
							FormAgregarIngrediente inst = new FormAgregarIngrediente();
							inst.setLocationRelativeTo(null);
							inst.setVisible(true);
						}
					});
				}
		};
		return getCargarItemAccion;
	}

	private AbstractAction getDescargarItemAccion() {
		getDescargarItemAccion = new AbstractAction("Borrar Ingrediente", null) {
			public void actionPerformed(ActionEvent evt){
					SwingUtilities.invokeLater(new Runnable() {
						public void run() {
							FormEliminarIngrediente inst = new FormEliminarIngrediente();
							inst.setLocationRelativeTo(null);
							inst.setVisible(true);
						}
					});
				}
		};
		return getDescargarItemAccion;
	}

	
}
