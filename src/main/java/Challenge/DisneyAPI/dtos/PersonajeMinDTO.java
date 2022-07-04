package Challenge.DisneyAPI.dtos;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class PersonajeMinDTO {

    private String id;
    private String img;
    private String nombre;

    public PersonajeMinDTO() {
    }

    public PersonajeMinDTO(String id, String img, String nombre) {
        this.id = id;
        this.img = img;
        this.nombre = nombre;
    }

}
