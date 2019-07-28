package br.edu.fema.bi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.fema.bi.vo.MenuItemVO;

public interface IMenuItemRepository extends JpaRepository<MenuItemVO, String>{

}
