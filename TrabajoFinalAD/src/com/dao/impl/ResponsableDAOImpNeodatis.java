/**
 *  Implementacion de neodatis para Responsable
 */
package com.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.IValuesQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;
import org.neodatis.odb.impl.core.query.values.ValuesCriteriaQuery;

import java.math.BigDecimal;

import com.dao.ResponsableDAO;
import com.modelo.Responsable;

/**
 * @author Angel Pavon Fraile
 *
 */
public class ResponsableDAOImpNeodatis implements ResponsableDAO{

private static ODB odb;
	
	public ResponsableDAOImpNeodatis(ODB odb) {
		this.odb = odb;
	}
	
	public static ODB crearConexion() {
		return odb;
	}
	
	@SuppressWarnings("deprecation")
	@Override 
	protected void finalize() throws Throwable{
		if (odb != null) {
			odb.close();
		}
		super.finalize();
	}
	
	
	
	/*
	 * Devuelve todos los elementos de la tabla
	 */
	
	@Override
	public List<Responsable> getAll() {
		Objects<Responsable> objetos = odb.getObjects(Responsable.class);
		ArrayList<Responsable> responsables = new ArrayList<Responsable>();
		objetos.forEach(obj -> responsables.add(obj));
		return responsables;
	}

	
	/** Creador responsables
	 * Crea un responsable con el objeto que recibe
	 * @param res Objeto responsable que se va a guardar
	 * @return boolean
	 */
	
	@Override
	public boolean create(Responsable res) {
		int id = maxID();
		res.setIdResponsable(id);
		odb.store(res);
		odb.commit();
		System.out.println("Responsable insertado");
		return true;
	}

	
	
	/** Modificador responsables
	 * Modifica un responsable ya existente con nuevos datos
	 * @param id identificador del responsable
	 * @param res Objeto responsable con nuevos datos
	 * @return boolean
	 * @exception IndexOutOfBoundsException
	 */
	
	@Override
	public boolean modify(Integer idn, Responsable res) {
		boolean valor =false;
		try {
			odb.store(res);
			odb.commit();
			valor = true;
			System.out.println("Responsable modificado");
		} catch (IndexOutOfBoundsException i) {
			i.printStackTrace();
		}
		return valor;
	}

	
	
	/** Borrador responsables
	 * Borra un responsable existente cuya id sea la que se pasa por parámetro
	 * @param id identificador del responsable
	 * @return boolean
	 * @exception IndexOutOfBoundsException
	*/
	@Override
	public boolean delete(Integer idn) {
		boolean valor =false;
		IQuery query = new CriteriaQuery(Responsable.class, Where.equal("idResponsable", idn));
		Objects<Responsable> objetos = odb.getObjects(query);
		try {
			Responsable responsable = (Responsable) objetos.getFirst();
			odb.delete(responsable);
			odb.commit();
			valor = true;
			System.out.println("Responsable eliminado");
		} catch (IndexOutOfBoundsException i) {
			i.printStackTrace();
		}
		
		return valor;
	}

	
	//NO SE UTILIZA
	@Override
	public void query() {
		// TODO Auto-generated method stub
		
	}
	
	
	/**
	 * Obtiene la ultima id le suma uno y la devuelve
	 * @return int 
	 */
	public int maxID() {
		int id = 0;
		IValuesQuery query;
		try {
			query = new ValuesCriteriaQuery(Responsable.class).max("idResponsable");
			id = ((BigDecimal) odb.getValues(query).getFirst().getByIndex(0)).intValue();
		}catch(IndexOutOfBoundsException i) {
			i.printStackTrace();
		}
		id++;
		return id;
	}

	@Override
	public Responsable getOne(Integer idn) {
		// TODO Auto-generated method stub
		return null;
	}

}
