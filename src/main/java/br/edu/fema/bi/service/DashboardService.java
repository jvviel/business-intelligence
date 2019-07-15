package br.edu.fema.bi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.fema.bi.repository.IDashboardRepository;
import br.edu.fema.bi.util.Util;
import br.edu.fema.bi.vo.DashboardVO;
import br.edu.fema.bi.vo.GridsterItemVO;

@Service
public class DashboardService {

	@Autowired
	private IDashboardRepository repository;
	
	@Autowired
	private GridsterItemService gridService;
	
	public void salvar(DashboardVO dash) {
		
		if(dash.getId() == null) {
			dash.setId(Util.codigo());
		}
		List<GridsterItemVO> widgets = dash.getWidgets();
		dash = this.repository.save(dash);
		this.salvarLista(widgets, dash);
	}
	
	public void deletar(String id) {
		this.repository.deleteById(id);
		this.gridService.deletarPorDashboard(id);
	}
	
	public List<DashboardVO> selecionarTodos() {
		List<DashboardVO> dashboards = this.repository.findAll();
		dashboards.forEach(dash -> {
			dash.setWidgets(this.gridService.buscarPorDashboard(dash.getId()));
		});
		
		return dashboards;
	}
	
	public DashboardVO selecionarPorId(String id) {
		Optional<DashboardVO> optional = this.repository.findById(id);
		DashboardVO dash = optional.get();
		dash.setWidgets(this.gridService.buscarPorDashboard(dash.getId()));
		return dash;
	}
	
	public void salvarLista(List<GridsterItemVO> grids, DashboardVO dash) {
		
		grids.forEach(grid -> {
			grid.setDashboard(dash.getId());
			this.gridService.salvar(grid);
		});
	}
}
