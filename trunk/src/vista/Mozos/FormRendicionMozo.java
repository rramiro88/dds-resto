package vista.Mozos;
import java.awt.event.ActionEvent;
import java.util.Vector;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.SwingUtilities;

import controlador.MozoView;
import controlador.Restaurante;


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
public class FormRendicionMozo extends javax.swing.JFrame {
	private JTable jTable1;
	private JScrollPane jScrollPane1;
	private AbstractAction cerrarAction;
	private JButton btnCerrar;

	/**
	* Auto-generated main method to display this JFrame
	*/
	/*public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				FormRendicionMozo inst = new FormRendicionMozo();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}*/
	
	public FormRendicionMozo() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("Rendición Mozos");
			getContentPane().setLayout(null);
			this.setPreferredSize(new java.awt.Dimension(400, 300));
			{
				jScrollPane1 = new JScrollPane();
				getContentPane().add(jScrollPane1);
				jScrollPane1.setBounds(12, 12, 368, 112);
				{
					Vector<MozoView> datos  = Restaurante.getRestaurante().getMozosView();
					Vector datosView = getMozosViewVector(datos);
					
					Vector encabezados = new Vector();
					encabezados.add("Nombre");
					encabezados.add("Comision");
					encabezados.add("Liquidacion");
					
					TableModel jTable1Model = new DefaultTableModel(datosView, encabezados);
						
					jTable1 = new JTable();
					jScrollPane1.setViewportView(jTable1);
					jTable1.setModel(jTable1Model);
					jTable1.setBounds(12, 12, 368, 51);
				}
			}
			{
				btnCerrar = new JButton();
				getContentPane().add(btnCerrar);
				btnCerrar.setText("Cerrar");
				btnCerrar.setBounds(149, 227, 97, 28);
				btnCerrar.setAction(getCerrarAction());
			}
			pack();
			setSize(400, 300);
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
	
	public Vector getMozosViewVector(Vector<MozoView> mozos){ 
		Vector mv = new Vector();
		for (int i= 0; i < mozos.size(); i++){
			Vector aux = new Vector(); 
			aux.add(mozos.elementAt(i).getNombre());
			aux.add(mozos.elementAt(i).getComision());
			aux.add(mozos.elementAt(i).getLiquidacion());
			mv.add(aux);
		}
		return mv;
	}

}
