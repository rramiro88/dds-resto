import java.util.Vector;

public class Carta {
	private String dia;
//	private boolean habilitada;
	private Vector <ItemDeCarta> itemsCarta;

	public Carta (String day){
		this.dia = day;
//		this.habilitada = false;
		itemsCarta = new Vector <ItemDeCarta>();
	}

	public String getDia() {
		return dia;
	}
	public void setDia(String dia) {
		this.dia = dia;
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

	public ItemDeCarta buscarItemDeCarta (int nro){
 		for (int i=0; i<itemsCarta.size(); i++){
			ItemDeCarta idecarta = itemsCarta.elementAt(i);
			if (idecarta.getNroItem() == nro){
				System.out.println("item existente");
				return idecarta;
			}
		}
		System.out.println("item NO existe");
 		return null;
	}

}