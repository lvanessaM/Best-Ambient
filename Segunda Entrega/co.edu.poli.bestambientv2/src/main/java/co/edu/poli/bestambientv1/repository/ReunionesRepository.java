package co.edu.poli.bestambientv1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.poli.bestambientv1.modelo.Reuniones;

public interface ReunionesRepository extends JpaRepository<Reuniones, String>{

	
	/*@Query(value = "SELECT usuario , nickname , admission_number FROM estados s where s.capital_city LIKE %?1% ORDER BY capital_city DESC", nativeQuery = true)
    List<String> findByPublicaciones(String s) ; */
	
	}



