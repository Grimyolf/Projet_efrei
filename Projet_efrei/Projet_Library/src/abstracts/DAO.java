package abstracts;

import java.util.ArrayList;

import models.Person;

public interface DAO<TEntity> {
	
	
	boolean add(TEntity e);
	TEntity getById(int id);
	ArrayList<TEntity> list();
	boolean update(int id, TEntity e);
	boolean remove(int id);
}
