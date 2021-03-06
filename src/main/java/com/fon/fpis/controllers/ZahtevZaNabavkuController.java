package com.fon.fpis.controllers;

import com.fon.fpis.entities.Artikal;
import com.fon.fpis.entities.Radnik;
import com.fon.fpis.entities.StavkaZahtevaZaNabavku;
import com.fon.fpis.entities.ZahtevZaNabavku;
import com.fon.fpis.services.ZahtevZaNabavkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * Created by fkrstev on 1/15/18.
 */
@Controller
@RequestMapping(value = "/zahtev")
public class ZahtevZaNabavkuController {

    @Autowired
    private ZahtevZaNabavkuService zahtevZaNabavkuService;

    @RequestMapping(value = {"/", ""})
    public String zahtevi(Model model) {
        model.addAttribute("zahtevi", zahtevZaNabavkuService.vratiZahteve());
        return "zahtevZaNabavku";
    }

    @RequestMapping(value = "/forma", method = RequestMethod.GET)
    public String zahtev(Model model, HttpSession session, @RequestParam(value = "id", required = false, defaultValue = "0") Long id) {
        ZahtevZaNabavku zahtevZaNabavku = zahtevZaNabavkuService.vratiZahtevPoId(id);
        if (zahtevZaNabavku == null) {
            zahtevZaNabavku = ZahtevZaNabavku.builder().build();
        }
        session.setAttribute("zahtev", zahtevZaNabavku);
        return zahtev(model, zahtevZaNabavku);
    }

    @RequestMapping(value = "/zahtev", method = RequestMethod.GET)
    public String zahtev(Model model, ZahtevZaNabavku zahtevZaNabavku) {
        model.addAttribute("zahtev", zahtevZaNabavku);
        model.addAttribute("radnici", zahtevZaNabavkuService.vratiRadnike());
        return "unosIzmenaZahtevaZaNabavku";
    }

    @RequestMapping(value = "/stavkaForma", method = RequestMethod.GET)
    public String stavka(Model model, HttpSession session, @RequestParam(value = "rb", required = false, defaultValue = "-1") int rb) {
        ZahtevZaNabavku zahtevZaNabavku = (ZahtevZaNabavku) session.getAttribute("zahtev");
        StavkaZahtevaZaNabavku stavkaZahtevaZaNabavku;
        if (rb == -1) {
            stavkaZahtevaZaNabavku = new StavkaZahtevaZaNabavku();
            stavkaZahtevaZaNabavku.setZahtev(zahtevZaNabavku);
        } else {
            stavkaZahtevaZaNabavku = zahtevZaNabavku.getStavke().get(rb);
            stavkaZahtevaZaNabavku.setRb((long) rb);
        }
        model.addAttribute("stavka", stavkaZahtevaZaNabavku);
        model.addAttribute("artikli", zahtevZaNabavkuService.vratiArtikle());
        return "stavka";
    }


    @RequestMapping(value = "/sacuvajStavku", method = RequestMethod.POST)
    public String dodajIzmeniStavku(Model model, HttpSession session, @RequestParam(value = "kolicina") int kolicina, @RequestParam(value = "artikal") Long artikalId, @RequestParam(value = "rb", required = false) Long rb) {
        ZahtevZaNabavku zahtevZaNabavku = (ZahtevZaNabavku) session.getAttribute("zahtev");
        Artikal artikal = zahtevZaNabavkuService.vratiProizvod(artikalId);
        if (rb != null) {
            StavkaZahtevaZaNabavku stavkaZahtevaZaNabavku = zahtevZaNabavku.getStavke().get(rb.intValue());
            stavkaZahtevaZaNabavku.setKolicina(kolicina);
            stavkaZahtevaZaNabavku.setArtikal(artikal);
        } else {
            StavkaZahtevaZaNabavku stavkaZahtevaZaNabavku =
                    StavkaZahtevaZaNabavku.builder()
                            .artikal(artikal)
                            .kolicina(kolicina)
                            .zahtev(zahtevZaNabavku)
                            .build();
            zahtevZaNabavku.getStavke().add(stavkaZahtevaZaNabavku);
        }
        return zahtev(model, zahtevZaNabavku);
    }

    @RequestMapping(value = "/obrisiStavku", method = RequestMethod.POST)
    public String obrisiStavku(Model model, HttpSession session, @RequestParam(value = "rb") int rb) {
        ZahtevZaNabavku zahtevZaNabavku = (ZahtevZaNabavku) session.getAttribute("zahtev");
        StavkaZahtevaZaNabavku stavkaZahtevaZaNabavku = zahtevZaNabavku.getStavke().remove(rb);
        if (zahtevZaNabavku.getId() != null && stavkaZahtevaZaNabavku.getId() != null) {
            zahtevZaNabavku.getStavkeZaBrisanje().add(stavkaZahtevaZaNabavku);
        }
        return zahtev(model, zahtevZaNabavku);
    }

    @RequestMapping(value = "/sacuvaj", method = RequestMethod.POST)
    public String sacuvajZahtev(Model model, HttpSession session, @RequestParam(value = "radnikId") Long radnikId, @RequestParam(value = "identifikacioniBroj") String identifikacioniBroj) {
        ZahtevZaNabavku zahtevZaNabavku = (ZahtevZaNabavku) session.getAttribute("zahtev");
        Radnik zap = zahtevZaNabavkuService.vratiRadnika(radnikId);
        if (zahtevZaNabavkuService.proveri(zap, identifikacioniBroj)) {
            zahtevZaNabavku.setKreirao(zap);
            zahtevZaNabavkuService.sacuvajZahtevZaNabaku(zahtevZaNabavku);
        }
        return zahtevi(model);
    }

    @RequestMapping(value = "/obrisi", method = RequestMethod.POST)
    public String obrisiKomitenta(Model model, @RequestParam(value = "id") Long id) {
        zahtevZaNabavkuService.obrisiZahtevZaNabavku(id);
        return zahtevi(model);
    }
}
