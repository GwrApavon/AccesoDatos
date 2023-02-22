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
	
	/*
	 * Devuelve todos los elementos de la tabla
	 */
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

	/** Consultas responsables
	 * Hace una consulta dependiendo del número que se le pase por parámetro 
	 * Consulta 1 --> 
	 * Consulta 2 -->
	 * @param id identificador del difunto
	 * @return Responsable
	 * @exception IndexOutOfBoundsException
	*/
	@Override
	public Responsable query(Integer option, Integer idn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Responsable query2(Integer option, Integer idn) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
