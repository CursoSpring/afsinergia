package com.afsinergia.org.service;

import java.util.List;

import com.afsinergia.org.model.PtltPrivilegio;

public interface PtltPrivilegioService {
	public List<PtltPrivilegio> getAllPrivilegioByIdGpoUsuario(Integer idGpoUsuario);
	public void saveOrUpdatePrivilegios(List<PtltPrivilegio> privilegios);
}
