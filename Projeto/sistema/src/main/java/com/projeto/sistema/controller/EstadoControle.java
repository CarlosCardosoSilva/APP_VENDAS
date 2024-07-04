package com.projeto.sistema.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	@GetMapping("/listarEstado")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("administrativo/estados/lista");
		mv.addObject("listarEstado", estadorepository.findAll());
		return mv;
	}
	@GetMapping("/editarEstado/{id}")
	public ModelAndView editar(@PathVariable("id") Long id ) {
		Optional<Estado> estado =  estadorepository.findById(id);
		return cadastrar(estado.get());
		
	}
	
	@GetMapping("/removerEstado/{id}")
	public ModelAndView remover(@PathVariable("id") Long id ) {
		Optional<Estado> estado =  estadorepository.findById(id);
		estadorepository.delete(estado.get());
		return listar();
		
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
