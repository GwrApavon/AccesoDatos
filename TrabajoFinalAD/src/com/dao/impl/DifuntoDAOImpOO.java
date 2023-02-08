/**
 * 
 */
package com.dao.impl;

import java.util.List;

import com.dao.DifuntoDAO;
import com.modelo.Difunto;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;

/**
 * @author alu
 *
 */
public class DifuntoDAOImpOO implements DifuntoDAO{

	private ODB odb;
	
	public DifuntoDAOImpOO(String db) {
		odb = ODBFactory.open(db);
	}
	
	@SuppressWarnings("deprecation")
	@Override 
	protected void finalize() throws Throwable{
		if (odb != null) {
			odb.close();
		}
		super.finalize();
	}
	
	@SuppressWarnings({"unchecked"})
	@Override
	public List <Difunto> getAll(){
		Objects<Difunto> objetos = odb.getObjects(Difunto.class);
		List<Difunto> difuntos = (List<Difunto>) objetos;
		return difuntos;
	}

	@Override
	public Difunto create() {
		return null;
	}

	@Override
	public Difunto modify(int id) {
		return null;
	}

	@Override
	public Difunto delete(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
