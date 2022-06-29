package Challenge.DisneyAPI.controladores;

import Challenge.DisneyAPI.entidades.Pelicula;
import Challenge.DisneyAPI.entidades.Personaje;
import Challenge.DisneyAPI.servicios.PeliculaServicio;
import Challenge.DisneyAPI.servicios.PersonajeServicio;
import java.util.List;
import java.util.Optional;
import javax.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/characters")
public class CharacterController {

    @Autowired
    private PersonajeServicio pjServ;
    
    @Autowired
    private PeliculaServicio peliServ;
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Personaje crearPersonaje(@RequestBody Personaje pj){
        return pjServ.crearPersonaje(pj);
    }
    
    @PutMapping("/{id}")
    public Personaje editarPersonaje(@PathVariable String id, @RequestBody Personaje pj) throws Exception{
        return pjServ.editarPersonaje(id,pj);
    }
    
    @GetMapping
    public List<Personaje> personajes(@RequestParam Optional<String> name,@RequestParam Optional<Integer> age,@RequestParam Optional<String> movies) throws Exception{
        if(name.isPresent())
            return pjServ.findByNombre(name.get());
        if(age.isPresent())
            return pjServ.findByEdad(age.get());
        if(movies.isPresent())
            return pjServ.findByPelicula(peliServ.findById(movies.get()));
        return pjServ.findAll();
    }
}
