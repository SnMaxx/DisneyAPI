package Challenge.DisneyAPI.controladores;

import Challenge.DisneyAPI.model.AuthenticationReq;
import Challenge.DisneyAPI.seguridad.JwtUtilService;
import Challenge.DisneyAPI.seguridad.TokenInfo;
import Challenge.DisneyAPI.entidades.Usuario;
import Challenge.DisneyAPI.mappers.MapStruct;
import Challenge.DisneyAPI.servicios.MailService;
import Challenge.DisneyAPI.servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/auth")
@Repository
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Autowired
    private UsuarioServicio userServ;

    @Autowired
    private JwtUtilService jwtUtilService;
    
    @Autowired
    private MailService mailServ;
    
    @Autowired
    private MapStruct mapStruct;

    @PostMapping("/register")
    public ResponseEntity<?> resgistro(@RequestBody Usuario usuario) throws Exception {
        ResponseEntity<?> respuesta = ResponseEntity.ok(userServ.crearUsuario(usuario));
        mailServ.sendEmail(mapStruct.usuarioToUserMail(usuario));
        return respuesta;
        }

    @PostMapping("/login")
    public ResponseEntity<TokenInfo> loginUser(@RequestBody AuthenticationReq usuario) {
        
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(usuario.getEmail(), usuario.getPassword()));

        final UserDetails userDetails = userServ.loadUserByUsername(usuario.getEmail());

        final String jwt = jwtUtilService.generateToken(userDetails);

        TokenInfo tokenInfo = new TokenInfo(jwt);
        return new ResponseEntity<>(tokenInfo, HttpStatus.OK);
    }

}
