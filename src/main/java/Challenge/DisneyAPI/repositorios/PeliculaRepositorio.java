package Challenge.DisneyAPI.repositorios;

import Challenge.DisneyAPI.entidades.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeliculaRepositorio extends JpaRepository<Pelicula, String>{
    
}
