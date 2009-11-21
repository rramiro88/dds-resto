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
public class FormModificarItemDeCarta extends javax.swing.JFrame {
	private JLabel lblNombre;
	private JLabel lblProveedores;
	private JButton btnCerrar;
	private JLabel jLabel1;
	private JTextField txtNombre;
	private JLabel lblPrecio;

	private JTextField txtIdBuscar;
	private JTextField txtPrecio;

	private JButton btnBuscar;
	private JButton btnModificar;

	private AbstractAction modificarAction;
	private AbstractAction buscarAction;
	private AbstractAction cerrarAction;

	private JPanel jPanel1;



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
			this.setPreferredSize(new java.awt.Dimension(400, 250));
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
							Vector icv = Restaurante.getRestaurante().getItemsDeCartaView();
							int i = 0;
							txtNombre.setText("");
							txtPrecio.setText("");
							do{
								ItemDeCartaView iv = ((ItemDeCartaView)icv.elementAt(i));
								if (iv.getNombre().equals(txtIdBuscar.getText())){
									txtNombre.setText(txtIdBuscar.getText());
									txtPrecio.setText(Float.toString(iv.getPrecio()));
									break;
								}else
									++i;
							}while (i<icv.size());
							if (i==icv.size())
								JOptionPane.showMessageDialog(null, "No se encontro el plato/bebida.", "Atencion", JOptionPane.WARNING_MESSAGE);
						}
						catch (Exception e){
							JOptionPane.showMessageDialog(null, "Debe ingresar el nombre del plato/bebida a buscar.", "Error en la carga de datos", JOptionPane.WARNING_MESSAGE);
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
							Restaurante.getRestaurante().modificarItemDeCarta(txtNombre.getText(), Float.parseFloat(txtPrecio.getText()));
							JOptionPane.showMessageDialog(null, "Plato/bebida actualizado con exito.", "Actualizacion de Datos", JOptionPane.INFORMATION_MESSAGE);
							txtIdBuscar.setText("");
							txtNombre.setText("");
							txtPrecio.setText("");
						}catch (Exception e){
							JOptionPane.showMessageDialog(null, "No se pudo actualizar. Llame al admin del sistema.", "Error en la carga de datos", JOptionPane.WARNING_MESSAGE);
							txtIdBuscar.setText("");
						}
					}
				};
			}
			return modificarAction;
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
		
		private JLabel getJLabel1() {
			if(jLabel1 == null) {
				jLabel1 = new JLabel();
				jLabel1.setText("NOMBRE: ");
				jLabel1.setBounds(17, 29, 143, 14);
			}
			return jLabel1;
		}

		/*public Vector getIngredientesViewVector(Vector<IngredienteView> viv){ 
			Vector mv = new Vector();
			for (int i= 0; i < viv.size(); i++){
				String aux = String.valueOf(viv.elementAt(i).getProducto().getNombre() + " - " + viv.elementAt(i).getProducto().getCantidad()); 
				mv.add(aux);
			}
			return mv;
		}
*/

	}
