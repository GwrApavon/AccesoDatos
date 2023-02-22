/**
 * 
 */
package com.controlador;

import java.util.List;

import com.dao.SepulturaDAO;
import com.dao.impl.SepulturaDAOImpExistDB;
import com.dao.impl.SepulturaDAOImpHibernate;
import com.dao.impl.SepulturaDAOImpNeodatis;
import com.modelo.Sepultura;

/**
 * @author alu
 *
 */
public class SepulturaControler {
	
	private SepulturaDAO sepultura;
	
	public SepulturaControler(String tipo) {
		if(tipo.equals("Neodatis")){
			sepultura = new SepulturaDAOImpNeodatis("cementerio.db");
		}
		if(tipo.equals("Hibernate")){
			sepultura = new SepulturaDAOImpHibernate();
		}
		if(tipo.equals("ExistDB")){
			sepultura = new SepulturaDAOImpExistDB();
		}
	}

	public List <Sepultura> listarTodos(){
		return sepultura.getAll();
	}
	
	public boolean crearSepultura(Sepultura d) {
		return sepultura.create(d);
	}
	
	public boolean modificarSepultura(int d, Sepultura dif) {
		return sepultura.modify(d,dif);
	}
	
	public boolean borrarSepultura(int id) {
		return sepultura.delete(id);
	}
}
