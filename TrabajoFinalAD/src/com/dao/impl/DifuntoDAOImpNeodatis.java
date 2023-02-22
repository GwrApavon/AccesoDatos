/**
 *  Implementacion de neodatis para Difunto
 */
package com.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.dao.DifuntoDAO;
import com.modelo.Difunto;
import com.modelo.Responsable;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

/**
 * @author Angel Pavon Fraile
 *
 */
public class DifuntoDAOImpNeodatis implements DifuntoDAO{

	private static ODB odb;
	
	public DifuntoDAOImpNeodatis(ODB odb) {
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
	public List <Difunto> getAll(){
		Objects<Difunto> objetos = odb.getObjects(Difunto.class);
		ArrayList<Difunto> difuntos = new ArrayList<Difunto>();
		objetos.forEach(obj -> difuntos.add(obj));
		return difuntos;
	}

	
	
	/** Creador difuntos
	 * Crea un difunto con el objeto que recibe
	 * @param dif Objeto difunto que se va a guardar
	 * @return boolean
	 */
	
	@Override
	public boolean create(Difunto dif) {
		odb.store(dif);
		odb.commit();
		System.out.println("Difunto insertado");
		return true;
	}

	
	
	/** Modificador difuntos
	 * Modifica un difunto ya existente con nuevos datos
	 * @param id identificador del difunto
	 * @param dif Objeto difunto con nuevos datos
	 * @return boolean
	 * @exception IndexOutOfBoundsException
	 */
	
	@Override
	public boolean modify(Integer idn, Difunto dif) {
		boolean valor =false;
		try {
			odb.store(dif);
			odb.commit();
			valor = true;
			System.out.println("Difunto modificado");
		} catch (IndexOutOfBoundsException i) {
			i.printStackTrace();
		}
		return valor;
	}

	/** Borrador difuntos
	 * Borra un difunto existente cuya id sea la que se pasa por parámetro
	 * @param id identificador del difunto
	 * @return boolean
	 * @exception IndexOutOfBoundsException
	*/
	
	@Override
	public boolean delete(Integer idn) {
		boolean valor =false;
		IQuery query = new CriteriaQuery(Difunto.class, Where.equal("idDep", idn));
		Objects<Difunto> objetos = odb.getObjects(query);
		try {
			Difunto difunto = (Difunto) objetos.getFirst();
			odb.delete(difunto);
			odb.commit();
			valor = true;
			System.out.println("Difunto eliminado");
		} catch (IndexOutOfBoundsException i) {
			i.printStackTrace();
		}
		
		return valor;
	}
	
	
	
	/** Consultas difuntos
	 * Hace una consulta dependiendo del número que se le pase por parámetro 
	 * Consulta 1 -->
	 * Consulta 2 -->
	 * @param id identificador del difunto
	 * @return boolean
	 * @exception IndexOutOfBoundsException
	*/
	
	@Override
	public Difunto query(Integer option, Integer idn) {
		Difunto d = new Difunto();
		IQuery query;
		Objects<Difunto> objetos;
		
		query = new CriteriaQuery(Difunto.class, Where.equal("idResponsable", idn));
		objetos = odb.getObjects(query);
				
		if (objetos != null) {
			try {
				d = (Difunto) objetos.getFirst();
			} catch (IndexOutOfBoundsException i) {
				i.printStackTrace();
				System.out.println("No se ha encontrado ningun difunto con identificador" + idn);
				d = null;
			}
		}
		return d;
	}
	public Difunto query2(Integer option, Integer idn) {
		Difunto d = new Difunto();
		IQuery query;
		Objects<Difunto> objetos;
		
		query = new CriteriaQuery(Difunto.class, Where.equal("idResponsable", idn));
		objetos = odb.getObjects(query);
				
		if (objetos != null) {
			try {
				d = (Difunto) objetos.getFirst();
			} catch (IndexOutOfBoundsException i) {
				i.printStackTrace();
				System.out.println("No se ha encontrado ningun difunto con identificador" + idn);
				d = null;
			}
		}
		return d;
	}
}
