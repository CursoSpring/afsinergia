package com.afsinergia.org.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.afsinergia.org.dao.UsutGpousuDao;
import com.afsinergia.org.model.UsutGpousu;
import com.afsinergia.org.utils.Utilidades;

@Component(value = "UsutGpousuDao")
public class UsutGpousuDaoImpl extends GenericDaoImpl<UsutGpousu, Integer> implements UsutGpousuDao{
	
	@Autowired
	@Qualifier(value = "sessionFactory")
	private SessionFactory sessionFactory;

	protected UsutGpousuDaoImpl() {
		super(UsutGpousu.class);
	}
	
	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<UsutGpousu> getGruposUsuariosByIdContrato(Integer idContrato) {
		Criteria criterio = getCurrentSession().createCriteria(UsutGpousu.class);
		criterio.add(Restrictions.eq("afstContrato.idContrato", idContrato));

		return (List<UsutGpousu>) criterio.list();
	}

	@Override
	public UsutGpousu getGrupoUsuariosById(Integer idGrupoUsuario) {
		Criteria criterio = getCurrentSession().createCriteria(UsutGpousu.class);
		criterio.add(Restrictions.eq("idGpousu", idGrupoUsuario));
		
		UsutGpousu gpoUs = (UsutGpousu) criterio.uniqueResult();
		return gpoUs;
	}

	@Override
	public void saveOrUpdateGrupoUsuario(UsutGpousu grupoUsuario) {
		
		if(grupoUsuario.getIdGpousu() != null && grupoUsuario.getIdGpousu() > 0 ){
			
			System.out.println("\t\t****************** VHM: metodo saveOrUpdateGrupoUsuario clase "+this.getClass().getName()+" actaliza grupo usuario.");

			Utilidades u = new Utilidades();
			
			Query query = getCurrentSession().createQuery("update UsutGpousu set nombre = '"+grupoUsuario.getNombre()+"', fechaActualiza = '"+u.getFechaActual()+"' where idGpousu = "+grupoUsuario.getIdGpousu());
			int result = query.executeUpdate();
			System.out.println("result = "+result);
		}
		else{
			System.out.println("\t\t****************** VHM: metodo saveOrUpdateGrupoUsuario clase "+this.getClass().getName()+" salva grupo usuario.");
			getCurrentSession().save(grupoUsuario);
		}
	}

}
