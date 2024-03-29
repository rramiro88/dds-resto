package controlador;

import java.util.Vector;

import modelo.*;


public class Restaurante {
	static private Restaurante restaurante = null;

	private boolean mesasAsignadas;
	private boolean open;

	//	La fecha y el dia se cargan como String al inciciar el Sistema.
	//	Se leen desde la hora y fecha configurada en el sistema operativo.
	private String fecha;	//	Formato dd/mm/aaaa
	private String dia;		//	lunes - martes - mi�rcoles - jueves - viernes - s�bado - domingo
	
	private Carta cartaActiva;

	private Vector <ItemDeCarta>	itemsCarta;
	private Vector <Carta> 			cartas;
	private Vector <Mozo> 			mozos;
	private Vector <Mesa> 			mesas;
	private Vector <Comanda> 		comandas;
	private Vector <Proveedor> 		proveedores;
	private Vector <OrdenDeCompra> 	ordenesCompra;
	private Vector <Producto> 		productos;

//	Constructor de instancia Restaurante
//	-------------------------------------------------------------	
	private Restaurante (){
		itemsCarta 		= new Vector <ItemDeCarta>();
		cartas 			= new Vector <Carta>();
		mozos 			= new Vector <Mozo> ();
		mesas 			= new Vector <Mesa> ();
		comandas 		= new Vector <Comanda> ();
		proveedores 	= new Vector <Proveedor>();
		ordenesCompra 	= new Vector <OrdenDeCompra>();
		productos 		= new Vector <Producto>();
		open			= false;

/**		-------------------------------------------------------------
 **		Metodos que cargan datos - USAR EN LAS PRUEBAS Y BORRAR	!!!! 
 **		-------------------------------------------------------------
 **/
		//	Mesas 12 (10 habilitadas, 2 deshabilitadas)
		for (int i=0; i<5; i++)
			altaDeMesa(true);
		for (int i=0; i<2; i++)
			altaDeMesa(false);
		for (int i=0; i<5; i++)
			altaDeMesa(true);
		//	Mozos
		altaDeMozo("Cacho Garay", 15, true);
		altaDeMozo("Jorge Buenaventua", 20, true);
		altaDeMozo("Chichilo Viale", 9, false);
		altaDeMozo("Flaco Pailos", 12, true);

		//	Proveedores
		altaDeProveedor("99999999995", "La Vaca Loca", "Lavalle 111");
		altaDeProveedor("21636582139", "La Botilleria de Jose", "Alsina 888");
		altaDeProveedor("20123456783", "Verduleria El Choclo Feliz", "Marcelo T 231");
		Proveedor prov = buscarProveedor("99999999995");
		Proveedor prov2 = buscarProveedor("21636582139");
		Proveedor prov3 = buscarProveedor("20123456783");
		//	Productos
		altaDeProducto("lomo", 1000, 100, 5000, prov);
		altaDeProducto("pollo", 1500, 80, 2000, prov);
		altaDeProducto("papa", 800, 100, 1200, prov3);
		altaDeProducto("ravioles", 1000, 550, 1000, prov2);
		altaDeProducto("tomate", 1000, 550, 1000, prov3);		
		altaDeProducto("vino tinto", 20, 18, 8, prov2);
		altaDeProducto("gaseosa naranja", 20, 4, 8, prov2);
		altaDeProducto("gaseosa cola", 20, 4, 8, prov2);
		altaDeProducto("agua sin gas 500cc", 200, 40, 80, prov3);
		
		//	Items de Carta		
		altaDePlato("Pollo con Papas", 18);
		ItemDeCarta polloPapas = buscarItemDeCarta ("Pollo con Papas");
		polloPapas.agregarIngrediente(buscarProducto("pollo"), 120);
		polloPapas.agregarIngrediente(buscarProducto("papa"), 85);
		
		altaDePlato("Ravioles con Tuco", 12);
		ItemDeCarta raviolesTuco = buscarItemDeCarta ("Ravioles con Tuco");
		raviolesTuco.agregarIngrediente(buscarProducto("ravioles"), 230);
		raviolesTuco.agregarIngrediente(buscarProducto("tomate"), 35);
		
		altaDePlato("Lomo con Fritas", 24);
		ItemDeCarta lomoF = buscarItemDeCarta ("Lomo con Fritas");
		lomoF.agregarIngrediente(buscarProducto("lomo"), 100);
		lomoF.agregarIngrediente(buscarProducto("papa"), 150);
		
		altaDeBebida("Fanta Naranja", 8);
		ItemDeCarta gaseosa = buscarItemDeCarta ("Fanta Naranja");
		gaseosa.agregarIngrediente(buscarProducto("gaseosa naranja"), 1);
		
		altaDeBebida("Trapiche Malbec", 16);
		ItemDeCarta vinoT = buscarItemDeCarta ("Trapiche Malbec");
		vinoT.agregarIngrediente(buscarProducto("vino tinto"), 1);
		
		altaDeBebida("Agua sin Gas 500cc", 5);
		ItemDeCarta agua = buscarItemDeCarta ("Agua sin Gas 500cc");
		agua.agregarIngrediente(buscarProducto("agua sin gas 500cc"), 1);

		//	Cartas
		altaDeCarta("mi�rcoles");
		Carta carta2 = buscarCarta("mi�rcoles");
		carta2.agregarItemCarta(vinoT);
		carta2.agregarItemCarta(raviolesTuco);
		altaDeCarta("jueves");
		Carta carta = buscarCarta("jueves");
		carta.agregarItemCarta(gaseosa);
		carta.agregarItemCarta(vinoT);
		carta.agregarItemCarta(polloPapas);
		altaDeCarta("viernes");
		Carta carta3 = buscarCarta("viernes");
		carta3.agregarItemCarta(gaseosa);
		carta3.agregarItemCarta(vinoT);
		carta3.agregarItemCarta(polloPapas);
		carta3.agregarItemCarta(agua);
		carta3.agregarItemCarta(lomoF);
		altaDeCarta("s�bado");
		Carta carta1 = buscarCarta("s�bado");
		carta1.agregarItemCarta(gaseosa);
		carta1.agregarItemCarta(polloPapas);
		carta1.agregarItemCarta(vinoT);
		carta1.agregarItemCarta(agua);
		carta1.agregarItemCarta(lomoF);
	}
/**				BORRAR LOS DATOS INGRESADOS ARRIBA
 **	------------------------------------------------------------	**/	

	
//	SINGLETON Restaurante getRestaurante()
//	-------------------------------------------------------------
	static public Restaurante getRestaurante(){
		if (restaurante == null){
			restaurante = new Restaurante();
		}
		return restaurante;
	}

	
//	Metodos sets y gets para los atributos de Restaurante
//	-------------------------------------------------------------	
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getFecha() {
		return fecha;
	}

