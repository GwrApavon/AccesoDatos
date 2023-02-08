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
	public Difunto create();
	public Difunto modify(int id);
	public Difunto delete(int id);
	
}
