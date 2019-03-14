package br.com.starwars.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.starwars.entitys.PlanetEntity;
import br.com.starwars.repository.PlanetRepository;

@Component
public class PlanetBusiness {
	
	@Autowired
	private PlanetRepository planetRepository;

	public PlanetEntity findById(Long id){
		return planetRepository.findOne(id);		
	}
	
	public List<PlanetEntity> findAll(){
		return planetRepository.findAll();
	}
	
	public PlanetEntity save(PlanetEntity entity) {
		return planetRepository.save(entity);
	}
	
	public void delete(Long id) {
		planetRepository.delete(id);
	}
	
}
