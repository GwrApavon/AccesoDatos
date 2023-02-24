/**
 *  Implementacion de hibernate para Responsable
 */
package com.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.controlador.HibernateUtil;
import com.dao.ResponsableDAO;
import com.modelo.Responsable;

/**
 * @author Angel Pavon Fraile
 *
 */
public class ResponsableDAOImpHibernate implements ResponsableDAO{

	SessionFactory fabrica;
	Session sesion;	
	Transaction tx;

	public ResponsableDAOImpHibernate() {
		fabrica = HibernateUtil.getSessionFactory();
		sesion  = fabrica.openSession();
	}
	
	/*
	 * Devuelve todos los elementos de la tabla
	 */
	@Override
	public List<Responsable> getAll() {
		Query<Responsable> q = sesion.createQuery("from Responsable");
		List <Responsable> lista = q.list();
		return lista;
	}

	/** Creador responsables
	 * Crea un responsable con el objeto que recibe
	 * @param res Objeto responsable que se va a guardar
	 * @return boolean
	 */
	@Override
	public boolean create(Responsable element) {
		tx= sesion.beginTransaction();
		sesion.saveOrUpdate(element);
		tx.commit();
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
	public boolean modify(Integer idn, Responsable element) {
		tx= sesion.beginTransaction();
		sesion.saveOrUpdate(element);
		tx.commit();
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
		return true;
	}

	/** Consultas responsables
	 * Hace una consulta dependiendo del número que se le pase por parámetro 
	 * Consulta 1 --> 
	 * Consulta 2 -->
	 * @param id identificador del difunto
	 * @return Responsable
	 * @exception IndexOutOfBoundsException
	*/
	@Override
	public Responsable query(Integer idn) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Responsable query2(Integer idn) {
		// TODO Auto-generated method stub
		return null;
	}

}
