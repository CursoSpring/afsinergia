package com.afsinergia.org.dao;

import java.io.Serializable;
import java.util.List;

public  interface GenericDao<E, ID extends Serializable>{

	public void saveEntity(E obj);

	public void deleteEntityByObject(E obj);
	
	public void deleteEntityById(ID obj);

	public E getEntity(ID id);

	public List<E> getAllEntity();
}
