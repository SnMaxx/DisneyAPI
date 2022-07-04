package Challenge.DisneyAPI.repositorios;

import Challenge.DisneyAPI.entidades.Pelicula;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeliculaRepositorio extends JpaRepository<Pelicula, String>{
    
    public List<Pelicula> findByTitulo(String titulo);
    
    public List<Pelicula> findAllByOrderByEstrenoAsc();
    
    public List<Pelicula> findAllByOrderByEstrenoDesc();
    
}