	public String getDia() {
		return dia;
	}
	public void setDia(String dia) {
		this.dia = dia;
	}

	public boolean isMesasAsignadas() {
		return mesasAsignadas;
	}
	private void setMesasAsignadas(boolean mesasAsignadas) {
		this.mesasAsignadas = mesasAsignadas;
	}

	public boolean isOpen() {
		return open;
	}
	private void setOpen(boolean open) {
		this.open = open;
	}

	private void setCartaActiva(Carta cartaActiva) {
		this.cartaActiva = cartaActiva;
	}

	
//	Metodos de jornada (apertura y cierre)
//	-------------------------------------------------------------		
	public boolean abrirJornada(){
		//	Revisa que exista una carta creada para asignar al presente dia
		if (buscarCarta(dia)==null){
				return false;
			}
		// Revisa que halla mozos y mesas disponibles para iniciar la jornada
		if ((mozos == null) || (mesas == null)){
				return false;
		}else{
			//	Hay carta del dia, hay mozos y hay mesas; ergo, abre la jornada.
			asignarMesas();
			setOpen(true);
			//	Asignar la carta activa del dia
			setCartaActiva(buscarCarta(dia));
			return true;
		}
	}
	
	public boolean cerrarJornada(){
		for (int i = 0; i<mesas.size(); i++){
			if (mesas.elementAt(i).isOcupada()){
				return false;
			}
		}
		pagarMozos();
		generarOrdenesDeCompra();
		setOpen(false);
		return true;
	}

/**
  * -----------------------------------------------------------------------------
  * ------------------  ABM - BUSCAR de las clases del NEGOCIO  -----------------
  * ----------------------------------------------------------------------------- 
  * 
  **/	
	
//	ABM - BUSCAR	Items De Carta (platos o bebidas)
//	-----------------------------------------------------
	private ItemDeCarta buscarItemDeCarta (String nombre){
 		for (int i=0; i<itemsCarta.size(); i++){
			ItemDeCarta idecarta = itemsCarta.elementAt(i);
			if (idecarta.getNombre().equals(nombre)){
				return idecarta;
			}
		}
 		return null;
	}

