package com.afsinergia.org.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.afsinergia.org.dao.PtltPrivilegioDao;
import com.afsinergia.org.model.PtlcFuncion;
import com.afsinergia.org.model.PtlcModulo;
import com.afsinergia.org.model.PtltPrivilegio;

@Component(value = "PtltPrivilegio")
public class PtltPrivilegioDaoImpl extends GenericDaoImpl<PtltPrivilegio, Integer> implements PtltPrivilegioDao{

	@Autowired
	@Qualifier(value = "sessionFactory")
	private SessionFactory sessionFactory;

	protected PtltPrivilegioDaoImpl() {
		super(PtltPrivilegio.class);
	}
	
	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<PtltPrivilegio> getAllPrivilegioByIdGpoUsuario(Integer idGpoUsuario) {
		Criteria criterio = getCurrentSession().createCriteria(PtltPrivilegio.class);
		criterio.add(Restrictions.eq("usutGpousu.idGpousu", idGpoUsuario));
		criterio.addOrder(Order.asc("ptlcModulo.idModulo"));
		
		List<PtltPrivilegio> privilegios = (List<PtltPrivilegio>) criterio.list();

		//Hibernate.initialize(PtlcModulo.class);
		//Hibernate.initialize(PtlcFuncion.class);

		//session.update(object);
		/*
		 * http://stackoverflow.com/questions/345705/hibernate-lazyinitializationexception-could-not-initialize-proxy
		 * http://stackoverflow.com/questions/21574236/org-hibernate-lazyinitializationexception-could-not-initialize-proxy-no-sess
		 * */

		if(privilegios != null && privilegios.size() > 0)
		{
			for(int i=0; i<privilegios.size(); i++){
				PtlcModulo modulo = privilegios.get(i).getPtlcModulo();
				PtlcFuncion funcion = privilegios.get(i).getPtlcFuncion();
				System.out.println(":::::::VHM_ Dao"+", idModulo: "+modulo.getIdModulo()+", idFuncion: "+funcion.getIdFun()+", modulo: "+modulo.getNomMod()+", funcion: "+funcion.getNomFun());
			}
		}
		
		return privilegios;
	}

	@Override
	public void saveOrUpdatePrivilegios(List<PtltPrivilegio> privilegios) {
		for(int i=0; i<privilegios.size(); i++)
			getCurrentSession().saveOrUpdate(privilegios);
	}

}
