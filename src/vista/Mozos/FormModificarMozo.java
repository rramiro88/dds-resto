package vista.Mozos;

import java.awt.event.ActionEvent;
import java.util.Vector;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;

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
public class FormModificarMozo extends javax.swing.JFrame {
	private JTextField txtIdBuscar;
	private JTextField txtId;
	private JCheckBox chkHabilitado;
	private JTextField txtNombre;
	private JTextField txtComision;

	private JLabel lblComision;
	private JLabel lblNombre;
	private JLabel lblId;
	private JLabel jLabel1;
	private JPanel jPanel1;

	private JButton btnCancelar;
	private JButton btnModificar;
	private JButton btnBuscar;

	private AbstractAction modificarAction;
	private AbstractAction buscarAction;
	private AbstractAction cerrarAction;

/**
	Auto-generated main method to display this JFrame
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				FormModificarMozo inst = new FormModificarMozo();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
*/
	
	public FormModificarMozo() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("Actualización de Mozos");
			getContentPane().setLayout(null);
			this.setPreferredSize(new java.awt.Dimension(400, 300));
			{
				lblId = new JLabel();
				getContentPane().add(lblId);
				lblId.setText("ID DE MOZO: ");
				lblId.setBounds(24, 25, 95, 14);
			}
			{
				txtIdBuscar = new JTextField();
				getContentPane().add(txtIdBuscar);
				txtIdBuscar.setBounds(137, 22, 36, 21);
			}
			{
				btnBuscar = new JButton();
				getContentPane().add(btnBuscar);
				btnBuscar.setText("Buscar");
				btnBuscar.setBounds(212, 22, 84, 21);
				btnBuscar.setFont(new java.awt.Font("Tahoma",1,11));
				btnBuscar.setAction(getBuscarAction());
			}
			{
				jPanel1 = new JPanel();
				getContentPane().add(jPanel1);
				jPanel1.setBounds(12, 65, 368, 123);
				jPanel1.setLayout(null);
				jPanel1.setBorder(BorderFactory.createTitledBorder(null, "DATOS MOZO", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma",1,11), new java.awt.Color(0,0,255)));
				{
					lblNombre = new JLabel();
					jPanel1.add(lblNombre);
					lblNombre.setText("NOMBRE: ");
					lblNombre.setBounds(34, 55, 72, 21);
				}
				{
					lblComision = new JLabel();
					jPanel1.add(lblComision);
					lblComision.setText("COMISION: ");
					lblComision.setBounds(34, 82, 72, 21);
				}
				{
					txtNombre = new JTextField();
					jPanel1.add(txtNombre);
					txtNombre.setBounds(124, 55, 227, 21);
				}
				{
					txtComision = new JTextField();
					jPanel1.add(txtComision);
					jPanel1.add(getJLabel1());
					jPanel1.add(getTxtId());
					jPanel1.add(getChkHabilitado());
					txtComision.setBounds(124, 82, 62, 21);
				}
			}
			{
				btnModificar = new JButton();
				getContentPane().add(btnModificar);
				btnModificar.setText("Modificar");
				btnModificar.setBounds(93, 217, 91, 28);
				btnModificar.setFont(new java.awt.Font("Tahoma",1,11));
				btnModificar.setAction(getModificarAction());
			}
			{
				btnCancelar = new JButton();
				getContentPane().add(btnCancelar);
				btnCancelar.setText("Cancelar");
				btnCancelar.setBounds(212, 217, 91, 28);
				btnCancelar.setFont(new java.awt.Font("Tahoma",1,11));
				btnCancelar.setAction(getCerrarAction());
			}
			pack();
		} catch (Exception e) {
			e.printStackTrace();
		}
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
	
	private AbstractAction getBuscarAction() {
		if(buscarAction == null) {
			buscarAction = new AbstractAction("Buscar", null) {
				public void actionPerformed(ActionEvent evt) {
					try{
						txtId.setText(txtIdBuscar.getText());
						Vector vmv = Restaurante.getRestaurante().getMozosView();
						int i = 0;
						do{
							MozoView mv = ((MozoView)vmv.elementAt(i));
							if (Integer.toString(mv.getId()).equals(txtIdBuscar.getText())){
								txtNombre.setText(mv.getNombre());
								txtComision.setText(Integer.toString(mv.getComision()));
								if (mv.isHabilitado())
									chkHabilitado.setSelected(true);
								else
									chkHabilitado.setSelected(false);
								break;
							}else
								++i;
						}while (i<vmv.size());
						if (i==vmv.size()){
							JOptionPane.showMessageDialog(null, "No se encontro mozo con ID = " + txtIdBuscar.getText(), "Dato no encontrado", JOptionPane.WARNING_MESSAGE);
							txtIdBuscar.setText("");
							txtId.setText("");
						}
					}
					catch (Exception e){
						JOptionPane.showMessageDialog(null, "Debe ingresar un valor entero como ID de mozo a buscar.", "Error en la carga de datos", JOptionPane.WARNING_MESSAGE);
						txtIdBuscar.setText("");
						txtId.setText("");
					}
				}
			};
		}
		return buscarAction;
	}
	
	private AbstractAction getModificarAction() {
		if(modificarAction == null) {
			modificarAction = new AbstractAction("Modificar", null) {
				public void actionPerformed(ActionEvent evt) {
					Restaurante.getRestaurante().modificarMozo(Integer.parseInt(txtId.getText()), txtNombre.getText(), Integer.parseInt(txtComision.getText()), chkHabilitado.isSelected());
					JOptionPane.showMessageDialog(null, "Mozo actualizado con exito.", "Actualizacion de Datos", JOptionPane.INFORMATION_MESSAGE);
					txtIdBuscar.setText("");
					txtId.setText("");
					txtNombre.setText("");
					txtComision.setText("");
					chkHabilitado.setSelected(false);
				}
			};
		}
		return modificarAction;
	}
	
	private JLabel getJLabel1() {
		if(jLabel1 == null) {
			jLabel1 = new JLabel();
			jLabel1.setText("ID: ");
			jLabel1.setBounds(34, 28, 18, 21);
		}
		return jLabel1;
	}
	
	private JTextField getTxtId() {
		if(txtId == null) {
			txtId = new JTextField();
			txtId.setBounds(124, 28, 30, 21);
			txtId.setEditable(false);
		}
		return txtId;
	}
	
	private JCheckBox getChkHabilitado() {
		if(chkHabilitado == null) {
			chkHabilitado = new JCheckBox();
			chkHabilitado.setText("HABILITADO");
			chkHabilitado.setBounds(244, 83, 108, 18);
		}
		return chkHabilitado;
	}

}
