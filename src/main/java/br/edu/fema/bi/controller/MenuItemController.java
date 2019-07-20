
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

import br.edu.fema.bi.service.MenuItemService;
import br.edu.fema.bi.vo.MenuItemVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/menuItem")
@Api(description = "[/menuItem] Api para realizar a persistência dos dados em relação ao objeto MenuItem")
public class MenuItemController {

	@Autowired
	private MenuItemService service;
	
	@GetMapping
	@ApiOperation(value = "Serviço para listar todos os objetos MenuItem")
	public ResponseEntity<?> bucarTodos() {
		List<MenuItemVO> menus = service.selecionarTodos();
		return new ResponseEntity<>(menus, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value = "Serviço para buscar um objeto MenuItem por id")
	public ResponseEntity<?> bucarPorId(@PathVariable String id) {
		MenuItemVO menu = service.selecionarPorId(id);
		return new ResponseEntity<>(menu, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	@ApiOperation(value = "Serviço para atualizar um objeto MenuItem")
	public ResponseEntity<?> atualizar(@PathVariable String id, @RequestBody MenuItemVO menu) {
		menu.setId(id);
		this.service.salvar(menu);
		return new ResponseEntity<>(menu, HttpStatus.OK);
	}
	
	@PostMapping
	@ApiOperation(value = "Serviço para incluir um novo MenuItem")
	public ResponseEntity<?> salvar(@RequestBody MenuItemVO menu) {
		this.service.salvar(menu);
		return new ResponseEntity<>(menu, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Serviço para excluir um MenuItem")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable String id) {
		this.service.deletar(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
