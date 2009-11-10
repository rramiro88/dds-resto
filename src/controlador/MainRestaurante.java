package controlador;

import java.io.*;
import java.util.Vector;

public class MainRestaurante {
	private Restaurante restaurante;

//	Metodos de Main Restaurante	
//	-------------------------------------------------------------
	public MainRestaurante(){
		super();
		//restaurante = new Restaurante();
	}
	public void setRestaurante(Restaurante newRestaurante) {
		restaurante = newRestaurante;
	}
	public Restaurante getRestaurante() {
		return restaurante;
	}
	public static void main(String[] args) {
		MainRestaurante main = new MainRestaurante();
		main.menuPrincipal();
	}
	
/**	 
 * 	 -----------------------------------------------------------------------
 * 	 --------------------------  MENU DE OPCIONES --------------------------
 *   -----------------------------------------------------------------------
**/ 

/*
	-- Menu principal de opciones --
 */	
	public void menuPrincipal(){
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(" ");
		System.out.println("-----*-----*-----*-----*-----*-----");
		System.out.println("MENU PRINCIPAL");
		System.out.println("-----*-----*-----*-----*-----*-----");
		System.out.println("1.- Cocina");
		System.out.println("2.- Atencion al publico");
		System.out.println("3.- Menu - Platos - Bebidas");
		System.out.println("4.- Menu de administracion");
		System.out.println("5.- Salir del sistema");
		System.out.println("-----*-----*-----*-----*-----*-----");
		System.out.println("-----*-----*-----*-----*-----*-----");
		System.out.println(" ");
		System.out.print("Opcion:");
		try	{
			char s = (char)reader.read();
		  	switch (s){
			  	case '1' : {this.menuCocina();
			  	break;
			  	}
			  	case '2' : {this.menuAttpub();
			  	break;
		  		}
			  	case '3' : {this.menuCarta();
			  	break;
				}
			  	case '4' : {this.menuAdministracion();
			  	break;
				}
			  	case '5' : {this.salir();
			  	break;
				}
		  	}
		}
		catch (Exception e)	{
		}
	}

/*
	-- Menu de opciones sobre stock - proveedores - ordenes de compra - productos --
 */	
	public void menuCocina(){
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(" ");
		System.out.println("OPCIONES de Cocina");
		System.out.println("-----*-----*-----*-----*-----*-----");
		System.out.println("1.- ingresar opcion 1");
		System.out.println("2.- ingresar opcion 2");
		System.out.println("3.- ingresar opcion 3");
		System.out.println("4.- Volver al menu principal");
		System.out.println("-----*-----*-----*-----*-----*-----");
		System.out.println(" ");
		System.out.print("Opcion:");
		try	{
			char s = (char)reader.read();
		  	switch (s){
			  	case '1' : {this.menuPrincipal();
			  	break;
			  	}
			  	case '2' : {this.menuPrincipal();
			  	break;
		  		}
			  	case '3' : {this.menuPrincipal();
			  	break;
				}
			  	case '4' : {this.menuPrincipal();
			  	break;
				}
		  	}
		}
		catch (Exception e)	{
		}
	}

/**
  * 
  * En este espacio van todos los metodos main respectivos a
  * proveedores, ordenes de compra, productos, e items de pedido
  * comandas e items de comanda.
  * 
  * 
  **/


/*
 	-- Menu de opciones sobre mozos - mesas - comandas - items de comanda --
 */	
	public void menuAttpub(){
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	 	
		System.out.println(" ");
		System.out.println("OPCIONES de atencion al publico");
		System.out.println("-----*-----*-----*-----*-----*-----");
		System.out.println("1.- Abrir Comanda de una Mesa");
		System.out.println("2.- Agregar Item a una comanda");
		//System.out.println("3.- Eliminar Item a una comanda");//falta
		System.out.println("4.- Cerrar Comanda");
		//System.out.println("5.- Listar comandas abiertas");//falta
		//System.out.println("6.- Listar todas las comandas del dia");//falta
		System.out.println("9.- Volver al menu principal");
		System.out.println("-----*-----*-----*-----*-----*-----");
		System.out.println(" ");
		System.out.print("Opcion:");
		try	{
			char s = (char)reader.read();
		  	switch (s){
			  	case '1' : {this.abrirMesa();
			  	break;
			  	}
			  	case '2' : {this.agregarItemComanda();
			  	break;
		  		}
			  	case '4' : {this.cerrarComanda();
			  	break;
				}
			  	case '9' : {this.menuPrincipal();
			  	break;
				}
		  	}
		}
		catch (Exception e)	{
		}		
	}
	
