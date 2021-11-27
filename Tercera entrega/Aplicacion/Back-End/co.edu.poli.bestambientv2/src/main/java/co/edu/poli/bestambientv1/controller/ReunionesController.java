package co.edu.poli.bestambientv1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.poli.bestambientv1.modelo.Reuniones;
import co.edu.poli.bestambientv1.repository.ReunionesRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController // Defines that this class is a spring bean
@RequestMapping("/api/v1/")
public class ReunionesController {

	
	

		// Tells the application context to inject an instance of stateRespository here
		@Autowired
		private ReunionesRepository reunionesRepository;

		@GetMapping("/Reuniones")
		public List<Reuniones> getAllReuniones() {
			// The stateRepository is already injected and you can use it
			return reunionesRepository.findAll();
		}

		@GetMapping("/Reuniones/{id}")
		public Reuniones getReunionesById(@PathVariable String id) {
			Reuniones Reuniones = reunionesRepository.findById(id).get();
			return Reuniones;
		}

		@PostMapping("/Reuniones")
		public Reuniones createReuniones(@RequestBody Reuniones Reuniones) {
			return reunionesRepository.save(Reuniones);
		}
		
		@PostMapping("/Reunioness")
		public String createReunionesList(@RequestBody List<Reuniones> Reuniones) {
			reunionesRepository.saveAll(Reuniones);
		return "Insercion Correcta";
		}
		

		@PutMapping("/Reuniones/{id}")
		public Reuniones updateReuniones(@PathVariable String id, @RequestBody Reuniones ReunionesNew) {
			Reuniones Reunionesdb = reunionesRepository.findById(id).get();
		
			Reunionesdb.setId(ReunionesNew.getId());
			Reunionesdb.setLugar_encuentro(ReunionesNew.getLugar_encuentro());
			Reunionesdb.setDescripciom_actividad(ReunionesNew.getDescripciom_actividad());
			Reunionesdb.setEstado(ReunionesNew.getEstado());
			

			reunionesRepository.save(Reunionesdb);
			return Reunionesdb;
		}

		@DeleteMapping("/reunion")
		public Reuniones deletestate(@RequestParam("Code") String id) {
			Reuniones Reunionesdb = reunionesRepository.findById(id).get();
			reunionesRepository.delete(Reunionesdb);
			return Reunionesdb;
		}

		

		/*// Query2
	    @GetMapping("/Reuniones/{s}")
	    public List<String> getfindByReuniones(@PathVariable String s){
	    return reunionesRepository.findByReuniones(s);}

		  
		// Load List of states
		@PostMapping("/ReunionesL")
		public String createstateList(@RequestBody List<Reuniones> Reuniones) {

			reunionesRepository.saveAll(Reuniones);
		return "done";
		} */
	}
	
	

