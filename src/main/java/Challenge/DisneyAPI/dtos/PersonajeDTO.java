package Challenge.DisneyAPI.dtos;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonajeDTO {

    private String id;
    private String img;
    private String nombre;
    private Integer edad;
    private Integer peso;
    private String historia;
    private List<PeliculaMinDTO> peliculas;

    public PersonajeDTO() {
    }

    public PersonajeDTO(String id, String img, String nombre, Integer edad, Integer peso, String historia, List<PeliculaMinDTO> peliculas) {
        this.id = id;
        this.img = img;
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.historia = historia;
        this.peliculas = peliculas;
    }

}
