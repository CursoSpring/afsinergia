package com.afsinergia.org.dao.impl;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.afsinergia.org.dao.PtltPrivilegioDao;
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

		Query query = getCurrentSession().createQuery("SELECT p FROM PtltPrivilegio p INNER JOIN FETCH p.ptlcModulo m INNER JOIN FETCH p.ptlcFuncion f INNER JOIN FETCH p.usutGpousu g where g.idGpousu =  "+idGpoUsuario);
		List<PtltPrivilegio> privilegios = (List<PtltPrivilegio>) query.list();
		Set<PtltPrivilegio> privilegiosSinDuplicar = new LinkedHashSet<PtltPrivilegio>(privilegios);
		privilegios.clear();
		privilegios.addAll(privilegiosSinDuplicar);
		
		return privilegios;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<PtltPrivilegio> getAllPrivilegioByUserName(String userName) {

		Query query = getCurrentSession().createQuery("SELECT p FROM PtltPrivilegio p INNER JOIN FETCH p.ptlcModulo m INNER JOIN FETCH p.ptlcFuncion f INNER JOIN FETCH p.usutGpousu g INNER JOIN FETCH g.usutUsuarios u  where u.usuario =  '"+userName+"'");
		List<PtltPrivilegio> privilegios = (List<PtltPrivilegio>) query.list();
		Set<PtltPrivilegio> privilegiosSinDuplicar = new LinkedHashSet<PtltPrivilegio>(privilegios);
		privilegios.clear();
		privilegios.addAll(privilegiosSinDuplicar);
		
		return privilegios;
	}
	
	@Override
	public void saveOrUpdatePrivilegios(List<PtltPrivilegio> privilegios) {
		
		for(int i=0; i<privilegios.size(); i++)
			getCurrentSession().saveOrUpdate(privilegios);
	}

}
