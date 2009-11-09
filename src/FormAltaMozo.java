
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.util.Vector;
import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


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
public class FormAltaMozo extends javax.swing.JFrame {
	private JButton closeButton;
	private JTable jTable1;
	private JScrollPane jScrollPane1;
	private AbstractAction agregarAction;
	private AbstractAction closeAction;
	private JLabel jLabel3;
	private JLabel jLabel2;
	private JTextField jTextField3;
	private JPanel jPanel1;
	private JTextField jTextField2;
	private JButton aceptButton;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		FormAltaMozo inst = new FormAltaMozo();
		inst.setVisible(true);
	}
	
	public FormAltaMozo() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			GroupLayout thisLayout = new GroupLayout((JComponent)getContentPane());
			getContentPane().setLayout(thisLayout);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("Alta de Mozos");
			{
				closeButton = new JButton();
				closeButton.setText("Cerrar");
				closeButton.setFont(new java.awt.Font("Tahoma",1,11));
				closeButton.setAction(getCloseAction());
			}
			{
				aceptButton = new JButton();
				aceptButton.setText("Agregar");
				aceptButton.setFont(new java.awt.Font("Tahoma",1,11));
				aceptButton.setAction(getAgregarAction());
			}
			{
				jScrollPane1 = new JScrollPane();
				{
					Vector datos = Restaurante.getRestaurante().getMozosViewVector();
					TableModel dtm = new DefaultTableModel(datos, MozoView.getEncabezados());
					jTable1 = new JTable();
					jScrollPane1.setViewportView(jTable1);
					jTable1.setModel(dtm);
				}
			}
			{
				jPanel1 = new JPanel();
				GroupLayout jPanel1Layout = new GroupLayout((JComponent)jPanel1);
				jPanel1.setLayout(jPanel1Layout);
				jPanel1.setFocusable(true);
				jPanel1.setBorder(BorderFactory.createTitledBorder("Agregar Mozo"));
				{
					jTextField2 = new JTextField();
					jTextField2.setLayout(null);
					jTextField2.setSize(36, 20);
					jTextField2.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
				}
				{
					jTextField3 = new JTextField();
					jTextField3.setSize(241, 20);
					jTextField3.setBorder(BorderFactory.createCompoundBorder(
							BorderFactory.createBevelBorder(BevelBorder.LOWERED), 
							null));
				}
				{
					jLabel2 = new JLabel();
					jLabel2.setText("NOMBRE: ");
				}
				{
					jLabel3 = new JLabel();
					jLabel3.setText("COMISION: ");
				}
				jPanel1Layout.setHorizontalGroup(jPanel1Layout.createSequentialGroup()
					.addContainerGap()
					.addGroup(jPanel1Layout.createParallelGroup()
					    .addComponent(jLabel3, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
					    .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
					        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					        .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					        .addGap(17)))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(jPanel1Layout.createParallelGroup()
					    .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
					        .addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					        .addGap(0, 150, Short.MAX_VALUE))
					    .addGroup(jPanel1Layout.createSequentialGroup()
					        .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)
					        .addGap(0, 0, Short.MAX_VALUE)))
					.addContainerGap(87, 87));
				jPanel1Layout.setVerticalGroup(jPanel1Layout.createSequentialGroup()
					.addContainerGap()
					.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					    .addComponent(jTextField2, GroupLayout.Alignment.BASELINE, 0, 23, Short.MAX_VALUE)
					    .addComponent(jLabel2, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					    .addComponent(jTextField3, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					    .addComponent(jLabel3, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap());
				jPanel1Layout.linkSize(SwingConstants.VERTICAL, new Component[] {jTextField2, jTextField3});
			}
			thisLayout.setVerticalGroup(thisLayout.createSequentialGroup()
				.addContainerGap()
				.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 0, Short.MAX_VALUE)
				.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				.addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(aceptButton, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(closeButton, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addContainerGap());
			thisLayout.setHorizontalGroup(thisLayout.createSequentialGroup()
				.addContainerGap()
				.addGroup(thisLayout.createParallelGroup()
				    .addComponent(jScrollPane1, GroupLayout.Alignment.LEADING, 0, 373, Short.MAX_VALUE)
				    .addComponent(jPanel1, GroupLayout.Alignment.LEADING, 0, 373, Short.MAX_VALUE)
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addGap(86)
				        .addComponent(aceptButton, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
				        .addGap(0, 19, Short.MAX_VALUE)
				        .addComponent(closeButton, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
				        .addGap(0, 76, GroupLayout.PREFERRED_SIZE)))
				.addContainerGap());
			thisLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {aceptButton, closeButton});
			pack();
			pack();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private AbstractAction getCloseAction() {
		if(closeAction == null) {
			closeAction = new AbstractAction("Cerrar", null) {
				public void actionPerformed(ActionEvent evt) {
					System.exit(0);
				}
			};
		}
		return closeAction;
	}
	
	private AbstractAction getAgregarAction() {
		if(agregarAction == null) {
			agregarAction = new AbstractAction("Agregar", null) {
				public void actionPerformed(ActionEvent evt) {
					try{
					
						Restaurante.getRestaurante().altaDeMozo(jTextField2.getText(), Integer.parseInt(jTextField3.getText()));
						Vector datos = Restaurante.getRestaurante().getMozosViewVector();
						TableModel dtm = new DefaultTableModel(datos, MozoView.getEncabezados());
						jTable1.setModel(dtm);
						jTextField2.setText("");
						jTextField3.setText("");
					}
					catch  (Exception e){
						JOptionPane.showMessageDialog(null, "La comisión debe ser un valor numérico entero.", "Error en la carga de datos", JOptionPane.WARNING_MESSAGE);
						jTextField3.setText("");
					}
				}
			};
		}
		return agregarAction;
	}

}