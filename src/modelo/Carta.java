package modelo;

import java.util.Vector;

import controlador.CartaView;

public class Carta {
	private String dia;
	private Vector <ItemDeCarta> itemsCarta;

//	Constructor de instancia Carta
//	-------------------------------------------------------------	
	public Carta (String day){
		this.dia = day;
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

	//	Metodo get que devuelve un CartaView para pasar a la vista
	public CartaView getCartaView(){
		CartaView cv = new CartaView(dia);
		return cv;
	}
	
//	Metodos que operan con Items de Carta
//	-------------------------------------------------------------	
	public ItemDeCarta buscarItemDeCarta (String nombre){
 		for (int i=0; i<itemsCarta.size(); i++){
			ItemDeCarta idecarta = itemsCarta.elementAt(i);
			if (idecarta.getNombre().equals(nombre)){
				System.out.println("Item existente en la carta");
				return idecarta;
			}
		}
		System.out.println("El item NO existe en esta carta");
 		return null;
	}

	public void agregarItemCarta (ItemDeCarta itdc){
		this.itemsCarta.add(itdc);
	}
	
	public void eliminarItemCarta (ItemDeCarta itdc){
		this.itemsCarta.remove(itdc);
	}

}