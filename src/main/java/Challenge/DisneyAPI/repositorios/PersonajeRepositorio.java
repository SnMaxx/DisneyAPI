package Challenge.DisneyAPI.repositorios;

import Challenge.DisneyAPI.entidades.Personaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonajeRepositorio extends JpaRepository<Personaje, String>{
    
}
