package com.afsinergia.org.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.afsinergia.org.dao.AfstGpoempDao;
import com.afsinergia.org.model.AfstGpoemp;

@Component(value = "AfstGpoempDao")
public class AfstGpoempDaoImpl extends GenericDaoImpl<AfstGpoemp, Integer>  implements AfstGpoempDao{

	@Autowired
	@Qualifier(value = "sessionFactory")
	private SessionFactory sessionFactory;

	protected AfstGpoempDaoImpl() {
		super(AfstGpoemp.class);
	}
	
	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void saveOrUpdateGruposEmp(AfstGpoemp grupoEmpresa) {
		getCurrentSession().save(grupoEmpresa);
	}

}
