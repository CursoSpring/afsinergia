package com.afsinergia.org.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.afsinergia.org.dao.UsutUsuarioDao;
import com.afsinergia.org.model.UsutUsuario;
import com.afsinergia.org.service.UsutUsuarioService;

@Component
public class UsutUsuarioServiceImpl implements UsutUsuarioService {

	@Resource(name = "UsutUsuarioDao")
	private UsutUsuarioDao dao;

	@Override
	@Transactional
	public void saveOrUpdateUsuario(UsutUsuario usuario) {
		dao.saveOrUpdateUsuario(usuario);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		UsutUsuario usuario = this.getUsuario(id);
		if (usuario != null) {
			dao.delete(id);
		}
	}

	@Override
	@Transactional
	public UsutUsuario getUsuario(Integer id) {
		UsutUsuario usuario = dao.getUsuario(id);
		return usuario;
	}

	@Override
	@Transactional
	public List<UsutUsuario> getUsuariosByIdGpoUsu(Integer idGpoUsuario) {
		return dao.getUsuariosByIdGpoUsu(idGpoUsuario);
	}

	@Override
	@Transactional
	public List<UsutUsuario> getUsuariosByIdContrato(Integer idContrato) {
		return dao.getUsuariosByIdContrato(idContrato);
	}

	@Override
	@Transactional
	public UsutUsuario getUsuarioForLoggin(UsutUsuario usuario) {
		return dao.getUsuarioForLoggin(usuario);
	}

	@Override
	@Transactional
	public UsutUsuario getUsuarioByUserName(String userName) {
		return dao.getUsuarioByUserName(userName);
	}

	@Override
	@Transactional
	public UsutUsuario getUsuarioById(Integer idUsuario) {
		return dao.getUsuarioById(idUsuario);
	}

}
