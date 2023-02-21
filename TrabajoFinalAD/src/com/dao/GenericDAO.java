package com.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO<T, ID extends Serializable>{

	public List <T> getAll();
	public boolean create(T element);
	public boolean modify(ID idn, T element);
	public boolean delete(ID idn);
	public T query(ID option, ID idn);
}
