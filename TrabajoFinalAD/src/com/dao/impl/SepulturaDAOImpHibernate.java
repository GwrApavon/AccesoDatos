/**
 *  Implementacion de hibernate para Sepultura
 */
package com.dao.impl;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.controlador.HibernateUtil;
import com.dao.SepulturaDAO;
import com.modelo.Responsable;
import com.modelo.Sepultura;

import cementerio.app.Utilities;

/**
 * @author Angel Pavon Fraile
 *
 */
public class SepulturaDAOImpHibernate implements SepulturaDAO{

	SessionFactory fabrica;
	Session sesion;	
	Transaction tx;
	Scanner sc;

	public SepulturaDAOImpHibernate() {
		fabrica = HibernateUtil.getSessionFactory();
		sesion  = fabrica.openSession();
		tx= sesion.beginTransaction();
		sc = new Scanner(System.in);
	}
	
	/*
	 * Devuelve todos los elementos de la tabla
	 */
	@Override
	public List<Sepultura> getAll() {
		Query<Sepultura> q = sesion.createQuery("from Sepultura");
		List <Sepultura> lista = q.list();
		return lista;
	}

	/**
	 * Devuelve un responsable
	 * @param idn id del responsable a devolver
	 */
	@Override
	public Sepultura getOne(Integer idn) {
		sesion = fabrica.openSession();
		Query<Sepultura> q = sesion.createQuery("from Responsable where id = " + idn);
		Sepultura sep = q.list().get(0);
		sesion.close();
		return sep;
	}
	
	/** Creador responsables
	 * Crea un responsable con el objeto que recibe
	 * @param res Objeto responsable que se va a guardar
	 * @return boolean
	 */
	@Override
	public boolean create(Sepultura element) {
		tx= sesion.beginTransaction();
		sesion.saveOrUpdate(element);
		tx.commit();
		System.out.println("Sepultura insertada");
		return true;
	}

	/** Modificador responsables
	 * Modifica un responsable ya existente con nuevos datos
	 * @param id identificador del responsable
	 * @param res Objeto responsable con nuevos datos
	 * @return boolean
	 * @exception IndexOutOfBoundsException
	 */
	@Override
	public boolean modify(Integer idn, Sepultura element) {
		tx= sesion.beginTransaction();
		sesion.saveOrUpdate(element);
		tx.commit();
		System.out.println("Sepultura modificada");
		return true;
	}

	/** Borrador responsables
	 * Borra un responsable existente cuya id sea la que se pasa por parámetro
	 * @param id identificador del responsable
	 * @return boolean
	 * @exception IndexOutOfBoundsException
	*/
	@Override
	public boolean delete(Integer idn) {
		tx= sesion.beginTransaction();
		sesion.delete(idn);
		tx.commit();
		System.out.println("Sepultura borrada");
		return true;
	}

	/** Consultas responsables
	 * Hace una consulta dependiendo del número que se le pase por parámetro 
	 * Consulta: Devuelve, con el nombre y el primer apellido del difunto,
	 * 			 la id de la sepultura, la calle, numero y el responsable con su id, nombre y apellidos.
	 * @param id identificador del difunto
	 * @return Sepultura
	 * @exception IndexOutOfBoundsException
	*/
	@Override
	public void query() {
		String hql = "SELECT D.idDifunto, S.idSepultura, S.calle, S.numSepultura, R.id, R.nombre, R.apellido1, "
				  + "R.apellido2 " +
				  "FROM Difunto D " +
				  "JOIN D.sepultura S " +
				  "JOIN S.responsable R " +
				  "WHERE D.nombre = :nombre " +
				  "AND D.apellido1 = :apellido1 ";
		
		System.out.println("Introduzca los datos del difunto:");
		String nombre = Utilities.pedirNombre(sc);
		String apellido1 = Utilities.pedirApellido1(sc);

		
		Query query = sesion.createQuery(hql);
		query.setParameter("nombre", nombre);
		query.setParameter("apellido1", apellido1);
		
		List<Object[]> results = query.list();
		
		for(Object[] result : results) {
			System.out.println("ID difunto: " + result[0]					
								+ "\nID sepultura: " + result[1]
								
								+ "\nPosicion sepultura:"			
								+ "\n\tCalle: " + result[2]
								+ "\n\tNum sepultura: " + result[3]
									
								+ "\nResponsable de la sepultura: "		
								+ "\n\tID: " + result[4]
								+ "\n\tNombre: " + result[5]
								+ "\n\tApellido1: " + result[6]
								+ "\n\tApellido2: " + result[7]);
		}
	}

}
