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

import com.afsinergia.org.dao.AfstContratoDao;
import com.afsinergia.org.model.AfstContrato;

@Component(value = "AfstContratoDao")
public class AfstContratoDaoImpl extends GenericDaoImpl<AfstContrato, Integer> implements AfstContratoDao{

	@Autowired
	@Qualifier(value = "sessionFactory")
	private SessionFactory sessionFactory;

	protected AfstContratoDaoImpl() {
		super(AfstContrato.class);
	}
	
	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AfstContrato> getContratosByIdCliente(Integer idCliente) {
		Criteria criterio = getCurrentSession().createCriteria(AfstContrato.class);
		criterio.add(Restrictions.eq("afstCliente.idCliente", idCliente));
		
		List<AfstContrato> contratos = (List<AfstContrato>) criterio.list();
		System.out.println("getContratosByIdCliente AfstContratoDaoImpl");
		
		for(int i=0; i<contratos.size();i++)
		{
			if(i==0)
				System.out.println(contratos.get(i).getAfstCliente().getIdCliente());
		}		
		
		return contratos;

	}

	@Override
	public AfstContrato getContratoByIdContrato(Integer idContrato) {
		Criteria criterio = getCurrentSession().createCriteria(AfstContrato.class);
		criterio.add(Restrictions.eq("idContrato", idContrato));
		
		return (AfstContrato) criterio.uniqueResult();
	}

	@Override
	public void saveOrUpdateContrato(AfstContrato contrato) {
		if(contrato.getIdContrato() != null && contrato.getIdContrato() > 0 ){
			
			System.out.println("\t\t****************** VHM: metodo saveOrUpdateContrato clase "+this.getClass().getName()+" actaliza contrato.");
			Query query = getCurrentSession().createQuery("update AfstContrato set nom_contrato = '"+contrato.getNomContrato()+"', plazo = "+contrato.getPlazo()+", noUnidades = "+contrato.getNoUnidades()+" where idContrato = "+contrato.getIdContrato());
			int result = query.executeUpdate();
			System.out.println("result = "+result);
		}
		else{
			System.out.println("\t\t****************** VHM: metodo saveOrUpdateContrato clase "+this.getClass().getName()+" salva contrato.");
			
			contrato.setInicioContrato(new Date());
			/*AfstCliente cliente = new AfstCliente();
			cliente.setIdCliente(1);
			contrato.setAfstCliente(cliente);*/
			getCurrentSession().save(contrato);
		}
	}

}
