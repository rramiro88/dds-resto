package vista.Productos;

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


public class FormIngresarMercaderia extends javax.swing.JFrame {
	private JLabel lblNombre;
	private JLabel jLabel1;
	private JLabel lblCantIng;
	private JLabel lblCantidad;

	private JTextField txtIdBuscar;
	private JTextField txtNombre;
	private JTextField txtCantidad;
	private JTextField txtCantIng;

	private AbstractAction modificarAction;
	private AbstractAction buscarAction;
	private AbstractAction cancelarAction;
	
	private JButton btnModificar;
	private JButton btnBuscar;

	private JPanel jPanel1;


	
	public FormIngresarMercaderia() {
		super();
		initGUI();
	}
		
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("Ingresar Mercaderia");
			getContentPane().setLayout(null);
			this.setPreferredSize(new java.awt.Dimension(400, 300));
			{
				lblNombre = new JLabel();
				getContentPane().add(lblNombre);
				lblNombre.setText("NOMBRE: ");
				lblNombre.setBounds(24, 12, 95, 14);
			}
			{
				txtIdBuscar = new JTextField();
				getContentPane().add(txtIdBuscar);
				txtIdBuscar.setBounds(137, 12, 147, 21);
			}
			{
				btnBuscar = new JButton();
				getContentPane().add(btnBuscar);
				btnBuscar.setText("Buscar");
				btnBuscar.setBounds(296, 12, 84, 21);
				btnBuscar.setFont(new java.awt.Font("Tahoma",1,11));
				btnBuscar.setAction(getBuscarAction());
			}
			{
				jPanel1 = new JPanel();
				getContentPane().add(jPanel1);
				jPanel1.setBounds(12, 44, 368, 178);
				jPanel1.setLayout(null);
				jPanel1.setBorder(BorderFactory.createTitledBorder(null, "DATOS PRODUCTO", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma",1,11), new java.awt.Color(0,0,255)));
				{
					lblCantidad = new JLabel();
					jPanel1.add(lblCantidad);
					lblCantidad.setText("CANTIDAD ACTUAL: ");
					lblCantidad.setBounds(17, 61, 149, 21);
				}
				{
					txtCantidad = new JTextField();
					jPanel1.add(txtCantidad);
					txtCantidad.setBounds(184, 61, 86, 21);
					txtCantidad.setEditable(false);
				}
				{
					lblCantIng = new JLabel();
					jPanel1.add(lblCantIng);
					lblCantIng.setText("CANTIDAD INGRESANTE: ");
					lblCantIng.setBounds(17, 94, 149, 21);
				}

				{
					txtCantIng = new JTextField();
					jPanel1.add(txtCantIng);
					jPanel1.add(getJLabel1());
					jPanel1.add(getTxtId());
					txtCantIng.setBounds(184, 94, 86, 21);
				}
				}

				{
					btnModificar = new JButton();
					getContentPane().add(btnModificar);
					btnModificar.setText("Modificar");
					btnModificar.setBounds(93, 234, 91, 21);
					btnModificar.setFont(new java.awt.Font("Tahoma",1,11));
					btnModificar.setAction(getModificarAction());
				}
				pack();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	private JLabel getJLabel1() {
		if(jLabel1 == null) {
			jLabel1 = new JLabel();
			jLabel1.setText("NOMBRE: ");
			jLabel1.setBounds(17, 28, 149, 21);
		}
		return jLabel1;
	}

	private JTextField getTxtId() {
		if(txtNombre == null) {
			txtNombre = new JTextField();
			txtNombre.setBounds(184, 26, 167, 21);
			txtNombre.setEditable(false);
		}
		return txtNombre;
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
						txtNombre.setText(txtIdBuscar.getText());
						Vector vmv = Restaurante.getRestaurante().getProductosView();
						int i = 0;
						do{
							ProductoView mv = ((ProductoView)vmv.elementAt(i));
							if (mv.getNombre().equals(txtIdBuscar.getText())){
								txtCantidad.setText(Float.toString(mv.getCantidad()));
								txtCantIng.setText("");
								break;
							}else
								++i;
						}while (i<vmv.size());
					}
					catch (Exception e){
						JOptionPane.showMessageDialog(null, "Debe ingresar el nombre del producto a buscar.", "Error en la carga de datos", JOptionPane.WARNING_MESSAGE);
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
					try{
						Restaurante.getRestaurante().ingresarMercaderia((txtNombre.getText()), Float.parseFloat((txtCantIng.getText())));
						JOptionPane.showMessageDialog(null, "Mercaderia ingresada con exito.", "Actualizacion de Stock", JOptionPane.INFORMATION_MESSAGE);
						txtIdBuscar.setText("");
						txtNombre.setText("");
						txtCantidad.setText("");
						txtCantIng.setText("");
					}
					catch  (Exception e){
						JOptionPane.showMessageDialog(null, "La cantidad debe ser un valor numérico.", "Error en la carga de datos", JOptionPane.WARNING_MESSAGE);
						txtCantIng.setText("");
					}
				}
			};
		}
		return modificarAction;
	}
		

}
