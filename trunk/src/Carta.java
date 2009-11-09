
import java.util.Vector;

public class Carta {
	private String dia;
//	private boolean habilitada;
	private Vector <ItemDeCarta> itemsCarta;

//	Constructor de instancia Carta
//	-------------------------------------------------------------	
	public Carta (String day){
		this.dia = day;
//		this.habilitada = false;
		itemsCarta = new Vector <ItemDeCarta>();
	}


//	Metodos sets y gets para los atributos de la clase ItemDeCarta
//	-------------------------------------------------------------	
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

//	Metodos que operan con Items de Carta
//	-------------------------------------------------------------	
	public ItemDeCarta buscarItemDeCarta (String nombre){
 		for (int i=0; i<itemsCarta.size(); i++){
			ItemDeCarta idecarta = itemsCarta.elementAt(i);
			if (idecarta.getNombre().equals(nombre)){
				System.out.println("item existente");
				return idecarta;
			}
		}
		System.out.println("item NO existe");
 		return null;
	}

	public void agregarItemCarta (ItemDeCarta itdc){
		this.itemsCarta.add(itdc);
	}
	
	public void eliminarItemCarta (ItemDeCarta itdc){
		this.itemsCarta.remove(itdc);
	}

}