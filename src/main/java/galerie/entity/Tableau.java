package galerie.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
@Entity
public class Tableau {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = false)
    @NonNull
    private String titre;

    @Column(unique = false)
    @NonNull
    private String support;

    @Column(unique = false)
    @NonNull
    private int largeur;

    @Column(unique = false)
    @NonNull
    private int hauteur;

    @ManyToMany (mappedBy = "oeuvres")
    private List<Exposition> accrochage = new LinkedList<>();

    @OneToOne (mappedBy = "oeuvre")
    private Transaction vendu;

    @ManyToOne
    private Artiste auteur;
}
