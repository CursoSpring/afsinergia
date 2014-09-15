package com.afsinergia.org.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.afsinergia.org.dao.AfstFlotillaDao;
import com.afsinergia.org.model.AfstFlotilla;
import com.afsinergia.org.utils.Utilidades;

@Component(value = "AfstFlotillaDao")
public class AfstFlotillaDaoImp extends GenericDaoImpl<AfstFlotilla, Integer> implements AfstFlotillaDao {
	// Inyectamos la instancia del ssesionFactory con spring
	@Autowired
	@Qualifier(value = "sessionFactory")
	private SessionFactory sessionFactory;

	/*
	 * Se llama el constructor de la clase padre pasándole la entidad con la que
	 * trabajara
	 */
	protected AfstFlotillaDaoImp() {
		super(AfstFlotilla.class);
	}
	
	/* Se obtiene la sesión actual de hibernate */
	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void delete(Integer id) {
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AfstFlotilla> getAfstFlotillaByIdContrato(Integer idContrato) {

		Criteria criterio = getCurrentSession().createCriteria(AfstFlotilla.class);
		criterio.add(Restrictions.eq("afstContrato.idContrato", idContrato));
		return (List<AfstFlotilla>) criterio.list();
	}

	@Override
	public AfstFlotilla getAfstFlotillaById(Integer idFlotilla) {

		Criteria criterio = getCurrentSession().createCriteria(AfstFlotilla.class);
		criterio.add(Restrictions.eq("idFlotilla", idFlotilla));
		return (AfstFlotilla) criterio.uniqueResult();
	}


	@Override
	public void saveOrUpdateAfstFlotilla(AfstFlotilla flotilla) {
		if(flotilla.getIdFlotilla() != null && flotilla.getIdFlotilla() > 0 ){
			System.out.println("\t\t****************** VHM: metodo saveOrUpdateAfstFlotilla clase "+this.getClass().getName()+" actaliza flotilla.");

			Utilidades u = new Utilidades();
			
			Query query = getCurrentSession().createQuery("update AfstFlotilla set nombre = '"+flotilla.getNombre()+"', fechaActualiza = '"+u.getFechaActual()+"'  where idFlotilla = "+flotilla.getIdFlotilla());
			int result = query.executeUpdate();
			System.out.println("result = "+result);
		}
		else{
			System.out.println("\t\t****************** VHM: metodo saveOrUpdateAfstFlotilla clase "+this.getClass().getName()+" salva flotilla.");
			flotilla.setFechaAlta(new Date());
			getCurrentSession().save(flotilla);
		}		
	}
}
