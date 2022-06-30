package Challenge.DisneyAPI.servicios;

import Challenge.DisneyAPI.entidades.Genero;
import Challenge.DisneyAPI.repositorios.GeneroRepositorio;
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
}
