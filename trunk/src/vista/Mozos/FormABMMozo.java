package vista.Mozos;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;



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
				btnAlta.setBounds(55, 20, 160, 35);

			}
			{
				btnModificar = new JButton();
				getContentPane().add(btnModificar);
				btnModificar.setText("MODIFICAR MOZO");
				btnModificar.setBounds(55, 66, 160, 35);
				btnModificar.setAction(getModificarMozoAccion());
			}
			{
				btnEliminar = new JButton();
				getContentPane().add(btnEliminar);
				btnEliminar.setText("ELIMINAR MOZO");
				btnEliminar.setAction(getEliminarMozoAccion());
				btnEliminar.setBounds(55, 112, 160, 35);

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