	/**
	  * 
	  * En este espacio van todos los metodos main respectivos 
	  * a mozos, mesas comandas e items de comanda.
	  * 
	  * 
	  **/
	
	
	//Se llamaba abrirComanda() en la primer entrega. Creo que abrirMesa es m�s claro.
	//Lo que hace, si est�n dadas las condiciones, es llamar a restaurante.abrirMesa(m)
	//que crear� la comanda activa para esa mesa. La comanda es el todo, los pedidos que
	//se van realizando son items de comanda.
	public void abrirMesa (){
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(" ");
		System.out.println("Ingrese la mesa a iniciarle una comanda");
		int nroMesa;
		
		try {
			nroMesa = Integer.parseInt(reader.readLine());
			Mesa m = restaurante.buscarMesa(nroMesa);
			if (m != null){
				if (m.isHabilitada()){
					if (! m.isOcupada()){
						restaurante.abrirMesa(m);
						
						//Comanda c = m.abrirMesa();
						//comandas.add(c);	
					}else{
						System.out.println("La mesa est� ocupada. Se debe finalizar la comanda activa.");
					}
				}else{
					System.out.println("La mesa no se encuentra habilitada el d�a de hoy.");
				}
			}else{
				System.out.println("No existe la mesa " + nroMesa);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		menuAttpub();
	}
	
	public void agregarItemComanda(){
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		
		int nroMesa;
		//String nroItemCarta;
		int nroItemCarta;
		int cant;
		try {
			System.out.println(" ");
			System.out.println("Ingrese la mesa: ");
			nroMesa = Integer.parseInt(reader.readLine());
			
			System.out.println(" ");
			System.out.println("Ingrese el numero del Item/Menu: ");
			nroItemCarta = Integer.parseInt(reader.readLine());
			
			//nroItemCarta = reader.readLine();
			
			System.out.println(" ");
			System.out.println("Ingrese la Cantidad: ");
			cant = Integer.parseInt(reader.readLine());
			
			restaurante.agregarItemComanda(nroMesa,nroItemCarta,cant);
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		menuAttpub();
	}
	
	public void cerrarComanda (){
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(" ");
		System.out.println("Ingrese la mesa a cerrar");
		int nroMesa;
		
		try {
			nroMesa = Integer.parseInt(reader.readLine());
			Mesa m = restaurante.buscarMesa(nroMesa);
			if ((m != null) && (m.isOcupada())){
				float totalMesa = m.cerrarMesa();
				System.out.println("La mesa " + nroMesa + " consumi� por $" + totalMesa);
			}else{
				System.out.println("No existe la mesa o est� desocupada");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		menuAttpub();
	}
	
	
	
	
/*
 	-- Menu de opciones sobre administracion de resto --
*/	
	public void menuAdministracion(){
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	 	
		System.out.println(" ");
		System.out.println("OPCIONES de Administracion");
		System.out.println("-----*-----*-----*-----*-----*-----");
		System.out.println("	RESTAURANT ");
		System.out.println("1.- Abrir Jornada");
		System.out.println("2.- Asignar Mesas");
		System.out.println(" ");
		System.out.println("	MOZOS ");
		System.out.println("3.- Alta Mozo");
		System.out.println("4.- Habilitar Mozo para que trabaje en la jornada");
		System.out.println("5.- InHabilita Mozo para que trabaje en la jornada");
		System.out.println("6.- Modificar Nombre del Mozo");
		System.out.println("7.- Baja Mozo");
		System.out.println("8.- Pagar Mozos");
		System.out.println("9.- Cambiar comision a mozo");
		System.out.println(" ");
		System.out.println("	MESAS ");
		System.out.println("a.- Alta Mesa");
		//System.out.println("b.- Habilitar Mesa para que trabaje en la jornada"); //No va pero se deja
		//System.out.println("c.- InHabilita Mesa para que trabaje en la jornada");//No va pero se deja
		System.out.println("d.- Baja Mesa");
		System.out.println(" ");
		System.out.println("	LISTADOS ");
		System.out.println("e.- Listar Mozos y Status");
		System.out.println("f.- Listar Mesas y Status");
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("z.- Volver al menu principal");
		System.out.println("-----*-----*-----*-----*-----*-----");
		System.out.println(" ");
		System.out.print("Opcion:");
		try	{
			char s = (char)reader.read();
		  	switch (s){
			  	case '1' : {this.abrirJornada();
			  	break;
			  	}
			  	//case '2' : {this.asignarMesas();
			  	//break;
		  		//}
			  	//case '3' : {this.altaMozo();
			  	//break;
				//}
			  	//case '4' : {this.habilitarMozo();
			  	//break;
				//}
			  	//case '5' : {this.desHabilitarMozo();
			  	//break;
				//}
			  	//case '6' : {this.modificarNombreMozo();
			  	//break;
				//}
			  	//case '7' : {this.eliminarMozo();
			  	//break;
				//}
			  	/*
			  	case '8' : {this.habilitarMesa();
			  	break;
				}
			  	case '9' : {this.desHabilitarMesa();
			  	break;
				}
				*/
			  	case '8' : {this.pagarMozos();
			  	break;
				}
			  	//case '9' : {this.modificarComisionMozo();
			  	//break;
				//}
			  	case 'a' : {this.altaMesa();
			  	break;
				}
			  	case 'd' : {this.eliminarMesa();
			  	break;
				}
			  	case 'e' : {this.listarMozos();
			  	break;
				}
			  	case 'f' : {this.listarMesas();
			  	break;
				}
			  	case 'z' : {this.menuPrincipal();
			  	break;
				}
		  	}
		}
		catch (Exception e)	{
		}		
	}
	
/**
	  * 
	  * En este espacio van todos los metodos main respectivos a
	  * la administracion, como alta de mozos, de mesas, abrir el dia
	  * pagar a los mozos
	  * 
	  * 
**/
	
	public void abrirJornada(){
		if (restaurante.isOpen()){
			System.out.println("El restaurant ya se encuentra abierto");
		}else{
			if ((restaurante.cantidadMozos()==0) || (restaurante.cantidadMesas()==0)){
				System.out.println("No hay mozos o mesas para atender. Crearlos!!!");
			}else{
				if (!restaurante.isMesasAsignadas()){
					System.out.println("Debe asignar las mesas antes de abrir la jornada");
				}else{
					//asignarMesas();
					restaurante.setOpen(true);
					System.out.println("Restaurant ABIERTO!!!");
				}
			}
		}
		menuAdministracion();
	}
	
	
	
	public void pagarMozos(){
		System.out.println(" ");
		System.out.println("Le pagamos a los mozos");
		restaurante.pagarMozos();
	
		menuAdministracion();
	}
	
	
	public void modificarComisionMozo (){
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int id;
		float comision;
		try {
			System.out.println(" ");
			System.out.println("Ingrese el Numero de mozo: ");
			id = Integer.parseInt(reader.readLine());
			
			System.out.println(" ");
			System.out.println("Ingrese la comision: ");
			comision = Float.parseFloat(reader.readLine());
			
			//restaurante.modificarComisionMozo(id, comision);
		}
		catch (Exception e)	{
		}
		menuAdministracion();
	}
	
	
	public void modificarNombreMozo (){
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int id;

		try {
			System.out.println(" ");
			System.out.println("Ingrese el Numero de mozo: ");
			id = Integer.parseInt(reader.readLine());
			System.out.println(" ");
			System.out.println("Ingrese el nuevo nombre: ");
			String nombre = reader.readLine();
			
			//restaurante.modificarNombreMozo(id,nombre);
			
		}
		catch (Exception e)	{
		}
		menuAdministracion();
	}
	
	
	public void altaMozo (){
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println(" ");
			System.out.println("Crear Mozo");
			System.out.println("---------------");
			System.out.print("Nombre del Mozo: ");
			String nombre = reader.readLine();
			/*System.out.print("Ingrese idMozo: ");
			int idMozo = Integer.parseInt(reader.readLine());*/
			System.out.print("Ingrese Comision: ");
			float comision = Float.parseFloat(reader.readLine());
			//restaurante.altaDeMozo(nombre, idMozo, comision);
			//restaurante.altaDeMozo(nombre, comision);
		}
		catch (Exception e)	{
		}
		menuAdministracion();
	}
	
	public void eliminarMozo (){
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println(" ");
			System.out.println("Eliminar Mozo");
			System.out.println("---------------");
			System.out.print("Ingrese idMozo: ");
			int idMozo = Integer.parseInt(reader.readLine());
			Vector <Mozo> moz = restaurante.getMozos();
			for (int i=0;i<moz.size();i++){
				Mozo m = (Mozo)moz.elementAt(i);
				if (m.getId()==idMozo){
					restaurante.bajaDeMozo(idMozo);
				}else{
					System.out.println("El Mozo NO se elimino");
					System.out.println("");
					}
				}
			
		}
		catch (Exception e)	{
		}
		menuAdministracion();
	}
	
	public void eliminarMesa (){
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println(" ");
			System.out.println("Eliminar Mesa");
			System.out.println("---------------");
			System.out.print("Ingrese Numero de Mesa: ");
			int idMesa = Integer.parseInt(reader.readLine());
			Vector <Mesa> mes = restaurante.getMesas();
			for (int i=0;i<mes.size();i++){
				Mesa m = (Mesa)mes.elementAt(i);
				if (m.getNroMesa()==idMesa){
					restaurante.bajaDeMesa(idMesa);
				}else{
					System.out.println("La Mesa NO se elimino");
					System.out.println("");
					}
				}
			
		}
		catch (Exception e)	{
		}
		menuAdministracion();
	}
	
	public void habilitarMozo (){
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println(" ");
			System.out.println("Habilitar Mozo Mozo");
			System.out.println("---------------");
			System.out.print("Id del Mozo ");
			int idMozo = Integer.parseInt(reader.readLine());
			restaurante.habilitarMozo(idMozo);
		}
		catch (Exception e)	{
		}
		menuAdministracion();
	}
	
	public void desHabilitarMozo (){
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println(" ");
			System.out.println("DesHabilitar Mozo Mozo");
			System.out.println("---------------");
			System.out.print("Id del Mozo ");
			int idMozo = Integer.parseInt(reader.readLine());
			restaurante.deshabilitarMozo(idMozo);
		}
		catch (Exception e)	{
		}
		menuAdministracion();
	}
	
