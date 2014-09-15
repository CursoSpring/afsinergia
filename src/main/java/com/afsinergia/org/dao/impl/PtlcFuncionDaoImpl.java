package com.afsinergia.org.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.afsinergia.org.dao.PtlcFuncionDao;
import com.afsinergia.org.model.PtlcFuncion;

@Component(value = "PtlcFuncionDao")
public class PtlcFuncionDaoImpl extends GenericDaoImpl<PtlcFuncion, Integer>  implements PtlcFuncionDao{

	@Autowired
	@Qualifier(value = "sessionFactory")
	private SessionFactory sessionFactory;

	protected PtlcFuncionDaoImpl() {
		super(PtlcFuncion.class);
	}
	
	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<PtlcFuncion> getFuncionByIdModulo(Integer idModulo) {
		Criteria criterio = getCurrentSession().createCriteria(PtlcFuncion.class);
		criterio.add(Restrictions.eq("ptlcModulo.idModulo", idModulo));

		return (List<PtlcFuncion>) criterio.list();
	}

	@Override
	public PtlcFuncion getFuncionByIdFuncion(Integer idFuncion) {
		Criteria criterio = getCurrentSession().createCriteria(PtlcFuncion.class);
		System.out.println(":::: VHM_ llegó idFuncion = "+idFuncion);
		criterio.add(Restrictions.eq("idFun", idFuncion));

		return (PtlcFuncion) criterio.uniqueResult();
	}

}
