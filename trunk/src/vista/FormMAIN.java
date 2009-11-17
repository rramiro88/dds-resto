package vista;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import controlador.Restaurante;
import vista.Productos.FormIngresarMercaderia;



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
public class FormMAIN extends javax.swing.JFrame {
	private JButton btnIniciarDia;
	private JButton btnCerrarDia;
	private JButton btnComandas;
	private JPanel jPanel5;
	private JPanel jPanel4;
	private JPanel jPanel3;
	private JPanel jPanel2;
	private JPanel jPanel1;
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
			this.setPreferredSize(new java.awt.Dimension(450, 400));

			{
				btnSalir = new JButton();
				getContentPane().add(btnSalir);
				btnSalir.setText("CERRAR");
				btnSalir.setAction(getSalirAccion());
				btnSalir.setBounds(132, 300, 149, 27);
				getJPanel1();
			}
			pack();
			this.setSize(427, 381);
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
			getABM = new AbstractAction("ABMs", null) {
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
					dispose();
				}
			};
		}
		return getSalirAccion;
	}
	
	private JPanel getJPanel1() {
		if(jPanel1 == null) {
			jPanel1 = new JPanel();
			{
				btnIniciarDia = new JButton();
				jPanel1.add(btnIniciarDia);
				getContentPane().add(getJPanel1());
				getContentPane().add(getJPanel3());
				jPanel1.setBounds(12, 12, 188, 102);
				jPanel1.setBorder(BorderFactory.createTitledBorder("JORNADA"));
				jPanel1.setLayout(null);
				jPanel1.setPreferredSize(new java.awt.Dimension(102, 188));
				btnIniciarDia.setText("INICIAR DIA");
				btnIniciarDia.setAction(getAbrirDia());
				btnIniciarDia.setBounds(24, 25, 135, 27);
			}
			{
				btnCerrarDia = new JButton();
				jPanel1.add(btnCerrarDia);
				btnCerrarDia.setText("CERRAR DIA");
				btnCerrarDia.setAction(getCerrarDia());
				btnCerrarDia.setBounds(24, 57, 135, 27);
			}
		}
		return jPanel1;
	}
	
	private JPanel getJPanel2() {
		if(jPanel2 == null) {
			jPanel2 = new JPanel();
			jPanel2.setBounds(219, 120, 188, 73);
			jPanel2.setBorder(BorderFactory.createTitledBorder("ABMs GENERALES"));
			jPanel2.setLayout(null);
			{
				btnABM = new JButton();
				jPanel2.add(btnABM);
				btnABM.setText("ABM");
				btnABM.setAction(getABM());
				btnABM.setBounds(27, 28, 135, 28);
			}
		}
		return jPanel2;
	}
	
	private JPanel getJPanel3() {
		if(jPanel3 == null) {
			jPanel3 = new JPanel();
			jPanel3.setBounds(12, 120, 188, 73);
			jPanel3.setBorder(BorderFactory.createTitledBorder("VENTAS"));
			jPanel3.setLayout(null);
			{
				btnComandas = new JButton();
				jPanel3.add(btnComandas);
				getContentPane().add(getJPanel2());
				getContentPane().add(getJPanel5());
				btnComandas.setText("COMANDAS");
				btnComandas.setAction(getComandas());
				btnComandas.setBounds(26, 24, 135, 28);
			}
		}
		return jPanel3;
	}
	
	private JPanel getJPanel4() {
		if(jPanel4 == null) {
			jPanel4 = new JPanel();
			jPanel4.setBounds(12, 199, 188, 73);
			jPanel4.setBorder(BorderFactory.createTitledBorder("COMPRAS"));
			jPanel4.setLayout(null);
			{
				btnGenerar = new JButton();
				jPanel4.add(btnGenerar);
				btnGenerar.setText("GENERAR ORDENES");
				btnGenerar.setAction(getGenerarOrdenesDeCompra());
				btnGenerar.setBounds(28, 24, 135, 28);
			}
		}
		return jPanel4;
	}
	
	private JPanel getJPanel5() {
		if(jPanel5 == null) {
			jPanel5 = new JPanel();
			jPanel5.setBounds(219, 199, 188, 73);
			jPanel5.setBorder(BorderFactory.createTitledBorder("STOCK"));
			jPanel5.setLayout(null);
			{
				btnIngMerca = new JButton();
				jPanel5.add(btnIngMerca);
				getContentPane().add(getJPanel4());
				btnIngMerca.setText("INGRESAR MERCADERIA");
				btnIngMerca.setAction(getIngresarMercaderia());
				btnIngMerca.setBounds(26, 25, 135, 28);
			}
		}
		return jPanel5;
	}

}
