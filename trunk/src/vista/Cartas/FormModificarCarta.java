package vista.Cartas;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import controlador.*;


public class FormModificarCarta extends javax.swing.JFrame {
//	private JButton btnCancel;
	private JButton btnAceptar;
	private JButton btnBuscar;

	private AbstractAction cancelarAccion;
	private AbstractAction aceptarAccion;
	private AbstractAction buscarAction;

	private JLabel jLabel1;
	private JLabel jLabel2;

	private JTextField txtNombreBuscar;
	private JTextField txtNuevaCarta;

/**
//	Auto-generated main method to display this JFrame
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				FormModificarCarta inst = new FormModificarCarta();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
*/
		
	public FormModificarCarta() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			getContentPane().setLayout(null);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("Modificar Cartas");
			{
				btnBuscar = new JButton();
				getContentPane().add(btnBuscar);
				btnBuscar.setText("Buscar");
				btnBuscar.setBounds(297, 10, 84, 34);
				btnBuscar.setFont(new java.awt.Font("Tahoma",1,11));
				btnBuscar.setAction(getBuscarAction());
			}
/*			{
				btnCancel = new JButton();
				getContentPane().add(btnCancel);
				btnCancel.setText("CANCELAR");
				btnCancel.setBounds(261, 225, 118, 34);
				btnCancel.setAction(getCancelarAccion());
			}
*/			{
				btnAceptar = new JButton();
				getContentPane().add(btnAceptar);
				btnAceptar.setText("ACEPTAR");
				btnAceptar.setBounds(132, 225, 118, 34);
				btnAceptar.setAction(getAceptarAccion());
			}
			{
				txtNombreBuscar = new JTextField();
				getContentPane().add(txtNombreBuscar);
				txtNombreBuscar.setBounds(134, 10, 120, 34);
			}
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				getContentPane().add(getJLabel2());
				getContentPane().add(getJTextField1());
				jLabel1.setText("Dia de Carta: ");
				jLabel1.setBounds(12, 10, 110, 34);

			
			}
			pack();
			setSize(400, 300);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private AbstractAction getBuscarAction() {
		if(buscarAction == null) {
			buscarAction = new AbstractAction("Buscar", null) {
				public void actionPerformed(ActionEvent evt) {
					CartaView cv = Restaurante.getRestaurante().getCartaView(txtNombreBuscar.getText());
					if (cv!=null){
						txtNuevaCarta.setText(cv.getDia());
					}else{
						JOptionPane.showMessageDialog(null, "Ingrese un dia de la semana.", "Error en la carga de datos", JOptionPane.WARNING_MESSAGE);
					}
				}
			};
		}
		return buscarAction;
	}
	
	private AbstractAction getAceptarAccion() {
		if(aceptarAccion == null) {
			aceptarAccion = new AbstractAction("ACEPTAR", null) {
				public void actionPerformed(ActionEvent evt) {
					if (Restaurante.getRestaurante().diaValido(txtNombreBuscar.getText()) && Restaurante.getRestaurante().diaValido(txtNuevaCarta.getText())){
						Restaurante.getRestaurante().modificarCarta(txtNombreBuscar.getText(), txtNuevaCarta.getText());
						txtNombreBuscar.setText("");
						txtNuevaCarta.setText("");	
					}else{
						JOptionPane.showMessageDialog(null, "Dia invalido o la Carta no existe.", "Error en la carga de datos", JOptionPane.WARNING_MESSAGE);
					}
				}
			};
		}
		return aceptarAccion;
	}
			
	private AbstractAction getCancelarAccion() {
		if(cancelarAccion == null) {
			cancelarAccion = new AbstractAction("CANCELAR", null) {
				public void actionPerformed(ActionEvent evt) {
					System.exit(0);
				}
			};
		}
		return cancelarAccion;
	}
	
	private JLabel getJLabel2() {
		if(jLabel2 == null) {
			jLabel2 = new JLabel();
			jLabel2.setText("Nuevo Dia de Carta: ");
			jLabel2.setBounds(12, 56, 110, 34);
		}
		return jLabel2;
	}
	
	private JTextField getJTextField1() {
		if(txtNuevaCarta == null) {
			txtNuevaCarta = new JTextField();
			txtNuevaCarta.setBounds(134, 57, 120, 34);
		}
		return txtNuevaCarta;
	}

	
}
