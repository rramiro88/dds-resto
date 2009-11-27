package vista.Mesas;

import java.awt.event.ActionEvent;
import java.util.Vector;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import controlador.*;


public class FormEliminarMesa extends javax.swing.JFrame {
	private JComboBox cmbMesas;
	private JButton btnEliminar;
	private JLabel lblCantidadMesas;
	private AbstractAction aceptarAccion;

	
	public FormEliminarMesa() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
		getContentPane().setLayout(null);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("Eliminar Mesas");
			{
				btnEliminar = new JButton();
				getContentPane().add(btnEliminar);
				btnEliminar.setText("ELIMINAR");
				btnEliminar.setBounds(110, 100, 120, 35);
				btnEliminar.setAction(getAceptarAccion());
			}
			{
				Vector mesasAsignadas = getMesasVector(Restaurante.getRestaurante().getMesasView());
				cmbMesas = new JComboBox(mesasAsignadas);
				getContentPane().add(cmbMesas);
				cmbMesas.setBounds(170, 30, 80, 30);
			}
			{
				lblCantidadMesas = new JLabel();
				getContentPane().add(lblCantidadMesas);
				lblCantidadMesas.setText("Nro de Mesa: ");
				lblCantidadMesas.setBounds(15, 30, 150, 35);
			}
			pack();
			setSize(340, 180);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	private AbstractAction getAceptarAccion() {
		if(aceptarAccion == null) {
			aceptarAccion = new AbstractAction("ELIMINAR", null) {
				public void actionPerformed(ActionEvent evt) {
					try{
						String sMesa = cmbMesas.getSelectedItem().toString();
						Restaurante.getRestaurante().bajaDeMesa(Integer.valueOf(sMesa));
						JOptionPane.showMessageDialog(null, "Mesa nro "+(Integer.valueOf(sMesa))+" eliminada", "Mensaje", JOptionPane.WARNING_MESSAGE);
						dispose();
					}catch  (Exception e){
						JOptionPane.showMessageDialog(null, "No hay mesas que eliminar.", "Error en la carga de datos", JOptionPane.WARNING_MESSAGE);
						dispose();
					}
				}
			};
		}
		return aceptarAccion;
	}

	
	public Vector getMesasVector (Vector<MesaView> v){
		Vector asignadas = new Vector();
		for (int i= 0; i < v.size(); i++){
			asignadas.add(v.elementAt(i).getNroMesa());
		}
		return asignadas;
	}
	
	
}
