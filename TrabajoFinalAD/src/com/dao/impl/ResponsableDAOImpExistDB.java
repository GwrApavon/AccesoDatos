/**
 *  Implementacion de ExistDb para Responsable
 */
package com.dao.impl;

import java.util.List;

import org.xmldb.api.base.Database;

import com.dao.ResponsableDAO;
import com.modelo.Responsable;

/**
 * @author Angel Pavon Fraile
 *
 */
public class ResponsableDAOImpExistDB implements ResponsableDAO{

	String driver = "org.exist.xmldb.DatabaseImpl";
	Class cl;
	Database BD;
	String URI;
	
	/*
	 * Devuelve todos los elementos de la tabla
	 */
	@Override
	public List<Responsable> getAll() {

		return null;
	}

	@Override
	public boolean create(Responsable element) {

		return false;
	}

	@Override
	public boolean modify(Integer idn, Responsable element) {

		return false;
	}

	@Override
	public boolean delete(Integer idn) {

		return false;
	}

	//NO SE UTILIZA
	@Override
	public void query() {
	}

	@Override
	public Responsable getOne(Integer idn) {
		return null;
	}


	
}
