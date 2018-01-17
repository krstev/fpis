package com.fon.fpis.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author fkrstev
 * Created on 11-Jan-18
 */
@Entity
@Data
public class Radnik {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String ime;

    private String prezime;

    private String identifikacioniBroj;

    public String punoIme() {
        return ime + " " + prezime;
    }
}
