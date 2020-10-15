
package com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.model.Reunion;
import com.persistence.ReunionRepository;

	@CrossOrigin()
	@RestController
	@RequestMapping("reuniones")
	public class ReunionController { 
		@Autowired
		private ReunionRepository reunionRepository;

		@GetMapping("getAll")
	    public List<Reunion> getAll(){
	        List<Reunion> reunion = this.reunionRepository.findAll();
	        return reunion;
	    }
		
		@GetMapping("get")
	    public Optional<Reunion> get(@RequestParam(name = "id") String id){
	        Optional<Reunion> tarea = this.reunionRepository.findOneBy_id(id);

	        return tarea;
	    }
		
		@PostMapping("create")
	    public Reunion create(@RequestParam(name = "id") String id, @RequestParam(name = "contenido") String contenido, @RequestParam(name = "completada") boolean completada){
			Reunion reunion = this.reunionRepository.insert(new Reunion(id, contenido, completada));

	        return reunion;
	    }
		
		@PutMapping("update")
	    public boolean update(@RequestParam(name = "id") String id, @RequestParam(name = "contenido") String contenido, @RequestParam(name = "completada") boolean completada){
	        if(this.reunionRepository.existsById(id)) {
	        	this.reunionRepository.deleteById(id);
	        	this.reunionRepository.insert(new Reunion(id, contenido, completada));
	        	return true;
	        }
	        return false;
	    }
		
		@PostMapping("delete")
	    public boolean delete(@RequestParam(name = "id") String id){
	        if(this.reunionRepository.existsById(id)) {
	        	this.reunionRepository.deleteById(id);
	        	return true;
	        }
	        return false;
	    }
}