	public void altaDePlato (String nombre, float precio){
		ItemDeCarta itemc = buscarItemDeCarta(nombre);
		if (itemc == null){
			Plato redondo = new Plato (nombre, precio);
			itemsCarta.add(redondo);
		}
	}

	public void altaDeBebida (String nombre, float precio){
		ItemDeCarta itemc = buscarItemDeCarta(nombre);
		if (itemc == null){
			Bebida vaso = new Bebida (nombre, precio);
			itemsCarta.add(vaso);
		}
	}	

	public void bajaDeItemDeCarta (String nombre){
		ItemDeCarta itemc = buscarItemDeCarta(nombre);
		if (itemc != null){
			itemsCarta.remove(itemc);
		}
	}

	public void modificarItemDeCarta (String nombreViejo, String nombreNuevo, float precio){
		ItemDeCarta itcar = buscarItemDeCarta(nombreViejo);
		if (itcar != null){
			itcar.setNombre(nombreNuevo);
			itcar.setPrecio(precio);
		}
	}

	//	Carga un producto en un plato/bebida
	public boolean cargarIngrediente (String nombreItem, String nombreProducto, float cantidad){
		//	Revisa que existan el plato/bebida y el producto
		ItemDeCarta itemc = buscarItemDeCarta(nombreItem);
		Producto prod = buscarProducto (nombreProducto);
		if (prod != null && itemc != null){
			return (itemc.agregarIngrediente(prod, cantidad));
		}
		return false;
	}

	//	Elimina un producto existente de un plato/bebida
	public boolean descargarIngrediente (String nombreItem, String nombreProducto){
		//	Revisa que existan el plato/bebida y el producto
		ItemDeCarta itemc = buscarItemDeCarta(nombreItem);
		Producto prod = buscarProducto (nombreProducto);
		if (prod != null && itemc != null){
			return (itemc.eliminarIngrediente(prod));
		}
		return false;
	}
	
	
//	ABM - BUSCAR	Cartas
//	-----------------------------------------------------
	private Carta buscarCarta (String dia){
 		for (int i=0; i<cartas.size(); i++){
			Carta car = cartas.elementAt(i);
			if (car.getDia().equals(dia)){
				return car;
			}
		}
 		return null;
	}

	//	Comprueba que el dia de semana sea valido
	public boolean diaValido (String dia){
		if (dia.equalsIgnoreCase("lunes"))
			return true;
		else
			if (dia.equalsIgnoreCase("martes"))
				return true;
			else
				if (dia.equalsIgnoreCase("mi�rcoles"))
					return true;
				else
					if (dia.equalsIgnoreCase("jueves"))
						return true;
					else
						if (dia.equalsIgnoreCase("viernes"))
							return true;
						else
							if (dia.equalsIgnoreCase("s�bado"))
								return true;
							else
								if (dia.equalsIgnoreCase("domingo"))
									return true;
								else
									return false;
	}
	
	public boolean altaDeCarta (String dia){
		boolean valido = diaValido(dia);
		//	Revisa que el dia sea valido
		if (valido){
			Carta letter = buscarCarta(dia);
			//	Revisa que la carta no halla sido creada
			if (letter == null){
				letter = new Carta (dia);
				cartas.add(letter);
				return true;
			}
		}
		return false;
	}

	public boolean bajaDeCarta (String dia){
		boolean valido = diaValido(dia);
		//	Revisa que el dia sea valido
		if (valido){
			Carta letter = buscarCarta(dia);
			//	Revisa que la carta exista
			if (letter != null){
				cartas.remove(letter);
				return true;
			}
		}
		return false;
	}

