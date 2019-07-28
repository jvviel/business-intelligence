package br.edu.fema.bi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.fema.bi.repository.IGridsItemRepository;
import br.edu.fema.bi.util.Util;
import br.edu.fema.bi.vo.GridsterItemVO;

@Service
public class GridsterItemService {

	@Autowired
	private IGridsItemRepository repository;
	
	public void salvar(GridsterItemVO grid) {
		
		if(grid.getId() == null) {
			grid.setId(Util.codigo());
		}
		this.repository.save(grid);
	}
	
	public void deletar(String id) {
		this.repository.deleteById(id);
	}
	
	public List<GridsterItemVO> selecionarTodos() {
		return this.repository.findAll();
	}
	
	public GridsterItemVO selecionarPorId(String id) {
		Optional<GridsterItemVO> optional = this.repository.findById(id);
		return optional.isPresent() ? optional.get() : null;
	}
	
	public List<GridsterItemVO> buscarPorDashboard(String dash) {
		return this.repository.findByDashboard(dash);
	}
	
	public void deletarPorDashboard(String id) {
		this.repository.deleteByDashboard(id);
	}

}
