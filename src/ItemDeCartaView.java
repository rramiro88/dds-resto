import java.util.Vector;

public abstract class ItemDeCartaView {
	private String name;
	private float price;
	private Vector <Ingrediente> ingredientes;
	boolean disponible;
	private int nroItem;
	private static int ultimoNroItem = 0;
	static final String[] encabezados = {"Nombre", "Precio", "Habilitar"};

	
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
	
	/* En el form de Alta de Carta queremos que se pueda dar un nombre y 
	 * seleccionar los ítem que la compondrán. Entonces hay que mostrar todos los
	 * items existentes y permitir darlos de alta para esa carta.
	 * Ver como manejamos eso en una tabla
	 */
	static public Vector getEncabezados() {
		Vector v = new Vector();
		for (int i=0; i<encabezados.length; i++){
			v.add(encabezados[i]);
		}
		return v;
	}
	
	public Vector toVector()
	{
		Vector v = new Vector();
		v.add(name);
		v.add(price);
		return v;
	}
	
}