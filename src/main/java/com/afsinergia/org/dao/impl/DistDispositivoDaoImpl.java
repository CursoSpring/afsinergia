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

import com.afsinergia.org.dao.DistDispositivoDao;
import com.afsinergia.org.model.DistDispositivo;
import com.afsinergia.org.utils.Utilidades;

@Component(value = "DistDispositivoDao")
public class DistDispositivoDaoImpl extends GenericDaoImpl<DistDispositivo, Integer> implements DistDispositivoDao{

	// Inyectamos la instancia del ssesionFactory con spring
	@Autowired
	@Qualifier(value = "sessionFactory")
	private SessionFactory sessionFactory;

	/*
	 * Se llama el constructor de la clase padre pasándole la entidad con la que
	 * trabajara
	 */
	protected DistDispositivoDaoImpl() {
		super(DistDispositivo.class);
	}
	
	/* Se obtiene la sesión actual de hibernate */
	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void saveOrUpdateDistDispositivo(DistDispositivo dispositivo) {
		
		if(dispositivo.getIdDispositivo() != null && dispositivo.getIdDispositivo() > 0 ){
			
			System.out.println("\t\t****************** VHM: metodo saveOrUpdateDistDispositivo clase "+this.getClass().getName()+" actaliza dispo.");

			Utilidades u = new Utilidades();
			
			Query query = getCurrentSession().createQuery("update DistDispositivo set imei = '"+dispositivo.getImei()+"', fechaActualiza = '"+u.getFechaActual()+"' where idDispositivo = "+dispositivo.getIdDispositivo());
			int result = query.executeUpdate();
			System.out.println("result = "+result);
		}
		else{
			System.out.println("\t\t****************** VHM: metodo saveOrUpdateDistDispositivo clase "+this.getClass().getName()+" salva dispo.");
			dispositivo.setFechaAlta(new Date());
			getCurrentSession().save(dispositivo);
		}
	}

	@Override
	public void delete(Integer id) {
		deleteEntityById(id);
	}

	@Override
	public DistDispositivo getDistDispositivo(Integer id) {
		return getEntity(id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DistDispositivo> getDistDispositivosByIdContrato(Integer idContrato) {
		Criteria criterio = getCurrentSession().createCriteria(DistDispositivo.class);
		criterio.add(Restrictions.eq("afstContrato.idContrato", idContrato));

		return (List<DistDispositivo>) criterio.list();
	}

	@Override
	public DistDispositivo getDistDispositivoById(Integer idDistDispositivo) {

		Criteria criterio = getCurrentSession().createCriteria(DistDispositivo.class);
		criterio.add(Restrictions.eq("idDispositivo", idDistDispositivo));
		
		DistDispositivo dispositivo = (DistDispositivo) criterio.uniqueResult();
		return dispositivo;
	}

}
