/**
 * 
 */
package com.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.dao.DifuntoDAO;
import com.modelo.Difunto;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

/**
 * @author alu
 *
 */
public class DifuntoDAOImpNeondatis implements DifuntoDAO{

	private static ODB odb;
	
	public DifuntoDAOImpNeondatis(String db) {
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
	
	@SuppressWarnings({"unchecked"})
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
		System.out.println("Departamento insertado");
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
	public boolean modify(int id, Difunto dif) {
		
		boolean valor =false;
		IQuery query = new CriteriaQuery(Difunto.class, Where.equal("idDep", dif));
		Objects<Difunto> objetos = odb.getObjects(query);
		try {
			Difunto difunto = (Difunto) objetos.getFirst();
			difunto.setNombre(dif.getNombre());
			difunto.setApellido1(dif.getApellido1());
			difunto.setApellido2(dif.getApellido2());
			difunto.setFechaNacimiento(dif.getFechaNacimiento());
			difunto.setFechaDefuncion(dif.getFechaDefuncion());
			difunto.setFechaEnterramiento(dif.getFechaEnterramiento());
			difunto.setSepultura(dif.getSepultura());
			odb.store(difunto);
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
	public boolean delete(int id) {
		boolean valor =false;
		IQuery query = new CriteriaQuery(Difunto.class, Where.equal("idDep", id));
		Objects<Difunto> objetos = odb.getObjects(query);
		try {
			Difunto departamento = (Difunto) objetos.getFirst();
			odb.delete(departamento);
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
	 * Consulta 1 --> Muestra un departamento dependiendo de la id que reciba de parámetro
	 * Consulta 2 -->
	 * Consulta 3 --> 
	 * @param id identificador del difunto
	 * @return boolean
	 * @exception IndexOutOfBoundsException
	*/
	@Override
	public Difunto query(int o, int idDif) {
		Difunto d = new Difunto();
		IQuery query;
		Objects<Difunto> objetos;
		switch(o) {
			case 1:
				query = new CriteriaQuery(Difunto.class, Where.equal("idDep", idDif));
				objetos = odb.getObjects(query);
				
				if (objetos != null) {
					try {
						d = (Difunto) objetos.getFirst();
					} catch (IndexOutOfBoundsException i) {
						i.printStackTrace();
						System.out.println("No se ha encontrado ningun difunto con identificador" + idDif);
						d = null;
					}
				}
				break;
			case 2:
				//Consulta compleja 1
				query = new CriteriaQuery(Difunto.class, Where.equal("idDep", idDif));
				objetos = odb.getObjects(query);
				
				if (objetos != null) {
					try {
						d = (Difunto) objetos.getFirst();
					} catch (IndexOutOfBoundsException i) {
						i.printStackTrace();
						System.out.println("No se ha encontrado ningun difunto con identificador" + idDif);
						d = null;
					}
				}
				break;
			case 3:
				//Consulta compleja 2
				query = new CriteriaQuery(Difunto.class, Where.equal("idDep", idDif));
				objetos = odb.getObjects(query);
				
				if (objetos != null) {
					try {
						d = (Difunto) objetos.getFirst();
					} catch (IndexOutOfBoundsException ioobe) {
						ioobe.printStackTrace();
						System.out.println("No se ha encontrado ningun difunto con identificador" + idDif);
						d = null;
					}
				}
				break;
			default:
				d = null;
				System.out.println("Elija una opción valida");
		
		}
		
		return d;
	}
}
