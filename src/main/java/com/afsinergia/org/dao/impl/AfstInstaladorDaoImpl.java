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

import com.afsinergia.org.dao.AfstInstaladorDao;
import com.afsinergia.org.model.AfstInstalador;
import com.afsinergia.org.utils.Utilidades;

@Component(value = "AfstInstaladorDao")
public class AfstInstaladorDaoImpl extends GenericDaoImpl<AfstInstalador, Integer> implements AfstInstaladorDao {

	// Inyectamos la instancia del ssesionFactory con spring
	@Autowired
	@Qualifier(value = "sessionFactory")
	private SessionFactory sessionFactory;

	/*
	 * Se llama el constructor de la clase padre pasándole la entidad con la que
	 * trabajara
	 */
	protected AfstInstaladorDaoImpl() {
		super(AfstInstalador.class);
	}
	
	/* Se obtiene la sesión actual de hibernate */
	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void saveOrUpdateAfstInstalador(AfstInstalador instalador) {
		if(instalador.getIdInstalador() != null && instalador.getIdInstalador() > 0 ){
			System.out.println("\t\t****************** VHM: metodo saveOrUpdateAfstInstalador clase "+this.getClass().getName()+" actaliza instalador.");

			Utilidades u = new Utilidades();
			
			Query query = getCurrentSession().createQuery("update AfstInstalador set nombre = '"+instalador.getNombre()+"', paterno = '"+instalador.getPaterno()+"', materno = '"+instalador.getMaterno()+"', correo = '"+instalador.getCorreo()+"', fechaActualiza = '"+u.getFechaActual()+"'  where idInstalador = "+instalador.getIdInstalador());
			int result = query.executeUpdate();
			System.out.println("result = "+result);
		}
		else{
			System.out.println("\t\t****************** VHM: metodo saveOrUpdateAfstInstalador clase "+this.getClass().getName()+" salva instalador.");
			instalador.setFechaAlta(new Date());
			getCurrentSession().save(instalador);
		}		
	}

	@Override
	public void delete(Integer idInstalador) {
		delete(idInstalador);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AfstInstalador> getAfstInstaladorByIdCliente(Integer idCliente) {

		Criteria criterio = getCurrentSession().createCriteria(AfstInstalador.class);
		criterio.add(Restrictions.eq("afstCliente.idCliente", idCliente));
		return (List<AfstInstalador>) criterio.list();
	}

	@Override
	public AfstInstalador getAfstInstaladorById(Integer idInstalador) {

		Criteria criterio = getCurrentSession().createCriteria(AfstInstalador.class);
		criterio.add(Restrictions.eq("idInstalador", idInstalador));
		return (AfstInstalador) criterio.uniqueResult();
	}

}
