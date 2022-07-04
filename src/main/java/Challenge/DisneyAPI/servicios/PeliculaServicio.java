package Challenge.DisneyAPI.servicios;

import Challenge.DisneyAPI.entidades.Pelicula;
import Challenge.DisneyAPI.entidades.Personaje;
import Challenge.DisneyAPI.repositorios.PeliculaRepositorio;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PeliculaServicio {

    @Autowired
    private PeliculaRepositorio peliRepo;

    @Autowired
    private PersonajeServicio perServ;
    
    @Transactional(readOnly = true)
    public Pelicula buscarPorId(String id) throws Exception {
        Optional<Pelicula> pelicula = peliRepo.findById(id);
        if (!pelicula.isPresent()) {
            throw new Exception("ID invalido");
        }
        return pelicula.get();
    }

    public List<Pelicula> traerTodo() {
        return peliRepo.findAll();
    }
    
    public List<Pelicula> traerTodo(String ordenamiento) {
        if(ordenamiento.equalsIgnoreCase("ASC"))
        return peliRepo.findAllByOrderByEstrenoAsc();
        if(ordenamiento.equalsIgnoreCase("DESC"))
        return peliRepo.findAllByOrderByEstrenoDesc();
        return null;
    }

    public List<Pelicula> buscarPorTitulo(String titulo) {
        return peliRepo.findByTitulo(titulo);

    }

    public Pelicula crearPelicula(Pelicula peli) throws Exception {
        validarPelicula(peli);
        return peliRepo.save(peli);

    }
    
    public Pelicula agregarPersonaje(String idMovie,String idCharacter) throws Exception{
        Pelicula peli = buscarPorId(idMovie);
        Set<Personaje> personajes = peli.getPersonajes();
        personajes.add(perServ.buscarPorId(idCharacter));
        peli.setPersonajes(personajes);
        return peliRepo.save(peli);
    }
    
    public Pelicula sacarPersonaje(String idMovie,String idCharacter) throws Exception{
        Pelicula peli = buscarPorId(idMovie);
        Set<Personaje> personajes = peli.getPersonajes();
        personajes.remove(perServ.buscarPorId(idCharacter));
        peli.setPersonajes(personajes);
        return peliRepo.save(peli);
    }

    @Transactional
    public Pelicula editarPelicula(String id, Pelicula peli) throws Exception {
        Optional<Pelicula> peliAnterior = peliRepo.findById(id);
        if (!peliAnterior.isPresent()) {
            throw new Exception("ID invalido");
        }
        peli.setId(id);
        peli.setPersonajes(peliAnterior.get().getPersonajes());
        return peliRepo.save(peli);
    }

    public void borrarPelicula(String id) {
        peliRepo.deleteById(id);
    }

    public void validarPelicula(Pelicula peli) throws Exception {
        if (peli.getCalificacion() >= 1 && peli.getCalificacion() <= 5) {
            throw new Exception("La calificación debe ser del 1 al 5");
        }

    }
}
