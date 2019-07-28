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

import br.edu.fema.bi.service.GridsterItemService;
import br.edu.fema.bi.vo.GridsterItemVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(description = "API para realizar a persistência de dados do objeto GridsterItem")
@RequestMapping("/gridsterItem")
public class GridsterItemController {

	@Autowired
	private GridsterItemService service;
	
	@ApiOperation(value = "Serviço para recuperar todos as gridsterItens")
	@GetMapping
	public ResponseEntity<?> bucarTodos() {
		List<GridsterItemVO> grids = service.selecionarTodos();
		return new ResponseEntity<>(grids, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Serviço para buscar uma gristerItem por id")
	@GetMapping("/{id}")
	public ResponseEntity<?> bucarPorId(@PathVariable String id) {
		GridsterItemVO grid = service.selecionarPorId(id);
		return new ResponseEntity<>(grid, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Serviço para atualizar uma gristerItem")
	@PutMapping("/{id}")
	public ResponseEntity<?> atualizar(@PathVariable String id, @RequestBody GridsterItemVO grid) {
		grid.setId(id);
		this.service.salvar(grid);
		return new ResponseEntity<>(grid, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Serviço para incluir um novo gristerItem")
	@PostMapping
	public ResponseEntity<?> salvar(@RequestBody GridsterItemVO grid) {
		this.service.salvar(grid);
		return new ResponseEntity<>(grid, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Serviço para excluir uma gridsterItem")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable String id) {
		this.service.deletar(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
