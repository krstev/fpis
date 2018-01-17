package com.fon.wsfpis.services;


import com.fon.wsfpis.entities.Komitent;
import com.fon.wsfpis.repositories.KomitentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author fkrstev
 * Created on 13-Jan-18
 */
@Service
public class KomitentService {

    @Autowired
    private KomitentRepository komitentRepository;

    public void sacuvajKomitenta(Komitent komitent) {
        komitentRepository.save(komitent);
    }

}