	//	La modificacion consiste en cambiar una carta de un dia a otro.
	public boolean modificarCarta (String diaViejo, String diaNuevo){
		boolean validoViejo = diaValido(diaViejo);
		boolean validoNuevo = diaValido(diaNuevo);
		//	Revisa que ambos dias sean validos
		if (validoViejo && validoNuevo){
			//	Revisa que no exista una carta con el mismo nombre a asignar
			//	para que no pueda haber dos cartas del mismo dia.
			Carta letterVieja = buscarCarta(diaViejo);
			Carta letterNueva = buscarCarta(diaNuevo);
			if (letterVieja != null || letterNueva == null ){
				letterVieja.setDia(diaNuevo);
				return true;
			}
		}
		return false;
	}

	//	Carga un plato o bebida en la carta
	public boolean cargarCarta (String nombreCarta, String nombreItem){
		//	Revisa que existan la carta y el plato/bebida
		Carta letter = buscarCarta(nombreCarta);
		ItemDeCarta itemc = buscarItemDeCarta(nombreItem);
		if (letter != null && itemc != null){
			return (letter.agregarItemCarta(itemc));
		}
		return false;
	}

	//	Elimina un plato o bebida existentes de una carta
	public boolean descargarCarta (String nombreCarta, String nombreItem){
		//	Revisa que existan la carta y el plato/bebida
		Carta letter = buscarCarta(nombreCarta);
		ItemDeCarta itemc = buscarItemDeCarta(nombreItem);
		if (letter != null && itemc != null){
			return (letter.eliminarItemCarta(itemc));
		}
		return false;
	}

	
//	ABM - BUSCAR	Productos
//	-----------------------------------------------------
	private Producto buscarProducto (String nombre){
 		for (int i=0; i<productos.size(); i++){
			Producto prod = productos.elementAt(i);
			if (prod.getNombre().equals(nombre)){
				return prod;
			}
		}
 		return null;
	}
	
	private void altaDeProducto (String nombre, int cantidad, int pedido, int reab, Proveedor prov){
		Producto prod = buscarProducto(nombre);
		if (prod == null){
			prod = new Producto(nombre, cantidad, pedido, reab, prov);
			productos.add(prod);
		}
	}
	
	public void altaDeProductoFromView (String nombre, int cantidad, int pedido, int reab, String cuit){
		Proveedor proveedor = buscarProveedor(cuit);
		Producto prod = buscarProducto(nombre);
		if ((prod == null) && (proveedor != null)){
			prod = new Producto(nombre, cantidad, pedido, reab, proveedor);
			productos.add(prod);

		}
	}

	public void bajaDeProducto (String nombre){
		Producto prod = buscarProducto(nombre);
		if (prod != null){
			productos.remove(prod);
		}
	}
	
	public void modificarProducto (String name, float canti, float puntop, float puntor, String prove){
		Proveedor prov = buscarProveedor(prove);
		Producto prod = buscarProducto(name);
		if (prod != null || prov != null){
			prod.setNombre(name);
			prod.setCantidad(canti);
			prod.setPuntoped(puntop);
			prod.setPuntoreab(puntor);
			prod.setProveedor(prov);
		}		
	}

	//	Actualizar stock cuando ingresa mercaderia nueva
	public void ingresarMercaderia (String produc, float cantidad){
		Producto prod = buscarProducto(produc);
		if (prod != null){
			prod.setCantidad(prod.getCantidad()+cantidad);
		}
	}

	
//	ABM - BUSCAR	Proveedores
//	-----------------------------------------------------
	 private Proveedor buscarProveedor (String cuit){
	 	for (int i=0; i<proveedores.size(); i++){
	 		Proveedor prov = proveedores.elementAt(i);
			if (prov.getCuit().equals(cuit)){
				return prov;
			}
		}
		return null;
	}

	public void altaDeProveedor (String cuit, String razonsocial, String domicilio){
		Proveedor prov = buscarProveedor(cuit);
		if (prov == null){
			prov = new Proveedor(cuit, razonsocial, domicilio);
			proveedores.add(prov);
		}
	}

