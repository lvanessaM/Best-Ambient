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

import co.edu.poli.bestambientv1.modelo.Usuario;
import co.edu.poli.bestambientv1.repository.UsuarioRepository;



@RestController // Defines that this class is a spring bean
@RequestMapping("/api/v1/")
public class UsuarioController {
	@Autowired
	private UsuarioRepository usuarioRepository;

	@GetMapping("/usuario")
	public List<Usuario> getAllStates() {
		// The stateRepository is already injected and you can use it
		return usuarioRepository.findAll();
	}
	@GetMapping("/usuario/{id}")
	public Usuario getstateById(@PathVariable String id) {
		Usuario usuario = usuarioRepository.findById(id).get();
		return usuario;
	}

	@PostMapping("/usuario")
	public Usuario createstate(@RequestBody Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	@PostMapping("/usuarios")
	public String createStateList(@RequestBody List<Usuario> usuarios) {
		usuarioRepository.saveAll(usuarios);
	return "Insercion Correcta";
	}
	
	@PutMapping("/usaurio/{id}")
	public Usuario updateusuario(@PathVariable String id, @RequestBody Usuario usuarioNew) {
		Usuario usuariodb = usuarioRepository.findById(id).get();
		
		usuariodb.setId(usuarioNew.getId());
		usuariodb.setNombre(usuarioNew.getNombre());
		usuariodb.setApellidos(usuarioNew.getApellidos());
		usuariodb.setEdad(usuarioNew.getEdad());
		usuariodb.setGenero(usuarioNew.getGenero());
		usuariodb.setCorreo_electronico(usuarioNew.getCorreo_electronico());
		usuariodb.setContraseña(usuarioNew.getContraseña());
		usuariodb.setRoles(usuarioNew.getRoles());
		usuariodb.setEstado(usuarioNew.getEstado());
	
		usuarioRepository.save(usuariodb);
		return usuariodb;
	
}
	@DeleteMapping("/usuario")
	public Usuario borrarusuario(@RequestParam("Id") String id) {
		Usuario usuariodb = usuarioRepository.findById(id).get();
		usuarioRepository.delete(usuariodb);
		return usuariodb;
	}

}