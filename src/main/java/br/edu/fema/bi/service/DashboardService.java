package br.edu.fema.bi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.fema.bi.repository.IDashboardRepository;
import br.edu.fema.bi.repository.IGridsItemRepository;
import br.edu.fema.bi.util.Util;
import br.edu.fema.bi.vo.DashboardVO;
import br.edu.fema.bi.vo.GridsterItemVO;

@Service
public class DashboardService {

	@Autowired
	private IDashboardRepository repository;

	@Autowired
	private GridsterItemService gridService;
	
	@Autowired
	private IGridsItemRepository gridRepository;

	public void salvar(DashboardVO dash) {

		if (dash.getCodigo() == null) {
			dash.setCodigo(Util.codigo());
		}
		List<GridsterItemVO> widgets = dash.getWidgets();
		dash = this.repository.save(dash);
		this.salvarLista(widgets, dash);
	}

	public void deletar(String id) {
		this.repository.deleteById(id);
		List<GridsterItemVO> grids = this.gridService.buscarPorDashboard(id);
		grids.forEach(grid -> {
			this.gridRepository.delete(grid);
		});
	}

	public List<DashboardVO> selecionarTodos() {
		List<DashboardVO> dashboards = this.repository.findAll();
		dashboards.forEach(dash -> {
			dash.setWidgets(this.gridService.buscarPorDashboard(dash.getId()));
		});

		return dashboards;
	}

	public DashboardVO selecionarPorCodigo(String codigo) {
		Optional<DashboardVO> optional = this.repository.findByCodigo(codigo);
		DashboardVO dash = optional.isPresent() ? optional.get() : null;
		if (dash != null) {
			dash.setWidgets(this.gridService.buscarPorDashboard(dash.getCodigo()));
		} else {
			dash = new DashboardVO();
		}
		return dash;
	}
	
	public DashboardVO selecionarPorId(String id) {
		Optional<DashboardVO> optional = this.repository.findById(id);
		DashboardVO dash = optional.isPresent() ? optional.get() : null;
		if (dash != null) {
			dash.setWidgets(this.gridService.buscarPorDashboard(dash.getCodigo()));
		} else {
			dash = new DashboardVO();
		}
		
		return dash;
	}

	public void salvarLista(List<GridsterItemVO> grids, DashboardVO dash) {

		grids.forEach(grid -> {
			grid.setDashboard(dash.getCodigo());
			this.gridService.salvar(grid);
		});
	}
}
