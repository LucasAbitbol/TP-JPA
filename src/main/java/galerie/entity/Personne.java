package galerie.entity;

import lombok.*;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
@Entity
public class Personne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = false)
    @NonNull
    private String nom;

    @Column(unique = false)
    @NonNull
    private String adresse;

    private float budgetAnnuel;

    @OneToMany (mappedBy = "client")
    private List<Transaction> achats = new LinkedList<>();
    public List<Transaction> geTransactions() {
        return achats;
    }

    public float budget(int annee, Personne client) {
        this.budgetAnnuel = 0;
        for (Transaction t : achats) {
            if (t.getVenduLe().getYear() == annee && t.getClient().getId() == this.getId()) {
                this.budgetAnnuel += t.getPrixVente();
            }
        }
        return this.budgetAnnuel;
    }

}
