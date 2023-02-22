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

	/** Consultas difuntos
	 * Hace una consulta dependiendo del número que se le pase por parámetro 
	 * Consulta 1 -->
	 * Consulta 2 -->
	 * @param id identificador del Difunto
	 * @return boolean
	 * @exception IndexOutOfBoundsException
	*/
	@Override
	public Difunto query(Integer idn) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Difunto query2(Integer idn) {
		// TODO Auto-generated method stub
		return null;
	}

}
