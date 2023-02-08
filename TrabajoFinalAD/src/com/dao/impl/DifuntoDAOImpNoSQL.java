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
public class DifuntoDAOImpNoSQL implements DifuntoDAO{
	
	String driver = "org.exist.xmldb.DatabaseImpl";
	Class cl;
	Database BD;
	String URI;
	
	@SuppressWarnings("deprecation")
	public DifuntoDAOImpNoSQL() {	
		try {
			cl = Class.forName(driver);
			BD = (Database)cl.newInstance();
			DatabaseManager.registerDatabase(BD);
			URI = "xmldb:exist://192.168.56.105:8080/exist/xmlrpc/db/cementerio";
			Collection miDB = DatabaseManager.getCollection(URI, "miusuario", "Pass!123456");
			XPathQueryService servicio = (XPathQueryService)miDB.getService("XPathQueryService", "1.0");
		} catch (XMLDBException xmldbe) {
			// TODO Auto-generated catch block
			xmldbe.printStackTrace();
		} catch (InstantiationException ie) {
			// TODO Auto-generated catch block
			ie.printStackTrace();
		} catch (IllegalAccessException iae) {
			// TODO Auto-generated catch block
			iae.printStackTrace();
		} catch (ClassNotFoundException cnfe) {
			// TODO Auto-generated catch block
			cnfe.printStackTrace();
		}
	}

	@Override
	public List<Difunto> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Difunto create() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Difunto modify(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Difunto delete(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
