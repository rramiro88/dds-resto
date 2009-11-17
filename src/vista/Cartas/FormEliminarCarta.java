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



public class FormEliminarCarta extends javax.swing.JFrame {
	private JButton btnEliminar;
	private AbstractAction aceptarAccion;
	private JComboBox jDias;
	private JLabel jLabel1;

	
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
				btnEliminar = new JButton();
				getContentPane().add(btnEliminar);
				btnEliminar.setText("ELIMINAR");
				btnEliminar.setBounds(86, 108, 118, 34);
				btnEliminar.setAction(getAceptarAccion());
			}
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				getContentPane().add(getJDias());
				jLabel1.setText("Dia de Carta a eliminar: ");
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
			aceptarAccion = new AbstractAction("ELIMINAR", null) {
				public void actionPerformed(ActionEvent evt) {
					if(Restaurante.getRestaurante().bajaDeCarta(jDias.getSelectedItem().toString())){
						JOptionPane.showMessageDialog(null, "Carta eliminada con exito.", "ATENCION", JOptionPane.WARNING_MESSAGE);
					}else{
						JOptionPane.showMessageDialog(null, "El dia no posee carta asignada", "Prohibido", JOptionPane.WARNING_MESSAGE);
					}
				}
			};
		}
		return aceptarAccion;
	}

}
