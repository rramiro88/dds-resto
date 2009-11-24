package vista.Productos;

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



public class FormAltaProducto extends javax.swing.JFrame {
	private JLabel lblNombre;
	private JLabel lblPtoPedido;
	private JLabel lblPtoRefill;
	private JLabel lblProveedores;
	private JLabel lblCantidad;

	private JTextField txtNombre;
	private JTextField txtPtoRefill;
	private JTextField txtPtoPedido;
	private JTextField txtCantidad;

	private AbstractAction cerrarAction;
	private AbstractAction aceptarAction;
	
	private JButton btnCancelar;
	private JButton btnAceptar;
	
	private JComboBox cmbProveedores;
	

	
	public FormAltaProducto() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setPreferredSize(new java.awt.Dimension(480, 230));
			this.setTitle("Alta de Producto");
			{
				lblNombre = new JLabel();
				getContentPane().add(lblNombre);
				lblNombre.setText("NOMBRE: ");
				lblNombre.setBounds(12, 12, 229, 14);
			}
			{
				lblCantidad = new JLabel();
				getContentPane().add(lblCantidad);
				lblCantidad.setText("CANTIDAD: ");
				lblCantidad.setBounds(12, 35, 229, 14);
			}
			{
				lblPtoPedido = new JLabel();
				getContentPane().add(lblPtoPedido);
				lblPtoPedido.setText("PUNTO DE PEDIDO: ");
				lblPtoPedido.setBounds(12, 58, 229, 14);
			}
			{
				lblPtoRefill = new JLabel();
				getContentPane().add(lblPtoRefill);
				lblPtoRefill.setText("PUNTO DE REABASTECIMIENTO: ");
				lblPtoRefill.setBounds(12, 81, 229, 14);
			}
			{
				lblProveedores = new JLabel();
				getContentPane().add(lblProveedores);
				lblProveedores.setText("PROVEEDOR: ");
				lblProveedores.setBounds(12, 104, 229, 14);
			}
			{
				txtNombre = new JTextField();
				getContentPane().add(txtNombre);
				txtNombre.setBounds(223, 9, 237, 21);
			}
			{
				txtCantidad = new JTextField();
				getContentPane().add(txtCantidad);
				txtCantidad.setBounds(223, 32, 86, 21);
			}
			{
				txtPtoPedido = new JTextField();
				getContentPane().add(txtPtoPedido);
				txtPtoPedido.setBounds(223, 55, 86, 21);
			}
			{
				txtPtoRefill = new JTextField();
				getContentPane().add(txtPtoRefill);
				txtPtoRefill.setBounds(223, 78, 86, 21);
			}
			{
				Vector vp = getProveedoresViewVector(Restaurante.getRestaurante().getProveedoresView());
				cmbProveedores = new JComboBox(vp);
				getContentPane().add(cmbProveedores);
				cmbProveedores.setBounds(223, 101, 237, 21);
			}
			{
				btnAceptar = new JButton();
				getContentPane().add(btnAceptar);
				btnAceptar.setText("Aceptar");
				btnAceptar.setBounds(127, 151, 96, 25);
				btnAceptar.setFont(new java.awt.Font("Tahoma",1,11));
				btnAceptar.setAction(getAceptarAction());
			}
			{
				btnCancelar = new JButton();
				getContentPane().add(btnCancelar);
				btnCancelar.setText("Cancelar");
				btnCancelar.setBounds(253, 151, 96, 25);
				btnCancelar.setFont(new java.awt.Font("Tahoma",1,11));
				btnCancelar.setAction(getCerrarAction());
			}
			this.pack();
			this.setSize(480, 230);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	private AbstractAction getAceptarAction() {
		if(aceptarAction == null) {
			aceptarAction = new AbstractAction("Aceptar", null) {
				public void actionPerformed(ActionEvent evt) {
					try{
						String sProveedor = cmbProveedores.getSelectedItem().toString().substring(0,11);
						Restaurante.getRestaurante().altaDeProductoFromView(txtNombre.getText(), Integer.parseInt(txtCantidad.getText()), Integer.parseInt(txtPtoPedido.getText()), Integer.parseInt(txtPtoRefill.getText()), sProveedor);
						JOptionPane.showMessageDialog(null, "Producto creado con exito.", "Alta de Producto", JOptionPane.INFORMATION_MESSAGE);
						txtNombre.setText("");
						txtCantidad.setText("");
						txtPtoPedido.setText("");
						txtPtoRefill.setText("");
					}
					catch  (Exception e){
						JOptionPane.showMessageDialog(null, "Cantidad, punto de pedido y reabastecimiento deben contener valores enteros.", "Error en la carga de datos", JOptionPane.WARNING_MESSAGE);
					}
				}
			};
		}
		return aceptarAction;
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
	
	
	public Vector getProveedoresViewVector(Vector<ProveedorView> vpv){ 
		Vector mv = new Vector();
		for (int i= 0; i < vpv.size(); i++){
			String aux = String.valueOf(vpv.elementAt(i).getCuit()) + " - " + vpv.elementAt(i).getRazonsocial(); 
			mv.add(aux);
		}
		return mv;
	}

	
}
