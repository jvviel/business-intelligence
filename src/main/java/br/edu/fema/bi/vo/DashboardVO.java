package br.edu.fema.bi.vo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity(name = "dashboard")
public class DashboardVO {

	@Id
	@Column(name = "id")
	private String id;
	
	@Column(name = "codigo")
	private Long codigo;
	
	@Transient 
	public List<GridsterItemVO> widgets;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public List<GridsterItemVO> getWidgets() {
		return widgets;
	}

	public void setWidgets(List<GridsterItemVO> widgets) {
		this.widgets = widgets;
	}
}
