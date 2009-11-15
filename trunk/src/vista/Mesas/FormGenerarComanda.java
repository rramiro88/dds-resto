package vista.Mesas;

import java.awt.event.ActionEvent;
import java.util.Vector;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.WindowConstants;

import controlador.MesaView;
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
public class FormGenerarComanda extends javax.swing.JFrame {
	private JLabel lblMesa;
	private JComboBox cmbMesas;
	private JLabel lblItem;
	private JButton btnCancelar;
	private JComboBox cmbItems;
	private JSpinner spnCantidad;
	private AbstractAction cancelarAction;
	private AbstractAction agregarAction;
	private JButton btnAgregar;
	private JLabel lblCantidad;

/** // Auto-generated main method to display this JFrame
	/*public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				FormGenerarComanda inst = new FormGenerarComanda();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}*/
	
	public FormGenerarComanda() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("Generar Comanda");
			getContentPane().setLayout(null);
			this.setPreferredSize(new java.awt.Dimension(400, 250));
			{
				lblMesa = new JLabel();
				getContentPane().add(lblMesa);
				lblMesa.setText("Seleccione Mesa: ");
				lblMesa.setBounds(12, 21, 122, 14);
			}
			{
				// Aca solo queremos mesas asignadas. Las que no fueron asigandas no se atienden.
				Vector mesasAsignadas = getMesasAsignadas(Restaurante.getRestaurante().getMesasView());
				cmbMesas = new JComboBox(mesasAsignadas);
				getContentPane().add(cmbMesas);
				cmbMesas.setBounds(194, 18, 81, 21);
			}
			{
				cmbItems = new JComboBox(Restaurante.getRestaurante().getItemsDeCartaViewVector());
				getContentPane().add(cmbItems);
				cmbItems.setBounds(194, 69, 174, 21);
			}
			{
				SpinnerListModel jSpinner1Model = 
					new SpinnerListModel(
							new String[] { "1", "2" , "3" , "4" , "5" , "6" , "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20" });
				spnCantidad = new JSpinner();
				spnCantidad.setModel(jSpinner1Model);
				getContentPane().add(spnCantidad);
				spnCantidad.setBounds(194, 101, 47, 21);
			}
			{
				lblItem = new JLabel();
				getContentPane().add(lblItem);
				lblItem.setText("Seleccione Menú/Bebida: ");
				lblItem.setBounds(12, 72, 164, 14);
			}
			{
				lblCantidad = new JLabel();
				getContentPane().add(lblCantidad);
				lblCantidad.setText("Cantidad: ");
				lblCantidad.setBounds(91, 104, 58, 14);
			}
			{
				btnAgregar = new JButton();
				getContentPane().add(btnAgregar);
				btnAgregar.setText("Agregar");
				btnAgregar.setBounds(81, 182, 113, 28);
				btnAgregar.setFont(new java.awt.Font("Tahoma",1,11));
				btnAgregar.setAction(getAgregarAction());
			}
			{
				btnCancelar = new JButton();
				getContentPane().add(btnCancelar);
				btnCancelar.setText("Cancelar");
				btnCancelar.setBounds(234, 182, 113, 28);
				btnCancelar.setFont(new java.awt.Font("Tahoma",1,11));
				btnCancelar.setAction(getCancelarAction());
			}
			pack();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private AbstractAction getAgregarAction() {
		if(agregarAction == null) {
			agregarAction = new AbstractAction("Agregar", null) {
				public void actionPerformed(ActionEvent evt) {
					String sMesa = cmbMesas.getSelectedItem().toString();
					sMesa = getPrimero(sMesa);
					String sItem = cmbItems.getSelectedItem().toString();
					sItem = getPrimero(sItem);
					int iCant = Integer.valueOf(spnCantidad.getValue().toString());
					Restaurante.getRestaurante().agregarItemComanda(Integer.valueOf(sMesa), sItem, iCant);
					JOptionPane.showMessageDialog(null, "Comanda creada con exito.", "Generar Pedido", JOptionPane.INFORMATION_MESSAGE);
				}
			};
		}
		return agregarAction;
	}
	
	private AbstractAction getCancelarAction() {
		if(cancelarAction == null) {
			cancelarAction = new AbstractAction("Cancelar", null) {
				public void actionPerformed(ActionEvent evt) {
					dispose();
				}
			};
		}
		return cancelarAction;
	}
	
	
	// Para parsear el string obtenido del combo y obtener el primer substring
	// Hasta la ',' o ']'
	public String getPrimero(String s){
		int i = 0;
		String sAux = new String("");
		if (s.charAt(i) == '[')
			i++;
		while ((s.charAt(i) != ',') && (s.charAt(i) != ']' )){
			sAux = sAux + s.charAt(i); 
			i++;
		}
		return sAux;
	}
	
	
	public Vector getMesasAsignadas (Vector<MesaView> v){
		Vector mv = new Vector();
		for (int i= 0; i < v.size(); i++){
			if (v.elementAt(i).isAsignada())
				mv.add(v.elementAt(i).getNroMesa());
		}
		return mv;
	}
}
