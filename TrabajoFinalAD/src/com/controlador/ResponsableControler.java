/**
 *  Controlador de Responsable
 */
package com.controlador;

import java.util.List;

import com.dao.ResponsableDAO;
import com.dao.impl.ResponsableDAOImpExistDB;
import com.dao.impl.ResponsableDAOImpHibernate;
import com.dao.impl.ResponsableDAOImpNeodatis;
import com.modelo.Difunto;
import com.modelo.Responsable;

/**
 * @author Angel Pavon Fraile
 *
 */
public class ResponsableControler {
	
	private ResponsableDAO responsable;
		
	/**
	 * Constructor del controlador de difunto
	 * @param tipo de base de datos a utilizar
	 */
	public ResponsableControler(String tipo) {
		if(tipo.equals("Neodatis")){
			responsable = new ResponsableDAOImpNeodatis("cementerio.db");
		}
		if(tipo.equals("Hibernate")){
			responsable = new ResponsableDAOImpHibernate();
		}
		if(tipo.equals("ExistDB")){
			responsable = new ResponsableDAOImpExistDB();
		}
	}
	
	/**
	 * Llama al metodo responsable.getAll()
	 * @return lista de responsables
	 */
	public List <Responsable> listarTodos(){
		return responsable.getAll();
	}
	
	/**
	 * Llama al metodo responsable.create()
	 * @param d Responsable que va a ser insertado
	 * @return devuelve true despues de insertar
	 */
	public boolean crearResponsable(Responsable d) {
		return responsable.create(d);
	}
	
	/**
	 * Llama al metodo responsable.modify()
	 * @param d Responsable modificado para hacer el update
	 * @return devuelve true despues de modificar
	 */
	public boolean modificarResponsable(int d, Responsable dif) {
		return responsable.modify(d,dif);
	}
	
	/**
	 * LLama al metodo responsable.delete()
	 * @param id identificador del responsable para borrar
	 * @return devueve true despues de borrar 
	 */
	public boolean borrarResponsable(int id) {
		return responsable.delete(id);
	}
	
	/**
	 * LLaman al metodo responsable.query()
	 * @param id identificador del responsable
	 * @return El obejto (Por ver si es esto lo que devuelve o un array)
	 */
	public Responsable query(int idn) {
		return responsable.query(idn);
	}
	/**
	 * LLaman al metodo responsable.query2()
	 * @param id identificador del responsable
	 * @return El obejto (Por ver si es esto lo que devuelve o un array)
	 */
	public Responsable query2(int idn) {
		return responsable.query(idn);
	}
}
