package vista;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import controlador.Restaurante;
import vista.Productos.FormIngresarMercaderia;


public class FormMAIN extends javax.swing.JFrame {
	private JButton btnIniciarDia;
	private JButton btnCerrarDia;
	private JButton btnComandas;
	private JButton btnABM;
	private JButton btnIngMerca;
	private JButton btnGenerar;	
	private JButton btnSalir;

	private AbstractAction getAbrirDia;
	private AbstractAction getCerrarDia;
	private AbstractAction getComandas;
	private AbstractAction getABM;
	private AbstractAction getIngresarMercaderia;	
	private AbstractAction getGenerarOrdenesDeCompra;
	private AbstractAction getSalirAccion;

/** //	Auto-generated main method to display this JFrame
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				FormMAIN inst = new FormMAIN();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
*/
	
	public FormMAIN() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			getContentPane().setLayout(null);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("Restaurante");
			{
				btnIniciarDia = new JButton();
				getContentPane().add(btnIniciarDia);
				btnIniciarDia.setText("INICIAR DIA");
				btnIniciarDia.setAction(getAbrirDia());
				btnIniciarDia.setBounds(12, 19, 120, 30);
			}
			{
				btnCerrarDia = new JButton();
				getContentPane().add(btnCerrarDia);
				btnCerrarDia.setText("CERRAR DIA");
				btnCerrarDia.setAction(getCerrarDia());
				btnCerrarDia.setBounds(12, 60, 120, 30);
			}
			{
				btnComandas = new JButton();
				getContentPane().add(btnComandas);
				btnComandas.setText("COMANDAS");
				btnComandas.setAction(getComandas());
				btnComandas.setBounds(12, 113, 140, 30);
			}
			{
				btnABM = new JButton();
				getContentPane().add(btnABM);
				btnABM.setText("ABM");
				btnABM.setAction(getABM());
				btnABM.setBounds(301, 42, 100, 30);
			}
			{
				btnIngMerca = new JButton();
				getContentPane().add(btnIngMerca);
				btnIngMerca.setText("INGRESAR MERCADERIA");
				btnIngMerca.setAction(getIngresarMercaderia());
				btnIngMerca.setBounds(221, 83, 180, 30);
			}
			{
				btnGenerar = new JButton();
				getContentPane().add(btnGenerar);
				btnGenerar.setText("GENERAR ORDENES");
				btnGenerar.setAction(getGenerarOrdenesDeCompra());
				btnGenerar.setBounds(221, 120, 180, 30);
			}

			{
				btnSalir = new JButton();
				getContentPane().add(btnSalir);
				btnSalir.setText("CERRAR");
				btnSalir.setAction(getSalirAccion());
				btnSalir.setBounds(320, 180, 90, 25);
			}
			pack();
			this.setSize(420, 240);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	private AbstractAction getAbrirDia() {
		if(getAbrirDia == null) {
			getAbrirDia = new AbstractAction("INICIAR DIA", null) {
				public void actionPerformed(ActionEvent evt){
					SwingUtilities.invokeLater(new Runnable() {
						public void run() {
							//	Revisa que la jornada no este abierta
							if (!Restaurante.getRestaurante().isOpen()){
								Restaurante.getRestaurante().abrirJornada();
								JOptionPane.showMessageDialog(null, "Jornada abierta con exito", "MENSAJE", JOptionPane.WARNING_MESSAGE);
							}else{
							//	Jornada ya abierta
							JOptionPane.showMessageDialog(null, "La jornada ya se encuentra abierta", "ATENCION", JOptionPane.WARNING_MESSAGE);
							}
						}
					});
				}
			};
		}
		return getAbrirDia;
	}

	
	private AbstractAction getCerrarDia() {
		if(getCerrarDia == null) {
			getCerrarDia = new AbstractAction("CERRAR DIA", null) {
				public void actionPerformed(ActionEvent evt){
					SwingUtilities.invokeLater(new Runnable() {
						public void run() {
							//	Revisa que la jornada halla sido abierta
							if (Restaurante.getRestaurante().isOpen()){
								if (Restaurante.getRestaurante().cerrarJornada()){
									JOptionPane.showMessageDialog(null, "Jornada cerrada con exito", "MENSAJE", JOptionPane.WARNING_MESSAGE);
								}else{
									JOptionPane.showMessageDialog(null, "No se pudo cerrar. Mesa/s con comanda/s en curso.", "ATENCION", JOptionPane.WARNING_MESSAGE);
								}
							}else{
								//	Jornada cerrada
								JOptionPane.showMessageDialog(null, "La jornada no ha sido abierta.", "ATENCION", JOptionPane.WARNING_MESSAGE);
							}
						}
					});
				}
			};
		}
		return getCerrarDia;
	}
	
	
	private AbstractAction getABM() {
		if(getABM == null) {
			getABM = new AbstractAction("ABM", null) {
				public void actionPerformed(ActionEvent evt){
					SwingUtilities.invokeLater(new Runnable() {
						public void run() {
							//	Revisa que la jornada no este abierta
							if (!Restaurante.getRestaurante().isOpen()){
								FormABMs inst = new FormABMs();
								inst.setLocationRelativeTo(null);
								inst.setVisible(true);
							}else{
							//	Con jornada abierta no permite modificar los objetos
							JOptionPane.showMessageDialog(null, "Jornada en curso. No se puede modificar.", "Prohibido", JOptionPane.WARNING_MESSAGE);
							}
						}
					});
				}
			};
		}
		return getABM;
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

	private AbstractAction getGenerarOrdenesDeCompra() {
		getGenerarOrdenesDeCompra = new AbstractAction("GENERAR ORDENES", null) {
			public void actionPerformed(ActionEvent evt){
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						//	Revisa que el dia no halla sido abierto
						if (!Restaurante.getRestaurante().isOpen()){
							int ord = Restaurante.getRestaurante().generarOrdenesDeCompra();
							JOptionPane.showMessageDialog(null, "Ordenes de compra generadas: " +ord+"", "Atencion", JOptionPane.WARNING_MESSAGE);
						}else{
							//	Si el dia esta abierto, no permite generar las ordenes de compra
							JOptionPane.showMessageDialog(null, "Negocio abierto. No se puede generar ordenes de compra.", "Prohibido", JOptionPane.WARNING_MESSAGE);
						}
					}
				});
			}
		};
	return getGenerarOrdenesDeCompra;
	}

	private AbstractAction getComandas() {
		getComandas = new AbstractAction("COMANDAS", null) {
			public void actionPerformed(ActionEvent evt){
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						//	Revisa que la jornada halla sido abierta para poder vender.
						if (Restaurante.getRestaurante().isOpen()){
							FormVender inst = new FormVender();
							inst.setLocationRelativeTo(null);
							inst.setVisible(true);
						}else{
							//	Con la jornada cerrada no permite vernder
							JOptionPane.showMessageDialog(null, "Jornada cerrada. No se puede vender.", "Prohibido", JOptionPane.WARNING_MESSAGE);
						}
					}
				});
			}
		};
		return getComandas;
	}
	
	private AbstractAction getSalirAccion() {
		if(getSalirAccion == null) {
			getSalirAccion = new AbstractAction("CERRAR", null) {
				public void actionPerformed(ActionEvent evt) {
					System.exit(0);
				}
			};
		}
		return getSalirAccion;
	}


}