	public void altaMesa (){
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println(" ");
			System.out.println("Crear Mesa");
			System.out.println("---------------");
			System.out.print("Ingrese Numero de Mesa: ");
			int numeroMesa = Integer.parseInt(reader.readLine());
			//restaurante.altaDeMozo(nombre, idMozo, comision);
			//restaurante.altaDeMesa(numeroMesa);
		}
		catch (Exception e)	{
		}
		menuAdministracion();
	}
	
	public void listarMesas (){
		System.out.println(" ");
		System.out.println("La Lista de Mesas");
		System.out.println("---------------");
		Vector <Mesa> mes = restaurante.getMesas();
		
		for (int i=0 ; i<mes.size() ; i++){
			Mesa mesaloca = mes.elementAt (i);
			Mozo m = mesaloca.getMozo();
			int id = 0;
			if ( m != null ){
				id = m.getId();
				System.out.println("Mesa: " +mesaloca.getNroMesa()+ " - Mozo asignado: " +id);
			}else{
				System.out.println("Mesa: " +mesaloca.getNroMesa()+ " - Sin Mozo asignado.");
			}
			if (mesaloca.isHabilitada()){
				System.out.println("HABILITADA");
			}else{
				System.out.println("NO HABILITADA");
			}
			if (mesaloca.isOcupada()){
				System.out.println("OCUPADA");
			}else{
				System.out.println("NO OCUPADA");
			}
			
			System.out.println("Comanda: ??? ");
			//System.out.println("Liquidacion:" +mozoloco.getLiquidacion());
			System.out.println(" ");
			System.out.println(" ");
		}
		menuAdministracion();
	}
	
	
	public void listarMozos (){
		System.out.println(" ");
		System.out.println("La Lista de Mozos");
		System.out.println("---------------");
		Vector <Mozo> moz = restaurante.getMozos();
		for (int i=0 ; i<moz.size() ; i++){
			Mozo mozoloco = moz.elementAt (i);
			System.out.println("Id: "+mozoloco.getId()+" - Nombre: "+mozoloco.getNombre());
			if (mozoloco.getHabilitado()){
				System.out.println("HABILITADO");
			}else{
				System.out.println("NO HABILITADO");
			}
			System.out.println("Comision: "+mozoloco.getComision());
			System.out.println("Liquidacion:" +mozoloco.getLiquidacion());
			System.out.println(" ");
			System.out.println(" ");
		}
		menuAdministracion();
	}
	
	
	//ESTO NO VA, nacho habilita las mesas a medida q se van asignando a cada mozo
	//en caso de q se quiera eprfeccionar la cosa, se habilita
	//en restaurante no se saco nada
	//by JuanMA
	/*
	public void habilitarMesa (){
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println(" ");
			System.out.println("Habilitar Mesa para la jornada");
			System.out.println("---------------");
			System.out.print("Id del mesa ");
			int idMesa = Integer.parseInt(reader.readLine());
			restaurante.habilitarMesa(idMesa);
		}
		catch (Exception e)	{
		}
		menuAdministracion();
	}
	
	public void desHabilitarMesa (){
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println(" ");
			System.out.println("DesHabilitar Mesa para la jornada");
			System.out.println("---------------");
			System.out.print("Id de la mesa ");
			int idMesa = Integer.parseInt(reader.readLine());
			restaurante.deshabilitarMesa(idMesa);
		}
		catch (Exception e)	{
		}
		menuAdministracion();
	}
	*/
	
