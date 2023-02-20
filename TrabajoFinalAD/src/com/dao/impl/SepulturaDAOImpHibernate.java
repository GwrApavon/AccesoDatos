/**
 * 
 */
package com.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.dao.SepulturaDAO;
import com.modelo.Sepultura;

/**
 * @author alu
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
	
	@Override
	public List<Sepultura> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean create(Sepultura element) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modify(Integer idn, Sepultura element) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Integer idn) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Sepultura query(Integer option, Integer idn) {
		// TODO Auto-generated method stub
		return null;
	}

}
