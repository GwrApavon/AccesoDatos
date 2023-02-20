/**
 * 
 */
package com.controlador;

import java.util.List;

import com.dao.ResponsableDAO;
import com.dao.impl.ResponsableDAOImpExistDB;
import com.dao.impl.ResponsableDAOImpHibernate;
import com.dao.impl.ResponsableDAOImpNeodatis;
import com.modelo.Responsable;

/**
 * @author alu
 *
 */
public class ResponsableControler {
	
	private ResponsableDAO responsable;
		
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
	
		public List <Responsable> listarTodos(){
			return responsable.getAll();
		}
		
		public boolean crearDifunto(Responsable d) {
			return responsable.create(d);
		}
		
		public boolean modificarDifunto(int d, Responsable dif) {
			return responsable.modify(d,dif);
		}
		
		public boolean borrarDifunto(int id) {
			return responsable.delete(id);
		}
}
