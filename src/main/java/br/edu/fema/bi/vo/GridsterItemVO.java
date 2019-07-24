package br.edu.fema.bi.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
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
	
	private String dashboard;

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
	
	
}
