/**
 *  Implementacion de ExistDb para Sepultura
 */
package com.dao.impl;

import java.util.List;

import org.xmldb.api.base.Database;

import com.dao.SepulturaDAO;
import com.modelo.Sepultura;

/**
 * @author Angel Pavon Fraile
 *
 */
public class SepulturaDAOImpExistDB implements SepulturaDAO{

	String driver = "org.exist.xmldb.DatabaseImpl";
	@SuppressWarnings("rawtypes")
	Class cl;
	Database BD;
	String URI;
	
	/*
	 * Devuelve todos los elementos de la tabla
	 */
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

	/** Consultas responsables
	 * Hace una consulta dependiendo del número que se le pase por parámetro 
	 * Consulta 1 -->
	 * Consulta 2 -->
	 * @param id identificador del difunto
	 * @return Sepultura
	 * @exception IndexOutOfBoundsException
	*/
	@Override
	public Sepultura query(Integer idn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Sepultura query2(Integer idn) {
		// TODO Auto-generated method stub
		return null;
	}

}
