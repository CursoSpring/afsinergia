package com.afsinergia.org.utils;

public class ModuloSolicitado {

	//modulo en cruso
	private String modulo;
	//id de la entidad abuelo ya que en la pantalla de edicion de una entidad, se deberia poder asignar de entre todas los entidades padres de dicho entidad,
	//lo que implica que se tiene que tener el id de la entidad abuela.
	private Integer idEntidadAbuela;
	private Integer idUsuario;
	
	public ModuloSolicitado(String modulo, Integer idEntidadAbuela) {
		super();
		this.modulo = modulo;
		this.idEntidadAbuela = idEntidadAbuela;
	}
	
	public String getModulo() {
		return modulo;
	}
	
	public void setModulo(String modulo) {
		this.modulo = modulo;
	}
	
	public Integer getIdEntidadAbuela() {
		return idEntidadAbuela;
	}

	public void setIdEntidadAbuela(Integer idEntidadAbuela) {
		this.idEntidadAbuela = idEntidadAbuela;
	}
	
	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	@Override
	public String toString() {
		return "modulo [modulo=" + modulo
				+ "]";
	}
	
	
}
