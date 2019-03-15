package br.com.starwars.business;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Example;
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
	
	public List<PlanetEntity> findByName(String name){
		PlanetEntity entity = new PlanetEntity();
		entity.setName(name);
		
		final ExampleMatcher matcher = ExampleMatcher.matching() //
				.withIgnoreCase() //
				.withIgnoreNullValues() //
				.withMatcher("name", match -> match.contains());

		final Example<PlanetEntity> example = Example.of(entity, matcher);

		return planetRepository.findAll(example);		
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
