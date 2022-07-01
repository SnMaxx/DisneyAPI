package Challenge.DisneyAPI.entidades;

public class PersonajeDTO {

    private String id;
    private String img;
    private String nombre;

    public PersonajeDTO() {
    }

    public PersonajeDTO(String id, String img, String nombre) {
        this.id = id;
        this.img = img;
        this.nombre = nombre;
    }
    
    public PersonajeDTO(Personaje personaje) {
        this.id = personaje.getId();
        this.img = personaje.getImg();
        this.nombre = personaje.getNombre();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "PersonajeDTO{" + "id=" + id + ", img=" + img + ", nombre=" + nombre + '}';
    }
    
    
}
