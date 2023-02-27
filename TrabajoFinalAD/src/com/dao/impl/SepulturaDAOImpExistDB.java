/**
 *  Implementacion de ExistDb para Sepultura
 */
package com.dao.impl;

import java.util.List;

import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.Database;
import org.xmldb.api.base.Resource;
import org.xmldb.api.base.ResourceIterator;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XPathQueryService;

import com.dao.SepulturaDAO;
import com.modelo.Sepultura;

/**
 * @author Angel Pavon Fraile
 *
 */
public class SepulturaDAOImpExistDB implements SepulturaDAO{

	String driver = "org.exist.xmldb.DatabaseImpl";
	Class cl;
	Database BD;
	String URI;
	Collection miDB;
	XPathQueryService servicio;
	
	public SepulturaDAOImpExistDB() {
		try {
			cl = Class.forName(driver);
			BD = (Database)cl.newInstance();
			URI = "xmldb:exist://192.168.56.105:8080/exist/xmlrpc/db/Cementerio";
			DatabaseManager.registerDatabase(BD);
			miDB = DatabaseManager.getCollection(URI, "miusuario", "Pass!123456");
			servicio = (XPathQueryService)miDB.getService("XPathQueryService", "1.0");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (XMLDBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*
	 * Devuelve todos los elementos de la tabla
	 */
	@Override
	public List<Sepultura> getAll() {

		return null;
	}

	@Override
	public boolean create(Sepultura element) {

		return false;
	}

	@Override
	public boolean modify(Integer idn, Sepultura element) {

		return false;
	}

	@Override
	public boolean delete(Integer idn) {

		return false;
	}

	
	/** Consulta sepultura
	 * Consulta: Muestra todas las sepulturas existentes.
	*/

	@Override
	public void query() {

		String query = "for $sepultura in doc('/db/Cementerio/Cementerio.xml')//table[@name='sepultura'] "
				+ "return $sepultura";
		ResourceSet resultado;
		try {
			resultado = servicio.query(query);
		
		ResourceIterator itera = resultado.getIterator();
		
		System.out.println("=========================================");
		
		if (!itera.hasMoreResources()) {
			System.out.println("No hay resultados");
		} else {
			while (itera.hasMoreResources()) {
				Resource elemento = itera.nextResource();
				String recibir = (String) elemento.getContent();
				System.out.println(recibir.replace(" ",""));
				System.out.println("=========================================");
			}
		}
		
		} catch (XMLDBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}

	@Override
	public Sepultura getOne(Integer idn) {

		return null;
	}

}
