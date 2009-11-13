package vista.Proveedores;

import java.awt.event.ActionEvent;
import java.util.Vector;
import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;

import controlador.*;


public class FormModificarProveedor extends javax.swing.JFrame {
	private JLabel lblCuit;
	private JLabel jLabel1;
	private JPanel jPanel1;
	private JLabel lblDomicilio;
	private JLabel lblRazonSocial;

	private JTextField txtIdBuscar;
	private JTextField txtCuit;
	private JTextField txtRazonSocial;
	private JTextField txtDomicilio;
	
//	private JButton btnCancelar;
	private JButton btnModificar;
	private JButton btnBuscar;

	private AbstractAction modificarAction;
	private AbstractAction buscarAction;
	private AbstractAction cancelarAction;

/** Auto-generated main method to display this JFrame
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				FormModificarProveedor inst = new FormModificarProveedor();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
*/

	public FormModificarProveedor() {
		super();
		initGUI();
	}
		
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("Actualizacion de Proveedores");
			getContentPane().setLayout(null);
			this.setPreferredSize(new java.awt.Dimension(400, 300));
			{
				lblCuit = new JLabel();
				getContentPane().add(lblCuit);
				lblCuit.setText("CUIT: ");
				lblCuit.setBounds(24, 25, 95, 14);
			}
			{
				txtIdBuscar = new JTextField();
				getContentPane().add(txtIdBuscar);
				txtIdBuscar.setBounds(137, 22, 147, 21);
			}
			{
				btnBuscar = new JButton();
				getContentPane().add(btnBuscar);
				btnBuscar.setText("Buscar");
				btnBuscar.setBounds(296, 22, 84, 21);
				btnBuscar.setFont(new java.awt.Font("Tahoma",1,11));
				btnBuscar.setAction(getBuscarAction());
			}
			{
				jPanel1 = new JPanel();
				getContentPane().add(jPanel1);
				jPanel1.setBounds(12, 65, 368, 123);
				jPanel1.setLayout(null);
				jPanel1.setBorder(BorderFactory.createTitledBorder(null, "DATOS PROVEEDOR", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma",1,11), new java.awt.Color(0,0,255)));
				{
					lblRazonSocial = new JLabel();
					jPanel1.add(lblRazonSocial);
					lblRazonSocial.setText("RAZON SOC: ");
					lblRazonSocial.setBounds(34, 55, 78, 21);
				}
				{
					lblDomicilio = new JLabel();
					jPanel1.add(lblDomicilio);
					lblDomicilio.setText("DOMICILIO: ");
					lblDomicilio.setBounds(34, 82, 78, 21);
				}
				{
					txtRazonSocial = new JTextField();
					jPanel1.add(txtRazonSocial);
					txtRazonSocial.setBounds(124, 55, 227, 21);
				}
				{
					txtDomicilio = new JTextField();
					jPanel1.add(txtDomicilio);
					jPanel1.add(getJLabel1());
					jPanel1.add(getTxtId());
					txtDomicilio.setBounds(124, 82, 227, 21);
				}
			}
			{
				btnModificar = new JButton();
				getContentPane().add(btnModificar);
				btnModificar.setText("Modificar");
				btnModificar.setBounds(93, 217, 91, 21);
				btnModificar.setFont(new java.awt.Font("Tahoma",1,11));
				btnModificar.setAction(getModificarAction());
			}
/*			{
				btnCancelar = new JButton();
				getContentPane().add(btnCancelar);
				btnCancelar.setText("Cancelar");
				btnCancelar.setBounds(212, 217, 91, 21);
				btnCancelar.setFont(new java.awt.Font("Tahoma",1,11));
				btnCancelar.setAction(getCancelarAction());
			}
*/			pack();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
		private AbstractAction getCancelarAction() {
			if(cancelarAction == null) {
				cancelarAction = new AbstractAction("Cancelar", null) {
					public void actionPerformed(ActionEvent evt) {
						System.exit(0);
					}
				};
			}
			return cancelarAction;
		}
		
		private AbstractAction getBuscarAction() {
			if(buscarAction == null) {
				buscarAction = new AbstractAction("Buscar", null) {
					public void actionPerformed(ActionEvent evt) {
						try{
							txtCuit.setText(txtIdBuscar.getText());
							Vector vmv = Restaurante.getRestaurante().getProveedoresView();
							int i = 0;
							do{
								ProveedorView mv = ((ProveedorView)vmv.elementAt(i));
								if (mv.getCuit().equals(txtIdBuscar.getText())){
									txtRazonSocial.setText(mv.getRazonsocial() );
									txtDomicilio.setText(mv.getDomicilio());
									break;
								}else
									++i;
							}while (i<vmv.size());
						}
						catch (Exception e){
							JOptionPane.showMessageDialog(null, "Debe ingresar un valor entero como CUIT de proveedor a buscar.", "Error en la carga de datos", JOptionPane.WARNING_MESSAGE);
							txtIdBuscar.setText("");
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
						Restaurante.getRestaurante().modificarProveedor((txtCuit.getText()), txtRazonSocial.getText(), (txtDomicilio.getText()));
						JOptionPane.showMessageDialog(null, "Proveedor actualizado con exito.", "Actualizacion de Datos", JOptionPane.INFORMATION_MESSAGE);
						txtIdBuscar.setText("");
						txtCuit.setText("");
						txtRazonSocial.setText("");
						txtDomicilio.setText("");
					}
				};
			}
			return modificarAction;
		}
		
		private JLabel getJLabel1() {
			if(jLabel1 == null) {
				jLabel1 = new JLabel();
				jLabel1.setText("CUIT: ");
				jLabel1.setBounds(34, 28, 78, 21);
			}
			return jLabel1;
		}

		private JTextField getTxtId() {
			if(txtCuit == null) {
				txtCuit = new JTextField();
				txtCuit.setBounds(124, 28, 124, 21);
				txtCuit.setEditable(false);
			}
			return txtCuit;
		}

	}
