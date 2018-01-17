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
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public void sacuvajZahtevZaNabaku(ZahtevZaNabavku zahtevZaNabavku) {
        zahtevZaNabavkuRepository.save(zahtevZaNabavku);
        sacuvajStavke(zahtevZaNabavku);
    }

    private void sacuvajStavke(ZahtevZaNabavku zahtevZaNabavku) {
        zahtevZaNabavku.getStavke().stream().forEach(stavka -> {
            if (stavka.getId() == null) {
                Long newRB = newRB();
                stavka.setId(newRB);
            }
            stavkaZahtevaZaNabavkuRepository.save(stavka);
        });
        zahtevZaNabavku.getStavkeZaBrisanje().stream().forEach(stavka -> stavkaZahtevaZaNabavkuRepository.delete(stavka));
    }

    private Long newRB() {
        return stavkaZahtevaZaNabavkuRepository.newRB() != null ? stavkaZahtevaZaNabavkuRepository.newRB() + 1 : 1;
    }

    @Transactional
    public void obrisiZahtevZaNabavku(Long id) {
        ZahtevZaNabavku zahtevZaNabavku = zahtevZaNabavkuRepository.findOne(id);
        stavkaZahtevaZaNabavkuRepository.deleteByZahtev(zahtevZaNabavku);
        zahtevZaNabavkuRepository.delete(zahtevZaNabavku);
    }

    public List<Artikal> vratiArtikle() {
        return (List<Artikal>) artikalRepository.findAll();
    }

    public List<Radnik> vratiRadnike() {
        return (List<Radnik>) radnikRepository.findAll();
    }

    public boolean proveri(Radnik zap, String identifikacionihBroj) {
        return zap.getIdentifikacioniBroj().equals(identifikacionihBroj.trim());
    }
}
