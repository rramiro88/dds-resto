package vista.Mozos;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.util.Vector;
import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
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

import controlador.MozoView;
import controlador.Restaurante;



public class FormAltaMozo extends javax.swing.JFrame {
	private JButton closeButton;
	private JTable jTable1;
	private JScrollPane jScrollPane1;
	private JCheckBox chkHabilitado;
	private AbstractAction agregarAction;
	private AbstractAction closeAction;
	private JLabel jLabel3;
	private JLabel jLabel2;
	private JTextField jTextField3;
	private JPanel jPanel1;
	private JTextField jTextField2;
	private JButton aceptButton;

	
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
					Vector<MozoView> datos  = Restaurante.getRestaurante().getMozosView();
					Vector datosView = getMozosViewVector(datos);
					TableModel dtm = new DefaultTableModel(datosView, MozoView.getEncabezados());
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
					        .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					        .addGap(17)))
					.addGap(24)
					.addGroup(jPanel1Layout.createParallelGroup()
					    .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
					        .addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					        .addGap(25)
					        .addComponent(getChkHabilitado(), GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
					    .addGroup(jPanel1Layout.createSequentialGroup()
					        .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(75, Short.MAX_VALUE));
				jPanel1Layout.setVerticalGroup(jPanel1Layout.createSequentialGroup()
					.addContainerGap()
					.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					    .addComponent(jTextField2, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					    .addComponent(jLabel2, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					    .addComponent(jTextField3, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					    .addComponent(getChkHabilitado(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					    .addComponent(jLabel3, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(30, 30));
				jPanel1Layout.linkSize(SwingConstants.VERTICAL, new Component[] {jTextField2, jTextField3});
			}
			thisLayout.setVerticalGroup(thisLayout.createSequentialGroup()
				.addContainerGap()
				.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				.addComponent(jPanel1, 0, 107, Short.MAX_VALUE)
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
				        .addGap(87)
				        .addComponent(aceptButton, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
				        .addGap(0, 20, Short.MAX_VALUE)
				        .addComponent(closeButton, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
				        .addGap(74)))
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
					dispose();
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
						int comision = Integer.parseInt(jTextField3.getText());
						if (comision < 0 || comision > 100){
							JOptionPane.showMessageDialog(null, "La comisión debe estar entre 0 y 100 porciento.", "Error en la carga de datos", JOptionPane.WARNING_MESSAGE);
							jTextField3.setText("");
						}else{
							Restaurante.getRestaurante().altaDeMozo(jTextField2.getText(), Integer.parseInt(jTextField3.getText()), chkHabilitado.isSelected());
							Vector<MozoView> datos  = Restaurante.getRestaurante().getMozosView();
							Vector datosView = getMozosViewVector(datos);
							TableModel dtm = new DefaultTableModel(datosView, MozoView.getEncabezados());
							jTable1.setModel(dtm);
							jTextField2.setText("");
							jTextField3.setText("");
						}
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

	
	private JCheckBox getChkHabilitado() {
		if(chkHabilitado == null) {
			chkHabilitado = new JCheckBox("HABILITADO", true);
		}
		return chkHabilitado;
	}
	
	
	public Vector getMozosViewVector(Vector<MozoView> mozos){ 
		Vector mv = new Vector();
		for (int i= 0; i < mozos.size(); i++){
			mv.add(mozos.elementAt(i).toVector());
		}
		return mv;
	}

	
}
