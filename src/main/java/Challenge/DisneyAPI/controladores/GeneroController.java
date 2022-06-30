package Challenge.DisneyAPI.controladores;

import Challenge.DisneyAPI.entidades.Genero;
import Challenge.DisneyAPI.servicios.GeneroServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/genero")
public class GeneroController {
    
    @Autowired
    private GeneroServicio genServ;
    
    @PostMapping
    public Genero crearGenero(@RequestBody Genero genero){
        return genServ.crearGenero(genero);
    }

}
