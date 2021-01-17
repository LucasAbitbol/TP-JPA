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
public class Artiste extends Personne{

    @Column(unique = true)
    @NonNull
    private String biographie;

    @OneToMany (mappedBy = "auteur")
    private List<Tableau> oeuvres = new LinkedList<>();
    public List<Tableau> getTableaux() {
        return oeuvres;
    }

}
