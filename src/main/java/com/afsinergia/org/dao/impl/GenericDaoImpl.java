package com.afsinergia.org.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.afsinergia.org.dao.GenericDao;

//@Component(value = "GenericDao")
public  class GenericDaoImpl<E, ID extends Serializable> implements GenericDao<E, ID>
{
	/* Se inyecta la sessionFactory de hibernate a la clase */
	@Autowired
	@Qualifier(value = "sessionFactory")
	private SessionFactory sessionFactory;

	/* Se recibe la clase entidad */
	private Class<E> entityClass;
	
	/* Constructor */
	protected GenericDaoImpl(Class<E> entityClass) {
		this.entityClass = entityClass;
	}

	/* Se obtiene la sesión actual de hibernate */
	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	/* Actualiza o almacena los datos de una entidad. */
	//@Override
	public void saveEntity(E obj) {
		getCurrentSession().saveOrUpdate(obj);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void deleteEntityById(ID id) {
		E obj = (E) getCurrentSession().get(entityClass, id);
		
		if(obj != null)
			getCurrentSession().delete(obj);
	}

	@SuppressWarnings("unchecked")
	@Override
	public E getEntity(ID id) {
		return (E) getCurrentSession().get(entityClass, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<E> getAllEntity() {
		return (List<E>) getCurrentSession().createCriteria(entityClass).list();
	}

	@Override
	public void deleteEntityByObject(E obj) {
		getCurrentSession().delete(obj);
	}
}
