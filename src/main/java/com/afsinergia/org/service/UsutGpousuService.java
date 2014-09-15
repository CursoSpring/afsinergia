package com.afsinergia.org.service;

import java.util.List;

import com.afsinergia.org.model.UsutGpousu;

public interface UsutGpousuService {

	public List<UsutGpousu> getGruposUsuariosByIdContrato(Integer idContrato);
	public UsutGpousu getGrupoUsuariosById(Integer idGrupoUsuario);
	public void saveOrUpdateGrupoUsuario(UsutGpousu grupoUsuario);
}
