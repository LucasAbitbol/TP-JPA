package galerie.entity;

import lombok.*;
import javax.persistence.*;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
@Entity

public class Exposition {

    private float sommmeVentes;

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = false)
    @NonNull
    private LocalDate debut;

    @Column(unique = false)
    @NonNull
    private String intitule;

    @Column(unique = false)
    @NonNull
    private int duree;

    @ManyToMany
    private List<Tableau> oeuvres = new LinkedList<>();

    @OneToMany (mappedBy = "lieuDeVente")
    private List<Transaction> ventes = new LinkedList<>();
    public List<Transaction> getTransactions() {
        return ventes;
    }

    @ManyToOne
    private Galerie organisateur;

    public float chiffreAffairePour(Integer id) {
        this.sommmeVentes = 0;
        for (Transaction v : ventes) {
            if (v.getLieuDeVente().id == id) {
                this.sommmeVentes += v.getPrixVente();
            }

        }
        return this.sommmeVentes;
    }

    }


