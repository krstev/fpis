package com.fon.fpis.repositories;

import com.fon.fpis.entities.Artikal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

/**
 * @author fkrstev
 * Created on 12-Jan-18
 */
@Component
public interface ArtikalRepository extends CrudRepository<Artikal, Long> {
}
