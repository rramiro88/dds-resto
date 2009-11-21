package vista.Comandas;
import java.util.Vector;
import javax.swing.AbstractAction;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import controlador.MesaView;
import controlador.Restaurante;
import java.awt.event.ActionEvent;

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
public class FormCerrarComanda extends javax.swing.JFrame {
	private JLabel lblMesa;
	private JComboBox cmbMesas;
	private JLabel lblTotal;
	private AbstractAction cerrarMesaAction;
	private AbstractAction calcTotalAction;
	private JButton btnCerrarMesa;
	private JButton btnTotal;
	private JTextField txtTotal;

	/**
	* Auto-generated main method to display this JFrame
	*/
	/*public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				FormCerrarComanda inst = new FormCerrarComanda();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}*/
	
	public FormCerrarComanda() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("Cerrar Mesa");
			getContentPane().setLayout(null);
			this.setPreferredSize(new java.awt.Dimension(400, 200));
			{
				lblMesa = new JLabel();
				getContentPane().add(lblMesa);
				lblMesa.setText("SELECCIONE MESA: ");
				lblMesa.setBounds(12, 12, 146, 14);
			}
			{
				Vector mesasAbiertas = getMesasAbiertas(Restaurante.getRestaurante().getMesasView());
				cmbMesas = new JComboBox(mesasAbiertas);
				getContentPane().add(cmbMesas);
				cmbMesas.setBounds(170, 9, 54, 21);
			}
			{
				lblTotal = new JLabel();
				getContentPane().add(lblTotal);
				lblTotal.setText("TOTAL MESA: ");
				lblTotal.setBounds(78, 54, 146, 14);
				lblTotal.setFont(new java.awt.Font("Tahoma",1,11));
				lblTotal.setForeground(new java.awt.Color(0,0,255));
			}
			{
				txtTotal = new JTextField();
				getContentPane().add(txtTotal);
				txtTotal.setBounds(255, 51, 125, 21);
				txtTotal.setEditable(false);
				txtTotal.setFont(new java.awt.Font("Tahoma",1,11));
				txtTotal.setForeground(new java.awt.Color(255,0,0));
			}
			{
				btnTotal = new JButton();
				getContentPane().add(btnTotal);
				btnTotal.setText("Calcular Total");
				btnTotal.setBounds(255, 9, 126, 21);
				btnTotal.setFont(new java.awt.Font("Tahoma",1,11));
				btnTotal.setAction(getCalcTotalAction());
			}
			{
				btnCerrarMesa = new JButton();
				getContentPane().add(btnCerrarMesa);
				btnCerrarMesa.setText("Cerrar Mesa");
				btnCerrarMesa.setBounds(78, 100, 303, 29);
				btnCerrarMesa.setFont(new java.awt.Font("Tahoma",1,11));
				btnCerrarMesa.setAction(getCerrarMesaAction());
			}
			pack();
			this.setSize(400, 200);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private AbstractAction getCalcTotalAction() {
		if(calcTotalAction == null) {
			calcTotalAction = new AbstractAction("Calcular Total", null) {
				public void actionPerformed(ActionEvent evt) {
					float total = 0;
					try{
						total = Restaurante.getRestaurante().getTotalComanda(Integer.parseInt(cmbMesas.getSelectedItem().toString()));
						txtTotal.setText(String.valueOf(total));
					}
					catch (Exception e){
						JOptionPane.showMessageDialog(null, "No se pudo calcular el total de la mesa seleccionada.", "Error en el calculo del total", JOptionPane.WARNING_MESSAGE);
					}
					
				}
			};
		}
		return calcTotalAction;
	}
	
	private AbstractAction getCerrarMesaAction() {
		if(cerrarMesaAction == null) {
			cerrarMesaAction = new AbstractAction("Cerrar Mesa", null) {
				public void actionPerformed(ActionEvent evt) {
					try{
						Restaurante.getRestaurante().cerrarMesa(Integer.parseInt(cmbMesas.getSelectedItem().toString()));
						JOptionPane.showMessageDialog(null, "Mesa cerrada correctamente. Se esta imprimiendo el ticket fiscal.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
					}
					catch (Exception e){
						JOptionPane.showMessageDialog(null, "No se pudo cerrar la mesa seleccionada.", "Error en el cierre de la mesa", JOptionPane.WARNING_MESSAGE);
					}
					
				}
			};
		}
		return cerrarMesaAction;
	}

	public Vector getMesasAbiertas (Vector<MesaView> v){
		Vector mv = new Vector();
		for (int i= 0; i < v.size(); i++){
			if (v.elementAt(i).isOcupada())
				mv.add(v.elementAt(i).getNroMesa());
		}
		return mv;
	}
}
