package br.com.starwars.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.starwars.entity.PlanetEntity;

@Repository
public interface PlanetRepository extends JpaRepository<PlanetEntity, Long> { 
	
}
