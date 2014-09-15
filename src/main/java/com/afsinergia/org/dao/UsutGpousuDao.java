package com.afsinergia.org.dao;

import java.util.List;

import com.afsinergia.org.model.UsutGpousu;

public interface UsutGpousuDao {

	public List<UsutGpousu> getGruposUsuariosByIdContrato(Integer idContrato);
	public UsutGpousu getGrupoUsuariosById(Integer idGrupoUsuario);
	public void saveOrUpdateGrupoUsuario(UsutGpousu grupoUsuario);

}
