package br.com.starwars.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.starwars.business.PlanetBusiness;
import br.com.starwars.entity.PlanetEntity;
import javassist.NotFoundException;

/**
 * @author: Gustavo Silva Coelho
 */

@RestController
@RequestMapping("/planets")
public class PlanetController {

  @Autowired	
  private PlanetBusiness planetBusiness;

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public PlanetEntity findById(@PathVariable Long id) throws NotFoundException {
    return planetBusiness.findById(id);
  }
  
  @RequestMapping(value = "/{name}", method = RequestMethod.GET)
  public List<PlanetEntity> findByName(@PathVariable String name) throws NotFoundException {
	return planetBusiness.findByName(name); 
  }

  @RequestMapping(value = "/all", method = RequestMethod.GET)
  public List<PlanetEntity> findAll() throws NotFoundException {
	  return planetBusiness.findAll();
  }

  @RequestMapping(value = "/save", method = RequestMethod.POST)
  public PlanetEntity save(@RequestBody PlanetEntity entity) throws Exception{
    return planetBusiness.save(entity);
  }

  @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
  public void delete(@PathVariable Long id) throws NotFoundException{
     planetBusiness.delete(id);
  }
  
}