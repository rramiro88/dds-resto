package vista.Mozos;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

import controlador.Restaurante;


public class FormEliminarMozo extends javax.swing.JFrame {
	private JLabel lblMozo;
	private AbstractAction eliminarAction;
	private AbstractAction cerrarAction;
//	private JButton btnCerrar;
	private JButton btnEliminar;
	private JComboBox cmbMozos;

/**
	Auto-generated main method to display this JFrame
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				FormEliminarMozo inst = new FormEliminarMozo();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
*/
	
	public FormEliminarMozo() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("Eliminar Mozo");
			this.setPreferredSize(new java.awt.Dimension(400, 150));
			{
				lblMozo = new JLabel();
				getContentPane().add(lblMozo);
				lblMozo.setText("SELECCIONAR MOZO: ");
				lblMozo.setBounds(12, 22, 132, 14);
			}
			{
				cmbMozos = new JComboBox(Restaurante.getRestaurante().getMozosViewVector());
				getContentPane().add(cmbMozos);
				cmbMozos.setBounds(156, 19, 224, 21);
			}
			{
				btnEliminar = new JButton();
				getContentPane().add(btnEliminar);
				btnEliminar.setText("Eliminar");
				btnEliminar.setBounds(86, 66, 92, 33);
				btnEliminar.setFont(new java.awt.Font("Tahoma",1,11));
				btnEliminar.setAction(getEliminarAction());
			}
/*			{
				btnCerrar = new JButton();
				getContentPane().add(btnCerrar);
				btnCerrar.setText("Cerrar");
				btnCerrar.setBounds(214, 67, 92, 32);
				btnCerrar.setFont(new java.awt.Font("Tahoma",1,11));
				btnCerrar.setAction(getCerrarAction());
			}
*/			pack();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private AbstractAction getEliminarAction() {
		if(eliminarAction == null) {
			eliminarAction = new AbstractAction("Eliminar", null) {
				public void actionPerformed(ActionEvent evt) {
					int id = Integer.parseInt(cmbMozos.getSelectedItem().toString().substring(1,4));
					Restaurante.getRestaurante().bajaDeMozo(id);
					cmbMozos.removeItemAt(cmbMozos.getSelectedIndex());
					JOptionPane.showMessageDialog(null, "Mozo eliminado con exito.", "Resultado", JOptionPane.INFORMATION_MESSAGE);
				}
			};
		}
		return eliminarAction;
	}
	
	private AbstractAction getCerrarAction() {
		if(cerrarAction == null) {
			cerrarAction = new AbstractAction("Cerrar", null) {
				public void actionPerformed(ActionEvent evt) {
					System.exit(0);
				}
			};
		}
		return cerrarAction;
	}

	
}
