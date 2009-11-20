package vista.ItemsDeCarta;

import java.awt.event.ActionEvent;
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

import controlador.*;



public class FormAgregarIngrediente extends javax.swing.JFrame {
	private JButton btnBuscar;
	private JButton btnAgregar;

	private JTextField txtItem;
	private JTextField txtCanti;

	private JComboBox cmbProductos;

	private JLabel lblCanti;
	private JLabel lblItem;
	private JLabel lblProd;

	private AbstractAction agregarAccion;
	private AbstractAction buscarAccion;

	
	public FormAgregarIngrediente() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
		getContentPane().setLayout(null);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("Agregar Ingrediente");
			{
				btnBuscar = new JButton();
				getContentPane().add(btnBuscar);
				btnBuscar.setText("BUSCAR");
				btnBuscar.setBounds(260, 15, 65, 25);
//				btnBuscar.setAction(buscarAccion());
			}
			{
				btnAgregar = new JButton();
				getContentPane().add(btnAgregar);
				btnAgregar.setText("AGREGAR");
				btnAgregar.setBounds(125, 140, 100, 25);
				btnAgregar.setAction(agregarAccion());
			}
			{
				lblItem = new JLabel();
				getContentPane().add(lblItem);
				lblItem.setText("Plato/Bebida:");
				lblItem.setBounds(10, 15, 70, 25);
			}
			{
				lblProd = new JLabel();
				getContentPane().add(lblProd);
				lblProd.setText("Productos:");
				lblProd.setBounds(10, 65, 70, 25);
			}
			{
				lblCanti = new JLabel();
				getContentPane().add(lblCanti);
				lblCanti.setText("Cantidad:");
				lblCanti.setBounds(10, 100, 70, 25);
			}
			{
				txtItem = new JTextField();
				getContentPane().add(txtItem);
				txtItem.setBounds(100, 15, 150, 25);
			}
			{
				txtCanti = new JTextField();
				getContentPane().add(txtCanti);
				txtCanti.setBounds(100, 100, 40, 25);
			}
			{
				Vector vp = getProductosViewVector(Restaurante.getRestaurante().getProductosView());
				cmbProductos = new JComboBox(vp);
				getContentPane().add(cmbProductos);
				cmbProductos.setBounds(100, 65, 225, 25);
			}
			pack();
			setSize(350, 200);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	private AbstractAction agregarAccion() {
		if(agregarAccion == null) {
			agregarAccion = new AbstractAction("AGREGAR", null) {
				public void actionPerformed(ActionEvent evt) {
					String nombre = getNombreProducto(cmbProductos.getSelectedItem().toString());
					if( Restaurante.getRestaurante().cargarIngrediente( (txtItem.getText()), nombre , Integer.parseInt(txtCanti.getText()) ) ){
						JOptionPane.showMessageDialog(null, "Ingrediente agregado con exito.", "MENSAJE", JOptionPane.WARNING_MESSAGE);
					}else{
						JOptionPane.showMessageDialog(null, "NO existe el Plato/Bebida o ya posee el ingrediente", "Prohibido", JOptionPane.WARNING_MESSAGE);
					}
				}
			};
		}
		return agregarAccion;
	}

	
	public Vector getProductosViewVector(Vector<ProductoView> vpv){ 
		Vector mv = new Vector();
		for (int i= 0; i < vpv.size(); i++){
			String aux = String.valueOf(vpv.elementAt(i).getNombre()) + "  "; 
			mv.add(aux);
		}
		return mv;
	}
	
	public String getNombreProducto(String s){
		int i = 0;
		String sAux = new String("");
		if (s.charAt(i) == '[')
			i++;
		while ((s.charAt(i) != ',') && (s.charAt(i) != ']' ) && (s.charAt(i) != ' ' ) && (s.charAt(i) != '-' )){
			sAux = sAux + s.charAt(i); 
			i++;
		}
		return sAux;
	}

	
}
