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
	public boolean modify(int id, Difunto dif);
	public boolean delete(int id);
	public Difunto query(int o, int id);
	
}
