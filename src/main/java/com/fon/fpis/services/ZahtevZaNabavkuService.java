package com.fon.fpis.services;

import com.fon.fpis.entities.Artikal;
import com.fon.fpis.entities.Komitent;
import com.fon.fpis.entities.Radnik;
import com.fon.fpis.entities.ZahtevZaNabavku;
import com.fon.fpis.repositories.ArtikalRepository;
import com.fon.fpis.repositories.RadnikRepository;
import com.fon.fpis.repositories.StavkaZahtevaZaNabavkuRepository;
import com.fon.fpis.repositories.ZahtevZaNabavkuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fkrstev on 1/15/18.
 */
@Service
public class ZahtevZaNabavkuService {

    @Autowired
    private ZahtevZaNabavkuRepository zahtevZaNabavkuRepository;

    @Autowired
    private StavkaZahtevaZaNabavkuRepository stavkaZahtevaZaNabavkuRepository;

    @Autowired
    private RadnikRepository radnikRepository;

    @Autowired
    private ArtikalRepository artikalRepository;

    public List<ZahtevZaNabavku> vratiZahteve() {
        return (List<ZahtevZaNabavku>) zahtevZaNabavkuRepository.findAll();
    }

    public ZahtevZaNabavku vratiZahtevPoId(Long id) {
        return zahtevZaNabavkuRepository.findOne(id);
    }

    public Radnik vratiRadnika(Long radnikId) {
        return radnikRepository.findOne(radnikId);
    }

    public Artikal vratiProizvod(Long artikal) {
        return artikalRepository.findOne(artikal);
    }

    public void sacuvajZahtevZaNabaku(ZahtevZaNabavku zahtevZaNabavku) {
        zahtevZaNabavkuRepository.save(zahtevZaNabavku);
    }

    public void obrisiZahtevZaNabavku(Long id) {
        zahtevZaNabavkuRepository.delete(id);
    }

    public List<Artikal> vratiArtikle() {
        return (List<Artikal>) artikalRepository.findAll();
    }
}
