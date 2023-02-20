/**
 * 
 */
package com.controlador;

import java.util.List;

import com.dao.DifuntoDAO;
import com.dao.impl.DifuntoDAOImpHibernate;
import com.dao.impl.DifuntoDAOImpExistDB;
import com.dao.impl.DifuntoDAOImpNeodatis;
import com.modelo.Difunto;

/**
 * @author alu
 *
 */
public class DifuntoControler {
	
	private DifuntoDAO difunto;
	
	public DifuntoControler(String tipo) {
		if(tipo.equals("Neodatis")){
			difunto = new DifuntoDAOImpNeodatis("cementerio.db");
		}
		if(tipo.equals("Hibernate")){
			difunto = new DifuntoDAOImpHibernate();
		}
		if(tipo.equals("ExistDB")){
			difunto = new DifuntoDAOImpExistDB();
		}
	}

	public List <Difunto> listarTodos(){
		return difunto.getAll();
	}
	
	public boolean crearDifunto(Difunto d) {
		return difunto.create(d);
	}
	
	public boolean modificarDifunto(int d, Difunto dif) {
		return difunto.modify(d,dif);
	}
	
	public boolean borrarDifunto(int id) {
		return difunto.delete(id);
	}
}
