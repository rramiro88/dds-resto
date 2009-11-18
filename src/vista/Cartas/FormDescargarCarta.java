package vista.Cartas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.AbstractAction;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import controlador.*;



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
public class FormDescargarCarta extends javax.swing.JFrame {
	private JButton btnEliminar;
	private JButton btnElegir;
	private JComboBox cmbItemCarta;
	private JComboBox cmbCarta;

	private JLabel lblItemEliminar;
	private JLabel lblCartaEliminar;

	private AbstractAction aceptarAccion;
	private AbstractAction getElegirAccion;

	
	//	Auto-generated main method to display this JFrame
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				FormDescargarCarta inst = new FormDescargarCarta();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}


	
	public FormDescargarCarta() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
		getContentPane().setLayout(null);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("Eliminar Plato / Bebida de Carta");
			{
				btnEliminar = new JButton();
				getContentPane().add(btnEliminar);
				btnEliminar.setText("ELIMINAR");
				btnEliminar.setBounds(115, 120, 120, 35);
				btnEliminar.setAction(getAceptarAccion());
			}
			{
				btnElegir = new JButton();
				getContentPane().add(btnElegir);
				btnElegir.setText("ok");
				btnElegir.setBounds(275, 20, 50, 30);
				btnElegir.setAction(getElegirAccion());
			}
			{
				lblCartaEliminar = new JLabel();
				getContentPane().add(lblCartaEliminar);
				lblCartaEliminar.setText("Dia de Carta: ");
				lblCartaEliminar.setBounds(5, 20, 130, 30);
			}
			{
				lblItemEliminar = new JLabel();
				getContentPane().add(lblItemEliminar);
				lblItemEliminar.setText("Plato / Bebida a Eliminar: ");
				lblItemEliminar.setBounds(5, 60, 151, 30);
			}
			{
				cmbCarta = new JComboBox(new String[] { "lunes", "martes", "miércoles", "jueves", "viernes", "sábado", "domingo"});
				getContentPane().add(cmbCarta);
				cmbCarta.setBounds(175, 20, 90, 30);
			}
			{
				cmbItemCarta = new JComboBox();
				getContentPane().add(cmbItemCarta);
				cmbItemCarta.setBounds(175, 60, 150, 30);
			}
			pack();
			setSize(350, 200);
		} catch (Exception e) {
			e.printStackTrace();
		}

	cmbCarta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (Restaurante.getRestaurante().buscarCarta(cmbCarta.getSelectedItem().toString()) != null){
					Vector platosBebidas = getPlatosBebidas(Restaurante.getRestaurante().getItemsDeCartaView(cmbCarta.getSelectedItem().toString()));
					cmbItemCarta.removeAllItems();
					cmbItemCarta = new JComboBox(platosBebidas);
				}else{
					JOptionPane.showMessageDialog(null, "El dia no posee carta asignada", "ATENCION", JOptionPane.WARNING_MESSAGE);
				}
			}
	});
	}

	
	private AbstractAction getElegirAccion() {
		if(getElegirAccion == null) {
			getElegirAccion = new AbstractAction("ok", null) {
				public void actionPerformed(ActionEvent evt) {
				}
			};
		}
		return getElegirAccion;
	}
	
	
	private AbstractAction getAceptarAccion() {
		if(aceptarAccion == null) {
			aceptarAccion = new AbstractAction("ELIMINAR", null) {
				public void actionPerformed(ActionEvent evt) {
/*					if(Restaurante.getRestaurante().bajaDeCarta(jDias.getSelectedItem().toString())){
						JOptionPane.showMessageDialog(null, "Carta eliminada con exito.", "ATENCION", JOptionPane.WARNING_MESSAGE);
					}else{
						JOptionPane.showMessageDialog(null, "El dia no posee carta asignada", "Prohibido", JOptionPane.WARNING_MESSAGE);
					}*/
				}
			};
		}
		return aceptarAccion;
	}

	public Vector getPlatosBebidas (Vector<ItemDeCartaView> v){
		Vector items = new Vector();
		for (int i= 0; i < v.size(); i++){
			items.add(v.elementAt(i).getNombre());
		}
		return items;
	}

	
}
