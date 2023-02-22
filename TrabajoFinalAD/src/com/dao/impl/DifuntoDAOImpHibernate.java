/**
 * 
 */
package com.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.dao.DifuntoDAO;
import com.modelo.Difunto;

import cementerio.cfg.HibernateUtil;

//import controlador.HibernateUtil;

/**
 * @author alu
 *
 */
public class DifuntoDAOImpHibernate implements DifuntoDAO{
	
	SessionFactory fabrica;
	Session sesion;	
	Transaction tx;

	public DifuntoDAOImpHibernate() {
		fabrica = HibernateUtil.getSessionFactory();
		sesion  = fabrica.openSession();
		
		
	}

	@Override
	public List<Difunto> getAll() {
		Query<Difunto> q = sesion.createQuery("from Difunto");
		List <Difunto> lista = q.list();
		return lista;
	}

	@Override
	public boolean create(Difunto element) {
		tx= sesion.beginTransaction();
		sesion.saveOrUpdate(element);
		tx.commit();
		return false;
	}

	@Override
	public boolean modify(Integer idn, Difunto element) {
		tx= sesion.beginTransaction();
		sesion.saveOrUpdate(element);
		tx.commit();
		return false;
	}

	@Override
	public boolean delete(Integer idn) {
		tx= sesion.beginTransaction();
		sesion.delete(idn);
		tx.commit();
		return false;
	}

	@Override
	public Difunto query(Integer option, Integer idn) {
		// TODO Auto-generated method stub
		return null;
	}



}
