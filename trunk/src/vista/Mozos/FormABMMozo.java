package vista.Mozos;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;


public class FormABMMozo extends javax.swing.JFrame {
	private JButton btnAlta;
	private JButton btnModificar;
	private JButton btnEliminar;

	private AbstractAction getAltaMozoAccion;
	private AbstractAction getModificarMozoAccion;
	private AbstractAction getEliminarMozoAccion;
	
	
	public FormABMMozo() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			getContentPane().setLayout(null);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("ABM de Mozos");
			{
				btnAlta = new JButton();
				getContentPane().add(btnAlta);
				btnAlta.setText("CREAR MOZO");
				btnAlta.setAction(getAltaMozoAccion());
				btnAlta.setBounds(37, 12, 160, 35);

			}
			{
				btnModificar = new JButton();
				getContentPane().add(btnModificar);
				btnModificar.setText("MODIFICAR MOZO");
				btnModificar.setBounds(37, 57, 160, 35);
				btnModificar.setAction(getModificarMozoAccion());
			}
			{
				btnEliminar = new JButton();
				getContentPane().add(btnEliminar);
				btnEliminar.setText("ELIMINAR MOZO");
				btnEliminar.setAction(getEliminarMozoAccion());
				btnEliminar.setBounds(37, 102, 160, 35);

			}
			pack();
			setSize(274, 200);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	private AbstractAction getAltaMozoAccion() {
		if(getAltaMozoAccion == null) {
			getAltaMozoAccion = new AbstractAction("ALTA DE MOZO", null) {
				public void actionPerformed(ActionEvent evt){
						SwingUtilities.invokeLater(new Runnable() {
							public void run() {
								FormAltaMozo inst = new FormAltaMozo();
								inst.setLocationRelativeTo(null);
								inst.setVisible(true);
							}
						});
					}
			};
		}
		return getAltaMozoAccion;
	}

	
	private AbstractAction getModificarMozoAccion() {
		if(getModificarMozoAccion== null) {
			getModificarMozoAccion= new AbstractAction("MODIFICAR MOZO", null) {
				public void actionPerformed(ActionEvent evt){
						SwingUtilities.invokeLater(new Runnable() {
							public void run() {
								FormModificarMozo inst = new FormModificarMozo();
								inst.setLocationRelativeTo(null);
								inst.setVisible(true);
							}
						});
					}
			};
		}
		return getModificarMozoAccion;
	}

	
	private AbstractAction getEliminarMozoAccion() {
		getEliminarMozoAccion = new AbstractAction("ELIMINAR MOZO", null) {
			public void actionPerformed(ActionEvent evt){
					SwingUtilities.invokeLater(new Runnable() {
						public void run() {
							FormEliminarMozo inst = new FormEliminarMozo();
							inst.setLocationRelativeTo(null);
							inst.setVisible(true);
						}
					});
				}
		};
		return getEliminarMozoAccion;
	}

	
}
