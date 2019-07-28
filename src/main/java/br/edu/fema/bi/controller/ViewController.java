package br.edu.fema.bi.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.fema.bi.repository.ViewRepository;
import br.edu.fema.bi.vo.ViewVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/views")
@Api(description = "API para a listagem dos valores dinamicamente de Views cadastradas no banco de dados")
public class ViewController {

	@Autowired
	private ViewRepository repository;
	
	@ApiOperation(value = "Serviço para buscar detalhes de todas as Views cadastradas no banco de dados")
	@GetMapping
	public List<ViewVO> findAll() throws SQLException {
		return this.repository.findAll();
	}
	
	@ApiOperation(value = "Serviço para buscar detalhes de uma View cadastrada no banco de dados")
	@GetMapping("/{name}")
	public ViewVO findByName(@PathVariable String name) throws SQLException {
		return this.repository.findByName(name);
	}
	
	@ApiOperation(value = "Serviço para buscar os valores de forma dinâmica de uma determinada View")
	@GetMapping("/values/{viewName}")
	public List<Map<String, Object>> findValuesView(@PathVariable String viewName) throws SQLException {
		return this.repository.findValuesView(viewName);
	}
}
