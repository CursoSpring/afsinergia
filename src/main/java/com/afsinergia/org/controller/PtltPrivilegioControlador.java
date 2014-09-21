package com.afsinergia.org.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.afsinergia.org.model.PtltPrivilegio;
import com.afsinergia.org.service.PtltPrivilegioService;
import com.afsinergia.org.utils.URLS;

@Controller
public class PtltPrivilegioControlador {
	private static final Logger logger = LoggerFactory.getLogger(PtltPrivilegioService.class);

	@Autowired
	private PtltPrivilegioService service;
	
	@RequestMapping(value = URLS.ADMIN)
	public String getAllPrivilegioByUserName(Authentication authentication, HttpServletRequest request, Model modelo) 
	{
		logger.info("\t\t****************** VHM: metodo getAllPrivilegioByUserName clase  "+this.getClass().getName());
		logger.info(":::::::::::::::::::: VHM: authentication.getName() = "+authentication.getName());
		
		List<PtltPrivilegio> privilegios = service.getAllPrivilegioByUserName(authentication.getName());
		modelo.addAttribute("privilegiosUsuario", privilegios);
		
		//Nombre de usuario
		modelo.addAttribute("nombreDeUsuario", authentication.getName());
		
		return "Administracion";
	}
}
