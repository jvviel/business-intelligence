package br.edu.fema.bi.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "views")
public class UserViewVO {

	@Id
	private Long codigo;
	private String nome;

	@Column(name = "sql_view")
	private String codigoView;

	@Column(name = "qtd_cores")
	private Integer quantidadeDeCores;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodigoView() {
		return codigoView;
	}

	public void setCodigoView(String codigoView) {
		this.codigoView = codigoView;
	}

	public Integer getQuantidadeDeCores() {
		return quantidadeDeCores;
	}

	public void setQuantidadeDeCores(Integer quantidadeDeCores) {
		this.quantidadeDeCores = quantidadeDeCores;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserViewVO other = (UserViewVO) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
