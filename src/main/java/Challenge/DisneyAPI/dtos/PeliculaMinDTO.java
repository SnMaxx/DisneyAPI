package Challenge.DisneyAPI.dtos;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class PeliculaMinDTO {

    private String id;
    private String img;
    private String titulo;
    private Integer estreno;

    public PeliculaMinDTO() {
    }

    public PeliculaMinDTO(String id, String img, String titulo, Integer estreno) {
        this.id = id;
        this.img = img;
        this.titulo = titulo;
        this.estreno = estreno;
    }

    
}