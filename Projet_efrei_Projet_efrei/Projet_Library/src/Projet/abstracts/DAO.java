package Projet.abstracts;

import java.util.ArrayList;

import Projet.models.Person;

public interface DAO<TEntity> {
	/*
	 * CRUD
	 * CREATE (ADD)
	 * RETRIEVE (GET)
	 * UPDATE (UPDATE)
	 * DELETE (REMOVE)
	 */
	
	boolean add(TEntity e);
	TEntity getById(int id);
	ArrayList<TEntity> list();
	boolean update(int id, TEntity e);
	boolean remove(int id);
	TEntity getByLastName(String logName);
	boolean find(int id, Person person, String logName);
}
