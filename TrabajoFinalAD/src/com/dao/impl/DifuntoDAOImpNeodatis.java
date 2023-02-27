/**
 *  Implementacion de neodatis para Difunto
 */
package com.dao.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.dao.DifuntoDAO;
import com.modelo.Difunto;
import com.modelo.Responsable;
import com.modelo.Sepultura;

import cementerio.app.Utilities;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.IValuesQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;
import org.neodatis.odb.impl.core.query.values.ValuesCriteriaQuery;

/**
 * @author Angel Pavon Fraile
 *
 */
public class DifuntoDAOImpNeodatis implements DifuntoDAO{

	private static ODB odb;
	Scanner sc;
	
	public DifuntoDAOImpNeodatis(ODB odb) {
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
		int id = maxID();
		dif.setIdDifunto(id);
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
	
	/** Consultas difunto
	 * Consulta: selecciona los datos del difunto, sepultura y responsable de la sepultura 
	 * 			 para aquellos difuntos que fallecieron después de la fecha que introduzcas, 
	 * 			 ordenados por fecha de defunción descendente.
	 * Nota: .ge significa "mayor o igual que" (greater or equal than)
	*/
	
	@Override
	public void query() {

		Date fecha = Utilities.pedirFechaDef(sc);
		
		CriteriaQuery query = new CriteriaQuery(Difunto.class, Where.ge("fechaDefuncion", fecha));
		Objects<Difunto> difuntos = odb.getObjects(query);

		for (Difunto dif : difuntos) {
		    Sepultura sep = dif.getSepultura();
		    Responsable res = sep.getResponsable();

		    System.out.println("=========================================");
		    System.out.println("Difunto:"
		            + "\n\tNombre: " + dif.getNombre()
		            + "\n\tApellido1: " + dif.getApellido1()
		            + "\n\tApellido2: " + dif.getApellido2()
		            + "\nFechas: "
		            + "\n\tFecha de nacimiento: " + dif.getFechaNacimiento()
		            + "\n\tFecha de defunción: " + dif.getFechaDefuncion()
		            + "\n\tFecha de enterramiento: " + dif.getFechaEnterramiento()
		            + "\nPosicion sepultura:"
		            + "\n\tCalle sepultura: " + sep.getCalle()
		            + "\n\tNumero sepultura " + sep.getNumSepultura()
		            + "\nTitular de la sepultura: "
		            + "\n\tNombre: " + sep.getNombreTitular()
		            + "\n\tApellido1: " + sep.getApellido1Titular()
		            + "\n\tApellido2: " + sep.getApellido2Titular()
		            + "\n\tTipo de contrato: " + sep.getTipoContrato()
		            + "\n\tObservaciones: " + sep.getObservaciones()
		            + "\nResponsable de la sepultura: "
		            + "\n\tNombre: " + res.getNombre()
		            + "\n\tApellido1: " + res.getApellido1()
		            + "\n\tApellido2: " + res.getApellido2());
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
	public Difunto getOne(Integer idn) {
		// TODO Auto-generated method stub
		return null;
	}
}
