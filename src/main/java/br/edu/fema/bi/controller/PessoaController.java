package br.edu.fema.bi.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.fema.bi.repository.PessoaRepository;
import br.edu.fema.bi.service.PessoaService;
import br.edu.fema.bi.vo.Pessoa;

@RestController
@RequestMapping(name = "/pessoa")
public class PessoaController {

	@Autowired
	private PessoaRepository pessoaRepository;

	@Autowired
	private PessoaService pessoaService;

	@GetMapping
	public List<Pessoa> getPessoas() {
		return pessoaRepository.findAll();
	}

	@GetMapping("/media")
	public Map<String, Object> getMedia(){
		return pessoaService.getMedia();
	}
	
	
}
