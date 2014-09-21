package com.afsinergia.org.dao;

import java.util.List;

import com.afsinergia.org.model.PtltPrivilegio;

public interface PtltPrivilegioDao {

	public List<PtltPrivilegio> getAllPrivilegioByIdGpoUsuario(Integer idGpoUsuario);
	public List<PtltPrivilegio> getAllPrivilegioByUserName(String userName);
	public void saveOrUpdatePrivilegios(List<PtltPrivilegio> privilegios);
}
