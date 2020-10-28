package com.controller;

import java.util.List;
import java.util.Optional;

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
    public Calendario create(@RequestParam(name = "horainicio") String horainicio,
    		@RequestParam(name = "horafin") String horafin,
    		@RequestParam(name = "enlace") String enlace){
		
		Calendario cal = this.calendarioRepository.insert(new Calendario(horainicio,horafin,enlace));

        return cal;
    }
	
	@PostMapping("delete")
    public boolean delete(@RequestParam(name = "horainicio") String horainicio){
		
		Optional<Calendario> cal = this.calendarioRepository.findByHorainicio(horainicio);
		
        if(!cal.isEmpty()) {
        	this.calendarioRepository.deleteByHorainicio(horainicio);
        	return true;
        }
        return false;
    }
	
	
}
