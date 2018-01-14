package com.fon.fpis.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author fkrstev
 * Created on 12-Jan-18
 */
@Entity
@Data
public class ZahtevZaNabavku {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date kreiran;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "kreirao")
    private Radnik kreirao;

    @OneToMany(mappedBy = "zahtev")
    private List<StavkaZahtevaZaNabavku> stavke = new ArrayList<>();
}
