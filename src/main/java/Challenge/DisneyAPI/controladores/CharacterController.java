package Challenge.DisneyAPI.controladores;

import Challenge.DisneyAPI.entidades.Personaje;
import Challenge.DisneyAPI.dtos.PersonajeDTO;
import Challenge.DisneyAPI.dtos.PersonajeMinDTO;
import Challenge.DisneyAPI.mappers.MapStruct;
import Challenge.DisneyAPI.servicios.PeliculaServicio;
import Challenge.DisneyAPI.servicios.PersonajeServicio;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/characters")
public class CharacterController {
    
    @Autowired
    private MapStruct mapperStruct;
    
    @Autowired
    private PersonajeServicio pjServ;
    
    @Autowired
    private PeliculaServicio peliServ;
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PersonajeDTO crearPersonaje(@RequestBody Personaje pj){
        return mapperStruct.personajeToPersonajeDTO(pjServ.crearPersonaje(pj));
    }
    
    @PutMapping("/{id}")
    public PersonajeDTO editarPersonaje(@PathVariable String id, @RequestBody Personaje pj) throws Exception{
        return mapperStruct.personajeToPersonajeDTO(pjServ.editarPersonaje(id,pj));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity borrarPersonaje(@PathVariable String id){
        pjServ.borrarPersonaje(id);
        return ResponseEntity.ok().build();
    }
    
    @GetMapping
    public List<PersonajeMinDTO> personajes(@RequestParam Optional<String> name, @RequestParam Optional<Integer> age, @RequestParam Optional<Integer> peso, @RequestParam Optional<String> movies) throws Exception{
        if(name.isPresent())
            return mapperStruct.personajesToPersonajeMinDTOs(pjServ.buscarPorNombre(name.get())) ;
        if(age.isPresent())
            return mapperStruct.personajesToPersonajeMinDTOs(pjServ.buscarPorEdad(age.get()));
        if(age.isPresent())
            return mapperStruct.personajesToPersonajeMinDTOs(pjServ.buscarPorPeso(peso.get()));
        if(movies.isPresent())
            return mapperStruct.personajesToPersonajeMinDTOs(pjServ.buscarPorPelicula(peliServ.buscarPorId(movies.get())));
        return mapperStruct.personajesToPersonajeMinDTOs(pjServ.traerTodo());
    }
    
    @GetMapping("/{id}")
    public PersonajeDTO personaje(@PathVariable String id) throws Exception{
        return mapperStruct.personajeToPersonajeDTO(pjServ.buscarPorId(id));
    }
}
