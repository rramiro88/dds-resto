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
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;

import controlador.*;



public class FormModificarItemDeCarta extends javax.swing.JFrame {
	private JLabel lblNombre;
	private JLabel jLabel1;
	private JLabel lblPrecio;

	private JComboBox cmbItems;

	private JPanel jPanel1;

	private JButton btnCerrar;
	private JButton btnBuscar;
	private JButton btnModificar;

	private JTextField txtNombre;
	private JTextField txtPrecio;

	private AbstractAction modificarAction;
	private AbstractAction buscarAction;
	private AbstractAction cerrarAction;


	public FormModificarItemDeCarta() {
		super();
		initGUI();
	}
		
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("Actualizacion de Plato/Bebida");
			getContentPane().setLayout(null);
			this.setPreferredSize(new java.awt.Dimension(400, 250));
			{
				Vector vp = getItemsViewVector(Restaurante.getRestaurante().getItemsDeCartaView());
				cmbItems = new JComboBox(vp);
				getContentPane().add(cmbItems);
				cmbItems.setBounds(115, 15, 168, 21);
			}
			{
				lblNombre = new JLabel();
				getContentPane().add(lblNombre);
				lblNombre.setText("PLATO/BEBIDA: ");
				lblNombre.setBounds(20, 15, 95, 21);
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
				jPanel1.setBounds(12, 48, 368, 103);
				jPanel1.setLayout(null);
				jPanel1.setBorder(BorderFactory.createTitledBorder(null, "DATOS de PLATO/BEBIDA", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma",1,11), new java.awt.Color(0,0,255)));
				{
					lblPrecio = new JLabel();
					jPanel1.add(lblPrecio);
					lblPrecio.setText("PRECIO: ");
					lblPrecio.setBounds(17, 55, 149, 21);
				}
				{
					txtPrecio = new JTextField();
					jPanel1.add(txtPrecio);
					{
						txtNombre = new JTextField();
						jPanel1.add(txtNombre);
						jPanel1.add(getJLabel1());
						txtNombre.setBounds(178, 26, 173, 21);
					}
					txtPrecio.setBounds(178, 55, 86, 21);
				}
			}
				{
					btnModificar = new JButton();
					getContentPane().add(btnModificar);
					getContentPane().add(getBtnCerrar());
					btnModificar.setText("Modificar");
					btnModificar.setBounds(92, 173, 91, 21);
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
				jLabel1.setBounds(17, 29, 143, 14);
			}
			return jLabel1;
		}

		private JButton getBtnCerrar() {
			if(btnCerrar == null) {
				btnCerrar = new JButton();
				btnCerrar.setText("Cerrar");
				btnCerrar.setBounds(204, 173, 91, 21);
				btnCerrar.setFont(new java.awt.Font("Tahoma",1,11));
				btnCerrar.setAction(getCerrarAction());
			}
			return btnCerrar;
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
						String nombre = cmbItems.getSelectedItem().toString();
						Vector icv = Restaurante.getRestaurante().getItemsDeCartaView();
						txtNombre.setText("");
						txtPrecio.setText("");
						for (int i = 0; i<icv.size(); i++){
							ItemDeCartaView iv = ((ItemDeCartaView)icv.elementAt(i));
							if (iv.getNombre().equals(nombre)){
								txtNombre.setText(nombre);
								txtPrecio.setText(Float.toString(iv.getPrecio()));
							}
						if (i==icv.size())
							JOptionPane.showMessageDialog(null, "No se encontro el plato/bebida.", "Atencion", JOptionPane.WARNING_MESSAGE);
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
							String nombre = cmbItems.getSelectedItem().toString();
							Restaurante.getRestaurante().modificarItemDeCarta(nombre, txtNombre.getText(), Float.parseFloat(txtPrecio.getText()));
							JOptionPane.showMessageDialog(null, "Plato/bebida actualizado con exito.", "Actualizacion de Datos", JOptionPane.INFORMATION_MESSAGE);
							txtNombre.setText("");
							txtPrecio.setText("");
							dispose();
						}catch (Exception e){
							JOptionPane.showMessageDialog(null, "No se pudo actualizar. Llame al admin del sistema.", "Error en la carga de datos", JOptionPane.WARNING_MESSAGE);
						}
					}
				};
			}
			return modificarAction;
		}
		
		
	public Vector getItemsViewVector(Vector<ItemDeCartaView> vpv){
		Vector mv = new Vector();
		for (int i= 0; i < vpv.size(); i++){
			String aux = String.valueOf(vpv.elementAt(i).getNombre()); 
			mv.add(aux);
		}
		return mv;
	}


}
