package discografica;

public class MantenimientoMenus {
	
	private static String reset  = "\u001B[0m";
	private static String purple = "\033[35m";
	private static String cyan   = "\033[36m";
	private static String green  = "\033[32m";
	private static String yellow = "\u001B[33m";
	private static String blue   = "\033[0;34m";

	public void mostrarTituloDiscografica() {
		colorearMensajeSalto(blue, "************************************************");
		colorearMensajeSalto(blue, "*                Discográfica                  *");
		colorearMensajeSalto(blue, "************************************************");
		System.out.println("\n");
	}
	
	public void menuBasesDeDatos() {
		System.out.println("¿Sobre que base de datos desea trabajar?");
		
		colorearMensaje(purple,"1.");
		System.out.print(" Base de datos MySQL con Hibernate");
		colorearMensaje(purple," -> ");
		System.out.println("Escribir 'MYSQL'");
		
		colorearMensaje(green,"2.");
		System.out.print(" Base de datos orientada a objetos con NeoDatis");
		colorearMensaje(green," -> ");
		System.out.println("Escribir 'OO'");
		
		colorearMensaje(yellow,"3.");
		System.out.print(" Base de datos en un fichero XML con ExistDB");
		colorearMensaje(yellow," -> ");
		System.out.println("Escribir 'EXISTDB'");
		
		colorearMensaje(cyan,"4.");
		System.out.print(" Salir");
		colorearMensaje(cyan," -> ");
		System.out.println("Escribir 'SALIR'");
	}
	
	public void mensajeBaseDatosUtilizada(String base) {
		System.out.print("Se ha seleccionado correctamente la base de datos -> ");
		if(base.equalsIgnoreCase("MYSQL")) {
			colorearMensajeSalto(purple,"MYSQL \n");
		} else if(base.equalsIgnoreCase("OO")) {
			colorearMensajeSalto(green,"Orientada a objetos \n");
		} else if(base.equalsIgnoreCase("EXISTDB")) {
			colorearMensajeSalto(yellow,"ExistDB \n");
		}
	}
	
	public void mensajeSalidaUsuario() {
		System.out.print("Has elegido salir: ");
		colorearMensajeSalto(cyan,"* Saliendo de la aplicación *");
	}
	
	public void tituloBaseDatos(String base) {
		if(base.equalsIgnoreCase("MYSQL")) {
			colorearMensajeSalto(purple,"***************************");
			colorearMensajeSalto(purple,"*          MYSQL          *");
			colorearMensajeSalto(purple,"***************************");
		} else if(base.equalsIgnoreCase("OO")) {
			colorearMensajeSalto(green,"***************************");
			colorearMensajeSalto(green,"*   Orientada a Objetos   *");
			colorearMensajeSalto(green,"***************************");
		} else if(base.equalsIgnoreCase("EXISTDB")) {
			colorearMensajeSalto(yellow,"***************************");
			colorearMensajeSalto(yellow,"*         ExistDB         *");
			colorearMensajeSalto(yellow,"***************************");
		}
	}
	
	public void menuTablasBaseDatos(String base) {
		String color = obtenerColorSegunBase(base);
		
		System.out.println("Elige una tabla, sobre la que deseas trabajar: ");
		colorearMensaje(color,"1.");
		System.out.print(" Tabla Cantantes");
		colorearMensaje(color," -> ");
		System.out.println("Escribir 'CANTANTE'");
		
		colorearMensaje(color,"2.");
		System.out.print(" Tabla Canciones");
		colorearMensaje(color," -> ");
		System.out.println("Escribir 'CANCION'");
		
		colorearMensaje(color,"3.");
		System.out.print(" Tabla Discos");
		colorearMensaje(color," -> ");
		System.out.println("Escribir 'DISCO'");
		
		colorearMensaje(color,"4.");
		System.out.print(" Salir de la base de datos: "+base);
		colorearMensaje(color," -> ");
		System.out.println("Escribir 'SALIR'");
	}
	
	public String obtenerColorSegunBase(String base) {
		String color = "";
		if(base.equalsIgnoreCase("MYSQL")) {
			color = purple;
		} else if(base.equalsIgnoreCase("OO")) {
			color = green;
		} else if(base.equalsIgnoreCase("EXISTDB")) {
			color = yellow;
		}
		return color;
	}
	
	public void mostrarMensajeListados(String base, String tabla, int opcion) {
		String color = obtenerColorSegunBase(base);
		if(opcion == 1) {
			colorearMensajeSalto(color,"Se van a listar todos los "+tabla+"S de la base de datos "+base);
		}
	}
	
	public void mostrarMenuInteraccionTablas(String base, String tabla) {
		System.out.println("\n");
		String color = obtenerColorSegunBase(base);
		colorearMensajeSalto(color, "Tabla: "+tabla+", de la base de datos "+base);
		
		colorearMensaje(color,"1.");
		System.out.print(" Insertar registro");
		colorearMensaje(color," -> ");
		System.out.println("Escribir '1'");
		
		colorearMensaje(color,"2.");
		System.out.print(" Eliminar registro");
		colorearMensaje(color," -> ");
		System.out.println("Escribir '2'");
		
		colorearMensaje(color,"3.");
		System.out.print(" Modificar registro");
		colorearMensaje(color," -> ");
		System.out.println("Escribir '3'");
		
		colorearMensaje(color,"4.");
		System.out.print(" Listar todos los registros de la tabla");
		colorearMensaje(color," -> ");
		System.out.println("Escribir '4'");
		
		if((tabla.equals("CANTANTE")|| tabla.equals("CANCION")) && base.equals("MYSQL")) {
			colorearMensaje(color,"5.");
			System.out.print(" CONSULTA 1: Mostrar las canciones con duración de 2 minutos ");
			colorearMensaje(color," -> ");
			System.out.println("Escribir '5'");
		}
		
		if((tabla.equals("CANTANTE")|| tabla.equals("CANCION")) && base.equals("MYSQL")) {
			colorearMensaje(color,"6.");
			System.out.print(" CONSULTA 2: Mostrar el nombre del autor que más canciones tienes ");
			colorearMensaje(color," -> ");
			System.out.println("Escribir '6'");
		}
		
		System.out.println("\n");
	}
	
	private static void colorearMensajeSalto(String color, String mensaje) {
		System.out.println(color + mensaje + reset);
	}
	
	private static void colorearMensaje(String color, String mensaje) {
		System.out.print(color + mensaje + reset);
	}
}
