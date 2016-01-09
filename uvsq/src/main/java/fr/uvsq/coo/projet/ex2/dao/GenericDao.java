package fr.uvsq.coo.projet.ex2.dao;

import java.util.List;

public interface GenericDao<T> {

	T create(T entity);

	T update(T entity);

	T read(long id);

	void delete(long id);

	List<T> list();

}
