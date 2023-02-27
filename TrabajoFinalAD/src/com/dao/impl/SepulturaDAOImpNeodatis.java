/**
 *  Implementacion de neodatis para Sepultura
 */
package com.dao.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.IValuesQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;
import org.neodatis.odb.impl.core.query.values.ValuesCriteriaQuery;

import com.dao.SepulturaDAO;
import com.modelo.Difunto;
import com.modelo.Responsable;
import com.modelo.Sepultura;

import cementerio.app.Utilities;

/**
 * @author Angel Pavon Fraile
 *
 */
public class SepulturaDAOImpNeodatis implements SepulturaDAO{

	private static ODB odb;
	Scanner sc;
	
	public SepulturaDAOImpNeodatis(ODB odb) {
		this.odb = odb;
		sc = new Scanner(System.in);
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
	public List<Sepultura> getAll() {
		Objects<Sepultura> objetos = odb.getObjects(Sepultura.class);
		ArrayList<Sepultura> responsables = new ArrayList<Sepultura>();
		objetos.forEach(obj -> responsables.add(obj));
		return responsables;
	}

	
	/** Creador responsables
	 * Crea un responsable con el objeto que recibe
	 * @param res Objeto responsable que se va a guardar
	 * @return boolean
	 */
	
	@Override
	public boolean create(Sepultura sep) {
		int id = maxID();
		sep.setIdSepultura(id);
		odb.store(sep);
		odb.commit();
		System.out.println("Sepultura insertada");
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
	public boolean modify(Integer idn, Sepultura sep) {
		boolean valor =false;
		try {
			odb.store(sep);
			odb.commit();
			valor = true;
			System.out.println("Sepultura modificada");
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
		IQuery query = new CriteriaQuery(Sepultura.class, Where.equal("idDep", idn));
		Objects<Sepultura> objetos = odb.getObjects(query);
		try {
			Sepultura responsable = (Sepultura) objetos.getFirst();
			odb.delete(responsable);
			odb.commit();
			valor = true;
			System.out.println("Sepultura eliminada");
		} catch (IndexOutOfBoundsException i) {
			i.printStackTrace();
		}
		
		return valor;
	}

	
	
	/** 
	 * Consultas responsables
	 * Hace una consulta dependiendo del número que se le pase por parámetro 
	 * Consulta: Devuelve, con el nombre y el primer apellido del difunto,
	 * 			 la id de la sepultura, la calle, numero y el responsable con su id, nombre y apellidos.
	*/
	@Override
	public void query() {
		System.out.println("Introduzca los datos del difunto:");
		String nombre = Utilities.pedirNombre(sc);
		String apellido1 = Utilities.pedirApellido1(sc);

		CriteriaQuery query = new CriteriaQuery(Difunto.class, Where.and()
								                .add(Where.equal("nombre", nombre))
								                .add(Where.equal("apellido1", apellido1)));
		Objects<Difunto> results = odb.getObjects(query);
		
		while (results.hasNext()) {
		Difunto dif = results.next();
		Sepultura sep = dif.getSepultura();
		Responsable resp = sep.getResponsable();
		
		System.out.println("=========================================");
		System.out.println("ID difunto: " + dif.getIdDifunto()                    
							+ "\nID sepultura: " + sep.getIdSepultura()
							+ "\nPosicion sepultura:"            
							+ "\n\tCalle: " + sep.getCalle()
							+ "\n\tNum sepultura: " + sep.getNumSepultura()
							+ "\nResponsable de la sepultura: "        
							+ "\n\tID: " + resp.getIdResponsable()
							+ "\n\tNombre: " + resp.getNombre()
							+ "\n\tApellido1: " + resp.getApellido1()
							+ "\n\tApellido2: " + resp.getApellido2());
        }
		System.out.println("=========================================");
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
	public Sepultura getOne(Integer idn) {
		// TODO Auto-generated method stub
		return null;
	}

}
