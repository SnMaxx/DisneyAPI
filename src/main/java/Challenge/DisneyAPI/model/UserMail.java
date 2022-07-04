package Challenge.DisneyAPI.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

/**
 * Date :July 25,2018
 *
 * @author MukulJaiswal
 * @version 1.0
 *
 */
@Getter
@Setter
@Component
public class UserMail {

    private String name;
    private String email;

}
