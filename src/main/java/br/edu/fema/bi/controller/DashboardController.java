package br.edu.fema.bi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.fema.bi.service.DashboardService;
import br.edu.fema.bi.vo.DashboardVO;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {

	@Autowired
	private DashboardService service;
	
	@GetMapping
	public List<DashboardVO> bucarTodos() {
		List<DashboardVO> dashs = service.selecionarTodos();
		return dashs;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> bucarTodos(@PathVariable String id) {
		DashboardVO dash = service.selecionarPorId(id);
		return new ResponseEntity<>(dash, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> atualizar(@PathVariable String id, @RequestBody DashboardVO dash) {
		dash.setId(id);
		this.service.salvar(dash);
		return new ResponseEntity<>(dash, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> salvar(@RequestBody DashboardVO dash) {
		this.service.salvar(dash);
		return new ResponseEntity<>(dash, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable String id) {
		this.service.deletar(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
