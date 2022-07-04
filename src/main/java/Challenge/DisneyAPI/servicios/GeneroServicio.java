package Challenge.DisneyAPI.servicios;

import Challenge.DisneyAPI.entidades.Genero;
import Challenge.DisneyAPI.repositorios.GeneroRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GeneroServicio {

    @Autowired
    private GeneroRepositorio genRepo;
    
    @Transactional
    public Genero crearGenero(Genero genero){
        return genRepo.save(genero);
    }
    
    @Transactional(readOnly = true)
    public Genero buscarPorId(String id) throws Exception{
        Optional<Genero> genero = genRepo.findById(id);
        if(!genero.isPresent()) throw new Exception("ID invalido");
        return genero.get();
    }
    
    public List<Genero> traerTodo(){
        return genRepo.findAll();
    }
}
