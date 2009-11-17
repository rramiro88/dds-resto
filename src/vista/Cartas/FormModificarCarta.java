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



public class FormModificarCarta extends javax.swing.JFrame {
	private JButton btnEliminar;
	private AbstractAction aceptarAccion;
	private JComboBox cmbDiaNuevo;
	private JLabel jLabel2;
	private JComboBox cmbDiaViejo;
	private JLabel jLabel1;

	
	public FormModificarCarta() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
		getContentPane().setLayout(null);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("Modificar Dia de Carta");
			{
				btnEliminar = new JButton();
				getContentPane().add(btnEliminar);
				btnEliminar.setText("MODIFICAR");
				btnEliminar.setBounds(86, 108, 118, 34);
				btnEliminar.setAction(getAceptarAccion());
			}
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				getContentPane().add(getJDias());
				getContentPane().add(getJComboBox1());
				getContentPane().add(getJLabel2());
				jLabel1.setText("Carta Original:");
				jLabel1.setBounds(12, 12, 119, 34);
			}
			pack();
			setSize(300, 180);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private JComboBox getJDias() {
		if(cmbDiaViejo == null) {
			ComboBoxModel jDiasModel = 
				new DefaultComboBoxModel(
						new String[] { "lunes", "martes", "miercoles", "jueves", "viernes", "sabado", "domingo"});
			cmbDiaViejo = new JComboBox();
			cmbDiaViejo.setModel(jDiasModel);
			cmbDiaViejo.setBounds(149, 12, 131, 34);
		}
		return cmbDiaViejo;
	}

	private AbstractAction getAceptarAccion() {
		if(aceptarAccion == null) {
			aceptarAccion = new AbstractAction("MODIFICAR", null) {
				public void actionPerformed(ActionEvent evt) {
					if(Restaurante.getRestaurante().modificarCarta(cmbDiaViejo.getSelectedItem().toString(), cmbDiaNuevo.getSelectedItem().toString())){
						JOptionPane.showMessageDialog(null, "Cartas modificadas con exito.", "MENSAJE", JOptionPane.WARNING_MESSAGE);
					}else{
						JOptionPane.showMessageDialog(null, "El dia original NO posee carta o el dia destino YA posee carta asignada", "Prohibido", JOptionPane.WARNING_MESSAGE);
					}
				}
			};
		}
		return aceptarAccion;
	}
	
	private JComboBox getJComboBox1() {
		if(cmbDiaNuevo == null) {
			ComboBoxModel jComboBox1Model = 
				new DefaultComboBoxModel(
						new String[] { "lunes", "martes", "miercoles", "jueves", "viernes", "sabado", "domingo"});
			cmbDiaNuevo = new JComboBox();
			cmbDiaNuevo.setModel(jComboBox1Model);
			cmbDiaNuevo.setBounds(149, 58, 131, 34);
		}
		return cmbDiaNuevo;
	}
	
	private JLabel getJLabel2() {
		if(jLabel2 == null) {
			jLabel2 = new JLabel();
			jLabel2.setText("Carta Destino: ");
			jLabel2.setBounds(12, 58, 119, 34);
		}
		return jLabel2;
	}

}
