package com.afsinergia.org.model;

// Generated 15/08/2014 02:52:34 PM by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * PtlcModulo generated by hbm2java
 */
@Entity
@Table(name = "ptlc_modulo", catalog = "afsinergia")
public class PtlcModulo implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7293659318391384348L;
	private Integer idModulo;
	private PtlcProducto ptlcProducto;
	private String nomMod;
	private Set<PtlcFuncion> ptlcFuncions = new HashSet<PtlcFuncion>(0);
	private Set<PtltPrivilegio> ptltPrivilegios = new HashSet<PtltPrivilegio>(0);

	public PtlcModulo() {
	}

	public PtlcModulo(PtlcProducto ptlcProducto, String nomMod) {
		this.ptlcProducto = ptlcProducto;
		this.nomMod = nomMod;
	}

	public PtlcModulo(PtlcProducto ptlcProducto, String nomMod,
			Set<PtlcFuncion> ptlcFuncions, Set<PtltPrivilegio> ptltPrivilegios) {
		this.ptlcProducto = ptlcProducto;
		this.nomMod = nomMod;
		this.ptlcFuncions = ptlcFuncions;
		this.ptltPrivilegios = ptltPrivilegios;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_modulo", unique = true, nullable = false)
	public Integer getIdModulo() {
		return this.idModulo;
	}

	public void setIdModulo(Integer idModulo) {
		this.idModulo = idModulo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_prod", nullable = false)
	public PtlcProducto getPtlcProducto() {
		return this.ptlcProducto;
	}

	public void setPtlcProducto(PtlcProducto ptlcProducto) {
		this.ptlcProducto = ptlcProducto;
	}

	@Column(name = "nom_mod", nullable = false, length = 30)
	public String getNomMod() {
		return this.nomMod;
	}

	public void setNomMod(String nomMod) {
		this.nomMod = nomMod;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ptlcModulo")
	public Set<PtlcFuncion> getPtlcFuncions() {
		return this.ptlcFuncions;
	}

	public void setPtlcFuncions(Set<PtlcFuncion> ptlcFuncions) {
		this.ptlcFuncions = ptlcFuncions;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ptlcModulo")
	public Set<PtltPrivilegio> getPtltPrivilegios() {
		return this.ptltPrivilegios;
	}

	public void setPtltPrivilegios(Set<PtltPrivilegio> ptltPrivilegios) {
		this.ptltPrivilegios = ptltPrivilegios;
	}

}