	public void bajaDeProveedor (String cuit){
		Proveedor prov = buscarProveedor(cuit);
		if (prov != null){
			proveedores.remove(prov);
		}
	}

	public boolean modificarProveedor(String cuit, String razonsocial, String domicilio){
		Proveedor prov = buscarProveedor(cuit);
		if (prov != null){
			prov.setCuit(cuit);
			prov.setDomicilio(domicilio);
			prov.setRazonsocial(razonsocial);
			return true;
		}
		return false;
	}


//	ABM - BUSCAR	Ordenes de Compra
//	-----------------------------------------------------
	private OrdenDeCompra buscarOrdenDeCompra (Proveedor prove, String date){
	 	for (int i=0; i<ordenesCompra.size(); i++){
	 		OrdenDeCompra ord = ordenesCompra.elementAt(i);
	 		//	Busca la orden de compra segun el Proveedor
	 		if (ord.getProveedor().equals(prove)){
	 			//	Compara fechas
				if(ord.getFecha().equals(date)){
					return ord;
				}
			}
		}
		return null;
	}

	/*	Genera un vector con productos bajo punto de pedido, correspondientes
		a un mismo proveedor. El vector se utiliza en altaDeOrdenDeCompra.		*/
	private Vector<Producto> productosBajoPuntoPedido(Proveedor bajoProve){
		Vector<Producto> produc = new Vector <Producto>();
		for (int i= 0; i<productos.size(); i++){
			Producto prod = productos.elementAt(i);
			if (prod.getProveedor().equals(bajoProve)){
				if (prod.estaBajoPuntoPedido()){
					produc.add(prod);
				}
			}
		}
		return produc;	//	Vector con los productos (de un proveedor) bajos en stock. 
	}

	/*	Genera las ordenes automaticamente para los productos bajos en stock. 
		Es UNA orden por proveedor, por dia. El proveedor fue validado previamente.	*/
	private int altaDeOrdenDeCompra (Proveedor prov){
		OrdenDeCompra ord = buscarOrdenDeCompra(prov, fecha);
		if (ord == null){
			//	Vector generado por productosBajoPuntoPedido
			Vector<Producto> itemsApedir = productosBajoPuntoPedido(prov);
			//	Revisa que el vector de productos a pedir no est� vac�o.
			if (!itemsApedir.isEmpty()){
				ord = new OrdenDeCompra(prov, fecha);
				//	Carga los items de pedido
				for (int i= 0; i<itemsApedir.size(); i++){
					Producto prod = itemsApedir.elementAt(i);
					ord.agregarItemDePedido(prod, prod.getPuntoreab());
				}
				//	Agrega la orden de compra al vector de ordenes de compra
				ordenesCompra.add(ord);
				// Devuelve uno para contabilizar las ordenes de compra creadas.
				return 1;
			}
		}
		//	Devuelve cero si no se creo la orden de compra.
		return 0;
	}

	//	Genera todas las ordenes de compra para los productos bajos en stock
	public int generarOrdenesDeCompra(){
		int ord = 0;
		for (int i=0; i<proveedores.size(); i++){
			Proveedor prov = proveedores.elementAt(i);
			int ord1 = altaDeOrdenDeCompra (prov);
			ord = ord + ord1;
		}
		return ord;
	}
	
	
//	ABM - BUSCAR	Mozos
//	-----------------------------------------------------
	private Mozo buscarMozo (int id){
 		for (int i=0; i<mozos.size(); i++){
			Mozo m = mozos.elementAt(i);
			if (m.getId()==id){
				return m;
			}
		}
 		return null;
	}

	public void altaDeMozo (String nombre, int comision, boolean habilitado){
		Mozo mozo = new Mozo (nombre, comision, habilitado);
		mozos.add(mozo);
	}
	
	public void bajaDeMozo (int idMozo){
		Mozo garzon = buscarMozo(idMozo);
		if (garzon != null){
			mozos.remove(garzon);
		}
	}

