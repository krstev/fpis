package com.fon.wsfpis.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author fkrstev
 * Created on 11-Jan-18
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Komitent {
    @Id
    private Long pib;

    private String naziv;

    private String adresa;

    private String telefon;

    private String fax;

    private String website;

    private String email;

    private String registarskiBroj;

    private int sifraDelatnosti;
}
