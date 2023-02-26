/**
 * Clase generica para DAO
 */
package com.dao;

import java.io.Serializable;
import java.util.List;
/**
 * @author Angel Pavon Fraile
 *
 */

public interface GenericDAO<T, ID extends Serializable>{

	public List <T> getAll();
	public T getOne(ID idn);
	public boolean create(T element);
	public boolean modify(ID idn, T element);
	public boolean delete(ID idn);
	public void query();
}
