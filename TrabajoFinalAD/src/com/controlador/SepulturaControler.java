/**
 *  Controlador de sepultura
 */
package com.controlador;

import java.util.List;

import com.dao.SepulturaDAO;
import com.dao.impl.SepulturaDAOImpExistDB;
import com.dao.impl.SepulturaDAOImpHibernate;
import com.dao.impl.SepulturaDAOImpNeodatis;
import com.modelo.Difunto;
import com.modelo.Responsable;
import com.modelo.Sepultura;

/**
 * @author Angel Pavon Fraile
 *
 */
public class SepulturaControler {
	
	private SepulturaDAO sepultura;
	
	/**
	 * Constructor del controlador de sepultura
	 * @param tipo de base de datos a utilizar
	 */
	public SepulturaControler(String tipo) {
		if(tipo.equals("Neodatis")){
			sepultura = new SepulturaDAOImpNeodatis(NeodatisUtils.buildODBConection("Cementerio.db"));
		}
		if(tipo.equals("Hibernate")){
			sepultura = new SepulturaDAOImpHibernate();
		}
		if(tipo.equals("ExistDB")){
			sepultura = new SepulturaDAOImpExistDB();
		}
	}

	/**
	 * Llama al metodo sepultura.getAll()
	 * @return lista de sepulturas
	 */
	public List <Sepultura> listarTodos(){
		return sepultura.getAll();
	}
	
	/**
	 * Llama al metodo sepultura.getOne()
	 * @return responsable
	 */
	public Sepultura devolverUno(int id){
		return sepultura.getOne(id);
	}
	/**
	 * Llama al metodo sepultura.create()
	 * @param d Sepultura que va a ser insertada
	 * @return devuelve true despues de insertar
	 */
	public boolean crearSepultura(Sepultura d) {
		return sepultura.create(d);
	}
	
	/**
	 * Llama al metodo sepultura.modify()
	 * @param d Sepultura modificada para hacer el update
	 * @return devuelve true despues de modificar
	 */
	public boolean modificarSepultura(int d, Sepultura dif) {
		return sepultura.modify(d,dif);
	}
	
	/**
	 * LLama al metodo sepultura.delete()
	 * @param id identificador de la sepultura para borrar
	 * @return devueve true despues de borrar 
	 */
	public boolean borrarSepultura(int id) {
		return sepultura.delete(id);
	}
	
	/**
	 * LLaman al metodo sepultura.query()
	 */
	public void query() {
		sepultura.query();
	}

}
