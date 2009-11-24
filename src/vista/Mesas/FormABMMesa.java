package vista.Mesas;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;


public class FormABMMesa extends javax.swing.JFrame {
	private JButton btnAlta;
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
				btnAlta.setBounds(40, 15, 160, 35);

			}
			{
				btnEliminar = new JButton();
				getContentPane().add(btnEliminar);
				btnEliminar.setText("ELIMINAR MESA");
				btnEliminar.setAction(getEliminarMesaAccion());
				btnEliminar.setBounds(40, 95, 160, 35);

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

	
}
