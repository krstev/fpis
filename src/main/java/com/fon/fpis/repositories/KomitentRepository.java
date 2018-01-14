package com.fon.fpis.repositories;

import com.fon.fpis.entities.Komitent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

/**
 * @author fkrstev
 * Created on 12-Jan-18
 */
@Component
public interface KomitentRepository extends CrudRepository<Komitent, Long> {

}
