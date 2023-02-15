package discografica;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.controlador.CancionControlador;
import com.controlador.CantanteControlador;
import com.controlador.DiscoControlador;
import com.modelo.Cantante;

public class Discografica {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean opcionSalir = false;
		boolean opcionCorrecta = false;
		boolean salirBaseDatos = false;
		String opcionBase = "";
		String opcionTabla = "";
		int opcionInteraccionTabla = 0;
		MantenimientoMenus m1 = new MantenimientoMenus();
		MantenimientoInteracciones mi1 = new MantenimientoInteracciones();
		CantanteControlador ccant = new CantanteControlador();
		CancionControlador ccan;
		DiscoControlador cdisc;
		
		m1.mostrarTituloDiscografica();
		
		do {
			while(!opcionCorrecta) {
				m1.menuBasesDeDatos();
				
				opcionBase = sc.nextLine().toUpperCase();
				switch(opcionBase) {
					case "MYSQL":
					case "OO":
					case "EXISTDB":
						m1.mensajeBaseDatosUtilizada(opcionBase);
						System.out.println("\n");
						ccant = new CantanteControlador(opcionBase);
						ccan = new CancionControlador(opcionBase);
						cdisc = new DiscoControlador(opcionBase);
						opcionCorrecta = true;
						break;
					case "SALIR":
						m1.mensajeSalidaUsuario();
						opcionSalir = true;
						opcionCorrecta = true;
						break;
					default:
						System.err.println("Opción mal introducida, vuelva a escribirla \n");
						break;				
				}
			}
			
			
			do {
				m1.tituloBaseDatos(opcionBase);
				m1.menuTablasBaseDatos(opcionBase);
					
				opcionTabla = sc.nextLine().toUpperCase();
				m1.mostrarMenuInteraccionTablas(opcionBase, opcionTabla);
				opcionInteraccionTabla = Integer.parseInt(sc.nextLine());
				switch(opcionInteraccionTabla) {
					case 1:
						if(opcionTabla.equalsIgnoreCase("CANTANTE")) {
							Cantante c = mi1.insertarNuevoCantante(opcionBase);
							if(ccant.inserta(c) == true) {
								System.out.println("Cantante insertado!");
							}
						}
						break;
					case 2:
						if(opcionTabla.equalsIgnoreCase("CANTANTE")) {
							Integer i = mi1.eliminarCantante(opcionBase);
							if(ccant.elimina(i) == true) {
								System.out.println("Cantante eliminado!");
							} else {
								System.err.println("El id escrito no pertenece a ningún cantante");
							}
						}
						break;
					case 3:
						if(opcionTabla.equalsIgnoreCase("CANTANTE")) {
							Integer i = mi1.preguntarIdModifica(opcionBase);
							if(ccant.modifica(i) == true) {
								System.out.println("Cantante modificado!");
							} else {
								System.err.println("El id escrito no pertenece a ningún cantante");
							}
						}
						break;
					case 4:
						if(opcionTabla.equalsIgnoreCase("CANTANTE")) {
							m1.mostrarMensajeListados(opcionBase, opcionTabla, 1);
							List<Cantante> listado = ccant.encuentraTodos();
							Iterator <Cantante> iter = listado.iterator();
							while (iter.hasNext()){
								Cantante cant = (Cantante)iter.next();
								System.out.println(cant.getIdCantante()+".     nombre = "+cant.getNombre()+"       edad = "+cant.getEdad()+"      nacionalidad = "+cant.getNacionalidad()+"      número discos platinos = "+cant.getNumeroDiscosPlatinos());
							}		
						}
						break;
					case 5:
						int contador = 1;
						if(opcionTabla.equalsIgnoreCase("CANTANTE")) {
							List<ArrayList<String>> nombres = ccant.consulta1();
							Iterator <ArrayList<String>> iter = nombres.iterator();
							while (iter.hasNext()){
								ArrayList<String> listado = (ArrayList<String>)iter.next();
								System.out.println(contador+". Nombre = "+listado.get(0)+" Cancion  = "+listado.get(1));
								contador++;
							}						
						}
						break;
				}
				salirBaseDatos = true;
			}while(!salirBaseDatos);
			//Para que no entre en bucle infinito
			opcionCorrecta = false;		
		}while(!opcionSalir);
		
		
		
		
		/*CantanteControlador cc = new CantanteControlador("MYSQL");
		
		List<Cantante> listaCantantes = cc.encuentraTodos();
		Cantante c = new Cantante("Sergio Márqueez",21,"Española",02);
		
		Iterator <Cantante> iter = listaCantantes.iterator();
		System.out.println("Número de registros:"  + listaCantantes.size());
		/*cc.inserta(c);
		if(cc.inserta(c)== true) {
			System.out.println("Cantante insertado");
		}*/
		
		/*listaCantantes = cc.encuentraTodos();
		iter = listaCantantes.iterator();
		System.out.println("Número de registros:"  + listaCantantes.size());*/
		
		/*int id = 22;
		Integer iInteger = Integer.valueOf(id);
		cc.elimina(iInteger);
		if(cc.elimina(iInteger)== true) {
			System.out.println("Cantante eliminado");
		}*/

	}

}
