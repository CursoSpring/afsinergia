package com.afsinergia.org.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.afsinergia.org.dao.DistDispositivoDao;
import com.afsinergia.org.model.DistDispositivo;
import com.afsinergia.org.service.DistDispositivoService;

@Component
public class DistDispositivoServiceImpl implements DistDispositivoService{

	@Resource(name = "DistDispositivoDao")
	private DistDispositivoDao dao;
	
	@Override
	@Transactional
	public void saveOrUpdateDistDispositivo(DistDispositivo dispositivo) {
		dao.saveOrUpdateDistDispositivo(dispositivo);
	}	

	@Override
	@Transactional
	public void delete(Integer id) {
		dao.delete(id);
	}

	@Override
	@Transactional
	public DistDispositivo getDistDispositivo(Integer id) {
		return dao.getDistDispositivo(id);
	}

	@Override
	@Transactional
	public List<DistDispositivo> getDistDispositivosByIdContrato(Integer idContrato) {
		return dao.getDistDispositivosByIdContrato(idContrato);
	}

	@Override
	@Transactional
	public DistDispositivo getDistDispositivoById(Integer idDistDispositivo) {
		return dao.getDistDispositivoById(idDistDispositivo);
	}

}
