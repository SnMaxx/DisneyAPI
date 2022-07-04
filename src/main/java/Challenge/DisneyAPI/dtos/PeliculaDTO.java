package Challenge.DisneyAPI.dtos;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PeliculaDTO {

    private String id;
    private String img;
    private String titulo;
    private Integer estreno;
    private Integer calificacion;
    private List<PersonajeMinDTO> personajes;

    public PeliculaDTO() {
    }

    public PeliculaDTO(String id, String img, String titulo, Integer estreno, Integer calificacion, List<PersonajeMinDTO> personajes) {
        this.id = id;
        this.img = img;
        this.titulo = titulo;
        this.estreno = estreno;
        this.calificacion = calificacion;
        this.personajes = personajes;
    }

}