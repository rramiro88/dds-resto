package vista.Comandas;

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

import controlador.ItemDeCartaView;
import controlador.MesaView;
import controlador.Restaurante;




public class FormGenerarComanda extends javax.swing.JFrame {
	private JLabel lblMesa;
	private JComboBox cmbMesas;
	private JLabel lblItem;
	private JButton btnCancelar;
	private JComboBox cmbItems;
	private JSpinner spnCantidad;
	private AbstractAction cerrarAction;
	private AbstractAction agregarAction;
	private JButton btnAgregar;
	private JLabel lblCantidad;

	
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
				Vector platosBebidas = getPlatosBebidas(Restaurante.getRestaurante().getItemsDeCartaActivaView());
				cmbItems = new JComboBox(platosBebidas);
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
				btnCancelar.setAction(getCerrarAction());
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
					try{
						String sMesa = cmbMesas.getSelectedItem().toString();
						String sItem = cmbItems.getSelectedItem().toString();
						int iCant = Integer.valueOf(spnCantidad.getValue().toString());
						Restaurante.getRestaurante().agregarItemComanda(Integer.valueOf(sMesa), sItem, iCant);
						JOptionPane.showMessageDialog(null, "Comanda creada con exito.", "Generar Pedido", JOptionPane.INFORMATION_MESSAGE);
					}
					catch (Exception e){
						JOptionPane.showMessageDialog(null, "No es posible vender " + spnCantidad.getValue().toString() + " unidades de " + cmbItems.getSelectedItem().toString() + ".", "Error en el calculo del total", JOptionPane.WARNING_MESSAGE);
					}
				}
			};
		}
		return agregarAction;
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
		Vector asignadas = new Vector();
		for (int i= 0; i < v.size(); i++){
			if (v.elementAt(i).isAsignada())
				asignadas.add(v.elementAt(i).getNroMesa());
		}
		return asignadas;
	}
	
	public Vector getPlatosBebidas (Vector<ItemDeCartaView> v){
		Vector items = new Vector();
		for (int i= 0; i < v.size(); i++){
			items.add(v.elementAt(i).getNombre());
		}
		return items;
	}
	
	
}
