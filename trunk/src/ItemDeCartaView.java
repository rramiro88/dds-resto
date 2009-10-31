import java.util.Vector;

public abstract class ItemDeCartaView {
	private String name;
	private float price;
	private Vector <Ingrediente> ingredientes;
	boolean disponible;
	private int nroItem;
	private static int ultimoNroItem = 0;

	
//	Constructor de instancia ItemDeCarta
//	-------------------------------------------------------------	
	public ItemDeCartaView (String nombre, float precio){
		this.name = nombre;
		this.price = precio;
		ingredientes = new Vector<Ingrediente>();
		this.disponible = true;
		nroItem = getProximoNroItem();
	}

//	Metodos sets y gets para los atributos de la clase ItemDeCarta
//	-------------------------------------------------------------	
	private int getProximoNroItem(){
		return ++ultimoNroItem;		
	}
	public int getNroItem() {
		return nroItem;
	}

	public String getNombre() {
		return name;
	}
	public float getPrecio() {
		return price;
	}
	public Vector<Ingrediente> getIngredientes() {
		return ingredientes;
	}
	
}