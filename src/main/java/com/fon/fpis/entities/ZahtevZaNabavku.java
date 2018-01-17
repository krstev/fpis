package com.fon.fpis.entities;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author fkrstev
 * Created on 12-Jan-18
 */
@Data
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ZahtevZaNabavku {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Builder.Default
    private Date kreiran = new Date();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "kreirao")
    private Radnik kreirao;

    @OneToMany(mappedBy = "zahtev")
    @Builder.Default
    private List<StavkaZahtevaZaNabavku> stavke = new ArrayList<>();

    @Transient
    @Builder.Default
    private List<StavkaZahtevaZaNabavku> stavkeZaBrisanje = new ArrayList<>();

    public List<StavkaZahtevaZaNabavku> getStavkeZaBrisanje() {
        if (stavkeZaBrisanje == null) {
            stavkeZaBrisanje = new ArrayList<>();
        }
        return stavkeZaBrisanje;
    }
}
