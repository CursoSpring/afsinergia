package com.afsinergia.org.utils;

public class URLS {
	
	//urls de todos los metodos controladores
	
	//Controller PtltPrivilegioControlador
	public static final String ADMIN = "/admin";
	
	//Controller AfstClienteControlador
	public static final String GET_CLIENTES = "/getClientes";
	public static final String GET_CLIENTE_BY_ID = "/getClienteByid/{id}";
	public static final String SET_CLIENTE = "/setCliente";
	public static final String CLIENTE = "/cliente/{id}";

	//Controller AfstContratoControlador
	public static final String GET_CONTRATOS = "/getContratos";
	public static final String GET_CONTRATOS_BY_ID_CLIENTE = "/getContratos/{id}";
	public static final String GET_CONTRATO_BY_ID = "/getContratoByid/{id}";
	public static final String SET_CONTRATO = "/setContrato";
	public static final String CONTRATO = "/contrato/{id}";

	////////////////////////////////////////////////////Flujo grupo uuarios - usuarios/////////////////////////////////////////////
	//Controller UsutGpousu
	public static final String GET_GRUPOS_USUARIOS = "/getGruposUsuarios";
	public static final String GET_GRUPOS_USUARIOS_BY_ID_CONTRATO = GET_GRUPOS_USUARIOS+"/{id}";
	public static final String GET_GRUPO_USUARIO_BY_ID = "/getGrupoUsuarioByid/{id}";
	public static final String SET_GRUPO_USUARIO = "/setGrupoUsuario";
	public static final String GRUPO_USUARIO = "/grupoUsuario/{id}";
	//edicion de privilegios por grupo usuario
	public static final String GET_PRIVILEGIOS_BY_ID_GPO_USU = "/getPrivilegiosByIdGpoUsu/{id}";
	public static final String SET_PRIVILEGIOS = "/setPrivilegios";

	//Controller UsutUsuarioControlador
	public static final String GET_USUARIOS = "/getUsuarios";
	public static final String GET_USUARIOS_BY_ID_GPO_USU = "/getUsuariosByIdGpoUsu/{id}";
	public static final String GET_USUARIOS_BY_ID_CONTRATO = GET_USUARIOS+"/{id}";
	public static final String GET_USUARIO_BY_ID = "/getUsuarioById/{id}";
	public static final String SET_USUARIO = "/setUsuario";
	public static final String USUARIO = "/usuario/{id}";
	////////////////////////////////////////////////////Fin flujo/////////////////////////////////////////////


	////////////////////////////////////////////////////Flujo dispositivo - /////////////////////////////////////////////
	//Controller DistDispositivo
	public static final String GET_DISPOSITIVOS = "/getDispositivos";
	public static final String GET_DISPOSITIVOS_BY_ID_CONTRATO = GET_DISPOSITIVOS+"/{id}";
	public static final String GET_DISPOSITIVO_BY_ID = "/getDispositivoById/{id}";
	public static final String SET_DISPOSITIVO = "/setDispositivo";
	public static final String DISPOSITIVO = "/dispositivo/{id}";


	////////////////////////////////////////////////////Flujo flotillas - unidad/////////////////////////////////////////////
	//Controller AfstFlotillas
	public static final String GET_FLOTILLAS = "/getFlotillas";
	public static final String GET_FLOTILLAS_BY_ID_CONTRATO = GET_FLOTILLAS+"/{id}";
	public static final String GET_FLOTILLA_BY_ID = "/getFlotillaByid/{id}";
	public static final String SET_FLOTILLA = "/setFlotilla";
	public static final String FLOTILLA = "/flotilla/{id}";

	//Controller UnitUnidad
	public static final String GET_UNIDADES = "/getUnidades";
	public static final String GET_UNIDADES_BY_ID_FLOTILLA = "/getUnidadesByIdFlotilla/{id}";
	public static final String GET_UNIDADES_BY_ID_CONTRATO = GET_UNIDADES+"/{id}";
	public static final String GET_UNIDAD_BY_ID = "/getUnidadById/{id}";
	public static final String SET_UNIDAD = "/setUnidad";
	public static final String UNIDAD = "/unidad/{id}";	
	////////////////////////////////////////////////////Fin flujo/////////////////////////////////////////////
	

	////////////////////////////////////////////////////Flujo instaladores - instalaciones/////////////////////////////////////////////
	//Controller AfstFlotillas
	public static final String GET_INSTALADORES = "/getInstaladores";
	public static final String GET_INSTALADORES_BY_ID_CLIENTE = GET_INSTALADORES+"/{id}";
	public static final String GET_INSTALADOR_BY_ID = "/getInstaladorById/{id}";
	public static final String SET_INSTALADOR = "/setInstalador";
	public static final String INSTALADOR = "/instalador/{id}";

	//Controller UnitUnidad
	/*public static final String GET_UNIDADES = "/getUnidades";
	public static final String GET_UNIDADES_BY_ID_FLOTILLA = "/getUnidadesByIdFlotilla/{id}";
	public static final String GET_UNIDADES_BY_ID_CONTRATO = GET_UNIDADES+"/{id}";
	public static final String GET_UNIDAD_BY_ID = "/getUnidadById/{id}";
	public static final String SET_UNIDAD = "/setUnidad";
	public static final String UNIDAD = "/unidad/{id}";*/
	////////////////////////////////////////////////////Fin flujo/////////////////////////////////////////////
	
	///Ctes para genero
	public static final Boolean GENERO_HOMBRE = true;
	public static final Boolean GENERO_MUJER = false;
}
