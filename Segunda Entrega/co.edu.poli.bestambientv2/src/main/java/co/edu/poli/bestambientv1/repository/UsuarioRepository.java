package co.edu.poli.bestambientv1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.poli.bestambientv1.modelo.Usuario;

public interface UsuarioRepository  extends JpaRepository<Usuario, String>{

}
