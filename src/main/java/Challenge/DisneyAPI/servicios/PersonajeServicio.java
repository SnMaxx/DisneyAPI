package Challenge.DisneyAPI.servicios;

import java.util.List;
import Challenge.DisneyAPI.entidades.Pelicula;
import Challenge.DisneyAPI.entidades.Personaje;
import Challenge.DisneyAPI.repositorios.PersonajeRepositorio;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonajeServicio {

    @Autowired
    private PersonajeRepositorio pjRepo;
    
    @Transactional
    public Personaje save(String img, Integer edad, Integer peso, String historia, List<Pelicula> peliculas){
        Personaje pj = new Personaje(img, edad, peso, historia, peliculas);
        return pjRepo.save(pj);
    }
    
    @Transactional
    public Personaje update(String id, String img, Integer edad, Integer peso, String historia, List<Pelicula> peliculas) throws Exception{
        Optional<Personaje> personaje = pjRepo.findById(id);
        if(!personaje.isPresent()) throw new Exception("ID invalido");
        Personaje pj = personaje.get();
        pj.setImg(img);
        pj.setEdad(edad);
        pj.setPeso(peso);
        pj.setHistoria(historia);
        pj.setPeliculas(peliculas);
        return pjRepo.save(pj);
    }
    
    @Transactional
    public void delete(String id){
         
    }
}
