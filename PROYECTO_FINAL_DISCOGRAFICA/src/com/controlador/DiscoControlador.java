package com.controlador;

import java.util.ArrayList;
import java.util.List;

import com.dao.DiscoDAO;
import com.modelo.Disco;

public class DiscoControlador implements DiscoDAO{

	private DiscoDAO disco;
	
	public DiscoControlador (String tipoDeBD) {
		if (tipoDeBD.equalsIgnoreCase("OO") ) {
			/*disco = new DiscoOO();*/
		} else if(tipoDeBD.equalsIgnoreCase("MYSQL")) {
			/*disco = new DiscoMySQL();*/
		} else {
			/*disco = new DiscoExistDB;*/
		}
	}

	public DiscoDAO getDisco() {
		return disco;
	}

	public void setDisco(DiscoDAO disco) {
		this.disco = disco;
	}

	@Override
	public boolean inserta(Disco disc) {
		return disco.inserta(disc);
	}

	@Override
	public boolean elimina(Integer idDisc) {
		return disco.elimina(idDisc);
	}

	@Override
	public boolean modifica(Integer idDisc) {
		return disco.modifica(idDisc);
	}


	@Override
	public List<Disco> encuentraTodos() {
		return disco.encuentraTodos();
	}

	@Override
	public List<ArrayList<String>> consulta1() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
