package com.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public interface GenericDAO<T, ID extends Serializable>{
	
	public boolean inserta(T elemento);
	public boolean elimina(ID identificador);
	public boolean modifica(ID identificador);
	public List<ArrayList<String>> consulta1();
	public List<T> encuentraTodos();
	
}
