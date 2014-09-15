package com.afsinergia.org.model;

// Generated 15/08/2014 02:52:34 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * AfstInstalacion generated by hbm2java
 */
@Entity
@Table(name = "afst_instalacion", catalog = "afsinergia")
public class AfstInstalacion implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5892720102423004787L;
	private Integer idInstalacion;
	private DistDispositivo distDispositivo;
	private AfstInstalador afstInstalador;
	private String observacion;
	private Date fechaInstalacion;

	public AfstInstalacion() {
	}

	public AfstInstalacion(DistDispositivo distDispositivo,
			AfstInstalador afstInstalador, String observacion,
			Date fechaInstalacion) {
		this.distDispositivo = distDispositivo;
		this.afstInstalador = afstInstalador;
		this.observacion = observacion;
		this.fechaInstalacion = fechaInstalacion;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_instalacion", unique = true, nullable = false)
	public Integer getIdInstalacion() {
		return this.idInstalacion;
	}

	public void setIdInstalacion(Integer idInstalacion) {
		this.idInstalacion = idInstalacion;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_dispositivo", nullable = false)
	public DistDispositivo getDistDispositivo() {
		return this.distDispositivo;
	}

	public void setDistDispositivo(DistDispositivo distDispositivo) {
		this.distDispositivo = distDispositivo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_instalador", nullable = false)
	public AfstInstalador getAfstInstalador() {
		return this.afstInstalador;
	}

	public void setAfstInstalador(AfstInstalador afstInstalador) {
		this.afstInstalador = afstInstalador;
	}

	@Column(name = "observacion", nullable = false, length = 200)
	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_instalacion", nullable = false, length = 0)
	public Date getFechaInstalacion() {
		return this.fechaInstalacion;
	}

	public void setFechaInstalacion(Date fechaInstalacion) {
		this.fechaInstalacion = fechaInstalacion;
	}

}
