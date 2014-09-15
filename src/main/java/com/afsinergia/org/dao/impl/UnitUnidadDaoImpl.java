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

import com.afsinergia.org.dao.UnitUnidadDao;
import com.afsinergia.org.model.UnitUnidad;
import com.afsinergia.org.utils.Utilidades;

@Component(value = "UnitUnidadDAO")
public class UnitUnidadDaoImpl extends GenericDaoImpl<UnitUnidad, Integer> implements UnitUnidadDao {

	@Autowired
	@Qualifier(value = "sessionFactory")
	private SessionFactory sessionFactory;

	protected UnitUnidadDaoImpl() {
		super(UnitUnidad.class);
	}
	
	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public UnitUnidad getUnidadById(Integer idUnidad) {
		Criteria criterio = getCurrentSession().createCriteria(UnitUnidad.class);
		criterio.add(Restrictions.eq("idUnidad", idUnidad));
		return (UnitUnidad) criterio.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UnitUnidad> getUnidadesByIdContrato(Integer idContrato) {
		
		Query query = getCurrentSession().createQuery("SELECT u FROM UnitUnidad u INNER JOIN FETCH u.afstFlotilla f INNER JOIN FETCH f.afstContrato contrato where contrato.idContrato =  "+idContrato);

		List<UnitUnidad> unidades = (List<UnitUnidad>) query.list();
		Set<UnitUnidad> unidadesSinDuplicar = new LinkedHashSet<UnitUnidad>(unidades);
		unidades.clear();
		unidades.addAll(unidadesSinDuplicar);

		return unidades;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UnitUnidad> getUnidadesByIdFlotilla(Integer idFlotilla) {
		Criteria criterio = getCurrentSession().createCriteria(UnitUnidad.class);
		criterio.add(Restrictions.eq("afstFlotilla.idFlotilla", idFlotilla));
		return (List<UnitUnidad>) criterio.list();
	}
	
	@Override
	public void saveOrUpdateUnidad(UnitUnidad unidad) {
		
		if(unidad.getIdUnidad() != null && unidad.getIdUnidad() > 0 ){
			
			System.out.println("\t\t****************** VHM: metodo saveOrUpdateUnidad clase "+this.getClass().getName()+" actaliza unidad.");

			Utilidades u = new Utilidades();
			
			String qry = "";
			System.out.println("La unidad es: "+unidad.getUnicTipoUnidad().getIdTipoUnidad());
			System.out.println("La unidad es: "+unidad.toString());
			//unidad vehiculo
			if(unidad.getUnicTipoUnidad().getIdTipoUnidad() == 1)
			{System.out.println("************************************************* VHM: Unidad");
			 	qry = "update UnitUnidad set nombre = '"+unidad.getNombre()+"', placas = '"+unidad.getPlacas()+"', motor = '"+unidad.getMotor()
			 			+"', color = '"+unidad.getColor()+"', modelo = '"+unidad.getModelo()+"', noPuertas = "+unidad.getNoPuertas()+", anio = '"
			 			+unidad.getAnio()+"', marca = '"+unidad.getMarca()+"', capCombustible = "+unidad.getCapCombustible()+", fotoTCirculacion = '"
			 			+unidad.getFotoTCirculacion()+"', ondometro = "+unidad.getOndometro()+", carEspecial = '"+unidad.getCarEspecial()
			 			+"', capCarga = "+unidad.getCapCarga()+", noPoliza = '"+unidad.getNoPoliza()+"', venPoliza = '"+u.getFecha(unidad.getVenPoliza())
			 			+"', fechaActualiza = '"+u.getFechaActual()+"' where idUnidad = "+unidad.getIdUnidad();
			}
			//unidad movil
			if(unidad.getUnicTipoUnidad().getIdTipoUnidad() == 2)
			{System.out.println("************************************************* VHM: Movil");
			 	qry = "update UnitUnidad set nombre = '"+unidad.getNombre()+"', carEspecial = '"+unidad.getCarEspecial()+"', modelo = '"+unidad.getModelo()+"', marca = '"+unidad.getMarca()+"', tecnologiaCel = '"+unidad.getTecnologiaCel()+"', fechaActualiza = '"+u.getFechaActual()+"' where idUnidad = "+unidad.getIdUnidad();
			}
			//unidad objeto
			if(unidad.getUnicTipoUnidad().getIdTipoUnidad() == 3)
			{System.out.println("************************************************* VHM: Objeto");
			 	qry = "update UnitUnidad set nombre = '"+unidad.getNombre()+"', carEspecial = '"+unidad.getCarEspecial()+"', proporcion = '"+unidad.getProporcion()+"', fechaActualiza = '"+u.getFechaActual()+"' where idUnidad = "+unidad.getIdUnidad();
			}
			//unidad persona
			if(unidad.getUnicTipoUnidad().getIdTipoUnidad() == 4)
			{System.out.println("************************************************* VHM: Persona");
				qry = "update UnitUnidad set nombre = '"+unidad.getNombre()+"', carEspecial = '"+unidad.getCarEspecial()+"', genero = '"+u.convertBooleanToBit(unidad.getGenero())+"', fechaNacimiento = '"+u.getFecha(unidad.getFechaNacimiento())+"', fechaActualiza = '"+u.getFechaActual()+"' where idUnidad = "+unidad.getIdUnidad();
			}
			
			Query query = getCurrentSession().createQuery(qry);
			int result = query.executeUpdate();
			System.out.println("result = "+result);
			System.out.println(unidad.toString());
		}
		else{
			System.out.println("\t\t****************** VHM: metodo saveOrUpdateUnidad clase "+this.getClass().getName()+" salva unidad.");
			unidad.setFechaAlta(new Date());
			getCurrentSession().save(unidad);
		}
	}

}
