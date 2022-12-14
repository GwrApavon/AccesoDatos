package app;

import java.util.Iterator;
import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import controlador.HibernateUtil;

import tablas.*;

public class Main {

	public static void main(String[] args) {

		// ------------------UTILIZAMOS LO DEFINIDO ANTES-------------
		//obtener la f�brica de la conexi�n actual para crear una sesi�n
		SessionFactory fabrica = HibernateUtil.getSessionFactory();
		//------------------------------------------------------------
		// creamos la sesi�n
		Session sesion = fabrica.openSession();	
		// creamos la transacci�n de la sesi�n
		Transaction tx = sesion.beginTransaction();
		System.out.println("Leo los libros");	
		Query<Libro> q = sesion.createQuery("from Libro");
		
		List <Libro> lista = q.list();
		// Obtenemos un Iterador y recorremos la lista.
		Iterator <Libro> iter = lista.iterator();
		System.out.println("N�mero de registros:"  + lista.size());
		while (iter.hasNext())
		{
		   //extraer el objeto
			Libro libro = (Libro) iter.next(); 
			System.out.println("Libro ISBN = " + libro.getIsbn() + " Titulo=" + libro.getTitulo());		   
		}

		System.out.println("FUNCIONO!!");
		
		tx.commit();
		
		
		
		sesion.close();
		fabrica.close();
		System.exit(0);	
		
	}

}
