package com.dao;

import java.util.List;
import com.modelo.Sepultura;

/**
 * @author alu
 *
 */

public interface SepulturaDAO {
	
	public List <Sepultura> getAll();
	public Sepultura create();
	public Sepultura modify(int id);
	public Sepultura delete(int id);
}
