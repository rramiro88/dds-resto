package modelo;

import java.util.Vector;

import controlador.ItemDeCartaView;


public abstract class ItemDeCarta {
	protected String name;
	protected float price;
	protected Vector <Ingrediente> ingredientes;

	
//	Constructor de instancia ItemDeCarta
//	-------------------------------------------------------------	
	public ItemDeCarta (String nombre, float precio){
		this.name = nombre;
		this.price = precio;
		ingredientes = new Vector<Ingrediente>();
	}

	
//	Metodo que genera un ItemDeCartaView para pasar a la vista
//	-------------------------------------------------------------	
	public ItemDeCartaView getItemDeCartaView(){
		ItemDeCartaView icv = new ItemDeCartaView(name, price);
		return icv;
	}

	
//	Metodos sets y gets para los atributos de la clase ItemDeCarta
//	-------------------------------------------------------------	

	public String getNombre() {
		return name;
	}
	public void setNombre(String name) {
		this.name = name;
	}

	public float getPrecio() {
		return price;
	}
	public void setPrecio(float price) {
		this.price = price;
	}

	
//	Metodos que operan con Ingredientes
//	-------------------------------------------------------------	
	private Ingrediente buscarIngrediente (Producto prod){
 		for (int i=0; i<ingredientes.size(); i++){
 			Ingrediente ingred = ingredientes.elementAt(i);
			if (ingred.getProducto().equals(prod)){
				return ingred;
			}
		}
		return null;
	}

	//	El producto del ingrediente se valida en Restaurante.
	public boolean agregarIngrediente(Producto prod, float cant){
		Ingrediente com = buscarIngrediente (prod);
		if (com == null){
			com = new Ingrediente (prod, cant);
			ingredientes.add(com);
			return true;
		}
		return false;
	}
	
	//	El producto del ingrediente se valida en Restaurante.
	public boolean eliminarIngrediente(Producto prod){
		Ingrediente com = buscarIngrediente (prod);
		if (com != null){
			ingredientes.remove(com);
			return true;
		}
		return false;
	}
	

//	Metodos para preparar items de carta (platos - bebidas)
//	-------------------------------------------------------------	
	/*	Revisa que la cantidad total de ingrediente alcance para
		preparar el total de items de carta requeridos.				*/
	public boolean esPreparable(int cantidadItemsDeCarta){
		//	Recorre todos los ingredientes del plato o bebida
		for (int i=0; i<ingredientes.size(); i++){
			Ingrediente ing = ingredientes.elementAt(i);
			// Revisa que el ingrediente pueda prepararse
			if (!ing.esSuficiente(cantidadItemsDeCarta * ing.getCantidad()))
				return false;
		}
		return true;
	}
	
	//	Ordena al ingrediente preparar el total de items de carta requeridos
	public void preparar (int cantidadItemsDeCarta){
		for (int i=0; i<ingredientes.size(); i++){
			Ingrediente ing = ingredientes.elementAt(i);
			ing.usar((ing.getCantidad()*cantidadItemsDeCarta));
		}
	}

	
}
