package vista.OrdenesDeCompra;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import controlador.Restaurante;

import vista.Productos.FormIngresarMercaderia;


public class FormOrdenesDeCompra extends javax.swing.JFrame {
	private JButton btnGenerar;
	private JButton btnAltaOrden;
	private JButton btnModificar;
	private JButton btnEliminar;
//	private JButton btnCancel;

	private JLabel lblFecha;
	private JTextField txtFecha;
	
	private AbstractAction getGenerarOrdenes;
	private AbstractAction getAltaOrden;
	private AbstractAction getIngresarMercaderia;
	private AbstractAction getEliminarOrden;
//	private AbstractAction cancelarAccion;
	

/*//	Auto-generated main method to display this JFrame
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				FormOrdenesDeCompra inst = new FormOrdenesDeCompra();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
*/	
	public FormOrdenesDeCompra() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			getContentPane().setLayout(null);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("ABM de Ordenes de Compra");
			{
				lblFecha = new JLabel();
				getContentPane().add(lblFecha);
				lblFecha.setText("Fecha (dd/mm/aaaa):");
				lblFecha.setBounds(20, 15, 120, 35);
			}
			{
				txtFecha = new JTextField();
				getContentPane().add(txtFecha);
				txtFecha.setBounds(190, 15, 190, 35);
			}
			{
				btnGenerar = new JButton();
				getContentPane().add(btnGenerar);
				btnGenerar.setText("GENERAR ORDENES");
				btnGenerar.setAction(getGenerarOrdenes());
				btnGenerar.setBounds(220, 60, 160, 35);
			}
			{
				btnAltaOrden = new JButton();
				getContentPane().add(btnAltaOrden);
				btnAltaOrden.setText("ALTA ORDEN");
				btnAltaOrden.setAction(getAltaOrden());
				btnAltaOrden.setBounds(20, 110, 160, 35);
			}
			{
				btnModificar = new JButton();
				getContentPane().add(btnModificar);
				btnModificar.setText("INGRESAR MERCADERIA");
				btnModificar.setAction(getIngresarMercaderia());
				btnModificar.setBounds(220, 220, 160, 35);
			}
			{
				btnEliminar = new JButton();
				getContentPane().add(btnEliminar);
				btnEliminar.setText("BAJA SIMPLE");
				btnEliminar.setAction(getEliminarOrden());
				btnEliminar.setBounds(20, 160, 160, 35);
			}
/*			{
				btnCancel = new JButton();
				getContentPane().add(btnCancel);
				btnCancel.setText("SALIR");
				btnCancel.setBounds(229, 224, 150, 35);
				btnCancel.setAction(getCancelarAccion());
			}
*/			pack();
			setSize(400, 300);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private AbstractAction getGenerarOrdenes() {
		if(getGenerarOrdenes == null) {
			getGenerarOrdenes = new AbstractAction("GENERAR ORDENES", null) {
				public void actionPerformed(ActionEvent evt){
					SwingUtilities.invokeLater(new Runnable() {
						public void run() {
							Restaurante.getRestaurante().generarOrdenesDeCompra();
						}
					});
				}
			};
		}
		return getGenerarOrdenes;
	}

	private AbstractAction getAltaOrden() {
		if(getAltaOrden == null) {
			getAltaOrden = new AbstractAction("ALTA SIMPLE", null) {
				public void actionPerformed(ActionEvent evt){
					SwingUtilities.invokeLater(new Runnable() {
						public void run() {
							FormAltaOrdenDeCompra inst = new FormAltaOrdenDeCompra();
							inst.setLocationRelativeTo(null);
							inst.setVisible(true);
						}
					});
				}
			};
		}
		return getAltaOrden;
	}

	private AbstractAction getIngresarMercaderia() {
		if(getIngresarMercaderia== null) {
			getIngresarMercaderia= new AbstractAction("INGRESAR MERCADERIA", null) {
				public void actionPerformed(ActionEvent evt){
					SwingUtilities.invokeLater(new Runnable() {
						public void run() {
							FormIngresarMercaderia inst = new FormIngresarMercaderia();
							inst.setLocationRelativeTo(null);
							inst.setVisible(true);
						}
					});
				}
			};
		}
		return getIngresarMercaderia;
	}

	private AbstractAction getEliminarOrden() {
		getEliminarOrden = new AbstractAction("BAJA SIMPLE", null) {
			public void actionPerformed(ActionEvent evt){
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						FormBajaOrdenDeCompra inst = new FormBajaOrdenDeCompra();
						inst.setLocationRelativeTo(null);
						inst.setVisible(true);
					}
				});
			}
		};
		return getEliminarOrden;
	}
			
/*	private AbstractAction getCancelarAccion() {
		if(cancelarAccion == null) {
			cancelarAccion = new AbstractAction("CANCELAR", null) {
				public void actionPerformed(ActionEvent evt) {
					System.exit(0);
				}
			};
		}
		return cancelarAccion;
	}
*/
	
}