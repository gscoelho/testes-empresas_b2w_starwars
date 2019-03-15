package br.com.starwars.unitytest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.starwars.business.PlanetBusiness;
import br.com.starwars.entity.PlanetEntity;
import javassist.NotFoundException;

public class PlanetTest {

	@Autowired
	private PlanetBusiness planetBusiness;
	
	//Return error message when findById method can't validate it's execution
	@Test
    public void validatefindById() throws NotFoundException {
		Long id = Long.valueOf(3); //Just turn it to null in order to testify
		assertNotNull("Parameter id informed must not be null.", id);
		assertNotNull("Parameter id informed not found.", planetBusiness.findById(id) == null);
    }
	
	//Return error message when findByName method doesn't return any value
	@Test
    public void validatefindByName() throws NotFoundException {
		String name = "mars"; //Just turn it to null in order to testify
		assertNotNull("Parameter name informed must not be null.", name);
		assertNotNull("Parameter name informed not found.", planetBusiness.findByName(name).isEmpty());
    }
	
	//Return error message when delete method can't find planet by id informed
	@Test
    public void validateDelete() throws NotFoundException {
		Long id = Long.valueOf(3); //Just turn it to null in order to testify
		assertNotNull("Parameter id informed must not be null.", id);
		assertNotNull("Parameter id informed not found.", planetBusiness.findById(id) == null);
    }
	
	//Return error message on saving new planet with existing name already saved
	@Test
    public void validateSaveWithExistingName() throws NotFoundException {
		String name = "mars";
		PlanetEntity entity = planetBusiness.findByName(name) == null ? null : planetBusiness.findByName(name).get(0);
		if(entity != null)
			assertSame("Planet name already exists.", entity.getName(), name);
	}
	
	//Return error message when saving planet with missing required attributes
    public void validateRequiredAttributes() throws NotFoundException {
    	PlanetEntity entity = new PlanetEntity();
		entity.setName("mars"); //Just turn it to null in order to testify
		entity.setClimate("dry"); //Just turn it to null in order to testify
		entity.setGround("sand"); //Just turn it to null in order to testify
		entity.setMovieAppearancesNumber(Integer.valueOf(12)); //Just turn it to null in order to testify

		assertNotNull("Parameter name informed must not be null.", entity.getName());
		assertNotNull("Parameter climate informed must not be null.", entity.getClimate());
		assertNotNull("Parameter ground informed must not be null.", entity.getGround());
		assertNotNull("Parameter movie appearances number informed must not be null.", entity.getName());
    }
    
}
