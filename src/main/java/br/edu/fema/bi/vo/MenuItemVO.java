package br.edu.fema.bi.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "menu_item")
public class MenuItemVO {

	@Id
	@Column(name = "id")
	private String id;
	
	@Column(name = "label")
	private String label;
	
	@Column(name = "item")
	private String item;
	
	@Column(name = "icon")
	private String icon;
	
	@Column(name = "style")
	private String style;

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

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
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
