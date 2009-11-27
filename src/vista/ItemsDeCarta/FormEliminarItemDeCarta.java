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


public class FormEliminarItemDeCarta extends javax.swing.JFrame {
	private JButton btnEliminar;

	private JLabel lblItemsCart;
	private JComboBox cmbItems;

	private AbstractAction eliminarAction;

	
	public FormEliminarItemDeCarta() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("Eliminar Plato/Bebida");
			this.setPreferredSize(new java.awt.Dimension(400, 150));
			{
				lblItemsCart = new JLabel();
				getContentPane().add(lblItemsCart);
				lblItemsCart.setText("Plato/Bebida a Eliminar: ");
				lblItemsCart.setBounds(15, 20, 153, 25);
			}
			{
				Vector vp = getItemsViewVector(Restaurante.getRestaurante().getItemsDeCartaView());
				cmbItems = new JComboBox(vp);
				getContentPane().add(cmbItems);
				cmbItems.setBounds(180, 20, 200, 25);
			}
			{
				btnEliminar = new JButton();
				getContentPane().add(btnEliminar);
				btnEliminar.setText("Eliminar");
				btnEliminar.setBounds(150, 80, 80, 35);
				btnEliminar.setFont(new java.awt.Font("Tahoma",1,11));
				btnEliminar.setAction(getEliminarAction());
			}
			pack();
			setSize(400, 150);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	private AbstractAction getEliminarAction() {
		if(eliminarAction == null) {
			eliminarAction = new AbstractAction("Eliminar", null) {
				public void actionPerformed(ActionEvent evt) {
					try{
					String nombre = cmbItems.getSelectedItem().toString();
					Restaurante.getRestaurante().bajaDeItemDeCarta(nombre);
					JOptionPane.showMessageDialog(null, "Plato/Bebida eliminado/a con exito.", "Resultado", JOptionPane.INFORMATION_MESSAGE);
					cmbItems.removeItemAt(cmbItems.getSelectedIndex());
					dispose();
					}catch  (Exception e){
						JOptionPane.showMessageDialog(null, "No hay platos/bebidas que eliminar.", "Error en la carga de datos", JOptionPane.WARNING_MESSAGE);
						dispose();
					}
				}
			};
		}
		return eliminarAction;
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
