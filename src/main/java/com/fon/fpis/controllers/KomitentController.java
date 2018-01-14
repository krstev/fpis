package com.fon.fpis.controllers;

import com.fon.fpis.entities.Komitent;
import com.fon.fpis.services.KomitentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author fkrstev
 * Created on 13-Jan-18
 */
@Controller
@RequestMapping(value = "/komitent")
public class KomitentController {

    @Autowired
    private KomitentService komitentService;

    @RequestMapping(value = "/")
    public String komitenti(Model model) {
        model.addAttribute("komitenti", komitentService.vratiKomitente());
        return "komitent";
    }

    @RequestMapping(value = "/forma", method = RequestMethod.GET)
    public String komitent(Model model, @RequestParam(value = "pib") Long pib) {
        Komitent komitent = komitentService.vratiKomitentaPoPibu(pib);
        if (komitent == null) {
            komitent = new Komitent();
        }
        model.addAttribute("komitent", komitent);
        return "unosIzmenaKomitent";
    }

    @RequestMapping(value = "/sacuvaj", method = RequestMethod.POST)
    public String dodajIzmeniKomitenta(Model model, @RequestParam(value = "pib") Long pib, @RequestParam(value = "naziv") String naziv, @RequestParam(value = "adresa") String adresa, @RequestParam(value = "telefon") String telefon, @RequestParam(value = "fax") String fax, @RequestParam(value = "website") String website, @RequestParam(value = "email") String email, @RequestParam(value = "registarskiBroj") String registarskiBroj, @RequestParam(value = "sifraDelatnosti") int sifraDelatnosti) {
        Komitent komitent = Komitent.builder()
                .pib(pib)
                .naziv(naziv)
                .adresa(adresa)
                .telefon(telefon)
                .fax(fax)
                .website(website)
                .email(email)
                .registarskiBroj(registarskiBroj)
                .sifraDelatnosti(sifraDelatnosti)
                .build();
        komitentService.sacuvajKomitenta(komitent);
        model.addAttribute("komitent", komitent);
        return "unosIzmenaKomitent";
    }

    @RequestMapping(value = "/obrisi", method = RequestMethod.POST)
    public String obrisiKomitenta(Model model, @RequestParam(value = "pib") Long pib) {
        komitentService.obrisiKomitenta(pib);
        return komitenti(model);
    }

}
