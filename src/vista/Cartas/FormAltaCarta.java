package vista.Cartas;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

import controlador.*;



public class FormAltaCarta extends javax.swing.JFrame {
	private JButton btnCrear;
	private AbstractAction aceptarAccion;
	private JComboBox jDias;
	private JLabel jLabel1;

	
	public FormAltaCarta() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
		getContentPane().setLayout(null);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("Crear Cartas");
			{
				btnCrear = new JButton();
				getContentPane().add(btnCrear);
				btnCrear.setText("CREAR");
				btnCrear.setBounds(86, 108, 118, 34);
				btnCrear.setAction(getAceptarAccion());
			}
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				getContentPane().add(getJDias());
				jLabel1.setText("Dia de Carta a Crear: ");
				jLabel1.setBounds(12, 31, 119, 34);
			}
			pack();
			setSize(300, 180);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private JComboBox getJDias() {
		if(jDias == null) {
			ComboBoxModel jDiasModel = 
				new DefaultComboBoxModel(
						new String[] { "lunes", "martes", "miercoles", "jueves", "viernes", "sabado", "domingo"});
			jDias = new JComboBox();
			jDias.setModel(jDiasModel);
			jDias.setBounds(149, 31, 131, 34);
		}
		return jDias;
	}

	private AbstractAction getAceptarAccion() {
		if(aceptarAccion == null) {
			aceptarAccion = new AbstractAction("CREAR", null) {
				public void actionPerformed(ActionEvent evt) {
					if(Restaurante.getRestaurante().altaDeCarta(jDias.getSelectedItem().toString())){
						JOptionPane.showMessageDialog(null, "Carta creada con exito.", "MENSAJE", JOptionPane.WARNING_MESSAGE);
					}else{
						JOptionPane.showMessageDialog(null, "El dia YA posee carta asignada", "Prohibido", JOptionPane.WARNING_MESSAGE);
					}
				}
			};
		}
		return aceptarAccion;
	}

}
