/**
 * 
 */
package app;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import controlador.HibernateUtil;
import tablas.Producto;
import tablas.Venta;

/**
 * @author alu
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		// ------------------UTILIZAMOS LO DEFINIDO ANTES-------------
		//obtener la f�brica de la conexi�n actual para crear una sesi�n
		SessionFactory fabrica = HibernateUtil.getSessionFactory();
		//------------------------------------------------------------
		// creamos la sesi�n
		Session sesion = fabrica.openSession();	
		// creamos la transacci�n de la sesi�n
		Transaction tx = sesion.beginTransaction();
		
		boolean salir = false;
		do {
			
			System.out.println("Recuerda guardar los cambios usando \"Commit\"");
			salir = menu(s,sesion,tx); // Menu que devuelve boolean para la salida del bucle
			
		}while(!salir);
		
		sesion.close();
		fabrica.close();
		s.close();
		System.exit(0);	

	}
	
	public static boolean menu(Scanner s, Session sesion, Transaction tx) { //Menu
		int opcion = 0;
		System.out.println("Que quieres hacer: "
							+ "\n1. Incluir el IVA en los precios"
							+ "\n2. Eliminar ventas de un cliente"
							+ "\n3. Commit"
							+ "\nElse. salir");

		
		opcion = sacarIntValido(s);
		
		try {
		switch(opcion) {
			case 1:
				modificarPrecioConIVA(sesion); //Hace update de todos los precios para que se incluya el IVA
				break;
			case 2:
				int idCliente = 20; //sacarIntValido(); --> Si no pidiera 20 usaría este método para sacar un int valido 
				eliminarVentas(sesion, idCliente); //Elimina todas las ventas que realiza el cliente cuya id pases
				break;
			case 3:
				tx.commit(); //Opción para hacer el commit
				break;
			default:
				System.out.println("Saliendo..."); //Opción para finalizar el programa 
				return true;
		}
		}catch(Exception e) {
			e.printStackTrace();
			tx.rollback(); //En caso de error se hace rollback
		}
		return false;
		
	}
	
	private static void modificarPrecioConIVA(Session s) { 
		System.out.println("Iniciando transacción");
		
		Query<Producto> query = s.createQuery("from Producto");
		List <Producto> p = query.list();
		Iterator <Producto> iter = p.iterator();
		
		while (iter.hasNext()) {
			Producto pr = (Producto) iter.next();
			float precio = pr.getPrecio();
			precio = (float) (precio * 1.21);
			pr.setPrecio(precio);
			s.update(pr);
		}
		
	}
	
	private static void eliminarVentas(Session s, int cliente) {
		String sentencia = "from Venta where id_cliente = :ident";
		Query query = s.createQuery(sentencia);
		query.setParameter("ident", cliente);
		List<Venta> v = query.getResultList();
		Iterator <Venta> iter = v.iterator();
		while (iter.hasNext()) {
			Venta vt = (Venta) iter.next();
			s.delete(vt);
		}
	}
	
	//Método que devuelve un int valido (>0)
	private static int sacarIntValido(Scanner s){
		 boolean salir = false;
		 int i = 0;
		 while(!salir || i < 0) {
			 try {
				 i = s.nextInt();
				 s.nextLine();
				 salir = true;
			 }catch(InputMismatchException ime) {
				 System.err.println("Introduzca un número por favor");
			 }
		 }
		 return i;
	 }

}
