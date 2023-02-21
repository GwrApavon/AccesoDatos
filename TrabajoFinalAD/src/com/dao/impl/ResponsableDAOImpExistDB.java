/**
 * 
 */
package com.dao.impl;

import java.util.List;

import org.xmldb.api.base.Database;

import com.dao.ResponsableDAO;
import com.modelo.Responsable;

/**
 * @author alu
 *
 */
public class ResponsableDAOImpExistDB implements ResponsableDAO{

	String driver = "org.exist.xmldb.DatabaseImpl";
	@SuppressWarnings("rawtypes")
	Class cl;
	Database BD;
	String URI;
	
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
