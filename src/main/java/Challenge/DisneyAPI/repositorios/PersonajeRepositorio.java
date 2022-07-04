package Challenge.DisneyAPI.repositorios;

import Challenge.DisneyAPI.entidades.Pelicula;
import Challenge.DisneyAPI.entidades.Personaje;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonajeRepositorio extends JpaRepository<Personaje, String>{
    
    public List<Personaje> findByNombre(String name);
    
    public List<Personaje> findByEdad(Integer edad);
    
    public List<Personaje> findByPeso(Integer peso);
    
    public List<Personaje> findByPeliculas(Pelicula peli);
}
