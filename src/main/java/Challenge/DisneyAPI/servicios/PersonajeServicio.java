package Challenge.DisneyAPI.servicios;

import java.util.List;
import Challenge.DisneyAPI.entidades.Pelicula;
import Challenge.DisneyAPI.entidades.Personaje;
import Challenge.DisneyAPI.dtos.PersonajeDTO;
import Challenge.DisneyAPI.repositorios.PersonajeRepositorio;
import java.util.ArrayList;
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
    public Personaje editarPersonaje(String id, Personaje pj) throws Exception{
        Optional<Personaje> pjAnterior = pjRepo.findById(id);
        if(!pjAnterior.isPresent()) throw new Exception("ID invalido");
        pj.setId(id);
        pj.setPeliculas(pjAnterior.get().getPeliculas());
        return pjRepo.save(pj);
    }
    
    @Transactional
    public void borrarPersonaje(String id){
         pjRepo.deleteById(id);
    }
    
    public List<Personaje> traerTodo(){
        return pjRepo.findAll();
    }
    
    public Personaje buscarPorId(String id) throws Exception{
        Optional<Personaje> personaje = pjRepo.findById(id);
        if(!personaje.isPresent()) throw new Exception("ID invalido");
        return personaje.get();
    }
    
    public List<Personaje> buscarPorNombre(String name){
        return pjRepo.findByNombre(name);
    };
    
    public List<Personaje> buscarPorEdad(Integer edad){
        return pjRepo.findByEdad(edad);
    };
    
    public List<Personaje> buscarPorPeso(Integer peso){
        return pjRepo.findByPeso(peso);
    };
    
    public List<Personaje> buscarPorPelicula(Pelicula peli){
        return pjRepo.findByPeliculas(peli);
    };
}
