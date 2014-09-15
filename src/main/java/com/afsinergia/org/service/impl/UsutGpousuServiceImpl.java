package com.afsinergia.org.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.afsinergia.org.dao.UsutGpousuDao;
import com.afsinergia.org.model.UsutGpousu;
import com.afsinergia.org.service.UsutGpousuService;

@Component
public class UsutGpousuServiceImpl implements UsutGpousuService{
	@Resource(name = "UsutGpousuDao")
	private UsutGpousuDao dao;

	@Override
	@Transactional
	public List<UsutGpousu> getGruposUsuariosByIdContrato(Integer idContrato) {
		return dao.getGruposUsuariosByIdContrato(idContrato);
	}

	@Override
	@Transactional
	public UsutGpousu getGrupoUsuariosById(Integer idGrupoUsuario) {
		return dao.getGrupoUsuariosById(idGrupoUsuario);
	}

	@Override
	@Transactional
	public void saveOrUpdateGrupoUsuario(UsutGpousu grupoUsuario) {
		dao.saveOrUpdateGrupoUsuario(grupoUsuario);
	}
	

}
