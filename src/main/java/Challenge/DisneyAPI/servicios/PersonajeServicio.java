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
    public Personaje crearPersonaje(Personaje pj){
        return pjRepo.save(pj);
    }
    
    @Transactional
    public Personaje editarPersonaje(String id, Personaje pj){
        pj.setId(id);
        return pjRepo.save(pj);
    }
    
    @Transactional
    public void delete(String id){
         pjRepo.deleteById(id);
    }
    
    public List<Personaje> findAll(){
        return pjRepo.findAll();
    }
    
    public Personaje findById(String id) throws Exception{
        Optional<Personaje> personaje = pjRepo.findById(id);
        if(!personaje.isPresent()) throw new Exception("ID invalido");
        return personaje.get();
    }
    
    public List<Personaje> findByNombre(String name){
        return pjRepo.findByNombre(name);
    };
    
    public List<Personaje> findByEdad(Integer name){
        return pjRepo.findByEdad(name);
    };
    
    public List<Personaje> findByPelicula(Pelicula peli){
        return pjRepo.findByPeliculas(peli);
    };
}
