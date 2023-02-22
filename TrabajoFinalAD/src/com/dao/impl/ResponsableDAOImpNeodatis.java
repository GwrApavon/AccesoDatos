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
	
	public ResponsableDAOImpNeodatis(String db) {
		odb = ODBFactory.open(db);
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

	
	
	/* Consultas responsables
	 * Hace una consulta dependiendo del número que se le pase por parámetro 
	 * Consulta 1 --> 
	 * Consulta 2 -->
	 * @param id identificador del difunto
	 * @return Responsable
	 * @exception IndexOutOfBoundsException
	*/
	@Override
	public Responsable query(Integer option, Integer idn) {
		Responsable d = new Responsable();
		IQuery query;
		Objects<Responsable> objetos;
		
		query = new CriteriaQuery(Responsable.class, Where.equal("idResponsable", idn));
		objetos = odb.getObjects(query);
				
		if (objetos != null) {
			try {
				d = (Responsable) objetos.getFirst();
			} catch (IndexOutOfBoundsException i) {
				i.printStackTrace();
				System.out.println("No se ha encontrado ningun difunto con identificador" + idn);
				d = null;
			}
		}
		return d;
	}
	
	@Override
	public Responsable query2(Integer option, Integer idn) {
		Responsable d = new Responsable();
		IQuery query;
		Objects<Responsable> objetos;
		
		query = new CriteriaQuery(Responsable.class, Where.equal("idResponsable", idn));
		objetos = odb.getObjects(query);
				
		if (objetos != null) {
			try {
				d = (Responsable) objetos.getFirst();
			} catch (IndexOutOfBoundsException i) {
				i.printStackTrace();
				System.out.println("No se ha encontrado ningun difunto con identificador" + idn);
				d = null;
			}
		}
		return d;
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

}
