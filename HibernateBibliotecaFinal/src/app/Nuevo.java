package app;

import java.util.Iterator;
import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import controlador.HibernateUtil;

import tablas.*;

public class Nuevo {

	public static void main(String[] args) {

		// ------------------UTILIZAMOS LO DEFINIDO ANTES-------------
		//obtener la f�brica de la conexi�n actual para crear una sesi�n
		SessionFactory fabrica = HibernateUtil.getSessionFactory();
		//------------------------------------------------------------
		// creamos la sesi�n
		Session sesion = fabrica.openSession();	
		// creamos la transacci�n de la sesi�n
		Transaction tx = sesion.beginTransaction();
		
		
		int id = proximo_id(sesion);
		Libro lib = new Libro(id, ("ISBN"+id));
		lib.setNejemplares(1);
		lib.setTitulo("Lala land");
		lib.setAutor("Fulanito");
		
		sesion.save(lib);
		

		System.out.println("FUNCIONO!!");
		
		tx.commit();
		
		
		
		sesion.close();
		fabrica.close();
		System.exit(0);	
		
	}

	private static int proximo_id(Session sesion) {
		Query<Integer> q = sesion.createQuery("select max(id) from Libro");
		
		Integer res = q.getSingleResult();
		return res.intValue()+1;
	}

	

}
