/**
 * 
 */
package com.dao.impl;

import java.util.List;

import org.xmldb.api.base.Database;

import com.dao.SepulturaDAO;
import com.modelo.Sepultura;

/**
 * @author alu
 *
 */
public class SepulturaDAOImpExistDB implements SepulturaDAO{

	String driver = "org.exist.xmldb.DatabaseImpl";
	Class cl;
	Database BD;
	String URI;
	
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
