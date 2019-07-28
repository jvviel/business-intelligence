package br.edu.fema.bi.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Entity(name = "gridster_item")
public class GridsterItemVO {

	@Id
	@Column(name = "id")
	private String id;

	@Column(name = "posicao_x")
	private Long x;

	@Column(name = "posicao_y")
	private Long y;

	@Column(name = "rows")
	private Long rows;

	@Column(name = "cols")
	private Long cols;

	@Column(name = "drag_enabled")
	private Boolean dragEnabled;

	@Column(name = "resize_enabled")
	private Boolean resizeEnabled;

	private String titulo;

	private String view;

	@Enumerated(EnumType.STRING)
	private TipoGrafico tipoGrafico;

	private String dashboard;

	private String cor;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getX() {
		return x;
	}

	public void setX(Long x) {
		this.x = x;
	}

	public Long getY() {
		return y;
	}

	public void setY(Long y) {
		this.y = y;
	}

	public Long getRows() {
		return rows;
	}

	public void setRows(Long rows) {
		this.rows = rows;
	}

	public Long getCols() {
		return cols;
	}

	public void setCols(Long cols) {
		this.cols = cols;
	}

	public Boolean getDragEnabled() {
		return dragEnabled;
	}

	public void setDragEnabled(Boolean dragEnabled) {
		this.dragEnabled = dragEnabled;
	}

	public Boolean getResizeEnabled() {
		return resizeEnabled;
	}

	public void setResizeEnabled(Boolean resizeEnabled) {
		this.resizeEnabled = resizeEnabled;
	}

	public String getDashboard() {
		return dashboard;
	}

	public void setDashboard(String dashboard) {
		this.dashboard = dashboard;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getView() {
		return view;
	}

	public void setView(String view) {
		this.view = view;
	}

	public TipoGrafico getTipoGrafico() {
		return tipoGrafico;
	}

	public void setTipoGrafico(TipoGrafico tipoGrafico) {
		this.tipoGrafico = tipoGrafico;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

}
