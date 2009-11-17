package vista.ItemsDeCarta;

import java.awt.event.ActionEvent;
import java.util.Vector;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;

import controlador.*;


public class FormModificarItemDeCarta extends javax.swing.JFrame {
	private JLabel lblNombre;
	private JLabel lblProveedores;
	private JLabel jLabel1;
	private JLabel lblPtoPedido;
	private JLabel lblPrecio;
	private JLabel lblPtoRefill;

	private JTextField txtPtoPedido;
	private JTextField txtPtoRefill;
	private JTextField txtIdBuscar;
	private JTextField txtNombre;
	private JTextField txtCantidad;

	private JButton btnBuscar;
	private JButton btnModificar;

	private AbstractAction modificarAction;
	private AbstractAction buscarAction;
	private AbstractAction cancelarAction;

	private JPanel jPanel1;

	private JComboBox cmbProductos;


/** */	//	Auto-generated main method to display this JFrame
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				FormModificarItemDeCarta inst = new FormModificarItemDeCarta();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}


	public FormModificarItemDeCarta() {
		super();
		initGUI();
	}
		
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("Actualizacion de Plato/Bebida");
			getContentPane().setLayout(null);
			this.setPreferredSize(new java.awt.Dimension(400, 300));
			{
				lblNombre = new JLabel();
				getContentPane().add(lblNombre);
				lblNombre.setText("PLATO/BEBIDA: ");
				lblNombre.setBounds(20, 15, 95, 21);
			}
			{
				txtIdBuscar = new JTextField();
				getContentPane().add(txtIdBuscar);
				txtIdBuscar.setBounds(130, 15, 145, 21);
			}
			{
				btnBuscar = new JButton();
				getContentPane().add(btnBuscar);
				btnBuscar.setText("Buscar");
				btnBuscar.setBounds(295, 15, 85, 21);
				btnBuscar.setFont(new java.awt.Font("Tahoma",1,11));
				btnBuscar.setAction(getBuscarAction());
			}
			{
				jPanel1 = new JPanel();
				getContentPane().add(jPanel1);
				jPanel1.setBounds(12, 44, 368, 178);
				jPanel1.setLayout(null);
				jPanel1.setBorder(BorderFactory.createTitledBorder(null, "DATOS de PLATO/BEBIDA", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma",1,11), new java.awt.Color(0,0,255)));
				{
					lblPrecio = new JLabel();
					jPanel1.add(lblPrecio);
					lblPrecio.setText("PRECIO: ");
					lblPrecio.setBounds(17, 55, 149, 21);
				}
				{
					txtCantidad = new JTextField();
					jPanel1.add(txtCantidad);
					txtCantidad.setBounds(178, 55, 86, 21);
				}
				{
					lblPtoPedido = new JLabel();
					jPanel1.add(lblPtoPedido);
					lblPtoPedido.setText("PUNTO DE PEDIDO: ");
					lblPtoPedido.setBounds(17, 82, 149, 21);
				}

				{
					txtPtoPedido = new JTextField();
					jPanel1.add(txtPtoPedido);
					jPanel1.add(getJLabel1());
					jPanel1.add(getTxtId());
				{
					lblPtoRefill = new JLabel();
					jPanel1.add(lblPtoRefill);
					lblPtoRefill.setText("PUNTO REABASTECIMIENTO: ");
					lblPtoRefill.setBounds(17, 109, 149, 21);
				}
				{
					txtPtoRefill = new JTextField();
					jPanel1.add(txtPtoRefill);
					txtPtoRefill.setBounds(178, 109, 86, 21);
				}
				{
					cmbProductos = new JComboBox(Restaurante.getRestaurante().getProductosViewVector());
					jPanel1.add(cmbProductos);
					cmbProductos.setBounds(91, 136, 266, 21);
				}
				{
					lblProveedores = new JLabel();
					jPanel1.add(lblProveedores);
					lblProveedores.setText("PRODUCTOS: ");
					lblProveedores.setBounds(17, 136, 68, 21);
				}
					txtPtoPedido.setBounds(178, 82, 86, 21);
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
							txtCantidad.setText("");
							txtPtoPedido.setText("");
							txtPtoRefill.setText("");
							do{
								ProductoView mv = ((ProductoView)vmv.elementAt(i));
								if (mv.getNombre().equals(txtIdBuscar.getText())){
									txtCantidad.setText(Float.toString(mv.getCantidad()));
									txtPtoPedido.setText(Float.toString(mv.getPuntoped()));
									txtPtoRefill.setText(Float.toString(mv.getPuntoreab()));
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
						String sProveedor = cmbProductos.getSelectedItem().toString().substring(1,12);
						Restaurante.getRestaurante().modificarProducto((txtNombre.getText()), Float.parseFloat(txtCantidad.getText()), Float.parseFloat((txtPtoPedido.getText())), Float.parseFloat(txtPtoRefill.getText()), Restaurante.getRestaurante().buscarProveedor(sProveedor));
						JOptionPane.showMessageDialog(null, "Producto actualizado con exito.", "Actualizacion de Datos", JOptionPane.INFORMATION_MESSAGE);
						txtIdBuscar.setText("");
						txtNombre.setText("");
						txtCantidad.setText("");
						txtPtoPedido.setText("");
						txtPtoRefill.setText("");
					}
				};
			}
			return modificarAction;
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
				txtNombre.setBounds(178, 28, 145, 21);
//				txtNombre.setEditable(false);
			}
			return txtNombre;
		}
		
		public Vector getIngredientesViewVector(Vector<IngredienteView> viv){ 
			Vector mv = new Vector();
			for (int i= 0; i < viv.size(); i++){
				String aux = String.valueOf(viv.elementAt(i).getProducto().getNombre() + " - " + viv.elementAt(i).getProducto().getCantidad()); 
				mv.add(aux);
			}
			return mv;
		}

	}
