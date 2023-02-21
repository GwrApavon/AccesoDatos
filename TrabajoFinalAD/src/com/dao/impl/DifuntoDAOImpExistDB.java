/**
 * 
 */
package com.dao.impl;

import java.util.List;


import org.xmldb.api.base.Database;
import com.dao.DifuntoDAO;
import com.modelo.Difunto;

/**
 * @author alu
 *
 */
public class DifuntoDAOImpExistDB implements DifuntoDAO{
	
	String driver = "org.exist.xmldb.DatabaseImpl";
	@SuppressWarnings("rawtypes")
	Class cl;
	Database BD;
	String URI;

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

}
