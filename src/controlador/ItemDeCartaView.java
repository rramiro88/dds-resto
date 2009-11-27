package controlador;

public class ItemDeCartaView {
	private String name;
	private float price;
	
//	Constructor de instancia ItemDeCartaView
//	-------------------------------------------------------------	
	public ItemDeCartaView (String nombre, float precio){
		this.name = nombre;
		this.price = precio;
	}

//	Metodos sets y gets para los atributos de la clase ItemDeCartaView
//	-------------------------------------------------------------	
	public String getNombre() {
		return name;
	}
	
	public float getPrecio() {
		return price;
	}
}