	public void modificarMozo(int id, String nombre, int comision, boolean habilitado){
		Mozo m = buscarMozo(id);
		if (m != null){
			m.setNombre(nombre);
			m.setComision(comision);
			m.setHabilitado(habilitado);
		}
	}

	
	//----------------------------------------------------------
	//	METODOS CON MESAS
	//----------------------------------------------------------
	public int getCantMesasHabilitadas (){
		int mesasOk = 0;
		for (int i=0; i<mesas.size(); i++){
			if (mesas.elementAt(i).isHabilitada()){
				mesasOk++;
			}
		}
		return mesasOk;
 	}
	
	//	Asigna las mesas a cada mozo.
	//	Determina cuantas mesas quedan habilitadas y que mozo atiende cada mesa.
	public void asignarMesas(){
		int indice=0;
		int i=0, j=0;
		
		int mozosHab = getCantMozosHabilitados();
		int mesasHab = getCantMesasHabilitadas();
		
		if (!mozos.isEmpty() && !mesas.isEmpty()){
			if (mozosHab >= mesasHab){
				while (i<mesas.size() && j<mozos.size()){
					Mesa mesa = mesas.elementAt(i);
					Mozo mozo = mozos.elementAt (j);
					if (mozo.isHabilitado() && mesa.isHabilitada()){
						mesas.elementAt(i).setMozo(mozos.elementAt(j));
						mesas.elementAt(i).setAsignada(true);
						i++;
						j++;
					}else{
						// La mesa esta habilitada pero el mozo no
						if (mesa.isHabilitada())
							j++;
						else	// La mozo esta habilitado pero la mesa no
							i++;
					}
				}
			}else{
				int mesasXmozo = mesasHab / mozosHab;
				for (i=0; i<mozos.size(); i++){
					j=0;
					Mozo mozo = mozos.elementAt (i);
					if (mozo.isHabilitado()){
						while (j<mesasXmozo){
							if (mesas.elementAt(indice).isHabilitada()){
								mesas.elementAt(indice).setMozo(mozos.elementAt(i));
								mesas.elementAt(indice).setAsignada(true);
								indice++;
								j++;
							}else
								indice++;
						}
					}else{
						continue;
					}
				}
			}
			setMesasAsignadas(true);
		}
	}
	
	public void cerrarMesa (int nroMesa){
 		Mesa mesa = buscarMesa(nroMesa);
 		mesa.cerrarMesa();
 	}
 	
 	public float getTotalComanda(int nroMesa){
 		float totalMesa = 0;
 		Mesa m = buscarMesa(nroMesa);
 		if ((m != null) && (m.isOcupada()))
 			totalMesa = m.getTotal();
 		return totalMesa;
 	}
	
	//----------------------------------------------------------
	//	METODOS CON MOZOS
	//----------------------------------------------------------
	public int getCantMozosHabilitados (){
		int mozosOk = 0;
		for (int i=0; i<mozos.size(); i++){
			if (mozos.elementAt(i).isHabilitado()){
				mozosOk++;
			}
		}
		return mozosOk;
 	}
	
	public void habilitarMozo (int idMozo){
		Mozo mozoHab = buscarMozo(idMozo);
		if (mozoHab != null){
			mozoHab.setHabilitado(true);
		}
	}
	
	public void deshabilitarMozo (int idMozo){
		Mozo mozoHab = buscarMozo(idMozo);
		if (mozoHab != null){
			mozoHab.setHabilitado(false);
		}
	}
	
	private Vector<Comanda> buscarComandasMozo(Mozo mozo){
		Vector<Comanda> comandasMozo = new Vector<Comanda>();
		for (int i = 0; i<comandas.size(); i++){
			if (comandas.elementAt(i).getMozo().equals(mozo)){
				comandasMozo.add(comandas.elementAt(i));
			}
		}
		return comandasMozo;
	}
	
	public void pagarMozos(){
		float totalMozo;
		int cantMozos = mozos.size();
		//Vector <Mozo> moz = getMozos();
		for (int j=0; j<cantMozos; j++){
			totalMozo = 0;
			//Mozo mozo = restaurante.buscarMozo(j);
			Mozo mozo = mozos.elementAt(j);
			if (mozo != null){
				Vector<Comanda> comandasMozo = buscarComandasMozo(mozo);
				if (comandasMozo != null){
					for (int i=0; i<comandasMozo.size(); i++){
						totalMozo = totalMozo + comandasMozo.elementAt(i).getTotal();
					}
					totalMozo = (totalMozo * mozo.getComision()) / 100;
					mozo.setLiquidacion(totalMozo);
				}
			}		
		}
	}
	
	
//	ABM - BUSCAR	Mesas
//	-----------------------------------------------------
	private Mesa buscarMesa(int id){
		int i = 0;
		while (i < mesas.size()){
			Mesa m = mesas.elementAt(i);
			if (m.getNroMesa() == id)
				return m;
			else
				i++;
		}
		return null;
	}

