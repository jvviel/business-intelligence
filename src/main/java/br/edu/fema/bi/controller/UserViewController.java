package br.edu.fema.bi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.fema.bi.repository.UserViewRepository;
import br.edu.fema.bi.vo.UserViewVO;

@RestController
@RequestMapping("/user-view")
public class UserViewController {

	@Autowired
	private UserViewRepository userViewRepository;

	@GetMapping
	public List<UserViewVO> buscarViews(){
		return this.userViewRepository.findAll();
	}
	
	
}
