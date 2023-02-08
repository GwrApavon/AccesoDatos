/**
 * 
 */
package com.controlador;

import java.util.List;

import com.dao.DifuntoDAO;
import com.dao.impl.DifuntoDAOImpHibernate;
import com.dao.impl.DifuntoDAOImpNoSQL;
import com.dao.impl.DifuntoDAOImpOO;
import com.modelo.Difunto;

/**
 * @author alu
 *
 */
public class DifuntoControler {
	
	DifuntoDAO difunto;
	
	public DifuntoControler(String tipo) {
		if(tipo.equals("OO")){
			difunto = new DifuntoDAOImpOO("cementerio.db");
		}
		if(tipo.equals("Hibernate")){
			difunto = new DifuntoDAOImpHibernate();
		}
		if(tipo.equals("NoSQL")){
			difunto = new DifuntoDAOImpNoSQL();
		}
	}

	public List <Difunto> listarTodos(){
		return difunto.getAll();
	}
	
	public void	crearDifunto(Difunto d) {
		d = difunto.create();
	}
	
	public void modificarDifunto(Difunto d, int id) {
		d = difunto.modify(id);
	}
	
	public void borrarDifunto(Difunto d, int id) {
		d = difunto.delete(id);
	}
}