/*
 	-- Menu de opciones sobre cartas - items de carta - ingredientes --
 */	
	public void menuCarta() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(" ");
		System.out.println("OPCIONES Cartas - Platos - Bebidas");
		System.out.println("-----*-----*-----*-----*-----*-----");
/*		System.out.println("1.- Crear carta");
		System.out.println("2.- Crear plato o bebida");
		System.out.println("3.- Detallar carta");
		System.out.println("4.- Listar platos y bebidas disponibles");
		System.out.println("5.- Eliminar Carta");
		System.out.println("6.- Eliminar plato o bebida");
		System.out.println("7.- Cargar carta");
		System.out.println("8.- Descargar carta");
		System.out.println("9.- Volver al menu principal");
		System.out.println("a.- Listar ingredientes de plato o bebida");
*/		System.out.println("	CARTAS ");
		System.out.println("1.- Crear carta");
		System.out.println("7.- Cargar carta");
		System.out.println("3.- Detallar carta");
		System.out.println("8.- Descargar carta");
		System.out.println("5.- Eliminar Carta");
		System.out.println(" ");
		System.out.println("	Platos - Bebidas ");
		System.out.println("2.- Crear plato o bebida");
		System.out.println("7.- Cargar ingredientes");
		System.out.println("a.- Listar ingredientes de plato o bebida");
		System.out.println("4.- Listar platos y bebidas disponibles");
		System.out.println("6.- Eliminar plato o bebida");
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("9.- Volver al menu principal");
		System.out.println("-----*-----*-----*-----*-----*-----");
		System.out.println(" ");
		System.out.print("Opcion:");
		try	{
			char s = (char)reader.read();
		  	switch (s){
			  	case '1' : {this.crearCarta();
			  	break;
			  	}
			  	case '2' : {this.crearItemDeCarta();
			  	break;
		  		}
			  	case '3' : {this.listarCarta();
			  	break;
				}
			  	case '4' : {this.listarItemsCarta();
			  	break;
			  	}
				case '5' : {this.eliminarCarta();
			  	break;
			  	}
			  	case '6' : {this.eliminarItemDeCarta();
			  	break;
			  	}
			  	case '7' : {this.cargarCarta();
			  	break;
			  	}
			  	case '8' : {this.descargarCarta();
			  	break;
			  	}
			  	case '9' : {this.menuPrincipal();
			  	break;
			  	}
			  	case 'a' : {this.listarIngredientes();
			  	break;
			  	}
		  	}
		}
		catch (Exception e)	{
		}
	}

	public void crearItemDeCarta() {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.println(" ");
			System.out.println("Crear Item De Carta");
			System.out.println("---------------");
			System.out.print("Nombre del item de Carta: ");
			String nombre = reader.readLine();
			System.out.println("");
			System.out.print("Ingrese precio: ");
			String preciotxt = reader.readLine();
			float precio = Float.parseFloat(preciotxt);
			System.out.println("Tipo de item de carta?:");
			System.out.println("p = plato:		b = bebida: ");
			String tipoItem = reader.readLine();
			if (tipoItem.equalsIgnoreCase("p")){
				restaurante.altaDePlato(nombre, precio);
				menuCarta();
			}else{
				if (tipoItem.equalsIgnoreCase("b")){
					restaurante.altaDeBebida(nombre, precio);
				}else{
					System.out.println("ERROR! item incorrecto");
					System.out.println("");
				}
			}
			menuCarta();
		}
		catch(Exception e){}
	}

