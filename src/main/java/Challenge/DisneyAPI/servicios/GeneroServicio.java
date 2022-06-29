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
    public Genero crearGenero(String img, String nombre){
        Genero genero = new Genero();
        genero.setImg(img);
        genero.setNombre(nombre);
        return genRepo.save(genero);
    }
}
