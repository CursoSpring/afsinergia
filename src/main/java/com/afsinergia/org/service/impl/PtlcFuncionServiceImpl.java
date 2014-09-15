package com.afsinergia.org.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.afsinergia.org.dao.PtlcFuncionDao;
import com.afsinergia.org.model.PtlcFuncion;
import com.afsinergia.org.service.PtlcFuncionService;

@Component
public class PtlcFuncionServiceImpl implements PtlcFuncionService{

	@Resource(name = "PtlcFuncionDao")
	private PtlcFuncionDao dao;
	
	@Override
	@Transactional
	public List<PtlcFuncion> getFuncionByIdModulo(Integer idModulo) {
		return dao.getFuncionByIdModulo(idModulo);
	}

	@Override
	@Transactional
	public PtlcFuncion getFuncionByIdFuncion(Integer idFuncion) {
		return dao.getFuncionByIdFuncion(idFuncion);
	}

}
