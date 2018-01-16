package com.fon.fpis.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author fkrstev
 * Created on 12-Jan-18
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
