package com.projeto.sistema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.projeto.sistema.models.Estado;
import com.projeto.sistema.reposytory.EstadoRepository;

@Controller
public class EstadoControle {
	
	@Autowired//Injeção de dependência
    private EstadoRepository estadorepository;
	
	//Obter o mapeamento
	@GetMapping("/cadastroEstado")
	//Responsavel por gera a viw
	public ModelAndView cadastrar(Estado estado) {
		                                     //Caminho de pasta
		ModelAndView mv = new ModelAndView("administrativo/estados/cadastro");
		mv.addObject("estado", estado);
		return mv;
		
	}
	
	@PostMapping("/salvarEstado")
	public ModelAndView salvar(Estado estado, BindingResult result) {
		if(result.hasErrors()) {
			return cadastrar(estado);
		}
		
		estadorepository.saveAndFlush(estado);
		return cadastrar(new Estado());
	}
}
