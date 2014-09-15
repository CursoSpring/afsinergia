package com.afsinergia.org.model;

// Generated 15/08/2014 02:52:34 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * AfstInstalador generated by hbm2java
 */
@Entity
@Table(name = "afst_instalador", catalog = "afsinergia")
public class AfstInstalador implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 303888930486978821L;
	private Integer idInstalador;
	private AfstCliente afstCliente;
	private String nombre;
	private String paterno;
	private String materno;
	private String correo;
	private Date fechaAlta;
	private Date fechaActualiza;
	private Date fechaBaja;
	private Set<AfstInstalacion> afstInstalacions = new HashSet<AfstInstalacion>(
			0);

	public AfstInstalador() {
	}

	public AfstInstalador(AfstCliente afstCliente, String nombre,
			String paterno, String materno, String correo, Date fechaAlta,
			Date fechaActualiza, Date fechaBaja) {
		this.afstCliente = afstCliente;
		this.nombre = nombre;
		this.paterno = paterno;
		this.materno = materno;
		this.correo = correo;
		this.fechaAlta = fechaAlta;
		this.fechaActualiza = fechaActualiza;
		this.fechaBaja = fechaBaja;
	}

	public AfstInstalador(AfstCliente afstCliente, String nombre,
			String paterno, String materno, String correo, Date fechaAlta,
			Date fechaActualiza, Date fechaBaja,
			Set<AfstInstalacion> afstInstalacions) {
		this.afstCliente = afstCliente;
		this.nombre = nombre;
		this.paterno = paterno;
		this.materno = materno;
		this.correo = correo;
		this.fechaAlta = fechaAlta;
		this.fechaActualiza = fechaActualiza;
		this.fechaBaja = fechaBaja;
		this.afstInstalacions = afstInstalacions;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_instalador", unique = true, nullable = false)
	public Integer getIdInstalador() {
		return this.idInstalador;
	}

	public void setIdInstalador(Integer idInstalador) {
		this.idInstalador = idInstalador;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cliente", nullable = false)
	public AfstCliente getAfstCliente() {
		return this.afstCliente;
	}

	public void setAfstCliente(AfstCliente afstCliente) {
		this.afstCliente = afstCliente;
	}

	@Column(name = "nombre", nullable = false, length = 45)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "paterno", nullable = false, length = 45)
	public String getPaterno() {
		return this.paterno;
	}

	public void setPaterno(String paterno) {
		this.paterno = paterno;
	}

	@Column(name = "materno", nullable = false, length = 45)
	public String getMaterno() {
		return this.materno;
	}

	public void setMaterno(String materno) {
		this.materno = materno;
	}

	@Column(name = "correo", nullable = false, length = 60)
	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_alta", nullable = false, length = 0)
	public Date getFechaAlta() {
		return this.fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_actualiza", nullable = false, length = 0)
	public Date getFechaActualiza() {
		return this.fechaActualiza;
	}

	public void setFechaActualiza(Date fechaActualiza) {
		this.fechaActualiza = fechaActualiza;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_baja", nullable = false, length = 0)
	public Date getFechaBaja() {
		return this.fechaBaja;
	}

	public void setFechaBaja(Date fechaBaja) {
		this.fechaBaja = fechaBaja;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "afstInstalador")
	public Set<AfstInstalacion> getAfstInstalacions() {
		return this.afstInstalacions;
	}

	public void setAfstInstalacions(Set<AfstInstalacion> afstInstalacions) {
		this.afstInstalacions = afstInstalacions;
	}

}
