package com.afsinergia.org.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.afsinergia.org.dao.UnicTipoUnidadDao;
import com.afsinergia.org.model.UnicTipoUnidad;
import com.afsinergia.org.service.UnicTipoUnidadService;

@Component
public class UnicTipoUnidadServiceImpl implements UnicTipoUnidadService{

	@Resource(name = "UnicTipoUnidadDAO")
	private UnicTipoUnidadDao dao;
	
	@Override
	@Transactional
	public List<UnicTipoUnidad> getAllUnicTipoUnidades() {
		return dao.getAllUnicTipoUnidades();
	}

}
