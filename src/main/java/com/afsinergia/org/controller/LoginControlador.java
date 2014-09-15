package com.afsinergia.org.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.afsinergia.org.utils.ModuloSolicitado;

@Controller
public class LoginControlador {
	
	//Metodo que hace un redirect al login de usuario
	@RequestMapping("/login")
	public String doLogin(HttpServletRequest request){
		
		ModuloSolicitado moduloSolicitado = new ModuloSolicitado("", -1);
		request.getSession().setAttribute("moduloSolicitado", moduloSolicitado);
		
		return "login";
	}
	
	//Metodo que hace un redirect al Administracion.jsp (cuando ocurre el error4-03, osea cuando no se encontro una pagina)
	@RequestMapping(value="/error-403")
	public String error403()
	{
		return "Administracion";
	}
}