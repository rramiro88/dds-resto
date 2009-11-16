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

	private AbstractAction getAltaItemDeCartaAccion;
	private AbstractAction getModificarItemDeCartaAccion;
	private AbstractAction getEliminarItemDeCartaAccion;
	

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
				btnAltaItem.setText("ALTA de ITEM");
				btnAltaItem.setAction(getAltaItemDeCartaAccion());
				btnAltaItem.setBounds(30, 12, 160, 35);

			}
			{
				btnModificarItem = new JButton();
				getContentPane().add(btnModificarItem);
				btnModificarItem.setText("MODIFICAR BEBIDA/PLATO");
				btnModificarItem.setAction(getModificarItemDeCartaAccion());
				btnModificarItem.setBounds(30, 57, 160, 35);
			}
			{
				btnEliminarItem = new JButton();
				getContentPane().add(btnEliminarItem);
				btnEliminarItem.setText("ELIMINAR BEBIDA/PLATO");
				btnEliminarItem.setAction(getEliminarItemDeCartaAccion());
				btnEliminarItem.setBounds(30, 102, 160, 35);
			}
			pack();
			setSize(250, 200);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private AbstractAction getAltaItemDeCartaAccion() {
		if(getAltaItemDeCartaAccion == null) {
			getAltaItemDeCartaAccion = new AbstractAction("ALTA ITEM", null) {
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
			getModificarItemDeCartaAccion= new AbstractAction("MODIFICAR ITEM", null) {
				public void actionPerformed(ActionEvent evt){
					SwingUtilities.invokeLater(new Runnable() {
						public void run() {
							FormModificarItemDeCarta inst = new FormModificarItemDeCarta();
						}
					});
				}
			};
		}
		return getModificarItemDeCartaAccion;
	}

	private AbstractAction getEliminarItemDeCartaAccion() {
		getEliminarItemDeCartaAccion = new AbstractAction("ELIMINAR ITEM", null) {
			public void actionPerformed(ActionEvent evt){
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
//						FormEliminarItemDeCarta inst = new FormEliminarItemDeCarta();
//						inst.setLocationRelativeTo(null);
//						inst.setVisible(true);
					}
				});
			}
		};
		return getEliminarItemDeCartaAccion;
	}
			
	
}
