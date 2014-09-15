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

import com.afsinergia.org.model.RespuestaDeError;
import com.afsinergia.org.model.UsutGpousu;
import com.afsinergia.org.model.UsutUsuario;
import com.afsinergia.org.service.UsutGpousuService;
import com.afsinergia.org.service.UsutUsuarioService;
import com.afsinergia.org.utils.ModuloSolicitado;
import com.afsinergia.org.utils.URLS;

@Controller
public class UsutUsuarioControlador {
	private static final Logger logger = LoggerFactory.getLogger(UsutUsuarioControlador.class);

	@Autowired
	private UsutUsuarioService service;

	@Autowired
	private UsutGpousuService serviceGpoUsu;
	
	//devuelve todos los Usuarios en funcion del idGrupoUsuario
	@RequestMapping(value = URLS.GET_USUARIOS, method = RequestMethod.GET)
	public String getUsuarios(HttpServletRequest request, Model modelo)
	{
		logger.info("\t\t****************** VHM: metodo getUsuarios clase "+this.getClass().getName());
		logger.info("\t\t****************** VHM: afuerzas!!(Sólo redirect)");
		
		ModuloSolicitado moduloSolicitado = (ModuloSolicitado) request.getSession().getAttribute("moduloSolicitado");
		moduloSolicitado.setModulo(URLS.GET_USUARIOS);

		request.getSession().setAttribute("moduloSolicitado",moduloSolicitado);
		return "redirect:"+URLS.GET_CLIENTES;
	}
	
	//devuelve todos los Usuarios en funcion del idGrupoUsuario
	@RequestMapping(value = URLS.GET_USUARIOS_BY_ID_GPO_USU, method = RequestMethod.GET)
	public String getUsuariosByIdGpoUsu(@PathVariable(value = "id") Integer idGpoUsu, HttpServletRequest request, Model modelo)
	{
		logger.info("\t\t****************** VHM: metodo getUsuariosByIdGpoUsu/"+idGpoUsu+" clase "+this.getClass().getName());
		logger.info("\t\t****************** VHM: afuerzas!!(Por grupo de usuario)");
		
		ModuloSolicitado moduloSolicitado = (ModuloSolicitado) request.getSession().getAttribute("moduloSolicitado");
		
		moduloSolicitado.setModulo("");
		request.getSession().setAttribute("moduloSolicitado",moduloSolicitado);
		
		List<UsutUsuario> Usuarios = service.getUsuariosByIdGpoUsu(idGpoUsu);
		modelo.addAttribute("usuarios", Usuarios);
		
		//en este caso no es necesario mandar el idGpoUsu
		//caso en que se consulto un grupo que no tiene usuarios
		/*if(Usuarios.size() == 0)${idGpoUsu_}
			modelo.addAttribute("idGpoUsu_", idGpoUsu);*/

		return "getUsuarios";
		
	}

	//devuelve todos los Usuarios en funcion del idContrato
	@RequestMapping(value = URLS.GET_USUARIOS_BY_ID_CONTRATO, method = RequestMethod.GET)
	public String getUsuariosByIdContrato(@PathVariable(value = "id") Integer idContrato, HttpServletRequest request, Model modelo)
	{
		logger.info("\t\t****************** VHM: metodo getUsuariosByIdContrato/"+idContrato+" clase "+this.getClass().getName());
		logger.info("\t\t****************** VHM: afuerzas!!(Por contrato)");
		
		ModuloSolicitado moduloSolicitado = (ModuloSolicitado) request.getSession().getAttribute("moduloSolicitado");

		moduloSolicitado.setModulo("");
		
		//set del idContrato para que al rescatar los grupos del contrato en el usuario nos ahorremos queryes
		moduloSolicitado.setIdEntidadAbuela(idContrato);
		request.getSession().setAttribute("moduloSolicitado",moduloSolicitado);
		
		List<UsutUsuario> usuarios = service.getUsuariosByIdContrato(idContrato);
		modelo.addAttribute("usuarios", usuarios);
		
		//Enviamos todos los grupos de usuarios
		List<UsutGpousu> gposUsuarios = serviceGpoUsu.getGruposUsuariosByIdContrato(idContrato);
		modelo.addAttribute("gposUsuarios", gposUsuarios);
		
		return "getUsuarios";
	}
	
	//obtiene el Usuario en funcion del id de entrada
	@RequestMapping(value = URLS.GET_USUARIO_BY_ID, method = RequestMethod.GET)
	public String getUsuarioById(HttpServletRequest request, @PathVariable(value = "id") Integer idUsuario, Model modelo)
	{
		logger.info("\t\t****************** VHM: metodo getUsuarioById/{"+idUsuario+"} clase "+this.getClass().getName());
		
		UsutUsuario Usuario = service.getUsuarioById(idUsuario);
		modelo.addAttribute("usuario", Usuario);

		ModuloSolicitado moduloSolicitado = (ModuloSolicitado) request.getSession().getAttribute("moduloSolicitado");
		System.out.println("ahhhh VHM:::::::::::::::::::::::: idContrato "+moduloSolicitado.getIdEntidadAbuela());
		
		//Enviamos todos los grupos de usuarios
		List<UsutGpousu> gposUsuarios = serviceGpoUsu.getGruposUsuariosByIdContrato(moduloSolicitado.getIdEntidadAbuela());
		modelo.addAttribute("gposUsuarios", gposUsuarios);
		
		return "frmUsuario";
	}
	
	//salva o actualiza un Usuario en la bd
	@RequestMapping(value = URLS.SET_USUARIO, method = RequestMethod.POST)
	public @ResponseBody RespuestaDeError setUsuario(HttpServletRequest request, @RequestBody UsutUsuario usuario)
	{
		logger.info("\t\t****************** VHM: metodo setUsuario clase "+this.getClass().getName());
		logger.info("\t\t****************** VHM: metodo setUsuario Usuario: idUsuario = "+usuario.getIdUsuario()+", usuario = "+usuario.getUsuario()+"', nombre = '"+usuario.getNombre()+"', apePat = '"+usuario.getApePat()+"', apeMat = '"+usuario.getApeMat()+"', clave = '"+usuario.getClave()+"', status = '"+usuario.getStatus());

		ModuloSolicitado moduloSolicitado = (ModuloSolicitado) request.getSession().getAttribute("moduloSolicitado");
		request.getSession().setAttribute("moduloSolicitado",moduloSolicitado);
		
		service.saveOrUpdateUsuario(usuario);
		RespuestaDeError r = new RespuestaDeError();
		r.setError(false);
		r.setMensaje("jala :=)");
		return r;
	}
	
	//metodo que redirige a la modal pasandole el idGpoUsu(si no existe esta hardcode en 0) para dar de alta o actualizar un Usuario
	@RequestMapping(value = URLS.USUARIO)
	public String openModalUsuario(HttpServletRequest request, @PathVariable(value = "id") Integer idGrupoUsuario, Model modelo) {
		logger.info("\t\t****************** VHM: metodo openModalUsuario/"+idGrupoUsuario+" clase "+this.getClass().getName());
		modelo.addAttribute("idGrupoUsuario", idGrupoUsuario);

		ModuloSolicitado moduloSolicitado = (ModuloSolicitado) request.getSession().getAttribute("moduloSolicitado");
		
		//Enviamos todos los grupos de usuarios
		List<UsutGpousu> gposUsuarios = serviceGpoUsu.getGruposUsuariosByIdContrato(moduloSolicitado.getIdEntidadAbuela());
		modelo.addAttribute("gposUsuarios", gposUsuarios);
		
		return "frmUsuario";
	}
}
