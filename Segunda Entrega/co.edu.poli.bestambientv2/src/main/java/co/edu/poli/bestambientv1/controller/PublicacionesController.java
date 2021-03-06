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

import co.edu.poli.bestambientv1.modelo.Publicaciones;
import co.edu.poli.bestambientv1.repository.PublicacionesRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController // Defines that this class is a spring bean
@RequestMapping("/api/v1/")
public class PublicacionesController {

	// Tells the application context to inject an instance of stateRespository here
	@Autowired
	private PublicacionesRepository publicacionesRepository;

	@GetMapping("/publicaciones")
	public List<Publicaciones> getAllPublicaciones() {
		// The stateRepository is already injected and you can use it
		return publicacionesRepository.findAll();
	}

	@GetMapping("/publicaciones/{id}")
	public Publicaciones getPublicacionesById(@PathVariable Long id) {
		Publicaciones publicaciones = publicacionesRepository.findById(id).get();
		return publicaciones;
	}

	@PostMapping("/publicaciones")
	public Publicaciones createpublicaciones(@RequestBody Publicaciones publicaciones) {
		return publicacionesRepository.save(publicaciones);
	}
	
	@PostMapping("/publicacionesss")
	public String createPublicacionesList(@RequestBody List<Publicaciones> publicaciones) {
		publicacionesRepository.saveAll(publicaciones);
	return "Insercion Correcta";
	}
	

	@PutMapping("/publicaciones/{id}")
	public Publicaciones updatepublicaciones(@PathVariable Long id, @RequestBody Publicaciones publicacionesNew) {
		Publicaciones publicacionesdb = publicacionesRepository.findById(id).get();
	
		
		publicacionesdb.setDescripcion(publicacionesNew.getDescripcion());
		publicacionesdb.setEstado(publicacionesNew.getEstado());	
		
		publicacionesRepository.save(publicacionesdb);
		return publicacionesdb;
	}
	@DeleteMapping("/authors/{id}")
	public Publicaciones deleteAuthor(@PathVariable Long id) {
		Publicaciones publicacionesdb = publicacionesRepository.findById(id).get();
	publicacionesRepository.delete(publicacionesdb);
	return publicacionesdb;
	}

	

	

	/*// Query2
    @GetMapping("/publicaciones/{s}")
    public List<String> getfindByPublicaciones(@PathVariable String s){
    return publicacionesRepository.findByPublicaciones(s);}

	  
	// Load List of states
	@PostMapping("/publicacionesL")
	public String createstateList(@RequestBody List<Publicaciones> publicaciones) {

		publicacionesRepository.saveAll(publicaciones);
	return "done";
	} */
}