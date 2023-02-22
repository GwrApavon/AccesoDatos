/**
 *  Implementacion de hibernate para Difunto
 */
package com.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.controlador.HibernateUtil;
import com.dao.DifuntoDAO;
import com.modelo.Difunto;


/**
 * @author Angel Pavon Fraile
 */
public class DifuntoDAOImpHibernate implements DifuntoDAO{
	
	SessionFactory fabrica;
	Session sesion;	
	Transaction tx;

	public DifuntoDAOImpHibernate() {
		fabrica = HibernateUtil.getSessionFactory();
		sesion  = fabrica.openSession();
		
		
	}

	/*
	 * Devuelve todos los elementos de la tabla
	 */
	@Override
	public List<Difunto> getAll() {
		Query<Difunto> q = sesion.createQuery("from Difunto");
		List <Difunto> lista = q.list();
		return lista;
	}

	/** Creador difuntos
	 * Crea un difunto con el objeto que recibe
	 * @param dif Objeto difunto que se va a guardar
	 * @return boolean
	 */
	@Override
	public boolean create(Difunto element) {
		tx= sesion.beginTransaction();
		sesion.saveOrUpdate(element);
		tx.commit();
		return false;
	}

	/** Modificador difuntos
	 * Modifica un difunto ya existente con nuevos datos
	 * @param id identificador del difunto
	 * @param dif Objeto difunto con nuevos datos
	 * @return boolean
	 * @exception IndexOutOfBoundsException
	 */
	@Override
	public boolean modify(Integer idn, Difunto element) {
		tx= sesion.beginTransaction();
		sesion.saveOrUpdate(element);
		tx.commit();
		return false;
	}

	/** Borrador difuntos
	 * Borra un difunto existente cuya id sea la que se pasa por parámetro
	 * @param id identificador del difunto
	 * @return boolean
	 * @exception IndexOutOfBoundsException
	*/
	@Override
	public boolean delete(Integer idn) {
		tx= sesion.beginTransaction();
		sesion.delete(idn);
		tx.commit();
		return false;
	}

	/** Consultas difuntos
	 * Hace una consulta dependiendo del número que se le pase por parámetro 
	 * Consulta 1 -->
	 * Consulta 2 -->
	 * @param id identificador del difunto
	 * @return Difunto
	 * @exception IndexOutOfBoundsException
	*/
	@Override
	public Difunto query(Integer idn) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Difunto query2(Integer idn) {
		// TODO Auto-generated method stub
		return null;
	}



}
