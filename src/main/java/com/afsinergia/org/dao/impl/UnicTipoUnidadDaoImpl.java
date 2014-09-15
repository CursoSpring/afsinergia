package com.afsinergia.org.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.afsinergia.org.dao.UnicTipoUnidadDao;
import com.afsinergia.org.model.UnicTipoUnidad;

@Component(value = "UnicTipoUnidadDAO")
public class UnicTipoUnidadDaoImpl extends GenericDaoImpl<UnicTipoUnidad, Integer> implements UnicTipoUnidadDao{

	@Autowired
	@Qualifier(value = "sessionFactory")
	private SessionFactory sessionFactory;

	protected UnicTipoUnidadDaoImpl() {
		super(UnicTipoUnidad.class);
	}
	
	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public List<UnicTipoUnidad> getAllUnicTipoUnidades() {
		return getAllEntity();
	}

}
