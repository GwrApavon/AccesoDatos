/**
 *  Implementacion de hibernate para Responsable
 */
package com.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

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
		tx= sesion.beginTransaction();
	}
	
	/*
	 * Devuelve todos los elementos de la tabla
	 */
	@Override
	public List<Responsable> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	/** Creador responsables
	 * Crea un responsable con el objeto que recibe
	 * @param res Objeto responsable que se va a guardar
	 * @return boolean
	 */
	@Override
	public boolean create(Responsable element) {
		// TODO Auto-generated method stub
		return false;
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
		// TODO Auto-generated method stub
		return false;
	}

	/** Borrador responsables
	 * Borra un responsable existente cuya id sea la que se pasa por parámetro
	 * @param id identificador del responsable
	 * @return boolean
	 * @exception IndexOutOfBoundsException
	*/
	@Override
	public boolean delete(Integer idn) {
		// TODO Auto-generated method stub
		return false;
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
	public Responsable query(Integer option, Integer idn) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Responsable query2(Integer option, Integer idn) {
		// TODO Auto-generated method stub
		return null;
	}

}
