package br.com.starwars.business;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Component;

import br.com.starwars.entity.PlanetEntity;
import br.com.starwars.repository.PlanetRepository;
import javassist.NotFoundException;

@Component
public class PlanetBusiness {
	
	@Autowired
	private PlanetRepository planetRepository;

	public PlanetEntity findById(Long id) throws NotFoundException{
	    Optional<PlanetEntity> planetOptional = Optional.of(planetRepository.findOne(id));
	    planetOptional.orElseThrow(() -> new NotFoundException("No planet found with id " + id));
	    return planetOptional.get();
	}
	
	public List<PlanetEntity> findByName(String name) throws NotFoundException{
		PlanetEntity entity = new PlanetEntity();
		entity.setName(name);
		
		final ExampleMatcher matcher = ExampleMatcher.matching() //
				.withIgnoreCase() //
				.withIgnoreNullValues() //
				.withMatcher("name", match -> match.contains());

		final Example<PlanetEntity> example = Example.of(entity, matcher);

	    Optional<List<PlanetEntity>> planetOptionalLst = Optional.of(planetRepository.findAll(example));
	    planetOptionalLst.orElseThrow(() -> new NotFoundException("No planet found with name " + name));
	    
	    return planetOptionalLst.get();
	}

	public List<PlanetEntity> findAll() throws NotFoundException{
	    Optional<List<PlanetEntity>> planetOptionalLst = Optional.of(planetRepository.findAll());
	    planetOptionalLst.orElseThrow(() -> new NotFoundException("No planet found"));
	    return planetOptionalLst.get();
	}
	
	public PlanetEntity save(PlanetEntity entity) throws Exception {
		if(validateRequiredAttributes(entity))
			return planetRepository.save(entity);
		return null;
	}

	private boolean validateRequiredAttributes(PlanetEntity entity) throws Exception {
		if(entity.getName() == null)
			throw new Exception("Attribute name required.");
		else if(!findByName(entity.getName()).isEmpty())
			throw new Exception("Planet with name informed already exists.");
 
		if(entity.getClimate() == null)
			throw new Exception("Attribute climate required.");

		if(entity.getGround() == null)
			throw new Exception("Attribute ground required.");

		if(entity.getMovieAppearancesNumber() == null)
			throw new Exception("Attribute movie appearances number required.");
		  
		return true;
	}
	
	public void delete(Long id) throws NotFoundException{
	    Optional<PlanetEntity> planetOptional = Optional.of(findById(id));
	    planetOptional.orElseThrow(() -> new NotFoundException("No planet found with id " + id));
		planetRepository.delete(id);
	}
	
}
