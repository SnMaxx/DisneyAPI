package Challenge.DisneyAPI.entidades;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

@Getter
@Setter
@ToString
@Entity
public class Pelicula {
    
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String img;
    private String titulo;
    private Integer estreno;
    private Integer calificacion;
    
    @ManyToMany
    @JoinTable(
    name = "personaje_pelicula",
    joinColumns = @JoinColumn(name = "pelicula_id"),
    inverseJoinColumns = @JoinColumn(name = "personaje_id"))
    private Set<Personaje> personajes = new HashSet<>();

    public Pelicula() {
    }

    public Pelicula(String img, String titulo, Integer estreno, Integer calificacion, Set<Personaje> personajes) {
        this.img = img;
        this.titulo = titulo;
        this.estreno = estreno;
        this.calificacion = calificacion;
        this.personajes = personajes;
    }
    
}
