package br.edu.fema.bi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.fema.bi.vo.GridsterItemVO;

public interface IGridsItemRepository extends JpaRepository<GridsterItemVO, String>{
	
	List<GridsterItemVO> findByDashboard(String dashboard);
	
	void deleteByDashboard(String id);

}