/*	public void agregarIngredientes(){
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.println(" ");
			System.out.print("Ingrese producto: ");
			String producto = reader.readLine();
			if (restaurante.buscarProducto(producto) != null){
				System.out.println("Ingrese cantidad a usar: ");
				String cantidadtxt = reader.readLine();
				float cantidad = Float.parseFloat(cantidadtxt);
				
			}
			
		}
		catch(Exception e){}
	}
*/	
	public void crearCarta() {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.println(" ");
			System.out.println("Crear Carta");
			System.out.println("---------------");
			System.out.println("Dia en que se usara la Carta: ");
			System.out.println("|  domingo  - lunes  - martes  		|");
			System.out.println("| miercoles - jueves - viernes - sabado |");
			System.out.println(" ");
			System.out.print("Dia: ");
			String dia = reader.readLine();
			//	ESTO NO SIRVE MAS. La validacion de dia para la carta 
			//	la implementé directamente en la clase carta
			if (dia.equalsIgnoreCase("lunes")){
				restaurante.altaDeCarta(dia);
			}else{
				if (dia.equalsIgnoreCase("martes")){
					restaurante.altaDeCarta(dia);
				}else{
					if (dia.equalsIgnoreCase("miercoles")){
						restaurante.altaDeCarta(dia);
					}else{
						if (dia.equalsIgnoreCase("jueves")){
							restaurante.altaDeCarta(dia);
						}else{
							if (dia.equalsIgnoreCase("viernes")){
								restaurante.altaDeCarta(dia);
							}else{
								if (dia.equalsIgnoreCase("sabado")){
									restaurante.altaDeCarta(dia);
								}else{
									if (dia.equalsIgnoreCase("domingo")){
										restaurante.altaDeCarta(dia);
									}else{
										System.out.print("ERROR - Dia NO valido");				
									}				
								}				
							}				
						}				
					}				
				}
			}
			menuCarta();
		}
		catch(Exception e){}
	}

	public void eliminarItemDeCarta() {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

			//	Solicita informacion de Item de Carta
			System.out.println(" ");
			System.out.println("Eliminar Item De Carta");
			System.out.println("---------------");
			System.out.print("Item a eliminar: ");
			String nombre = reader.readLine();
			System.out.println("");
			Vector <ItemDeCarta> itcart = restaurante.getItemsCarta();
			for (int i=0;i<itcart.size();i++){
				ItemDeCarta c = (ItemDeCarta)itcart.elementAt(i);
				if (c.getNombre().equals(nombre)){
					restaurante.bajaDeItemDeCarta(nombre);
				}else{
					System.out.println("El item NO se elimino");
					System.out.println("");
					}
				}
			menuCarta();
			}
		catch(Exception e){}
	}

	public void eliminarCarta() {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

			//	Solicita informacion de Item de Carta
			System.out.println(" ");
			System.out.println("Eliminar Carta");
			System.out.println("---------------");
			System.out.print("Ingrese dia de carta: ");
			String nombre = reader.readLine();
			System.out.println("");
			Vector <Carta> car = restaurante.getCartas();
			for (int i=0;i<car.size();i++){
				Carta c = (Carta)car.elementAt(i);
				if (c.getDia().equals(nombre)){
					restaurante.bajaDeCarta(nombre);
				}else{
					System.out.println("La carta NO se elimino");
					System.out.println("");
					}
				}
			menuCarta();
			}
		catch(Exception e){}
	}
	
	public void listarItemsCarta (){
		restaurante.listarItemsCarta();
		/*		Vector <ItemDeCarta> itcart = restaurante.getItemsCarta();
		for (int i=0;i<itcart.size();i++){
			ItemDeCarta c = (ItemDeCarta)itcart.elementAt(i);
			//	Listar items de carta disponibles
			if (c.disponible){
				System.out.print("Nombre: "+ c.getNombre());
				System.out.println(" $"+ c.getPrecio());
				System.out.println("-----");
			}
		}
*/		menuCarta();
	}

	public void listarCarta (){
		try {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(" ");
		System.out.print("Dia de carta: ");
		String dia = reader.readLine();
		System.out.println(" ");
		restaurante.detalleCarta(dia);
		menuCarta();
		}
		catch(Exception e){}
	}

	public void cargarCarta(){
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.println(" ");
			System.out.print("Carta a cargar: ");
			String dia = reader.readLine();
			System.out.print("Plato o bebida a cargar: ");
			String item = reader.readLine();
			System.out.println(" ");
			restaurante.cargarCarta(dia, item);
			menuCarta();
		}
		catch(Exception e){}
	}

