package com.afsinergia.org.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.afsinergia.org.dao.AfstInstaladorDao;
import com.afsinergia.org.model.AfstInstalador;
import com.afsinergia.org.service.AfstInstaladorService;

@Component
public class AfstInstaladorServiceImpl implements AfstInstaladorService{
	
	@Resource(name = "AfstInstaladorDao")
	private AfstInstaladorDao dao;
	
	@Override
	@Transactional
	public void saveOrUpdateAfstInstalador(AfstInstalador instalador) {
		dao.saveOrUpdateAfstInstalador(instalador);
	}

	@Override
	@Transactional
	public void delete(Integer idInstalador) {
		dao.delete(idInstalador);
	}

	@Override
	@Transactional
	public List<AfstInstalador> getAfstInstaladorByIdCliente(Integer idCliente) {
		return dao.getAfstInstaladorByIdCliente(idCliente);
	}

	@Override
	@Transactional
	public AfstInstalador getAfstInstaladorById(Integer idInstalador) {
		return dao.getAfstInstaladorById(idInstalador);
	}

}
