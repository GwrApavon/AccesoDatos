/**
 *  Implementacion de ExistDb para difunto
 */
package com.dao.impl;

import java.util.List;


import org.xmldb.api.base.Database;
import com.dao.DifuntoDAO;
import com.modelo.Difunto;

/**
 * @author Angel Pavon Fraile
 *
 */
public class DifuntoDAOImpExistDB implements DifuntoDAO{
	
	String driver = "org.exist.xmldb.DatabaseImpl";
	@SuppressWarnings("rawtypes")
	Class cl;
	Database BD;
	String URI;

	/*
	 * Devuelve todos los elementos de la tabla
	 */
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

	//TODO
	/** Consultas difuntos
	 * Consulta 
	 * @param id identificador del Difunto
	 * @return boolean
	 * @exception IndexOutOfBoundsException
	*/
	@Override
	public void query() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Difunto getOne(Integer idn) {
		// TODO Auto-generated method stub
		return null;
	}

}
