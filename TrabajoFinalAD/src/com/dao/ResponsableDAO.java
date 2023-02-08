/**
 * 
 */
package com.dao;

import java.util.List;

import com.modelo.Responsable;

/**
 * @author alu
 *
 */
public interface ResponsableDAO {
	
	public List <Responsable> getAll();
	public Responsable create();
	public Responsable modify(int id);
	public Responsable delete(int id);

}