	public void altaDeMesa (boolean habilitada){
		Mesa mesaNew = new Mesa (habilitada);
		mesas.add(mesaNew);
	}

	public void bajaDeMesa(int id){
		Mesa table = buscarMesa(id);
		if (table != null){
			mesas.remove(table);
		}
	}

	public void modificarMesa(int id, boolean estado){
		Mesa table = buscarMesa(id);
		if (table != null){
			table.setHabilitada(estado);
		}
	}
	
	public int cantidadMesas (){
 		return (mesas.size());
 	}

	public void abrirMesa (Mesa m){
		Comanda c = m.abrirMesa();
		comandas.add(c);
	}
	
	public void agregarItemComanda(int nroMesa, String nombreItemCarta, int cant){
		Mesa m = buscarMesa(nroMesa);
		if (m != null){
			if (! m.isOcupada())
				abrirMesa(m);
			ItemDeCarta itemCarta = cartaActiva.buscarItemDeCarta(nombreItemCarta);
			if ((itemCarta != null) && itemCarta.esPreparable(cant)){
				m.agregarItemComanda(cant, itemCarta);
			}
		}
	}

	
	
//	Metodos que operan con Vectores View
//	-----------------------------------------------------

	//	CARTAS
	public CartaView getCartaView(String dia){
		Carta car = buscarCarta(dia);
		if (car!=null)
			return car.getCartaView();
		return null;
	}
	
	public Vector<CartaView> getCartasView(){
		Vector<CartaView> cv = new Vector<CartaView>();
		for (int i=0; i<cartas.size(); i++){
			cv.add(cartas.elementAt(i).getCartaView());
		}	
		return cv;
	}
	
	// ITEMS DE CARTA ACTIVA
	public Vector<ItemDeCartaView> getItemsDeCartaActivaView(){
		Vector<ItemDeCartaView> icv = new Vector<ItemDeCartaView>();
		for (int i=0; i<cartaActiva.getItemsCarta().size(); i++){
			icv.add(cartaActiva.getItemsCarta().elementAt(i).getItemDeCartaView());
		}	
		return icv;
	}

	// PLATOS / BEBIDAS
	public Vector<ItemDeCartaView> getItemsDeCartaView(){
		Vector<ItemDeCartaView> icv = new Vector<ItemDeCartaView>();
		for (int i=0; i<itemsCarta.size(); i++){
			icv.add(itemsCarta.elementAt(i).getItemDeCartaView());
		}	
		return icv;
	}

	
	//	PRODUCTOS
	public Vector<ProductoView> getProductosView(){
		Vector<ProductoView> mv = new Vector<ProductoView>();
		for (int i= 0; i < productos.size(); i++){
			mv.add(productos.elementAt(i).getProductoView());
		}	
		return mv;
	}
	
	//	PROVEEDORES
	public Vector<ProveedorView> getProveedoresView(){ 
		Vector<ProveedorView> mv = new Vector<ProveedorView>();
		for (int i= 0; i < proveedores.size(); i++){
			mv.add(proveedores.elementAt(i).getProveedorView());
		}
		return mv;
	}

	//	MOZOS		
 	public Vector<MozoView> getMozosView(){ 
		Vector<MozoView> mv = new Vector<MozoView>();
		for (int i= 0; i < mozos.size(); i++)
		{
			mv.add(mozos.elementAt(i).getMozoView());
		}
		return mv;
	}

 	//	MESAS
 	public Vector<MesaView> getMesasView(){ 
		Vector<MesaView> mv = new Vector<MesaView>();
		for (int i= 0; i < mesas.size(); i++){
			mv.add(mesas.elementAt(i).getMesaView());
		}
		return mv;
 	}
 	
 	
}
