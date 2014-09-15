package com.afsinergia.org.dao.impl;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.afsinergia.org.dao.UsutUsuarioDao;
import com.afsinergia.org.model.UserStatus;
import com.afsinergia.org.model.UsutUsuario;
import com.afsinergia.org.utils.Utilidades;

@Component(value = "UsutUsuarioDao")
public class UsutUsuarioDaoImpl extends GenericDaoImpl<UsutUsuario, Integer> implements UsutUsuarioDao{

	// Inyectamos la instancia del ssesionFactory con spring
	@Autowired
	@Qualifier(value = "sessionFactory")
	private SessionFactory sessionFactory;

	/*
	 * Se llama el constructor de la clase padre pasándole la entidad con la que
	 * trabajara
	 */
	protected UsutUsuarioDaoImpl() {
		super(UsutUsuario.class);
	}
	
	/* Se obtiene la sesión actual de hibernate */
	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	//baja de un usuario en la bd
	@Override
	public void delete(Integer id) {
		deleteEntityById(id);
	}

	//get de un usuario de la bd, en funcion del id
	@Override
	public UsutUsuario getUsuario(Integer id) {
		return getEntity(id);
	}

	//get de usuarios en funcion del idGrupoUsuario
	@SuppressWarnings("unchecked")
	@Override
	public List<UsutUsuario> getUsuariosByIdGpoUsu(Integer idUsuario) {
		
		Criteria criterio = getCurrentSession().createCriteria(UsutUsuario.class);
		criterio.add(Restrictions.eq("usutGpousu.idGpousu", idUsuario));

		List<UsutUsuario> usuarios = (List<UsutUsuario>) criterio.list();
		
		/*for(int i=0;i<usuarios.size();i++)
		{
			System.out.println("::::::::::::::::::::::: getUsuariosByIdGpoUsu usuario: "+usuarios.get(i).getNombre()+""+usuarios.get(i).getUsutGpousu().getNombre());
		}*/
		
		return usuarios;
	}

	//get de usuarios en funcion del idContrato
	@SuppressWarnings("unchecked")
	@Override
	public List<UsutUsuario> getUsuariosByIdContrato(Integer idContrato) {
		
		Query query = getCurrentSession().createQuery("SELECT usu FROM UsutUsuario usu INNER JOIN FETCH usu.usutGpousu gpo_usu INNER JOIN FETCH gpo_usu.afstContrato contrato where contrato.idContrato =  "+idContrato);

		List<UsutUsuario> usuarios = (List<UsutUsuario>) query.list();
		Set<UsutUsuario> usuariosSinDuplicar = new LinkedHashSet<UsutUsuario>(usuarios);
		usuarios.clear();
		usuarios.addAll(usuariosSinDuplicar);
		
		/*for(int i=0;i<usuarios.size();i++)
		{
			System.out.println("::::::::::::::::::::::: getUsuariosByIdContrato usuario: "+usuarios.get(i).getNombre()+""+usuarios.get(i).getUsutGpousu().getNombre());
		}*/
		
		return usuarios;
	}
	
	//get de usuarios en funcion del idGrupoUsuario y idCliente
	@Override
	public UsutUsuario getUsuarioById(Integer idUsuario) {
		
		Criteria criterio = getCurrentSession().createCriteria(UsutUsuario.class);
		criterio.add(Restrictions.eq("idUsuario", idUsuario));

		return (UsutUsuario) criterio.uniqueResult();
	}

	
	//metodo que verfica si un usuario existe o no en el sistema, en funcion del usuario y el password(clave)
	@Override
	public UsutUsuario getUsuarioForLoggin(UsutUsuario usuario) {
		
		Criteria criterio = getCurrentSession().createCriteria(UsutUsuario.class);
		criterio.add(Restrictions.and(Restrictions.eq("usuario", usuario.getUsuario()), Restrictions.eq("clave", usuario.getClave())));

		return (UsutUsuario) criterio.uniqueResult();
	}

	//metodo que verifica si un usuario existe en el sistema, en funcion del nombre de usuario (usuario)
	@Override
	public UsutUsuario getUsuarioByUserName(String userName) {
		Criteria criterio = getCurrentSession().createCriteria(UsutUsuario.class);
		criterio.add(Restrictions.eq("usuario", userName));
		return (UsutUsuario) criterio.uniqueResult();
	}

	
	@Override
	public void saveOrUpdateUsuario(UsutUsuario usuario) {
		
		if(usuario.getIdUsuario() != null && usuario.getIdUsuario() > 0 ){
			System.out.println("\t\t****************** VHM: metodo saveOrUpdateUsuario clase "+this.getClass().getName()+" actaliza usuario.");

			Utilidades u = new Utilidades();
			
			Query query = getCurrentSession().createQuery("update UsutUsuario set usuario = '"+usuario.getUsuario()+"', nombre = '"+usuario.getNombre()+"', apePat = '"+usuario.getApePat()+"', apeMat = '"+usuario.getApeMat()+"', usuario = '"+usuario.getUsuario()+"', clave = '"+usuario.getClave()+"', fechaActualiza = '"+u.getFechaActual()+"', status = '"+usuario.getStatus()+"', usutGpousu.idGpousu = "+usuario.getUsutGpousu().getIdGpousu()+"  where idUsuario = "+usuario.getIdUsuario());
			int result = query.executeUpdate();
			System.out.println("result = "+result);
		}
		else{
			System.out.println("\t\t****************** VHM: metodo saveOrUpdateUsuario clase "+this.getClass().getName()+" salva usuario.");
			usuario.setStatus(UserStatus.ACTIVE);
			usuario.setFechaAlta(new Date());
			getCurrentSession().save(usuario);
		}
	}
}
