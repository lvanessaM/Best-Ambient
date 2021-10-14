package co.edu.poli.bestambientv1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.poli.bestambientv1.modelo.Roles;
import co.edu.poli.bestambientv1.repository.RolesRepository;

@RestController // Defines that this class is a spring bean
@RequestMapping("/api/v1/")
public class RolesController {
	// Tells the application context to inject an instance of stateRespository here
	@Autowired
	private RolesRepository rolRepository;

	@GetMapping("/Roles")
	public List<Roles> getAllRoles() {
		// The rolRepository is already injected and you can use it
		return rolRepository.findAll();
	}

	@GetMapping("/Roles/{id}")
	public Roles getstateById(@PathVariable String id) {
		Roles state = rolRepository.findById(id).get();
		return state;
	}

	@PostMapping("/Roles")
	public Roles createstate(@RequestBody Roles rol) {
		return rolRepository.save(rol);
	}
	
	@PostMapping("/Roles1")
	public String createStateList(@RequestBody List<Roles> rols) {
	rolRepository.saveAll(rols);
	return "Insercion Correcta";
	}
	

	@PutMapping("/Roles/{id}")
	public Roles updatestate(@PathVariable String id, @RequestBody Roles rolNew) {
		Roles roldb = rolRepository.findById(id).get();
	
		
		roldb.setId(rolNew.getId());
		roldb.setDesc_rol(rolNew.getDesc_rol());
		roldb.setEstado(rolNew.getEstado());
		
		rolRepository.save(roldb);
		return roldb;
	}

	@DeleteMapping("/Roles")
	public Roles deletestate(@RequestParam("Id") String id) {
		Roles roldb = rolRepository.findById(id).get();
		rolRepository.delete(roldb);
		return roldb;
	}

	//*// Query1
	//*@GetMapping("/Roless/{s}")
	//*public List<Roles> getfindByMarca(@PathVariable String s) {
	//*	return rolRepository.findByMarca(s);
	//*}

	// Query2
	//*@GetMapping("/Roless/{b}/{e}")
	//*public List<Roles> getfindByModelo(@PathVariable int b, @PathVariable int e) {
	//*return rolRepository.findByModelo(b,e);
	//*}
	
	// Load List of Roles
	//*@PostMapping("/RolesL")
	//*public String createstateList(@RequestBody List<Roles> Roles) {

	//*rolRepository.saveAll(Roles);
	//*return "done";
	//*}
}

