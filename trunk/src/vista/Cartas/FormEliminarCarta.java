package vista.Cartas;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import controlador.*;

public class FormEliminarCarta extends javax.swing.JFrame {
	private JButton btnCancel;
	private JButton btnEliminar;
	private AbstractAction cancelarAccion;
	private AbstractAction aceptarAccion;
	private JLabel jLabel1;
	private JTextField txtNombre;

/**
//	Auto-generated main method to display this JFrame
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				FormEliminarCarta inst = new FormEliminarCarta();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
*/
	
	public FormEliminarCarta() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			getContentPane().setLayout(null);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("Eliminar Cartas");
			{
				btnCancel = new JButton();
				getContentPane().add(btnCancel);
				btnCancel.setText("CANCELAR");
				btnCancel.setBounds(261, 225, 118, 34);
				btnCancel.setAction(getCancelarAccion());
			}
			{
				btnEliminar = new JButton();
				getContentPane().add(btnEliminar);
				btnEliminar.setText("ELIMINAR");
				btnEliminar.setBounds(132, 225, 118, 34);
				btnEliminar.setAction(getAceptarAccion());
			}
			{
				txtNombre = new JTextField();
				getContentPane().add(txtNombre);
				txtNombre.setBounds(135, 10, 244, 34);
			}
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("Dia de Carta: ");
				jLabel1.setBounds(12, 10, 110, 34);
			}
			pack();
			setSize(400, 300);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private AbstractAction getAceptarAccion() {
		if(aceptarAccion == null) {
			aceptarAccion = new AbstractAction("ELIMINAR", null) {
				public void actionPerformed(ActionEvent evt) {
					if(!Restaurante.getRestaurante().bajaDeCarta(txtNombre.getText())){
						JOptionPane.showMessageDialog(null, "Ingrese un dia de la semana.", "Error en la carga de datos", JOptionPane.WARNING_MESSAGE);
					}
					txtNombre.setText("");
				}
			};
		}
		return aceptarAccion;
	}
			
	private AbstractAction getCancelarAccion() {
		if(cancelarAccion == null) {
			cancelarAccion = new AbstractAction("CANCELAR", null) {
				public void actionPerformed(ActionEvent evt) {
					//aca va el codigo de lo que hace el boton
					System.exit(0);
				}
			};
		}
		return cancelarAccion;
	}
}
