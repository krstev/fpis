package com.fon.fpis.repositories;

import com.fon.fpis.entities.StavkaZahtevaZaNabavku;
import com.fon.fpis.entities.ZahtevZaNabavku;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

/**
 * @author fkrstev
 * Created on 13-Jan-18
 */
@Component
public interface StavkaZahtevaZaNabavkuRepository extends CrudRepository<StavkaZahtevaZaNabavku, Long> {

    void deleteByZahtev(ZahtevZaNabavku zahtev);

    @Query("SELECT max(s.id) FROM StavkaZahtevaZaNabavku s")
    Long newRB();
}
