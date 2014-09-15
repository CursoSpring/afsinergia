package com.afsinergia.org.dao;

import java.util.List;

import com.afsinergia.org.model.AfstFlotilla;

public interface AfstFlotillaDao {
	
	public void saveOrUpdateAfstFlotilla(AfstFlotilla flotilla);

	public void delete(Integer id);
	
	public List<AfstFlotilla> getAfstFlotillaByIdContrato(Integer idContrato);
	
	public AfstFlotilla getAfstFlotillaById(Integer idFlotilla);
}
