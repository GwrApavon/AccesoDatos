package com.controlador;

import java.util.ArrayList;
import java.util.List;

import com.dao.CantanteDAO;
import com.dao.implementacion.CantanteDAOImpHibernate;
import com.modelo.Cantante;

public class CantanteControlador implements CantanteDAO{

	private CantanteDAO cantante;
	
	
	
	public CantanteControlador() {
		super();
	}

	public CantanteControlador (String tipoDeBD) {
		if (tipoDeBD.equalsIgnoreCase("OO") ) {
			/*cantante = new CantanteOO();*/
		} else if(tipoDeBD.equalsIgnoreCase("MYSQL")) {
			cantante = new CantanteDAOImpHibernate();
		} else {
			/*cantante = new CantanteExistDB;*/
		}
	}

	public CantanteDAO getCantante() {
		return cantante;
	}

	public void setCantante(CantanteDAO cantante) {
		this.cantante = cantante;
	}

	@Override
	public boolean inserta(Cantante cant) {
		return cantante.inserta(cant);
	}

	@Override
	public boolean elimina(Integer idCant) {
		return cantante.elimina(idCant);
	}

	@Override
	public boolean modifica(Integer idCant) {
		return cantante.modifica(idCant);
	}

	

	@Override
	public List<Cantante> encuentraTodos() {
		return cantante.encuentraTodos();
	}

	@Override
	public List<ArrayList<String>> consulta1() {
		return cantante.consulta1();
	}
	
	
}
