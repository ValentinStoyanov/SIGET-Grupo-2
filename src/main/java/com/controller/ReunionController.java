
package com.controller;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
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
	    public List<Reunion> get(@RequestParam(name = "asistentes") String asistentes){
	        List<Reunion> r = this.reunionRepository.findByAsistentesIn(asistentes);

	        return r;
	    }
		
		
		@PostMapping("create")
	    public Reunion create(@RequestParam(name = "temas") String temas,
	    		@RequestParam(name = "descripcion") String descripcion,
	    		@RequestParam(name = "hora_inicio") String hora_inicio,
	    		@RequestParam(name = "hora_fin") String hora_fin,
	    		@RequestParam(name = "asistentes") String[] asistentes,
	    		@RequestParam(name = "convocante") String convocante){
			Reunion reunion = this.reunionRepository.insert(new Reunion(temas,descripcion,hora_inicio,
					hora_fin,asistentes,convocante));

	        return reunion;
	    }
		
		/*@PutMapping("update")
	    public boolean update(@RequestParam(name = "id") String id, @RequestParam(name = "contenido") String contenido, @RequestParam(name = "completada") boolean completada){
	        if(this.reunionRepository.existsById(id)) {
	        	this.reunionRepository.deleteById(id);
	        	this.reunionRepository.insert(new Reunion(id, contenido, completada));
	        	return true;
	        }
	        return false;
	    }*/
		
		@PostMapping("delete")
	    public boolean delete(@RequestParam(name = "convocante") String convocante){
			
			Optional<Reunion> reunion = this.reunionRepository.findOneByConvocante(convocante);
			
	        if(!reunion.equals(null)) {
	        	this.reunionRepository.deleteByConvocante(convocante);
	        	return true;
	        }
	        return false;
	    }
}
