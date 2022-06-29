package Challenge.DisneyAPI.repositorios;

import Challenge.DisneyAPI.entidades.Genero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneroRepositorio extends JpaRepository<Genero, String>{

}
