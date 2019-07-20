package br.edu.fema.bi.vo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity(name = "dashboard")
public class DashboardVO {

	
	@Column(name = "id")
	private String id;
	
	@Id
	@Column(name = "codigo")
	private String codigo;
	
	@Column(name = "id_menu_item")
	private String idMenuItem;
	
	public String getIdMenuItem() {
		return idMenuItem;
	}
	
	public void setIdMenuItem(String idMenuItem) {
		this.idMenuItem = idMenuItem;
	}
	
	@Transient 
	public List<GridsterItemVO> widgets;
	
	public String getCodigo() {
		return codigo;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<GridsterItemVO> getWidgets() {
		return widgets;
	}

	public void setWidgets(List<GridsterItemVO> widgets) {
		this.widgets = widgets;
	}
}
