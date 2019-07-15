package br.edu.fema.bi.vo;

public class ViewVO {

	private String schemaName;
	
	private String viewName;
	
	private String definition;
	
	private String viewOwner;
	
	public String getViewOwner() {
		return viewOwner;
	}
	
	public void setViewOwner(String viewOwner) {
		this.viewOwner = viewOwner;
	}

	public String getSchemaName() {
		return schemaName;
	}

	public void setSchemaName(String schemaName) {
		this.schemaName = schemaName;
	}

	public String getViewName() {
		return viewName;
	}

	public void setViewName(String viewName) {
		this.viewName = viewName;
	}

	public String getDefinition() {
		return definition;
	}

	public void setDefinition(String definition) {
		this.definition = definition;
	}
}
