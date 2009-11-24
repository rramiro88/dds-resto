package vista.Comandas;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;


public class FormVender extends javax.swing.JFrame {
	private JButton btnGenerarComanda;
	private AbstractAction cerrarMesaAction;
	private AbstractAction cerrarFormAction;
	private AbstractAction generarComandaAction;
	private JButton btnCerrar;
	private JButton btnCerrarMesa;

	
	public FormVender() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("Ventas");
			this.setPreferredSize(new java.awt.Dimension(400, 200));
			{
				btnGenerarComanda = new JButton();
				getContentPane().add(btnGenerarComanda);
				btnGenerarComanda.setText("Generar Comanda");
				btnGenerarComanda.setBounds(12, 37, 171, 51);
				btnGenerarComanda.setFont(new java.awt.Font("Tahoma",1,11));
				btnGenerarComanda.setAction(getGenerarComandaAction());
			}
			{
				btnCerrarMesa = new JButton();
				getContentPane().add(btnCerrarMesa);
				btnCerrarMesa.setText("Cerrar Mesa");
				btnCerrarMesa.setBounds(210, 37, 171, 51);
				btnCerrarMesa.setFont(new java.awt.Font("Tahoma",1,11));
				btnCerrarMesa.setAction(getCerrarMesaAction());
			}
			{
				btnCerrar = new JButton();
				getContentPane().add(btnCerrar);
				btnCerrar.setText("Cerrar");
				btnCerrar.setBounds(12, 126, 369, 29);
				btnCerrar.setFont(new java.awt.Font("Tahoma",1,11));
				btnCerrar.setAction(getCerrarFormAction());
			}
			pack();
			this.setSize(400, 200);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	private AbstractAction getGenerarComandaAction() {
		if(generarComandaAction == null) {
			generarComandaAction = new AbstractAction("Generar Comanda", null) {
				public void actionPerformed(ActionEvent evt) {
					SwingUtilities.invokeLater(new Runnable() {
						public void run() {
							FormGenerarComanda inst = new FormGenerarComanda();
							inst.setLocationRelativeTo(null);
							inst.setVisible(true);
						}
					});
				}
			};
		}
		return generarComandaAction;
	}
	
	
	private AbstractAction getCerrarMesaAction() {
		if(cerrarMesaAction == null) {
			cerrarMesaAction = new AbstractAction("Cerrar Mesa", null) {
				public void actionPerformed(ActionEvent evt) {
					SwingUtilities.invokeLater(new Runnable() {
						public void run() {
							FormCerrarComanda inst = new FormCerrarComanda();
							inst.setLocationRelativeTo(null);
							inst.setVisible(true);
						}
					});
				}
			};
		}
		return cerrarMesaAction;
	}
	
	
	private AbstractAction getCerrarFormAction() {
		if(cerrarFormAction == null) {
			cerrarFormAction = new AbstractAction("Cerrar Ventana", null) {
				public void actionPerformed(ActionEvent evt) {
					dispose();
				}
			};
		}
		return cerrarFormAction;
	}

	
}
