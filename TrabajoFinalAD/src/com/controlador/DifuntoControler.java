/**
 *  Controlador de Difunto
 */
package com.controlador;

import java.util.List;

import com.dao.DifuntoDAO;
import com.dao.impl.DifuntoDAOImpHibernate;
import com.dao.impl.DifuntoDAOImpExistDB;
import com.dao.impl.DifuntoDAOImpNeodatis;
import com.modelo.Difunto;

/**
 * @author Angel Pavon Fraile
 *
 */
public class DifuntoControler {
	
	private DifuntoDAO difunto;
	
	/**
	 * Constructor del controlador de difunto
	 * @param tipo de base de datos a utilizar
	 */
	public DifuntoControler(String tipo) {
		if(tipo.equals("Neodatis")){
			difunto = new DifuntoDAOImpNeodatis(NeodatisUtils.buildODBConection("Cementerio.db"));
		}
		if(tipo.equals("Hibernate")){
			difunto = new DifuntoDAOImpHibernate();
		}
		if(tipo.equals("ExistDB")){
			difunto = new DifuntoDAOImpExistDB();
		}
	}

	/**
	 * Llama al metodo difunto.getAll()
	 * @return lista de difuntos
	 */
	public List <Difunto> listarTodos(){
		return difunto.getAll();
	}
	
	/**
	 * Llama al metodo difunto.create()
	 * @param d Difunto que va a ser insertado
	 * @return devuelve true despues de insertar
	 */
	public boolean crearDifunto(Difunto d) {
		return difunto.create(d);
	}
	
	/**
	 * Llama al metodo difunto.modify()
	 * @param d Difunto modificado para hacer el update
	 * @return devuelve true despues de modificar
	 */
	public boolean modificarDifunto(int d, Difunto dif) {
		return difunto.modify(d,dif);
	}
	
	/**
	 * LLama al metodo difunto.delete()
	 * @param id identificador del difunto para borrar
	 * @return devueve true despues de borrar 
	 */
	public boolean borrarDifunto(int id) {
		return difunto.delete(id);
	}
}
