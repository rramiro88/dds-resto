package vista.Mesas;
import java.awt.event.ActionEvent;
import java.util.Vector;

import javax.swing.AbstractAction;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import controlador.MesaView;
import controlador.MozoView;
import controlador.Restaurante;



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
public class FormModificarMesa extends javax.swing.JFrame {
	private JLabel lblMesas;
	private JButton btnEstado;
	private JCheckBox chkHabilitada;
	private AbstractAction setEstadoMesaAction;
	private AbstractAction cerrarAction;
	private AbstractAction getEstadoMesaAction;
	private JButton btnCerrar;
	private JButton btnModificar;
	private JComboBox cmbMesas;
	
	public FormModificarMesa() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("Modificar Mesa");
			getContentPane().setLayout(null);
			this.setPreferredSize(new java.awt.Dimension(400, 200));
			{
				lblMesas = new JLabel();
				getContentPane().add(lblMesas);
				lblMesas.setText("Mesas dadas de alta: ");
				lblMesas.setBounds(12, 32, 144, 14);
				lblMesas.setFont(new java.awt.Font("Tahoma",1,11));
			}
			{
				Vector mesasAsignadas = getMesasVector(Restaurante.getRestaurante().getMesasView());
				cmbMesas = new JComboBox(mesasAsignadas);
				getContentPane().add(cmbMesas);
				cmbMesas.setBounds(168, 29, 65, 21);
			}
			{
				btnEstado = new JButton();
				getContentPane().add(btnEstado);
				btnEstado.setText("Get Estado");
				btnEstado.setBounds(270, 25, 111, 30);
				btnEstado.setAction(getGetEstadoMesaAction());
			}
			{
				chkHabilitada = new JCheckBox();
				getContentPane().add(chkHabilitada);
				chkHabilitada.setText("HABILITADA");
				chkHabilitada.setBounds(168, 68, 111, 18);
				chkHabilitada.setFont(new java.awt.Font("Tahoma",1,11));
			}
			{
				btnModificar = new JButton();
				getContentPane().add(btnModificar);
				btnModificar.setText("Set Estado");
				btnModificar.setBounds(66, 113, 111, 30);
				btnModificar.setAction(getSetEstadoMesaAction());
			}
			{
				btnCerrar = new JButton();
				getContentPane().add(btnCerrar);
				btnCerrar.setText("Cerrar");
				btnCerrar.setBounds(215, 113, 111, 30);
				btnCerrar.setAction(getCerrarAction());
			}
			pack();
			this.setSize(400, 200);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private AbstractAction getGetEstadoMesaAction() {
		if(getEstadoMesaAction == null) {
			getEstadoMesaAction = new AbstractAction("Get Estado", null) {
				public void actionPerformed(ActionEvent evt) {
					try{
						Vector vmv = Restaurante.getRestaurante().getMesasView();
						int i = 0;
						do{
							MesaView mv = ((MesaView)vmv.elementAt(i));
							if (Integer.toString(mv.getNroMesa()).equals(cmbMesas.getSelectedItem().toString())){
								if (mv.isHabilitada())
									chkHabilitada.setSelected(true);
								else
									chkHabilitada.setSelected(false);
								break;
							}else
								++i;
						}while (i<vmv.size());
						if (i==vmv.size()){
							JOptionPane.showMessageDialog(null, "No se encontro la mesa = " + cmbMesas.getSelectedItem().toString(), "Dato no encontrado", JOptionPane.WARNING_MESSAGE);
						}
					}
					catch (Exception e){
						JOptionPane.showMessageDialog(null, "Debe ingresar un valor válido como número de mesa.", "Error en la carga de datos", JOptionPane.WARNING_MESSAGE);
					}
				}
			};
		}
		return getEstadoMesaAction;
	}
	
	private AbstractAction getSetEstadoMesaAction() {
		if(setEstadoMesaAction == null) {
			setEstadoMesaAction = new AbstractAction("Set Estado", null) {
				public void actionPerformed(ActionEvent evt) {
					Restaurante.getRestaurante().modificarMesa(Integer.parseInt(cmbMesas.getSelectedItem().toString()),chkHabilitada.isSelected());
					JOptionPane.showMessageDialog(null, "Mesa actualizada con exito.", "Actualizacion de Datos", JOptionPane.INFORMATION_MESSAGE);
				}
			};
		}
		return setEstadoMesaAction;
	}
	
	private AbstractAction getCerrarAction() {
		if(cerrarAction == null) {
			cerrarAction = new AbstractAction("Cerrar", null) {
				public void actionPerformed(ActionEvent evt) {
					dispose();
				}
			};
		}
		return cerrarAction;
	}
	
	
	public Vector getMesasVector (Vector<MesaView> v){
		Vector asignadas = new Vector();
		for (int i= 0; i < v.size(); i++){
			asignadas.add(v.elementAt(i).getNroMesa());
		}
		return asignadas;
	}

}
