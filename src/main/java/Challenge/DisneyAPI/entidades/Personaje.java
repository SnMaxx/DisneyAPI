package Challenge.DisneyAPI.entidades;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

@Getter
@Setter
@ToString
@Entity
public class Personaje {
    
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String img;
    private String nombre;
    private Integer edad;
    private Integer peso;
    private String historia;
    
    @ManyToMany(mappedBy = "personajes")
    private Set<Pelicula> peliculas = new HashSet<>();

    public Personaje() {
    }

    public Personaje(String img, String nombre, Integer edad, Integer peso, String historia, Set<Pelicula> peliculas) {
        this.img = img;
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.historia = historia;
        this.peliculas = peliculas;
    }

}
