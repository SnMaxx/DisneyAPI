package Challenge.DisneyAPI.controladores;

import Challenge.DisneyAPI.dtos.PeliculaDTO;
import Challenge.DisneyAPI.dtos.PeliculaMinDTO;
import Challenge.DisneyAPI.entidades.Pelicula;
import Challenge.DisneyAPI.entidades.Personaje;
import Challenge.DisneyAPI.mappers.MapStruct;
import Challenge.DisneyAPI.servicios.GeneroServicio;
import Challenge.DisneyAPI.servicios.PeliculaServicio;
import Challenge.DisneyAPI.servicios.PersonajeServicio;
import java.util.List;
import java.util.Optional;
import java.util.Set;
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

@RestController
@RequestMapping("/movies")
public class MoviesController {
    
    @Autowired
    private MapStruct mapperStruct;
    
    @Autowired
    private PeliculaServicio peliServ;
    
    @Autowired
    private PersonajeServicio perServ;
    
    @Autowired
    private GeneroServicio genServ;
    
    @GetMapping("/{id}")
    public PeliculaDTO verPelicula(@PathVariable String id) throws Exception{
        return mapperStruct.peliculaToPeliculaDTO(peliServ.buscarPorId(id));
    }
    
    @GetMapping
    public List<PeliculaMinDTO> peliculas(@RequestParam Optional<String> name, @RequestParam Optional<String> genreId, @RequestParam Optional<String> order) throws Exception{
        if(name.isPresent())
            return mapperStruct.peliculasToPeliculaMinDTOs(peliServ.buscarPorTitulo(name.get()));
        if(genreId.isPresent())
            return mapperStruct.peliculasToPeliculaMinDTOs(genServ.buscarPorId(genreId.get()).getPeliculas());
        if(order.isPresent())
            return mapperStruct.peliculasToPeliculaMinDTOs(peliServ.traerTodo(order.get()));
        return mapperStruct.peliculasToPeliculaMinDTOs(peliServ.traerTodo());
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PeliculaDTO agregarPelicula(@RequestBody Pelicula peli) throws Exception{
        
        return mapperStruct.peliculaToPeliculaDTO(peliServ.crearPelicula(peli));
    }
    
    @PutMapping("/{id}")
    public PeliculaDTO editarPelicula(@PathVariable String id, @RequestBody Pelicula peli) throws Exception{
        return mapperStruct.peliculaToPeliculaDTO(peliServ.editarPelicula(id,peli));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity borrarPelicula(@PathVariable String id){
        peliServ.borrarPelicula(id);
        return ResponseEntity.ok().build();
    }
    
    @PostMapping("/{idMovie}/characters/{idCharacter}")
    public PeliculaDTO agregarPersonaje(@PathVariable String idMovie, @PathVariable String idCharacter) throws Exception{
        return mapperStruct.peliculaToPeliculaDTO(peliServ.agregarPersonaje(idMovie,idCharacter));        
    }
    
    @DeleteMapping("/{idMovie}/characters/{idCharacter}")
    public PeliculaDTO sacarPersonaje(@PathVariable String idMovie, @PathVariable String idCharacter) throws Exception{
        return mapperStruct.peliculaToPeliculaDTO(peliServ.sacarPersonaje(idMovie,idCharacter));        
    }
    
}
