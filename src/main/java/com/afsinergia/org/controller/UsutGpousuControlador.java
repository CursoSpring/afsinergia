package com.afsinergia.org.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.afsinergia.org.model.UsutGpousu;
import com.afsinergia.org.model.RespuestaDeError;
import com.afsinergia.org.service.UsutGpousuService;
import com.afsinergia.org.utils.ModuloSolicitado;
import com.afsinergia.org.utils.URLS;

@Controller
public class UsutGpousuControlador {
	private static final Logger logger = LoggerFactory.getLogger(UsutGpousuControlador.class);

	@Autowired
	private UsutGpousuService service;
	
	//Metodo que retorna los grupos de usuario en funcion del contrato
	@RequestMapping(value = URLS.GET_GRUPOS_USUARIOS, method = RequestMethod.GET)
	public String getGruposUsuarios(HttpServletRequest request, Model modelo) 
	{
		logger.info("\t\t****************** VHM: metodo getGruposUsuariosByIdContrato clase "+this.getClass().getName());
		logger.info("\t\t****************** VHM: afuerzas!!(Sólo redirect)");
		
		//creamos un objeto ModuloSolicitado y hacemos el setModulo
		ModuloSolicitado moduloSolicitado = (ModuloSolicitado) request.getSession().getAttribute("moduloSolicitado");
		moduloSolicitado.setModulo(URLS.GET_GRUPOS_USUARIOS);
		
		request.getSession().setAttribute("moduloSolicitado",moduloSolicitado);
		return "redirect:"+URLS.GET_CLIENTES;
		

	}
	
	@RequestMapping(value = URLS.GET_GRUPOS_USUARIOS_BY_ID_CONTRATO, method = RequestMethod.GET)
	public String getGruposUsuariosByIdContrato(@PathVariable(value = "id") Integer idContrato, HttpServletRequest request, Model modelo) 
	{
		logger.info("\t\t****************** VHM: metodo getGruposUsuariosByIdContrato clase "+this.getClass().getName());
		logger.info("\t\t****************** VHM: afuerzas!!(Por contrato)");
		
		//creamos un objeto ModuloSolicitado y hacemos el setModulo
		ModuloSolicitado moduloSolicitado = (ModuloSolicitado) request.getSession().getAttribute("moduloSolicitado");
		
		//reetamos los valores de la variable de session y seteamos el objeto
		moduloSolicitado.setModulo("");
		//set del idContrato para que al rescatar los grupos del contrato en el usuario nos ahorremos queryes
		moduloSolicitado.setIdEntidadAbuela(idContrato);
		request.getSession().setAttribute("moduloSolicitado",moduloSolicitado);
		//consultamos los gruposUsuarios
		List<UsutGpousu> gruposUsuarios = service.getGruposUsuariosByIdContrato(idContrato);
		modelo.addAttribute("gruposUsuarios", gruposUsuarios);

		//Solo mando el parametro si se consulto un contrato que no tiene grupos de usuario
		if(gruposUsuarios.size() == 0)
			modelo.addAttribute("idContrato_", idContrato);
		
		return "getGruposUsuarios";
	}
	
	//obtiene el grupo usuario en funcion del id de entrada
	@RequestMapping(value = URLS.GET_GRUPO_USUARIO_BY_ID, method = RequestMethod.GET)
	public String getGrupoUsuariosByid(@PathVariable(value = "id") Integer idGrupoUsuario, Model modelo)
	{
		logger.info("\t\t****************** VHM: metodo getGrupoUsuariosByid/{"+idGrupoUsuario+"} clase "+this.getClass().getName());
		
		UsutGpousu grupoUsuario = service.getGrupoUsuariosById(idGrupoUsuario);
		modelo.addAttribute("grupoUsuario", grupoUsuario);
		return "frmGrupoUsuario";
	}
	
	//salva o actualiza un grupo usuario en la bd
	@RequestMapping(value = URLS.SET_GRUPO_USUARIO, method = RequestMethod.POST)
	public @ResponseBody RespuestaDeError setGrupoUsuario(HttpServletRequest request, @RequestBody UsutGpousu grupoUsuario)
	{
		logger.info("\t\t****************** VHM: metodo setGrupoUsuario clase "+this.getClass().getName());
		logger.info("\t\t****************** VHM: metodo setGrupoUsuario grupo idGrupoUsuario: "+grupoUsuario.getIdGpousu()+", nombre: "+grupoUsuario.getNombre());

		//hacemos el set del modulo para que al hacer el load despues de guardar/actualizar se actualice la tabla
		ModuloSolicitado moduloSolicitado = (ModuloSolicitado) request.getSession().getAttribute("moduloSolicitado");
		request.getSession().setAttribute("moduloSolicitado",moduloSolicitado);
		//////////////////////
		service.saveOrUpdateGrupoUsuario(grupoUsuario);
		RespuestaDeError r = new RespuestaDeError();
		r.setError(false);
		r.setMensaje("jala :=)");
		return r;
	}
	
	//metodo que redirige a la modal pasandole el idContrato(si no existe esta hardcode en 0) para dar de alta o actualizar un GrupoUsuario
	@RequestMapping(value = URLS.GRUPO_USUARIO)
	public String openModalGrupoUsuario(@PathVariable(value = "id") Integer idContrato, Model modelo) {
		logger.info("\t\t****************** VHM: metodo openModalGrupoUsuario/"+idContrato+" clase "+this.getClass().getName());
		
		modelo.addAttribute("idContrato", idContrato);
		return "frmGrupoUsuario";
	}
}
