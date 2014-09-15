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

import com.afsinergia.org.dao.AfstClienteDao;
import com.afsinergia.org.model.AfstCliente;
import com.afsinergia.org.utils.Utilidades;

@Component(value = "AfstClienteDao")
public class AfstClienteDaoImpl extends GenericDaoImpl<AfstCliente, Integer>  implements AfstClienteDao{

	@Autowired
	@Qualifier(value = "sessionFactory")
	private SessionFactory sessionFactory;

	protected AfstClienteDaoImpl() {
		super(AfstCliente.class);
	}
	
	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<AfstCliente> getClientesByIdGpoEmp(Integer idGrupoEmp) {
		Criteria criterio = getCurrentSession().createCriteria(AfstCliente.class);
		criterio.add(Restrictions.eq("afstGpoemp.idGpoemp", idGrupoEmp));
		
		List<AfstCliente> clientes = (List<AfstCliente>) criterio.list();
		System.out.println("getClientesByIdGpoEmp AfstClienteDaoImpl");
		
		for(int i=0; i<clientes.size();i++)
		{
			if(i==0)
				System.out.println(clientes.get(i).getAfstGpoemp().getIdGpoemp());
		}		
		
		return clientes;
	}

	@Override
	public AfstCliente getClienteById(Integer idCliente) {
		Criteria criterio = getCurrentSession().createCriteria(AfstCliente.class);
		criterio.add(Restrictions.eq("idCliente", idCliente));
		
		return (AfstCliente) criterio.uniqueResult();
	}


	@Override
	public void saveOrUpdateCliente(AfstCliente cliente) {
		
		if(cliente.getIdCliente() != null && cliente.getIdCliente() > 0 ){
			System.out.println("\t\t****************** VHM: metodo saveOrUpdateCliente clase "+this.getClass().getName()+" actaliza cliente.");

			Utilidades u = new Utilidades();
			
			Query query = getCurrentSession().createQuery("update AfstCliente set nombre = '"+cliente.getNombre()+"', contacto = '"+cliente.getContacto()+"', telefono = '"+cliente.getTelefono()+"', movil = '"+cliente.getMovil()+"', mail = '"+cliente.getMail()+"', fechaActualiza = '"+u.getFechaActual()+"'  where idCliente = "+cliente.getIdCliente());
			int result = query.executeUpdate();
			System.out.println("result = "+result);
		}
		else{
			System.out.println("\t\t****************** VHM: metodo saveOrUpdateCliente clase "+this.getClass().getName()+" salva cliente.");
			
			cliente.setFechaAlta(new Date());
			getCurrentSession().save(cliente);
		}
	}

}
