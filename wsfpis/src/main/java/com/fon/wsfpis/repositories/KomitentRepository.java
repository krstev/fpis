package com.fon.wsfpis.repositories;

import com.fon.wsfpis.entities.Komitent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

/**
 * @author fkrstev
 * Created on 12-Jan-18
 */
@Component
public interface KomitentRepository extends CrudRepository<Komitent, Long> {

}
