package vista.Mesas;

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
public class FormABMMesa extends javax.swing.JFrame {
	private JButton btnAlta;
	private AbstractAction modificarMesaAction;
	private JButton btnModificar;
	private JButton btnEliminar;

	private AbstractAction getAltaMesaAccion;
	private AbstractAction getEliminarMesaAccion;
	

	public FormABMMesa() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			getContentPane().setLayout(null);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("ABM de Mesas");
			{
				btnAlta = new JButton();
				getContentPane().add(btnAlta);
				btnAlta.setText("CREAR MESA");
				btnAlta.setAction(getAltaMesaAccion());
				btnAlta.setBounds(40, 24, 160, 35);

			}
			{
				btnEliminar = new JButton();
				getContentPane().add(btnEliminar);
				getContentPane().add(getBtnModificar());
				btnEliminar.setText("ELIMINAR MESA");
				btnEliminar.setAction(getEliminarMesaAccion());
				btnEliminar.setBounds(40, 107, 160, 35);

			}
			pack();
			setSize(250, 200);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	private AbstractAction getAltaMesaAccion() {
		if(getAltaMesaAccion == null) {
			getAltaMesaAccion = new AbstractAction("ALTA DE MESA", null) {
				public void actionPerformed(ActionEvent evt){
						SwingUtilities.invokeLater(new Runnable() {
							public void run() {
								FormAltaMesa inst = new FormAltaMesa();
								inst.setLocationRelativeTo(null);
								inst.setVisible(true);
							}
						});
					}
			};
		}
		return getAltaMesaAccion;
	}


	private AbstractAction getEliminarMesaAccion() {
		getEliminarMesaAccion = new AbstractAction("ELIMINAR MESA", null) {
			public void actionPerformed(ActionEvent evt){
					SwingUtilities.invokeLater(new Runnable() {
						public void run() {
							FormEliminarMesa inst = new FormEliminarMesa();
							inst.setLocationRelativeTo(null);
							inst.setVisible(true);
						}
					});
				}
		};
		return getEliminarMesaAccion;
	}
	
	private JButton getBtnModificar() {
		if(btnModificar == null) {
			btnModificar = new JButton();
			btnModificar.setText("MODIFICAR MESA");
			btnModificar.setBounds(40, 67, 160, 35);
			btnModificar.setAction(getModificarMesaAction());
		}
		return btnModificar;
	}
	
	private AbstractAction getModificarMesaAction() {
		if(modificarMesaAction == null) {
			modificarMesaAction = new AbstractAction("MODIFICAR MESA", null) {
				public void actionPerformed(ActionEvent evt) {
					FormModificarMesa inst = new FormModificarMesa();
					inst.setLocationRelativeTo(null);
					inst.setVisible(true);
				}
			};
		}
		return modificarMesaAction;
	}

}
