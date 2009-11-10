package controlador;

import java.util.Vector;

public class CartaView {
	private String dia;
//	private boolean habilitada;
	private Vector <ItemDeCarta> itemsCarta;

	public CartaView (String day){
		this.dia = day;
//		this.habilitada = false;
		itemsCarta = new Vector <ItemDeCarta>();
	}

	public String getDia() {
		return dia;
	}
	public Vector<ItemDeCarta> getItemsCarta() {
		return itemsCarta;
	}

}