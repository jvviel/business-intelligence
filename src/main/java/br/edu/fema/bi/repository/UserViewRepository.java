package br.edu.fema.bi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.fema.bi.vo.UserViewVO;

public interface UserViewRepository extends JpaRepository<UserViewVO, Long> {

}
