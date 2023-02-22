/**
 *  Implementacion de hibernate para Sepultura
 */
package com.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.dao.SepulturaDAO;
import com.modelo.Sepultura;

/**
 * @author Angel Pavon Fraile
 *
 */
public class SepulturaDAOImpHibernate implements SepulturaDAO{

	SessionFactory fabrica;
	Session sesion;	
	Transaction tx;

	public SepulturaDAOImpHibernate() {
		//fabrica = HibernateUtil.getSessionFactory();
		sesion  = fabrica.openSession();
		tx= sesion.beginTransaction();
	}
	
	/*
	 * Devuelve todos los elementos de la tabla
	 */
	@Override
	public List<Sepultura> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	/** Creador responsables
	 * Crea un responsable con el objeto que recibe
	 * @param res Objeto responsable que se va a guardar
	 * @return boolean
	 */
	@Override
	public boolean create(Sepultura element) {
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
	public boolean modify(Integer idn, Sepultura element) {
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
	 * @return Sepultura
	 * @exception IndexOutOfBoundsException
	*/
	@Override
	public Sepultura query(Integer idn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Sepultura query2(Integer idn) {
		// TODO Auto-generated method stub
		return null;
	}

}
