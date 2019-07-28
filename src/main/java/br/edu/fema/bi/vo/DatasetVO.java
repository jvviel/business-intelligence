package br.edu.fema.bi.vo;

import java.util.ArrayList;
import java.util.List;

public class DatasetVO {

	private List<Integer> data = new ArrayList<>();
	private List<String> backgroundColor = new ArrayList<String>();
	private List<String> hoverBackgroundColor = new ArrayList<String>();

	public List<Integer> getData() {
		return data;
	}

	public void setData(List<Integer> data) {
		this.data = data;
	}

	public List<String> getBackgroundColor() {
		return backgroundColor;
	}

	public void setBackgroundColor(List<String> backgroundColor) {
		this.backgroundColor = backgroundColor;
	}

	public List<String> getHoverBackgroundColor() {
		return hoverBackgroundColor;
	}

	public void setHoverBackgroundColor(List<String> hoverBackgroundColor) {
		this.hoverBackgroundColor = hoverBackgroundColor;
	}

}
