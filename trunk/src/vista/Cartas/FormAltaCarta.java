	package vista.Cartas;

	import java.awt.event.ActionEvent;
	import javax.swing.AbstractAction;
	import javax.swing.JButton;
	import javax.swing.JLabel;
import javax.swing.JOptionPane;
	import javax.swing.JTextField;

	import javax.swing.WindowConstants;
	import javax.swing.SwingUtilities;

import controlador.*;

	
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
public class FormAltaCarta extends javax.swing.JFrame {
		private JButton btnCancel;
		private JButton btnAceptar;
		private AbstractAction cancelarAccion;
		private AbstractAction aceptarAccion;
		private JLabel jLabel1;
		private JTextField txtNombre;
		/**
		* Auto-generated main method to display this JFrame
		*/
		public static void main(String[] args) {
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					FormAltaCarta inst = new FormAltaCarta();
					inst.setLocationRelativeTo(null);
					inst.setVisible(true);
				}
			});
		}
		
		public FormAltaCarta() {
			super();
			initGUI();
		}
		
		private void initGUI() {
			try {
				getContentPane().setLayout(null);
				setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				this.setTitle("Alta de Cartas");
				{
					btnCancel = new JButton();
					getContentPane().add(btnCancel);
					btnCancel.setText("CANCELAR");
					btnCancel.setBounds(261, 225, 118, 34);
					btnCancel.setAction(getCancelarAccion());
				}
				{
					btnAceptar = new JButton();
					getContentPane().add(btnAceptar);
					btnAceptar.setText("ACEPTAR");
					btnAceptar.setBounds(132, 225, 118, 34);
					btnAceptar.setAction(getAceptarAccion());
				}
				{
					txtNombre = new JTextField();
					getContentPane().add(txtNombre);
					txtNombre.setBounds(134, 10, 244, 34);
				}
				{
					jLabel1 = new JLabel();
					getContentPane().add(jLabel1);
					jLabel1.setText("Dia de Carta");
					jLabel1.setBounds(12, 17, 110, 33);
				}
				pack();
				setSize(400, 300);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		private AbstractAction getAceptarAccion() {
			if(aceptarAccion == null) {
				aceptarAccion = new AbstractAction("ACEPTAR", null) {
					public void actionPerformed(ActionEvent evt) {
						if(!Restaurante.getRestaurante().altaDeCarta(txtNombre.getText())){
							JOptionPane.showMessageDialog(null, "Ingrese un dia de la semana.", "Error en la carga de datos", JOptionPane.WARNING_MESSAGE);
						}
						txtNombre.setText("");
					}
				};
			}
			return aceptarAccion;
		}
				
		private AbstractAction getCancelarAccion() {
			if(cancelarAccion == null) {
				cancelarAccion = new AbstractAction("CANCELAR", null) {
					public void actionPerformed(ActionEvent evt) {
						//aca va el codigo de lo que hace el boton
						System.exit(0);
					}
				};
			}
			return cancelarAccion;
		}
	}
