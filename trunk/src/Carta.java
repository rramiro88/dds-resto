import java.util.Vector;

public class Carta {
	private String dia;
	private boolean habilitada;
	private Vector <ItemDeCarta> itemsCarta;

	public Carta (String day){
		this.dia = day;
		this.habilitada = false;
		itemsCarta = new Vector <ItemDeCarta>();
	}

	public String getDia() {
		return dia;
	}
	public void setDia(String dia) {
		this.dia = dia;
	}

	public boolean isHabilitada() {
		return habilitada;
	}
	public void setHabilitada(boolean habilitada) {
		this.habilitada = habilitada;
	}

	public Vector<ItemDeCarta> getItemsCarta() {
		return itemsCarta;
	}
	public void setItemsCarta(Vector<ItemDeCarta> itemsCartaCarta) {
		this.itemsCarta = itemsCartaCarta;
	}

	public void agregarItemCarta (ItemDeCarta itdc){
		this.itemsCarta.add(itdc);
	}
	
	public void eliminarItemCarta (ItemDeCarta itdc){
		this.itemsCarta.remove(itdc);
	}
}