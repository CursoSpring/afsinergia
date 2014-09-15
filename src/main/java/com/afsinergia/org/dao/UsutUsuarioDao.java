package com.afsinergia.org.dao;

import java.util.List;

import com.afsinergia.org.model.UsutUsuario;

public interface UsutUsuarioDao {

	public void saveOrUpdateUsuario(UsutUsuario usuario);

	public void delete(Integer id);

	public UsutUsuario getUsuario(Integer id);
	
	public UsutUsuario getUsuarioByUserName(String userName);
	
	public UsutUsuario getUsuarioForLoggin(UsutUsuario usuuario);

	public List<UsutUsuario> getUsuariosByIdGpoUsu(Integer idGpoUsuario);
	
	public List<UsutUsuario> getUsuariosByIdContrato(Integer idContrato);
	
	public UsutUsuario getUsuarioById(Integer idUsuario);
	
}
