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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * DistCarrier generated by hbm2java
 */
@Entity
@Table(name = "dist_carrier", catalog = "afsinergia")
public class DistCarrier implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3841754912252838990L;
	private Integer idCarrier;
	private String nombre;
	private String formatoSim;
	private double costoSim;
	private String nomPlan;
	private Date vigenciaPlan;
	private double costoPlan;
	private int datos;
	private String estatus;
	private Date fechaAlta;
	private Date fechaActualiza;
	private Date fechaBaja;
	private Set<DistSim> distSims = new HashSet<DistSim>(0);

	public DistCarrier() {
	}

	public DistCarrier(String nombre, String formatoSim, double costoSim,
			String nomPlan, Date vigenciaPlan, double costoPlan, int datos,
			String estatus, Date fechaAlta, Date fechaActualiza, Date fechaBaja) {
		this.nombre = nombre;
		this.formatoSim = formatoSim;
		this.costoSim = costoSim;
		this.nomPlan = nomPlan;
		this.vigenciaPlan = vigenciaPlan;
		this.costoPlan = costoPlan;
		this.datos = datos;
		this.estatus = estatus;
		this.fechaAlta = fechaAlta;
		this.fechaActualiza = fechaActualiza;
		this.fechaBaja = fechaBaja;
	}

	public DistCarrier(String nombre, String formatoSim, double costoSim,
			String nomPlan, Date vigenciaPlan, double costoPlan, int datos,
			String estatus, Date fechaAlta, Date fechaActualiza,
			Date fechaBaja, Set<DistSim> distSims) {
		this.nombre = nombre;
		this.formatoSim = formatoSim;
		this.costoSim = costoSim;
		this.nomPlan = nomPlan;
		this.vigenciaPlan = vigenciaPlan;
		this.costoPlan = costoPlan;
		this.datos = datos;
		this.estatus = estatus;
		this.fechaAlta = fechaAlta;
		this.fechaActualiza = fechaActualiza;
		this.fechaBaja = fechaBaja;
		this.distSims = distSims;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_carrier", unique = true, nullable = false)
	public Integer getIdCarrier() {
		return this.idCarrier;
	}

	public void setIdCarrier(Integer idCarrier) {
		this.idCarrier = idCarrier;
	}

	@Column(name = "nombre", nullable = false, length = 45)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "formato_sim", nullable = false, length = 20)
	public String getFormatoSim() {
		return this.formatoSim;
	}

	public void setFormatoSim(String formatoSim) {
		this.formatoSim = formatoSim;
	}

	@Column(name = "costo_sim", nullable = false, precision = 22, scale = 0)
	public double getCostoSim() {
		return this.costoSim;
	}

	public void setCostoSim(double costoSim) {
		this.costoSim = costoSim;
	}

	@Column(name = "nom_plan", nullable = false, length = 45)
	public String getNomPlan() {
		return this.nomPlan;
	}

	public void setNomPlan(String nomPlan) {
		this.nomPlan = nomPlan;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "vigencia_plan", nullable = false, length = 0)
	public Date getVigenciaPlan() {
		return this.vigenciaPlan;
	}

	public void setVigenciaPlan(Date vigenciaPlan) {
		this.vigenciaPlan = vigenciaPlan;
	}

	@Column(name = "costo_plan", nullable = false, precision = 22, scale = 0)
	public double getCostoPlan() {
		return this.costoPlan;
	}

	public void setCostoPlan(double costoPlan) {
		this.costoPlan = costoPlan;
	}

	@Column(name = "datos", nullable = false)
	public int getDatos() {
		return this.datos;
	}

	public void setDatos(int datos) {
		this.datos = datos;
	}

	@Column(name = "estatus", nullable = false, length = 45)
	public String getEstatus() {
		return this.estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "distCarrier")
	public Set<DistSim> getDistSims() {
		return this.distSims;
	}

	public void setDistSims(Set<DistSim> distSims) {
		this.distSims = distSims;
	}

}
