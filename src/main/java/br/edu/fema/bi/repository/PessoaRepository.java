package br.edu.fema.bi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.fema.bi.vo.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
