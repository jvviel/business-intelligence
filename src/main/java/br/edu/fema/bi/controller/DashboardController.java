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
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/dashboard")
@Api(description = "Api que realiza a persistência dos dados para o objeto Dashboard")
public class DashboardController {

	@Autowired
	private DashboardService service;
	
	@ApiOperation(value = "Serviço para buscar todos os Dashboards cadastrados")
	@GetMapping
	public List<DashboardVO> bucarTodos() {
		List<DashboardVO> dashs = service.selecionarTodos();
		return dashs;
	}
	
	@ApiOperation(value = "Serviço para buscar um dashBoard por código")
	@GetMapping("/{codigo}")
	public ResponseEntity<?> buscarPorCodigo(@PathVariable String codigo) {
		DashboardVO dash = service.selecionarPorCodigo(codigo);
		return new ResponseEntity<>(dash, HttpStatus.OK);
	}
	
/*	@GetMapping("/{id}")
	@ApiOperation(value = "Serviço para buscar um dashboard por id")
	public ResponseEntity<?> buscarPorId(@PathVariable String id) {
		DashboardVO dash = service.selecionarPorId(id);
		return new ResponseEntity<>(dash, HttpStatus.OK);
	} */
	
	@ApiOperation(value = "Serviço para atualizar um dashboard")
	@PutMapping("/{id}")
	public ResponseEntity<?> atualizar(@PathVariable String id, @RequestBody DashboardVO dash) {
		dash.setId(id);
		this.service.salvar(dash);
		return new ResponseEntity<>(dash, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Serviço para salvar um dashboard")
	@PostMapping
	public ResponseEntity<?> salvar(@RequestBody DashboardVO dash) {
		this.service.salvar(dash);
		return new ResponseEntity<>(dash, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Serviço para exluir um dashboard")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable String id) {
		this.service.deletar(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
