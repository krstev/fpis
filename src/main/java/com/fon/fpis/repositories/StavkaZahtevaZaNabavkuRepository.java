package com.fon.fpis.repositories;

import com.fon.fpis.entities.StavkaZahtevaZaNabavku;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

/**
 * @author fkrstev
 * Created on 13-Jan-18
 */
@Component
public interface StavkaZahtevaZaNabavkuRepository extends CrudRepository<StavkaZahtevaZaNabavku, Long> {
}
