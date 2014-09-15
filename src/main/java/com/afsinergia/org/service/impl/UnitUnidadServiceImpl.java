package com.afsinergia.org.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.afsinergia.org.model.UnitUnidad;
import com.afsinergia.org.dao.UnitUnidadDao;
import com.afsinergia.org.service.UnitUnidadService;

@Component
public class UnitUnidadServiceImpl implements UnitUnidadService{

	@Resource(name = "UnitUnidadDAO")
	private UnitUnidadDao dao;
	
	@Override
	@Transactional
	public UnitUnidad getUnidadById(Integer idUnidad) {
		return dao.getUnidadById(idUnidad);
	}

	@Override
	@Transactional
	public List<UnitUnidad> getUnidadesByIdContrato(Integer idContrato) {
		return dao.getUnidadesByIdContrato(idContrato);
	}

	@Override
	@Transactional
	public void saveOrUpdateUnidad(UnitUnidad unidad) {
		dao.saveOrUpdateUnidad(unidad);
	}

	@Override
	@Transactional
	public List<UnitUnidad> getUnidadesByIdFlotilla(Integer idFlotilla) {
		return dao.getUnidadesByIdFlotilla(idFlotilla);
	}

}
