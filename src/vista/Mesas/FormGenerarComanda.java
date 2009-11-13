package vista.Mesas;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import controlador.Restaurante;


public class FormGenerarComanda extends javax.swing.JFrame {
	private JLabel lblMesa;
	private JComboBox cmbMesas;
	private JLabel lblItem;
	private JButton btnCancelar;
	private JComboBox cmbItems;
	private JSpinner jSpinner1;
	private AbstractAction cancelarAction;
	private AbstractAction agregarAction;
	private JButton btnAgregar;
	private JLabel lblCantidad;

/** Auto-generated main method to display this JFrame
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				FormGenerarComanda inst = new FormGenerarComanda();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
*/
	
	public FormGenerarComanda() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("Generar Comanda");
			getContentPane().setLayout(null);
			this.setPreferredSize(new java.awt.Dimension(400, 300));
			{
				lblMesa = new JLabel();
				getContentPane().add(lblMesa);
				lblMesa.setText("Seleccione Mesa: ");
				lblMesa.setBounds(12, 12, 122, 14);
			}
			{
				cmbMesas = new JComboBox(Restaurante.getRestaurante().getMesasViewVector());
				getContentPane().add(cmbMesas);
				cmbMesas.setBounds(192, 9, 81, 21);
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
				btnAgregar.setBounds(79, 168, 113, 28);
				btnAgregar.setFont(new java.awt.Font("Tahoma",1,11));
				btnAgregar.setAction(getAgregarAction());
			}
			{
				btnCancelar = new JButton();
				getContentPane().add(btnCancelar);
				getContentPane().add(getJSpinner1());
				getContentPane().add(getCmbItems());
				btnCancelar.setText("Cancelar");
				btnCancelar.setBounds(233, 168, 113, 28);
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
				}
			};
		}
		return agregarAction;
	}
	
	private AbstractAction getCancelarAction() {
		if(cancelarAction == null) {
			cancelarAction = new AbstractAction("Cancelar", null) {
				public void actionPerformed(ActionEvent evt) {
					System.exit(0);
				}
			};
		}
		return cancelarAction;
	}
	
	private JSpinner getJSpinner1() {
		if(jSpinner1 == null) {
			SpinnerListModel jSpinner1Model = 
				new SpinnerListModel(
						new String[] { "1", "2" , "3" , "4" , "5" , "6" , "7", "8", "9", "10" });
			jSpinner1 = new JSpinner();
			jSpinner1.setModel(jSpinner1Model);
			jSpinner1.setBounds(194, 101, 47, 21);
		}
		return jSpinner1;
	}
	
	private JComboBox getCmbItems() {
		if(cmbItems == null) {
			
			cmbItems = new JComboBox(Restaurante.getRestaurante().getItemsDeCartaViewVector());
			getContentPane().add(cmbItems);
			cmbItems.setBounds(194, 69, 174, 21);
		}
		return cmbItems;
	}

}
