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

@RestController
@RequestMapping("/views")
public class ViewController {

	@Autowired
	private ViewRepository repository;
	
	@GetMapping
	public List<ViewVO> findAll() throws SQLException {
		return this.repository.findAll();
	}
	
	@GetMapping("/{name}")
	public ViewVO findByName(@PathVariable String name) throws SQLException {
		return this.repository.findByName(name);
	}
	
	@GetMapping("/values/{viewName}")
	public List<Map<String, Object>> findValuesView(@PathVariable String viewName) throws SQLException {
		return this.repository.findValuesView(viewName);
	}
}
