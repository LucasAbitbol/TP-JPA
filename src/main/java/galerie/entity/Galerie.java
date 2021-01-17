package galerie.entity;
import javax.persistence.*;
import lombok.*;

import java.util.LinkedList;
import java.util.List;

// Un exemple d'entité
// On utilise Lombok pour auto-générer getter / setter / toString...
// cf. https://examples.javacodegeeks.com/spring-boot-with-lombok/
@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @ToString
@Entity // Une entité JPA
public class Galerie {
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id;

    @Column(unique=false)
    @NonNull
    private String nom;
    
    @Column(unique=true)
    @NonNull
    private String adresse;

    private float chiffreAffaireAnnuel;

    @OneToMany (mappedBy = "organisateur")
    private List<Exposition> evenements = new LinkedList<>();
    public List<Exposition> getExpositions() {
        return evenements;
    }

    public float CAannuel(int annee) {
        this.chiffreAffaireAnnuel = 0;
        for (Exposition e : evenements) {
            if (e.getDebut().getYear() == annee) {
                this.chiffreAffaireAnnuel += e.chiffreAffairePour(this.id);
            }
        }
        return this.chiffreAffaireAnnuel;
    }
}