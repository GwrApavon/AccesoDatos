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
import com.modelo.Difunto;
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
	}
	
	/*
	 * Devuelve todos los elementos de la tabla
	 */
	@Override
	public List<Responsable> getAll() {
		sesion  = fabrica.openSession();
		Query<Responsable> q = sesion.createQuery("from Responsable");
		List <Responsable> lista = q.list();
		sesion.close();
		return lista;
	}

	/**
	 * Devuelve un responsable
	 * @param idn id del responsable a devolver
	 */
	@Override
	public Responsable getOne(Integer idn) {
		sesion  = fabrica.openSession();
		Query<Responsable> q = sesion.createQuery("from Responsable where id = " + idn);
		Responsable res = q.list().get(0);
		sesion.close();
		return res;
	}
	
	/** Creador responsables
	 * Crea un responsable con el objeto que recibe
	 * @param res Objeto responsable que se va a guardar
	 * @return boolean
	 */
	@Override
	public boolean create(Responsable element) {
		sesion  = fabrica.openSession();
		tx= sesion.beginTransaction();
		sesion.saveOrUpdate(element);
		tx.commit();
		sesion.close();
		System.out.println("Responsable insertado");
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
		sesion  = fabrica.openSession();
		tx= sesion.beginTransaction();
		sesion.saveOrUpdate(element);
		tx.commit();
		sesion.close();
		System.out.println("Responsable modificado");
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
		sesion  = fabrica.openSession();
		tx= sesion.beginTransaction();
		sesion.delete(idn);
		tx.commit();
		sesion.close();
		System.out.println("Responsable borrado");
		return true;
	}

	//NO SE UTILIZA
	@Override
	public void query() {
		
	}



}
