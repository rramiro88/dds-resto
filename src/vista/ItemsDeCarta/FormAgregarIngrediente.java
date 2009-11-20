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
public class FormAgregarIngrediente extends javax.swing.JFrame {
	private JButton btnAgregar;

	private JTextField txtItem;
	private JTextField txtCanti;

	private JComboBox cmbProductos;
	private JComboBox cmbItems;
	
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
				lblItem.setBounds(10, 20, 70, 25);
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
				Vector it = getProductosViewVector(Restaurante.getRestaurante().getProductosView());
				cmbProductos = new JComboBox(it);
				getContentPane().add(cmbProductos);
				cmbProductos.setBounds(100, 65, 180, 25);
			}
			{
				Vector vp = getItemsViewVector(Restaurante.getRestaurante().getItemsDeCartaView());
				cmbItems = new JComboBox(vp);
				getContentPane().add(cmbItems);
				cmbItems.setBounds(100, 20, 180, 25);
			}
			{
				txtCanti = new JTextField();
				getContentPane().add(txtCanti);
				txtCanti.setBounds(100, 100, 40, 25);
			}
			pack();
			setSize(300, 200);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	private AbstractAction agregarAccion() {
		if(agregarAccion == null) {
			agregarAccion = new AbstractAction("AGREGAR", null) {
				public void actionPerformed(ActionEvent evt) {
					String plabeb = getNombreItem(cmbProductos.getSelectedItem().toString());
					String producto = getNombreProducto(cmbProductos.getSelectedItem().toString());
					if( Restaurante.getRestaurante().cargarIngrediente( plabeb, producto , Integer.parseInt(txtCanti.getText()) ) ){
						JOptionPane.showMessageDialog(null, "Ingrediente agregado con exito.", "MENSAJE", JOptionPane.WARNING_MESSAGE);
					}else{
						JOptionPane.showMessageDialog(null, "El Plato/Bebida ya posee el ingrediente", "Prohibido", JOptionPane.WARNING_MESSAGE);
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
	
	public Vector getItemsViewVector(Vector<ItemDeCartaView> vpv){ 
		Vector mv = new Vector();
		for (int i= 0; i < vpv.size(); i++){
			String aux = String.valueOf(vpv.elementAt(i).getNombre()) + "  "; 
			mv.add(aux);
		}
		return mv;
	}

	
	public String getNombreItem(String s){
		int i = 0;
		String sAux = new String("");
		if (s.charAt(i) == '[')
			i++;
		while ((s.charAt(i) != ',') && (s.charAt(i) != ']' ) && (s.charAt(i) != '-' )){
			sAux = sAux + s.charAt(i); 
			i++;
		}
		return sAux;
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
