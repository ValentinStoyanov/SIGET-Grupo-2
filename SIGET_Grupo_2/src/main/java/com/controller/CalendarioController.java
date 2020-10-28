package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.model.Calendario;
import com.model.Reunion;
import com.persistence.CalendarioRepository;

@CrossOrigin()
@RestController
@RequestMapping("calendario")
public class CalendarioController {
	
	@Autowired
	private CalendarioRepository calendarioRepository;
	
	
	@GetMapping("getAll")
    public List<Calendario> getAll(){
        List<Calendario> cal = this.calendarioRepository.findAll();
        return cal;
    }
	
	
	@PostMapping("create")
    public Calendario create(@RequestParam(name = "hora_inicio") String hora_inicio,
    		@RequestParam(name = "hora_fin") String hora_fin,
    		@RequestParam(name = "enlace_reunion") String enlace_reunion){
		
		Calendario cal = this.calendarioRepository.insert(new Calendario(hora_inicio,hora_fin,enlace_reunion));

        return cal;
    }
}
