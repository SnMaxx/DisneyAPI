package Challenge.DisneyAPI.servicios;

import Challenge.DisneyAPI.entidades.Usuario;
import Challenge.DisneyAPI.enums.Role;
import Challenge.DisneyAPI.repositorios.UsuarioRepositorio;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Service
public class UsuarioServicio implements UserDetailsService{

    @Autowired
    private UsuarioRepositorio userRepo;

    public Usuario crearUsuario(Usuario usuario) throws Exception {
        validator(usuario);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        usuario.setPassword(encoder.encode(usuario.getPassword()));
        usuario.setRole(Role.USER);
        return userRepo.save(usuario);
    }

    public void validator(Usuario usuario) throws Exception {

        if (usuario.getName() == null || usuario.getName().trim().isEmpty()) {
            throw new Exception("Nombre y Apellido no puede estar vacio");
        }

        if (usuario.getEmail() == null || usuario.getEmail().trim().isEmpty()) {
            throw new Exception("Email no puede estar vacio");
        }
        Usuario u = userRepo.findByEmail(usuario.getEmail());
        if (u != null) {
            throw new Exception("Ya posees una cuenta registrada!");
        }

        if (usuario.getPassword() == null || usuario.getPassword().trim().isEmpty()) {
            throw new Exception("La contraseña no puede estar vacía");
        }
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Usuario usuario = userRepo.findByEmail(email);
        if (usuario != null) {
            
            User.UserBuilder userBuilder = User.withUsername(email);
            String pwEncrypt = usuario.getPassword();
            String role = ""+usuario.getRole();
            userBuilder.password(pwEncrypt).roles(role);
            return userBuilder.build();

        } else {
            System.out.println("malo");
            return null;
        }
    }
}
