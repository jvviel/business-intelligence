package br.edu.fema.bi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.fema.bi.repository.IDashboardRepository;
import br.edu.fema.bi.repository.IGridsItemRepository;
import br.edu.fema.bi.repository.IMenuItemRepository;
import br.edu.fema.bi.util.Util;
import br.edu.fema.bi.vo.DashboardVO;
import br.edu.fema.bi.vo.MenuItemVO;

@Service
public class MenuItemService {
	
	@Autowired
	private IMenuItemRepository repository;
	
	@Autowired
	private IDashboardRepository dashRepository;
	
	@Autowired
	private IGridsItemRepository gridRepository;
	
	@Autowired
	private DashboardService service;
	
	public void salvar(MenuItemVO menu) {
		
		if(menu.getId() == null) {
			menu.setId(Util.codigo());
		}
		this.repository.save(menu);
		menu.getDashboard().setIdMenuItem(menu.getId());
		this.service.salvar(menu.getDashboard());
	}
	
	public void deletar(String id) {
		this.repository.deleteById(id);
		DashboardVO dash = this.dashRepository.findByIdMenuItem(id);
		this.service.deletar(dash.getCodigo());
	}
	
	public List<MenuItemVO> selecionarTodos() {
		List<MenuItemVO> menus = this.repository.findAll();
		menus.forEach(menu -> {
			menu = this.montaObjeto(menu);
		});
		
		return menus;
	}
	
	public MenuItemVO selecionarPorId(String id) {
		Optional<MenuItemVO> optional = this.repository.findById(id);
		return optional.isPresent() ? this.montaObjeto(optional.get()) : null;
	}
	
	private MenuItemVO montaObjeto(MenuItemVO menu) {
		DashboardVO dash = this.dashRepository.findByIdMenuItem(menu.getId());
		dash.setWidgets(this.gridRepository.findByDashboard(dash.getCodigo()));
		menu.setDashboard(dash);
		
		return menu;
	}

}
