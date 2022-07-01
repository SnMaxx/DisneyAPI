package Challenge.DisneyAPI.controladores;

import Challenge.DisneyAPI.entidades.Pelicula;
import Challenge.DisneyAPI.servicios.PeliculaServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MoviesController {
    
    @Autowired
    private PeliculaServicio peliServ;
    
    @GetMapping("/{id}")
    public Pelicula verPelicula(@PathVariable String id) throws Exception{
        return peliServ.buscarPorId(id);
    }
    
    @GetMapping
    public List<Pelicula> peliculas(){
        return peliServ.traerTodo();
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pelicula agregarPelicula(@RequestBody Pelicula peli) throws Exception{
        
        return peliServ.crearPelicula(peli);
    }
}
