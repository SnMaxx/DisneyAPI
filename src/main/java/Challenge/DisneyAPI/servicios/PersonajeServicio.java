package Challenge.DisneyAPI.servicios;

import java.util.List;
import Challenge.DisneyAPI.entidades.Pelicula;
import Challenge.DisneyAPI.entidades.Personaje;
import Challenge.DisneyAPI.entidades.PersonajeDTO;
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
    public Personaje editarPersonaje(String id, Personaje pj){
        pj.setId(id);
        return pjRepo.save(pj);
    }
    
    @Transactional
    public void borrarPersonaje(String id){
         pjRepo.deleteById(id);
    }
    
    public List<PersonajeDTO> traerTodo(){
        List<PersonajeDTO> personajeDTO = new ArrayList<>();
        for (Personaje personaje : pjRepo.findAll()) {
            personajeDTO.add(new PersonajeDTO(personaje));
        }
        return personajeDTO;
    }
    
    public Personaje buscarPorId(String id) throws Exception{
        Optional<Personaje> personaje = pjRepo.findById(id);
        if(!personaje.isPresent()) throw new Exception("ID invalido");
        return personaje.get();
    }
    
    public List<PersonajeDTO> buscarPorNombre(String name){
        List<PersonajeDTO> personajeDTO = new ArrayList<>();
        for (Personaje personaje : pjRepo.findByNombre(name)) {
            personajeDTO.add(new PersonajeDTO(personaje));
        }
        return personajeDTO;
    };
    
    public List<PersonajeDTO> buscarPorEdad(Integer edad){
        List<PersonajeDTO> personajeDTO = new ArrayList<>();
        for (Personaje personaje : pjRepo.findByEdad(edad)) {
            personajeDTO.add(new PersonajeDTO(personaje));
        }
        return personajeDTO;
    };
    
    public List<PersonajeDTO> buscarPorPeso(Integer peso){
        List<PersonajeDTO> personajeDTO = new ArrayList<>();
        for (Personaje personaje : pjRepo.findByPeso(peso)) {
            personajeDTO.add(new PersonajeDTO(personaje));
        }
        return personajeDTO;
    };
    
    public List<PersonajeDTO> buscarPorPelicula(Pelicula peli){
        List<PersonajeDTO> personajeDTO = new ArrayList<>();
        for (Personaje personaje : pjRepo.findByPeliculas(peli)) {
            personajeDTO.add(new PersonajeDTO(personaje));
        }
        return personajeDTO;
    };
}
