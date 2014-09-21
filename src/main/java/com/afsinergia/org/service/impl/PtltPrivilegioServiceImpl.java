package com.afsinergia.org.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.afsinergia.org.dao.PtltPrivilegioDao;
import com.afsinergia.org.model.PtltPrivilegio;
import com.afsinergia.org.service.PtltPrivilegioService;

@Component
public class PtltPrivilegioServiceImpl implements PtltPrivilegioService{

	@Resource(name = "PtltPrivilegio")
	private PtltPrivilegioDao dao;
	
	@Override
	@Transactional
	public List<PtltPrivilegio> getAllPrivilegioByIdGpoUsuario(Integer idGpoUsuario) {
		return dao.getAllPrivilegioByIdGpoUsuario(idGpoUsuario);
	}

	@Override
	@Transactional
	public List<PtltPrivilegio> getAllPrivilegioByUserName(String userName) {
		return dao.getAllPrivilegioByUserName(userName);
	}

	@Override
	@Transactional
	public void saveOrUpdatePrivilegios(List<PtltPrivilegio> privilegios) {
		dao.saveOrUpdatePrivilegios(privilegios);
	}

}
