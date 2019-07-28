	package br.edu.fema.bi.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity(name = "menu_item")
public class MenuItemVO {

	@Id
	@Column(name = "id")
	private String id;
	
	@Column(name = "label")
	private String label;
	
	@Column(name = "icon")
	private String icon;
	
	@Column(name = "style")
	private String style;
	
	@Transient
	private DashboardVO dashboard;
	
	public DashboardVO getDashboard() {
		return dashboard;
	}
	
	public void setDashboard(DashboardVO dashboard) {
		this.dashboard = dashboard;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}
	
	
}
