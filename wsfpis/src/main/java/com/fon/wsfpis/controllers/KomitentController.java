package com.fon.wsfpis.controllers;

import com.fon.wsfpis.entities.Komitent;
import com.fon.wsfpis.services.KomitentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fkrstev
 * Created on 17-Jan-18
 */
@RestController
public class KomitentController {

    @Autowired
    private KomitentService komitentService;

    @RequestMapping(value = "/komitent/sacuvaj", method = RequestMethod.POST)
    public boolean dodajIzmeniKomitenta(@RequestParam(value = "pib") Long pib, @RequestParam(value = "naziv") String naziv, @RequestParam(value = "adresa", required = false) String adresa, @RequestParam(value = "telefon", required = false) String telefon, @RequestParam(value = "fax", required = false) String fax, @RequestParam(value = "website", required = false) String website, @RequestParam(value = "email", required = false) String email, @RequestParam(value = "registarskiBroj") String registarskiBroj, @RequestParam(value = "sifraDelatnosti") int sifraDelatnosti) {
        try {
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
            return true;
        } catch (Exception ignored) {
        }
        return false;
    }
}
