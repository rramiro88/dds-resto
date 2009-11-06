import java.awt.Component;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;


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
public class FormAltaProducto2 extends javax.swing.JFrame {
	private JLabel lblNombre;
	private JTextField txtNombre;
	private AbstractAction abstractAceptarAction;
	private JButton btnListar;
	private JButton btnAceptar;
	private JComboBox cmbProveedores;
	private JLabel txtProveedores;
	private JTextField txtPtoRefill;
	private JLabel lblPtoRefill;
	private JTextField txtPtoPedido;
	private JLabel lblPtoPedido;
	private JTextField txtCantidad;
	private JLabel lblCantidad;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				FormAltaProducto2 inst = new FormAltaProducto2();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public FormAltaProducto2() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			GroupLayout thisLayout = new GroupLayout((JComponent)getContentPane());
			getContentPane().setLayout(thisLayout);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				lblNombre = new JLabel();
				lblNombre.setText("Nombre: ");
			}
			{
				btnAceptar = new JButton();
				btnAceptar.setText("Aceptar");
				btnAceptar.setAction(getAbstractAceptarAction());
			}
			{
				btnListar = new JButton();
				btnListar.setText("Listar");
			}
			{
				txtNombre = new JTextField();
			}
			{
				lblCantidad = new JLabel();
				lblCantidad.setText("Cantidad: ");
			}
			{
				txtCantidad = new JTextField();
			}
			{
				lblPtoPedido = new JLabel();
				lblPtoPedido.setText("Punto de Pedido: ");
			}
			{
				txtPtoPedido = new JTextField();
			}
			{
				lblPtoRefill = new JLabel();
				lblPtoRefill.setText("Punto de Reabastecimiento: ");
			}
			{
				txtPtoRefill = new JTextField();
			}
			{
				txtProveedores = new JLabel();
				txtProveedores.setText("Proveedores: ");
			}
			{
				
				//cmbProveedores = new JComboBox (Restaurante.getRestaurante().getProveedoresView());
				
				/*ComboBoxModel cmbProveedoresModel = 
					new DefaultComboBoxModel(
							new String[] { "Item One", "Item Two" });*/
				
				ComboBoxModel cmbProveedoresModel = new DefaultComboBoxModel(Restaurante.getRestaurante().getProveedoresView());
				//cmbProveedoresModel.setSelectedItem("");
				cmbProveedores = new JComboBox();
				cmbProveedores.setModel(cmbProveedoresModel);
				cmbProveedores.setSelectedIndex(0);
				//cmbProveedores.addItem("PEPE");
			}
			thisLayout.setVerticalGroup(thisLayout.createSequentialGroup()
				.addContainerGap()
				.addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(txtNombre, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(lblNombre, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(txtCantidad, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(lblCantidad, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(lblPtoPedido, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
				    .addComponent(txtPtoPedido, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(txtPtoRefill, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(lblPtoRefill, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(cmbProveedores, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(txtProveedores, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
				.addGap(48)
				.addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(btnAceptar, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(btnListar, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addContainerGap(56, 56));
			thisLayout.setHorizontalGroup(thisLayout.createSequentialGroup()
				.addContainerGap()
				.addGroup(thisLayout.createParallelGroup()
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addComponent(txtProveedores, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
				        .addGap(0, 6, GroupLayout.PREFERRED_SIZE))
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addComponent(lblPtoRefill, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
				        .addGap(0, 6, GroupLayout.PREFERRED_SIZE))
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addComponent(lblPtoPedido, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
				        .addGap(0, 6, GroupLayout.PREFERRED_SIZE))
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addComponent(lblCantidad, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
				        .addGap(0, 6, GroupLayout.PREFERRED_SIZE))
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addComponent(lblNombre, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
				        .addGap(0, 6, GroupLayout.PREFERRED_SIZE))
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addGap(66)
				        .addComponent(btnAceptar, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)))
				.addGroup(thisLayout.createParallelGroup()
				    .addComponent(cmbProveedores, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
				    .addComponent(txtPtoRefill, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
				    .addComponent(txtPtoPedido, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
				    .addComponent(txtCantidad, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
				    .addComponent(txtNombre, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addPreferredGap(cmbProveedores, btnListar, LayoutStyle.ComponentPlacement.INDENT)
				        .addComponent(btnListar, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
				        .addGap(0, 49, Short.MAX_VALUE)))
				.addContainerGap(29, 29));
			thisLayout.linkSize(SwingConstants.VERTICAL, new Component[] {txtNombre, lblNombre, lblCantidad, lblPtoPedido, lblPtoRefill, txtProveedores, cmbProveedores, txtPtoRefill, txtPtoPedido, txtCantidad});
			thisLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {txtNombre, lblNombre, lblCantidad, lblPtoPedido, lblPtoRefill, txtProveedores, cmbProveedores, txtPtoRefill, txtPtoPedido, txtCantidad});
			pack();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private AbstractAction getAbstractAceptarAction() {
		if(abstractAceptarAction == null) {
			abstractAceptarAction = new AbstractAction("Aceptar", null) {
				public void actionPerformed(ActionEvent evt) {
					Restaurante.getRestaurante().altaDeProducto(txtNombre.getText(), Integer.parseInt(txtCantidad.getText()), Integer.parseInt(txtPtoPedido.getText()), Integer.parseInt(txtPtoRefill.getText()),(Proveedor)cmbProveedores.getSelectedItem()); //Cargo en el vector los datos que el usuario cargo en la ventana.
					txtNombre.setText("");
					txtCantidad.setText("");
					txtPtoPedido.setText("");
					txtPtoRefill.setText("");
				}
			};
		}
		return abstractAceptarAction;
	}

}
