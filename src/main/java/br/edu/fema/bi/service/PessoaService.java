package br.edu.fema.bi.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.fema.bi.repository.PessoaRepository;
import br.edu.fema.bi.vo.DatasetVO;
import br.edu.fema.bi.vo.Pessoa;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;

	public Map<String, Object> getMedia() {
		Map<String, Object> retorno = new HashMap<>();
		List<Pessoa> pessoas = pessoaRepository.findAll();
		int aprovados = 0;
		int reprovados = 0;
		int recuperacao = 0;
		for (Pessoa pessoa : pessoas) {
			if (pessoa.getMedia() >= 7) {
				aprovados++;
			} else if (pessoa.getMedia() >= 4.5) {
				recuperacao++;
			} else {
				reprovados++;
			}
		}
		retorno.put("labels", Arrays.asList("Aprovado", "Recuperação", "Reprovado"));
		DatasetVO dataset = new DatasetVO();
		List<Integer> dados = new ArrayList();
		dados.add(aprovados);
		dados.add(recuperacao);
		dados.add(reprovados);
		dataset.setData(dados);
		dataset.setBackgroundColor(Arrays.asList("#FF6384","#AA6384","#FFCC84"));
		dataset.setHoverBackgroundColor(Arrays.asList("#FFFF84","#AC63C4","#F2CC94"));
		List<DatasetVO> datasets = new ArrayList<DatasetVO>();
		datasets.add(dataset);
		retorno.put("datasets", datasets);
		
		return retorno;
	}

}
