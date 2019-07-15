package br.edu.fema.bi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.fema.bi.repository.IMenuItemRepository;
import br.edu.fema.bi.util.Util;
import br.edu.fema.bi.vo.MenuItemVO;

@Service
public class MenuItemService {
	
	@Autowired
	private IMenuItemRepository repository;
	
	public void salvar(MenuItemVO menu) {
		
		if(menu.getId() == null) {
			menu.setId(Util.codigo());
		}
		this.repository.save(menu);
	}
	
	public void deletar(String id) {
		this.repository.deleteById(id);
	}
	
	public List<MenuItemVO> selecionarTodos() {
		return this.repository.findAll();
	}
	
	public MenuItemVO selecionarPorId(String id) {
		Optional<MenuItemVO> optional = this.repository.findById(id);
		return optional.isPresent() ? optional.get() : null;
	}

}
