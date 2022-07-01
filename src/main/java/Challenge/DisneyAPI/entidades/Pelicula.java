package Challenge.DisneyAPI.entidades;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import org.hibernate.annotations.GenericGenerator;

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
    private List<Personaje> personajes;

    public Pelicula() {
    }

    public Pelicula(String img, String titulo, Integer estreno, Integer calificacion, List<Personaje> personajes) {
        this.img = img;
        this.titulo = titulo;
        this.estreno = estreno;
        this.calificacion = calificacion;
        this.personajes = personajes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public Integer getEstreno() {
        return estreno;
    }

    public void setEstreno(Integer estreno) {
        this.estreno = estreno;
    }

    public Integer getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Integer calificacion) {
        this.calificacion = calificacion;
    }

    public List<Personaje> getPersonajes() {
        return personajes;
    }

    public void setPersonajes(List<Personaje> personajes) {
        this.personajes = personajes;
    }

    @Override
    public String toString() {
        return "Pelicula{" + "id=" + id + ", img=" + img + ", titulo=" + titulo + ", estreno=" + estreno + ", calificacion=" + calificacion + ", personajes=" + personajes + '}';
    }

}
