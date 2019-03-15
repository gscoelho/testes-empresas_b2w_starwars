package br.com.starwars.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.starwars.business.PlanetBusiness;
import br.com.starwars.entitys.PlanetEntity;

/**
 * @author: Gustavo Silva Coelho
 * @date: 15/03/2019 
 */

@RestController
@RequestMapping("/planets")
public class PlanetController {

  @Autowired	
  private PlanetBusiness planetBusiness;

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public PlanetEntity findById(@PathVariable Long id){
    return planetBusiness.findById(id);
  }
  
  @RequestMapping(value = "/all", method = RequestMethod.GET)
  public List<PlanetEntity> findAll(){
    return planetBusiness.findAll();
  }

  @RequestMapping(value = "/save", method = RequestMethod.POST)
  public PlanetEntity save(@RequestBody PlanetEntity entity){
    return planetBusiness.save(entity);
  }

  @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
  public void delete(@PathVariable Long id){
     planetBusiness.delete(id);
  }
  
}