package vista.Cartas;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import controlador.*;


public class FormAgregarPlatoBebida extends javax.swing.JFrame {
	private JButton btnAgregar;
	private JComboBox cmbCarta;
	private JTextField txtItem;
	private JLabel lblCarta;
	private JLabel lblItem;
	private AbstractAction agregarAccion;

	
	public FormAgregarPlatoBebida() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
		getContentPane().setLayout(null);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("Agregar Plato/Bebida");
			{
				btnAgregar = new JButton();
				getContentPane().add(btnAgregar);
				btnAgregar.setText("AGREGAR");
				btnAgregar.setBounds(86, 108, 118, 34);
				btnAgregar.setAction(agregarAccion());
			}
			{
				lblCarta = new JLabel();
				getContentPane().add(lblCarta);
				lblCarta.setText("Dia de Carta:");
				lblCarta.setBounds(10, 15, 90, 35);
			}
			{
				lblItem = new JLabel();
				getContentPane().add(lblItem);
				lblItem.setText("Plato/Bebida:");
				lblItem.setBounds(10, 60, 90, 35);
			}
			{
				String[] n = { "", "lunes", "martes", "miércoles", "jueves", "viernes", "sábado", "domingo"};
				cmbCarta = new JComboBox(n);
				getContentPane().add(cmbCarta);
				cmbCarta.setBounds(120, 15, 90, 35);
			}
			{
				txtItem = new JTextField();
				getContentPane().add(txtItem);
				txtItem.setBounds(120, 60, 150, 35);
			}
			pack();
			setSize(300, 180);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	private AbstractAction agregarAccion() {
		if(agregarAccion == null) {
			agregarAccion = new AbstractAction("AGREGAR", null) {
				public void actionPerformed(ActionEvent evt) {
					if( Restaurante.getRestaurante().cargarCarta( (cmbCarta.getSelectedItem().toString()) , (txtItem.getText()) ) ){
						JOptionPane.showMessageDialog(null, "Plato/Bebida agregado con exito.", "MENSAJE", JOptionPane.WARNING_MESSAGE);
					}else{
						JOptionPane.showMessageDialog(null, "El dia NO posee carta asignada o NO existe el Plato/Bebida", "Prohibido", JOptionPane.WARNING_MESSAGE);
					}
				}
			};
		}
		return agregarAccion;
	}

	
}
