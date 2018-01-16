package com.fon.fpis.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author fkrstev
 *         Created on 12-Jan-18
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ZahtevZaNabavku {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Builder.Default
    private Date kreiran = new Date();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "kreirao")
    private Radnik kreirao;

    @OneToMany(mappedBy = "zahtev")
    @Builder.Default
    private List<StavkaZahtevaZaNabavku> stavke = new ArrayList<>();
}
