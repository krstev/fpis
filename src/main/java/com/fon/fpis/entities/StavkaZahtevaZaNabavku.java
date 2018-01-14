package com.fon.fpis.entities;

import lombok.Data;

import javax.persistence.*;

/**
 * @author fkrstev
 * Created on 12-Jan-18
 */
@Entity
@Data
public class StavkaZahtevaZaNabavku {
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    @JoinColumn(name = "artikal")
    private Artikal artikal;

    private int kolicina;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "zahtev")
    private ZahtevZaNabavku zahtev;
}
