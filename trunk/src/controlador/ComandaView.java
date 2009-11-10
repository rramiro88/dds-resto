package controlador;

import java.util.Vector;

import modelo.ItemComanda;
import modelo.Mozo;

public class ComandaView {
	
	private Vector<ItemComanda> itemsComanda;
	private Mozo mozo; //ver si hace falta
	private float total;
	
	
	public ComandaView(Mozo mozo) {
		super();
		this.itemsComanda = new Vector<ItemComanda>();
		this.mozo = mozo;
		this.total = 0;
	}
	
	public float getTotal() {
		for (int i = 0; i<itemsComanda.size(); i++){
			total = total + itemsComanda.elementAt(i).getSubtotal();
		}
		return total;
	}

	public Mozo getMozo() {
		return mozo;
	}
}
