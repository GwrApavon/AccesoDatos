/**
 * 
 */
package com.dao.impl;

import java.util.List;

import org.xmldb.api.base.Collection;
import org.xmldb.api.base.Database;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XPathQueryService;
import org.xmldb.api.DatabaseManager;
import com.dao.DifuntoDAO;
import com.modelo.Difunto;

/**
 * @author alu
 *
 */
public class DifuntoDAOImpExistDB implements DifuntoDAO{
	
	String driver = "org.exist.xmldb.DatabaseImpl";
	Class cl;
	Database BD;
	String URI;
	
	@SuppressWarnings("deprecation")
	public DifuntoDAOImpExistDB() {	
	}

	@Override
	public List<Difunto> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean create(Difunto dif) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modify(int id, Difunto dif) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Difunto query(int o, int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
