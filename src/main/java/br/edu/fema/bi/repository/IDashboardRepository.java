package br.edu.fema.bi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.fema.bi.vo.DashboardVO;

public interface IDashboardRepository extends JpaRepository<DashboardVO, String>{

}
