package com.afsinergia.org.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.afsinergia.org.dao.AfstContratoDao;
import com.afsinergia.org.model.AfstContrato;
import com.afsinergia.org.service.AfstContratoService;

@Component
public class AfstContratoServiceImpl implements AfstContratoService{

	@Resource(name = "AfstContratoDao")
	private AfstContratoDao dao;
	
	@Override
	@Transactional
	public List<AfstContrato> getContratosByIdCliente(Integer idCliente) {
		return dao.getContratosByIdCliente(idCliente);
	}

	@Override
	@Transactional
	public AfstContrato getContratoByIdContrato(Integer idContrato) {
		return dao.getContratoByIdContrato(idContrato);
	}

	@Override
	@Transactional
	public void saveOrUpdateContrato(AfstContrato contrato) {
		dao.saveOrUpdateContrato(contrato);
	}

}
