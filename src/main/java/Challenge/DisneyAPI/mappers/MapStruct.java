package Challenge.DisneyAPI.mappers;

import Challenge.DisneyAPI.dtos.*;
import Challenge.DisneyAPI.entidades.*;
import Challenge.DisneyAPI.model.UserMail;
import org.mapstruct.*;
import java.util.List;

@Mapper(componentModel = "spring")
public interface MapStruct {

    PersonajeDTO personajeToPersonajeDTO(Personaje personaje);

    PersonajeMinDTO personajeToPersonajeMinDTO(Personaje personaje);

    List<PersonajeDTO> personajesToPersonajeDTOs(List<Personaje> personajes);

    List<PersonajeMinDTO> personajesToPersonajeMinDTOs(List<Personaje> personajes);
    
    PeliculaDTO peliculaToPeliculaDTO(Pelicula pelicula);

    PeliculaMinDTO peliculaToPeliculaMinDTO(Pelicula pelicula);

    List<PeliculaDTO> peliculasToPeliculaDTOs(List<Pelicula> peliculas);

    List<PeliculaMinDTO> peliculasToPeliculaMinDTOs(List<Pelicula> peliculas);
    
    UserMail usuarioToUserMail(Usuario usuario);


}
