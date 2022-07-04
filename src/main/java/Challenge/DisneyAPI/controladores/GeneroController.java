package Challenge.DisneyAPI.controladores;

import Challenge.DisneyAPI.entidades.Genero;
import Challenge.DisneyAPI.servicios.GeneroServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/genero")
public class GeneroController {
    
    @Autowired
    private GeneroServicio genServ;
    
    @GetMapping
    public List<Genero> traerGeneros(){
        return genServ.traerTodo();
    }
    @PostMapping
    public Genero crearGenero(@RequestBody Genero genero){
        return genServ.crearGenero(genero);
    }
//    @PutMapping("/{id}")
//    public List<Genero> modificarGenero(@PathVariable String id, @RequestBody Genero genero){
//        return genServ.modificarGenero(id,genero);
//    }
//    @DeleteMapping("/{id}")
//    public List<Genero> eliminarGenero(@PathVariable String id){
//        return genServ.traerTodo();
//    }

}
