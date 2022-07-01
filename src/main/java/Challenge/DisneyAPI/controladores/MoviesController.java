package Challenge.DisneyAPI.controladores;

import Challenge.DisneyAPI.entidades.Pelicula;
import Challenge.DisneyAPI.servicios.PeliculaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MoviesController {
    
    @Autowired
    private PeliculaServicio peliServ;
    
    @GetMapping("/{id}")
    public Pelicula verPelicula(@PathVariable String id) throws Exception{
        return peliServ.findById(id);
    }
}
