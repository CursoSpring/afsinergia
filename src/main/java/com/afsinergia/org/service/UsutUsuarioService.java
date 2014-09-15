package com.afsinergia.org.service;

import java.util.List;

import com.afsinergia.org.model.UsutUsuario;

public interface UsutUsuarioService {

	public void saveOrUpdateUsuario(UsutUsuario usuario);
	
	public void delete(Integer id);

	public UsutUsuario getUsuario(Integer id);

	public UsutUsuario getUsuarioByUserName(String userName);
	
	public UsutUsuario getUsuarioForLoggin(UsutUsuario usuario);
	
	public List<UsutUsuario> getUsuariosByIdGpoUsu(Integer idGpoUsuario);
	
	public List<UsutUsuario> getUsuariosByIdContrato(Integer idContrato);
	
	public UsutUsuario getUsuarioById(Integer idUsuario);
}