/*	public void asignarItem(){
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.println(" ");
			System.out.print("Plato o bebida a cargar: ");
			String item = reader.readLine();
			ItemDeCarta inc = restaurante.buscarItemDeCarta(item);
			if (inc != null){
				System.out.print("Ingrediente: ");
				String ingre = reader.readLine();
				System.out.print("Cantidad a usar: ");
				String numero = reader.readLine();
				float amount = Float.parseFloat(numero);
// me falta terminarlo		inc.agregarIngrediente(ingre, amount);
			}
			menuCarta();
		}
		catch(Exception e){}
	}
*/
	public void descargarCarta(){
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.println(" ");
			System.out.print("Carta a cargar: ");
			String dia = reader.readLine();
			this.listarItemsCarta();
			System.out.print("Plato o bebida a eliminar: ");
			String item = reader.readLine();
			System.out.println(" ");
			restaurante.cargarCarta(dia, item);
			menuCarta();
		}
		catch(Exception e){}
	}
	
	public void listarIngredientes(){
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.println(" ");
			System.out.print("Plato o bebida: ");
			String nombre = reader.readLine();
			ItemDeCarta itemc = restaurante.buscarItemDeCarta(nombre);
				if (itemc != null)
					itemc.listarIngredientes();
			menuCarta();
		}
		catch(Exception e){}
	}

/**
 * ------------------------------------------------------------
 * ------------------ Fin de Menues y de main -----------------
 * ------------------------------------------------------------
 * **/
	
	public void salir(){
		System.exit(0);
	}

}