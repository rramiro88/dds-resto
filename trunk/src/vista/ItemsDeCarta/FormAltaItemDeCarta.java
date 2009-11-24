package vista.ItemsDeCarta;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import controlador.*;


public class FormAltaItemDeCarta extends javax.swing.JFrame {
	private JButton btnEsPlato;
	private JButton btnEsBebida;

	private AbstractAction getPlatoAccion;
	private AbstractAction getBebidaAccion;

	private JLabel lblPrecio;
	private JLabel lblNombre;

	private JTextField txtPrecio;
	private JTextField txtNombre;

	
	public FormAltaItemDeCarta() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			getContentPane().setLayout(null);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("Alta Platos y Bebidas");
			{
				btnEsBebida = new JButton();
				getContentPane().add(btnEsBebida);
				btnEsBebida.setText("BEBIDA");
				btnEsBebida.setAction(getBebidaAccion());
				btnEsBebida.setBounds(210, 225, 110, 35);
			}
			{
				btnEsPlato = new JButton();
				getContentPane().add(btnEsPlato);
				btnEsPlato.setText("PLATO");
				btnEsPlato.setAction(getPlatoAccion());
				btnEsPlato.setBounds(70, 225, 110, 35);
			}

			{
				txtNombre = new JTextField();
				getContentPane().add(txtNombre);
				txtNombre.setBounds(135, 15, 240, 35);
			}
			{
				txtPrecio = new JTextField();
				getContentPane().add(txtPrecio);
				txtPrecio.setBounds(135, 60, 240, 35);
			}
			{
				lblNombre = new JLabel();
				getContentPane().add(lblNombre);
				lblNombre.setText("Plato o Bebida:");
				lblNombre.setBounds(15, 15, 110, 30);
			}
			{
				lblPrecio = new JLabel();
				getContentPane().add(lblPrecio);
				lblPrecio.setText("Precio:");
				lblPrecio.setBounds(15, 60, 110, 30);
			}
			pack();
			setSize(400, 300);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	private AbstractAction getBebidaAccion() {
		if(getBebidaAccion == null) {
			getBebidaAccion = new AbstractAction("es BEBIDA", null) {
				public void actionPerformed(ActionEvent evt) {
					Restaurante.getRestaurante().altaDeBebida(txtNombre.getText(), Integer.parseInt(txtPrecio.getText()));
					txtNombre.setText("");
					txtPrecio.setText("");
				}
			};
		}
		return getBebidaAccion;
	}
			
	
	private AbstractAction getPlatoAccion() {
		if(getPlatoAccion == null) {
			getPlatoAccion = new AbstractAction("es PLATO", null) {
				public void actionPerformed(ActionEvent evt) {
					Restaurante.getRestaurante().altaDePlato(txtNombre.getText(), Integer.parseInt(txtPrecio.getText()));
					txtNombre.setText("");
					txtPrecio.setText("");
				}
			};
		}
		return getPlatoAccion;
	}


}
