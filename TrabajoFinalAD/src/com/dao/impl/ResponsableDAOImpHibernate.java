/**
 * 
 */
package com.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.dao.ResponsableDAO;
import com.modelo.Responsable;

/**
 * @author alu
 *
 */
public class ResponsableDAOImpHibernate implements ResponsableDAO{

	SessionFactory fabrica;
	Session sesion;	
	Transaction tx;

	public ResponsableDAOImpHibernate() {
		//fabrica = HibernateUtil.getSessionFactory();
		sesion  = fabrica.openSession();
		tx= sesion.beginTransaction();
	}
	@Override
	public List<Responsable> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean create(Responsable element) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modify(Integer idn, Responsable element) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Integer idn) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Responsable query(Integer option, Integer idn) {
		// TODO Auto-generated method stub
		return null;
	}

}
