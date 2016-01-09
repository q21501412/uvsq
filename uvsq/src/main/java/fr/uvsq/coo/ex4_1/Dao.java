package fr.uvsq.coo.ex4_1;

import java.util.List;

public interface Dao<T> {
	
	T create(T entity);
	T update(T entity);
	T read(String id);
	void delete(String id);
	List<T> list();

}
