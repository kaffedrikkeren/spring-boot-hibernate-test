package ormtest.repositories;

import com.sun.tools.javac.util.List;
import ormtest.models.Thing;
import org.springframework.data.repository.CrudRepository;


/**
 * Created by amo on 14.04.18.
 */
public interface ThingRepository extends CrudRepository<Thing, Long> {

}
