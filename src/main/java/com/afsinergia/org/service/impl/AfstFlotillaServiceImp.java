package com.afsinergia.org.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.afsinergia.org.dao.AfstFlotillaDao;
import com.afsinergia.org.model.AfstFlotilla;
import com.afsinergia.org.service.AfstFlotillaService;

@Component
public class AfstFlotillaServiceImp implements AfstFlotillaService{

	@Resource(name = "AfstFlotillaDao")
	private AfstFlotillaDao dao;
	
	@Override
	@Transactional
	public void saveOrUpdateAfstFlotilla(AfstFlotilla flotilla) {
		dao.saveOrUpdateAfstFlotilla(flotilla);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		dao.delete(id);
	}

	@Override
	@Transactional
	public List<AfstFlotilla> getAfstFlotillaByIdContrato(Integer idContrato) {
		return dao.getAfstFlotillaByIdContrato(idContrato);
	}

	@Override
	@Transactional
	public AfstFlotilla getAfstFlotillaById(Integer idFlotilla) {
		return dao.getAfstFlotillaById(idFlotilla);
	}

}
