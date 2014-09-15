package com.afsinergia.org.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.afsinergia.org.dao.AfstGpoempDao;
import com.afsinergia.org.model.AfstGpoemp;
import com.afsinergia.org.service.AfstGpoempService;

@Component
public class AfstGpoempServiceImpl implements AfstGpoempService{

	@Resource(name = "AfstGpoempDao")
	private AfstGpoempDao dao;
	
	@Override
	@Transactional
	public void saveOrUpdateGruposEmp(AfstGpoemp grupoEmpresa) {
		dao.saveOrUpdateGruposEmp(grupoEmpresa);
	}

}
