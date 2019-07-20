package br.edu.fema.bi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.fema.bi.vo.DashboardVO;

public interface IDashboardRepository extends JpaRepository<DashboardVO, String>{
	
	Optional<DashboardVO> findByCodigo(String codigo);
	
	void deleteByIdMenuItem(String id);
	
	DashboardVO findByIdMenuItem(String id);

}
