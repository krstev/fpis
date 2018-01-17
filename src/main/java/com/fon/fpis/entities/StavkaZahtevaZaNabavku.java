package com.fon.fpis.entities;

import lombok.*;

import javax.persistence.*;

/**
 * @author fkrstev
 * Created on 12-Jan-18
 */
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StavkaZahtevaZaNabavku {
    @Id
    private Long id;

    @OneToOne
    @JoinColumn(name = "artikal")
    private Artikal artikal;

    private int kolicina;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "zahtev")
    private ZahtevZaNabavku zahtev;

    @Transient
    private Long rb;
}
