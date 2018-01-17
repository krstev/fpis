package com.fon.fpis.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * @author fkrstev
 * Created on 11-Jan-18
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Artikal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long kataloskiBroj;

    private String naziv;

    private String opis;

    private BigDecimal cena;

    private int stanjeNaLageru;

    private int naruceno;

    private int rezervisano;

    private int otpremljeno;

    private int vracenoKomitentu;

    private int izdato;

    private int prodato;

    private int reklamirano;
}
