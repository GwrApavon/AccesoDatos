/**
 * 
 */
package com.dao;
import java.util.List;
import com.modelo.Difunto;

/**
 * @author alu
 *
 */
public interface DifuntoDAO {

	public List <Difunto> getAll();
	public boolean create(Difunto dif);
	public boolean modify(Difunto dif);
	public boolean delete(int id);
	public Difunto query(int o, int id);
	public int lastID();
	
}
