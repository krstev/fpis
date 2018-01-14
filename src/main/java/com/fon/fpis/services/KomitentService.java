package com.fon.fpis.services;

import ch.qos.logback.core.encoder.EchoEncoder;
import com.fon.fpis.entities.Komitent;
import com.fon.fpis.repositories.KomitentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author fkrstev
 * Created on 13-Jan-18
 */
@Service
public class KomitentService {

    @Autowired
    private KomitentRepository komitentRepository;

    public List<Komitent> vratiKomitente() {
        return (List<Komitent>) komitentRepository.findAll();
    }

    public Komitent vratiKomitentaPoPibu(Long pib) {
        return komitentRepository.findOne(pib);
    }

    public void sacuvajKomitenta(Komitent komitent) {
        komitentRepository.save(komitent);
    }

    public boolean obrisiKomitenta(Long pib) {
        try {
            komitentRepository.delete(pib);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
