package ormtest.controllers;


import com.sun.tools.javac.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ormtest.models.Thing;
import ormtest.repositories.ThingRepository;

/**
 * Created by amo on 12.04.18.
 */
@RestController
public class ThingController {

  @Autowired
  ThingRepository thingRepository;

  @RequestMapping(value = "/things", method = RequestMethod.GET)
  public @ResponseBody Iterable<Thing> products() {
    return thingRepository.findAll();
  }


}
