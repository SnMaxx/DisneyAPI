package Challenge.DisneyAPI.entidades;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Genero {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String nombre;
    private String img;
    @OneToMany
    private List<Pelicula> peliculas;

    public Genero() {
    }

    public Genero(String nombre, String img, List<Pelicula> peliculas) {
        this.nombre = nombre;
        this.img = img;
        this.peliculas = peliculas;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public List<Pelicula> getPeliculas() {
        return peliculas;
    }

    public void setPeliculas(List<Pelicula> peliculas) {
        this.peliculas = peliculas;
    }

    @Override
    public String toString() {
        return "Genero{" + "id=" + id + ", nombre=" + nombre + ", img=" + img + ", peliculas=" + peliculas + '}';
    }
    
}
