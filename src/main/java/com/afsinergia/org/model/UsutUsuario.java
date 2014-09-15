package com.afsinergia.org.model;

// Generated 15/08/2014 02:52:34 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * UsutUsuario generated by hbm2java
 */
@Entity
@Table(name = "usut_usuario", catalog = "afsinergia", uniqueConstraints = @UniqueConstraint(columnNames = "usuario"))
public class UsutUsuario implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4040101677508740738L;
	private Integer idUsuario;
	private UsutGpousu usutGpousu;
	private String usuario;
	private String clave;
	private List<UsutRol> roles;
	private UserStatus status;
	private String nombre;
	private String apePat;
	private String apeMat;
	private Date fechaAlta;
	private Date fechaActualiza;
	private Date fechaBaja;
	
	public UsutUsuario() {
	}

	public UsutUsuario(UsutGpousu usutGpousu, String usuario, String clave,
			List<UsutRol> roles, UserStatus status,
			String nombre, String apePat, String apeMat, Date fechaAlta,
			Date fechaActualiza, Date fechaBaja) {
		this.usutGpousu = usutGpousu;
		this.usuario = usuario;
		this.clave = clave;
		this.roles = roles;
		this.status = status;
		this.nombre = nombre;
		this.apePat = apePat;
		this.apeMat = apeMat;
		this.fechaAlta = fechaAlta;
		this.fechaActualiza = fechaActualiza;
		this.fechaBaja = fechaBaja;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_usuario", unique = true, nullable = false)
	public Integer getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_gpousu", nullable = false)
	public UsutGpousu getUsutGpousu() {
		return this.usutGpousu;
	}

	public void setUsutGpousu(UsutGpousu usutGpousu) {
		this.usutGpousu = usutGpousu;
	}

	@Column(name = "usuario", unique = true, nullable = false, length = 50)
	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	@Column(name = "clave", nullable = false, length = 10)
	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}
	
	@ManyToMany
	@JoinTable(name="rel_usuarios_roles", joinColumns=@JoinColumn(name="id_usuario"),inverseJoinColumns=@JoinColumn(name="id_rol"))
	public List<UsutRol> getRoles() {
		return roles;
	}

	public void setRoles(List<UsutRol> roles) {
		this.roles = roles;
	}

	@Enumerated(EnumType.STRING)
	public UserStatus getStatus() {
		return status;
	}

	public void setStatus(UserStatus status) {
		this.status = status;
	}
	
	@Column(name = "nombre", nullable = false, length = 45)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "ape_pat", nullable = false, length = 45)
	public String getApePat() {
		return this.apePat;
	}

	public void setApePat(String apePat) {
		this.apePat = apePat;
	}

	@Column(name = "ape_mat", nullable = false, length = 45)
	public String getApeMat() {
		return this.apeMat;
	}

	public void setApeMat(String apeMat) {
		this.apeMat = apeMat;
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
	@Column(name = "fecha_actualiza", nullable = true, length = 0)
	public Date getFechaActualiza() {
		return this.fechaActualiza;
	}

	public void setFechaActualiza(Date fechaActualiza) {
		this.fechaActualiza = fechaActualiza;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_baja", nullable = true, length = 0)
	public Date getFechaBaja() {
		return this.fechaBaja;
	}

	public void setFechaBaja(Date fechaBaja) {
		this.fechaBaja = fechaBaja;
	}

}
