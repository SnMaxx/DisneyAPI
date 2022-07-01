package Challenge.DisneyAPI.servicios;

import Challenge.DisneyAPI.entidades.Pelicula;
import Challenge.DisneyAPI.repositorios.PeliculaRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PeliculaServicio {

    @Autowired
    private PeliculaRepositorio peliRepo;
    
    @Transactional(readOnly = true)
    public Pelicula buscarPorId(String id) throws Exception{
        Optional<Pelicula> pelicula = peliRepo.findById(id);
        if(!pelicula.isPresent()) throw new Exception("ID invalido");
        return pelicula.get();
    }
    
    public List<Pelicula> traerTodo(){
        return peliRepo.findAll();
        
    }
    
    public Pelicula crearPelicula(Pelicula peli){
        return peliRepo.save(peli);
        
    }
}
