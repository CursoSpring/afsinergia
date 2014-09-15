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

import com.afsinergia.org.model.AfstCliente;
import com.afsinergia.org.model.RespuestaDeError;
import com.afsinergia.org.service.AfstClienteService;
import com.afsinergia.org.utils.URLS;

@Controller
public class AfstClienteControlador {

	private static final Logger logger = LoggerFactory.getLogger(AfstClienteControlador.class);

	@Autowired
	private AfstClienteService service;

	//devuelve todos los clientes en funcion del idGrupoEmpleado
	@RequestMapping(value = URLS.GET_CLIENTES, method = RequestMethod.GET)
	public String getClientesByIdGpoEmp(HttpServletRequest request, Model modelo)
	{
		logger.info("\t\t****************** VHM: metodo getClientesByIdGpoEmp clase "+this.getClass().getName());
		
		List<AfstCliente> clientes = service.getClientesByIdGpoEmp(1);
		modelo.addAttribute("clientes", clientes);
		return "getClientes";
	}
	
	//obtiene el cliente en funcion del id de entrada
	@RequestMapping(value = URLS.GET_CLIENTE_BY_ID, method = RequestMethod.GET)
	public String getClienteById(@PathVariable(value = "id") Integer idCliente, Model modelo)
	{
		logger.info("\t\t****************** VHM: metodo getClienteByid/{"+idCliente+"} clase "+this.getClass().getName());
		
		AfstCliente cliente = service.getClienteById(idCliente);
		modelo.addAttribute("cliente", cliente);
		return "frmCliente";
	}
	
	//salva o actualiza un cliente en la bd
	@RequestMapping(value = URLS.SET_CLIENTE, method = RequestMethod.POST)
	public @ResponseBody RespuestaDeError setCliente(@RequestBody AfstCliente cliente)
	{
		logger.info("\t\t****************** VHM: metodo setCliente clase "+this.getClass().getName());
		logger.info("\t\t****************** VHM: metodo setCliente cliente: "+cliente.getIdCliente()+", "+cliente.getNombre()+", "+cliente.getContacto()+", "+cliente.getMail()+", "+cliente.getMovil()+", "+cliente.getTelefono()+", "+cliente.getAfstGpoemp().getIdGpoemp());
		service.saveOrUpdateCliente(cliente);
		RespuestaDeError r = new RespuestaDeError();
		r.setError(false);
		r.setMensaje("jala :=)");
		return r;
	}
	
	//metodo que redirige a la modal pasandole el idGpoemp(si no existe esta hardcode en 0) para dar de alta o actualizar un cliente
	@RequestMapping(value = URLS.CLIENTE)
	public String openModalCliente(@PathVariable(value = "id") Integer idGpoemp, Model modelo) {
		logger.info("\t\t****************** VHM: metodo openModalCliente/"+idGpoemp+" clase "+this.getClass().getName());
		
		modelo.addAttribute("IdGpoemp", idGpoemp);
		return "frmCliente";
	}

}
