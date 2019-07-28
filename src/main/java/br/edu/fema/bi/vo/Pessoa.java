package br.edu.fema.bi.vo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "pessoas")
public class Pessoa {

	@Id
	private Long codigo;

	private Double media;

	private Character sexo;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Double getMedia() {
		return media;
	}

	public void setMedia(Double media) {
		this.media = media;
	}

	public Character getSexo() {
		return sexo;
	}

	public void setSexo(Character sexo) {
		this.sexo = sexo;
	}

}
