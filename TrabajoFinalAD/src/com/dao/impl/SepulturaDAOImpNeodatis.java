/**
 * 
 */
package com.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

import com.dao.SepulturaDAO;
import com.modelo.Sepultura;

/**
 * @author alu
 *
 */
public class SepulturaDAOImpNeodatis implements SepulturaDAO{

private static ODB odb;
	
	public SepulturaDAOImpNeodatis(String db) {
		odb = ODBFactory.open(db);
	}
	
	public static ODB crearConexion() {
		return odb;
	}
	
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
		odb.store(sep);
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
	public boolean modify(Integer idn, Sepultura sep) {
		boolean valor =false;
		try {
			odb.store(sep);
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
		IQuery query = new CriteriaQuery(Sepultura.class, Where.equal("idDep", idn));
		Objects<Sepultura> objetos = odb.getObjects(query);
		try {
			Sepultura responsable = (Sepultura) objetos.getFirst();
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
	 * Consulta 1 --> Muestra un responsable dependiendo de la id que reciba de parámetro
	 * Consulta 2 -->
	 * Consulta 3 --> 
	 * @param id identificador del difunto
	 * @return boolean
	 * @exception IndexOutOfBoundsException
	*/
	@Override
	public Sepultura query(Integer option, Integer idn) {
		Sepultura d = new Sepultura();
		IQuery query;
		Objects<Sepultura> objetos;
		switch(option) {
			case 1:
				query = new CriteriaQuery(Sepultura.class, Where.equal("idDep", idn));
				objetos = odb.getObjects(query);
				
				if (objetos != null) {
					try {
						d = (Sepultura) objetos.getFirst();
					} catch (IndexOutOfBoundsException i) {
						i.printStackTrace();
						System.out.println("No se ha encontrado ningun difunto con identificador" + idn);
						d = null;
					}
				}
				break;
			case 2:
				//Consulta compleja 1
				break;
			case 3:
				//Consulta compleja 2
				break;
			default:
				d = null;
				System.out.println("Elija una opción valida");
		
		}
		
		return d;
	}

}
