/**
 * 
 */
package com.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.dao.DifuntoDAO;
import com.modelo.Difunto;

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
		//fabrica = HibernateUtil.getSessionFactory();
		sesion  = fabrica.openSession();
		tx= sesion.beginTransaction();
	}

	@Override
	public List<Difunto> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean create(Difunto element) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modify(Integer idn, Difunto element) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Integer idn) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Difunto query(Integer option, Integer idn) {
		// TODO Auto-generated method stub
		return null;
	}



}
