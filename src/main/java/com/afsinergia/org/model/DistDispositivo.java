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
import javax.persistence.UniqueConstraint;

/**
 * DistDispositivo generated by hbm2java
 */
@Entity
@Table(name = "dist_dispositivo", catalog = "afsinergia", uniqueConstraints = {
		@UniqueConstraint(columnNames = "imei"),
		@UniqueConstraint(columnNames = "id_sim") })
public class DistDispositivo implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2974994912604675606L;
	private Integer idDispositivo;
	private DistSim distSim;
	private AfstContrato afstContrato;
	private String imei;
	private Date fechaAlta;
	private Date fechaActualiza;
	private Date fechaBaja;
	private Set<AfstInstalacion> afstInstalacions = new HashSet<AfstInstalacion>(
			0);
	private Set<InvtAccesorio> invtAccesorios = new HashSet<InvtAccesorio>(0);
	private Set<UnitUnidad> unitUnidads = new HashSet<UnitUnidad>(0);

	public DistDispositivo() {
	}

	public DistDispositivo(DistSim distSim, AfstContrato afstContrato,
			String imei, Date fechaAlta, Date fechaActualiza,
			Date fechaBaja) {
		this.distSim = distSim;
		this.afstContrato = afstContrato;
		this.imei = imei;
		this.fechaAlta = fechaAlta;
		this.fechaActualiza = fechaActualiza;
		this.fechaBaja = fechaBaja;
	}

	public DistDispositivo(DistSim distSim, AfstContrato afstContrato,
			String imei, Date fechaAlta, Date fechaActualiza,
			Date fechaBaja, Set<AfstInstalacion> afstInstalacions,
			Set<InvtAccesorio> invtAccesorios, Set<UnitUnidad> unitUnidads) {
		this.distSim = distSim;
		this.afstContrato = afstContrato;
		this.imei = imei;
		this.fechaAlta = fechaAlta;
		this.fechaActualiza = fechaActualiza;
		this.fechaBaja = fechaBaja;
		this.afstInstalacions = afstInstalacions;
		this.invtAccesorios = invtAccesorios;
		this.unitUnidads = unitUnidads;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_dispositivo", unique = true, nullable = false)
	public Integer getIdDispositivo() {
		return this.idDispositivo;
	}

	public void setIdDispositivo(Integer idDispositivo) {
		this.idDispositivo = idDispositivo;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_sim", unique = true, nullable = false)
	public DistSim getDistSim() {
		return this.distSim;
	}

	public void setDistSim(DistSim distSim) {
		this.distSim = distSim;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_contrato", nullable = false)
	public AfstContrato getAfstContrato() {
		return this.afstContrato;
	}

	public void setAfstContrato(AfstContrato afstContrato) {
		this.afstContrato = afstContrato;
	}

	@Column(name = "imei", unique = true, nullable = false, length = 45)
	public String getImei() {
		return this.imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
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
	@Column(name = "fecha_actualiza", length = 0)
	public Date getFechaActualiza() {
		return this.fechaActualiza;
	}

	public void setFechaActualiza(Date fechaActualiza) {
		this.fechaActualiza = fechaActualiza;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_baja", length = 0)
	public Date getFechaBaja() {
		return this.fechaBaja;
	}

	public void setFechaBaja(Date fechaBaja) {
		this.fechaBaja = fechaBaja;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "distDispositivo")
	public Set<AfstInstalacion> getAfstInstalacions() {
		return this.afstInstalacions;
	}

	public void setAfstInstalacions(Set<AfstInstalacion> afstInstalacions) {
		this.afstInstalacions = afstInstalacions;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "distDispositivo")
	public Set<InvtAccesorio> getInvtAccesorios() {
		return this.invtAccesorios;
	}

	public void setInvtAccesorios(Set<InvtAccesorio> invtAccesorios) {
		this.invtAccesorios = invtAccesorios;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "distDispositivo")
	public Set<UnitUnidad> getUnitUnidads() {
		return this.unitUnidads;
	}

	public void setUnitUnidads(Set<UnitUnidad> unitUnidads) {
		this.unitUnidads = unitUnidads;
	}

}
