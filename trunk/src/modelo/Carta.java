/**
  *	El restaurante administra siete (7) cartas: una para cada dia.
  *	Cada carta se identifica por el dia de la semana al que corresponde.
  *	La validacion del dia se hace en Restaurante.java.
  **/

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

	//	Metodo get que devuelve un CartaView para pasar a la vista
	public CartaView getCartaView(){
		CartaView cv = new CartaView(dia);
		return cv;
	}
	
//	Metodos que operan con Platos/Bebidas de la Carta
//	-------------------------------------------------------------	
	public ItemDeCarta buscarItemDeCarta (String nombre){
 		for (int i=0; i<this.itemsCarta.size(); i++){
			ItemDeCarta idecarta = this.itemsCarta.elementAt(i);
			if (idecarta.getNombre().equals(nombre)){
				System.out.println("Item existente en la carta");
				return idecarta;
			}
		}
		System.out.println("El item NO existe en esta carta");
 		return null;
	}

	public boolean agregarItemCarta (ItemDeCarta itdc){
		if (buscarItemDeCarta (itdc.getNombre()) == null){
			this.itemsCarta.add(itdc);
			System.out.println("Carga de item en carta exitosa.");
			return true;
		}
		return false;
	}
	
	public boolean eliminarItemCarta (ItemDeCarta itdc){
		if (buscarItemDeCarta (itdc.getNombre()) != null){
			this.itemsCarta.remove(itdc);
			System.out.println("Item eliminado de la carta con exito.");
			return true;
		}
		return false;
	}

	
}
