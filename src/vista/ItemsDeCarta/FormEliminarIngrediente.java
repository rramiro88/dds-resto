package vista.ItemsDeCarta;

import java.awt.event.ActionEvent;
import java.util.Vector;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

import controlador.*;


public class FormEliminarIngrediente extends javax.swing.JFrame {
	private JButton btnEliminar;

	private JComboBox cmbProductos;
	private JComboBox cmbItems;
	
	private JLabel lblItem;
	private JLabel lblProd;

	private AbstractAction eliminarAccion;

	
	public FormEliminarIngrediente() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
	getContentPane().setLayout(null);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("Eliminar Ingrediente");
			{
				btnEliminar = new JButton();
				getContentPane().add(btnEliminar);
				btnEliminar.setText("ELIMINAR");
				btnEliminar.setBounds(100, 140, 100, 25);
				btnEliminar.setAction(eliminarAccion());
			}
			{
				lblItem = new JLabel();
				getContentPane().add(lblItem);
				lblItem.setText("Plato/Bebida:");
				lblItem.setBounds(10, 20, 81, 25);
			}
			{
				lblProd = new JLabel();
				getContentPane().add(lblProd);
				lblProd.setText("Productos:");
				lblProd.setBounds(10, 65, 81, 25);
			}
			{
				Vector it = getProductosViewVector(Restaurante.getRestaurante().getProductosView());
				cmbProductos = new JComboBox(it);
				getContentPane().add(cmbProductos);
				cmbProductos.setBounds(103, 65, 177, 25);
			}
			{
				Vector vp = getItemsViewVector(Restaurante.getRestaurante().getItemsDeCartaView());
				cmbItems = new JComboBox(vp);
				getContentPane().add(cmbItems);
				cmbItems.setBounds(103, 20, 177, 25);
			}
			pack();
			setSize(300, 200);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	private AbstractAction eliminarAccion() {
		if(eliminarAccion == null) {
			eliminarAccion = new AbstractAction("ELIMINAR", null) {
				public void actionPerformed(ActionEvent evt) {
					String plabeb = cmbItems.getSelectedItem().toString();
					String producto = cmbProductos.getSelectedItem().toString();
					if( Restaurante.getRestaurante().descargarIngrediente(plabeb, producto) ){
						JOptionPane.showMessageDialog(null, "Ingrediente eliminado con exito.", "MENSAJE", JOptionPane.WARNING_MESSAGE);
						dispose();
					}else{
						JOptionPane.showMessageDialog(null, "El Plato/Bebida NO posee el ingrediente", "Prohibido", JOptionPane.WARNING_MESSAGE);
					}
				}
			};
		}
		return eliminarAccion;
	}

	
	public Vector getProductosViewVector(Vector<ProductoView> vpv){ 
		Vector mv = new Vector();
		for (int i= 0; i < vpv.size(); i++){
			String aux = String.valueOf(vpv.elementAt(i).getNombre()); 
			mv.add(aux);
		}
		return mv;
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
