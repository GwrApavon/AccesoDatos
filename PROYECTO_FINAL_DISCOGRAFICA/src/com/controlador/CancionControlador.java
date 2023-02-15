package com.controlador;

import java.util.ArrayList;
import java.util.List;

import com.dao.CancionDAO;
import com.modelo.Cancion;


public class CancionControlador implements CancionDAO{
	
	private CancionDAO cancion;
	
	public CancionControlador (String tipoDeBD) {
		if (tipoDeBD.equalsIgnoreCase("OO") ) {
			/*cancion = new CancionOO();*/
		} else if(tipoDeBD.equalsIgnoreCase("MYSQL")) {
			/*cancion = new CancionMySQL();*/
		} else {
			/*cancion = new CancionExistDB;*/
		}
	}
	
	/**
	 * @return la canción
	 */
	public CancionDAO getCancion() {
		return cancion;
	}

	/**
	 * @param cancion la cancion to set
	 */
	public void setCancion(CancionDAO cancion) {
		this.cancion = cancion;
	}

	@Override
	public boolean inserta(Cancion can) {
		return cancion.inserta(can);
	}

	@Override
	public boolean elimina(Integer idCan) {
		return cancion.elimina(idCan);
	}

	@Override
	public boolean modifica(Integer idCan) {
		return cancion.modifica(idCan);
	}

	@Override
	public List<Cancion> encuentraTodos() {
		return cancion.encuentraTodos();
	}

	@Override
	public List<ArrayList<String>> consulta1() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	

}
