package galerie.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = false)
    @NonNull
    private Date venduLe;

    @Column(unique = false)
    @NonNull
    private float prixVente;

    @ManyToOne
    private Exposition lieuDeVente;

    @OneToOne
    private Tableau oeuvre;

    @ManyToOne
    private Personne client;

    public Date getVenduLe() {
        return venduLe;
    }
}
