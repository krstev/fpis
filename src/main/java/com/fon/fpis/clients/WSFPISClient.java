package com.fon.fpis.clients;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author fkrstev
 * Created on 17-Jan-18
 */
@FeignClient(name = "wsfpis", url = "http://localhost:5001")
public interface WSFPISClient {

    @RequestMapping(method = RequestMethod.POST, value = "/komitent/sacuvaj")
    boolean sacuvaj(@RequestParam(value = "pib") Long pib, @RequestParam(value = "naziv") String naziv, @RequestParam(value = "adresa", required = false) String adresa, @RequestParam(value = "telefon", required = false) String telefon, @RequestParam(value = "fax", required = false) String fax, @RequestParam(value = "website", required = false) String website, @RequestParam(value = "email", required = false) String email, @RequestParam(value = "registarskiBroj") String registarskiBroj, @RequestParam(value = "sifraDelatnosti") int sifraDelatnosti);

}
