package co.edu.poli.bestambientv1.repository;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.edu.poli.bestambientv1.modelo.Publicaciones;

public interface PublicacionesRepository extends JpaRepository<Publicaciones, String>{

	
	/*@Query(value = "SELECT usuario , nickname , admission_number FROM estados s where s.capital_city LIKE %?1% ORDER BY capital_city DESC", nativeQuery = true)
    List<String> findByPublicaciones(String s) ; */
	
	}




