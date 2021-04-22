package cat.itb.projectprimavera.model.servei;
import cat.itb.projectprimavera.model.Usuari;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService extends CrudRepository<Usuari, String> {

        private List<Usuari> repositori = new ArrayList<>();
        public void afegir(Usuari e) {
            e.setPassword(passwordEncoder(e.getPassword()));
            repositori.add(e);
        }
        public List<Usuari> llistat() {
            return repositori;
        }

        @PostConstruct
        public void init() {
            repositori.save(new Usuari("user1", passwordEncoder("user1"), "user1"), new Usuari("user2", passwordEncoder("user2"), "user2"), new Usuari("ADMIN", passwordEncoder("ADMIN"), "ADMIN","ADMIN"));
        }

        public Usuari findById(String username){
            Usuari u = repositori.findById(username).orElse(null);
            return u;
        }

    public Usuari consultaPerId(String s) {
            Usuari u = null;
            boolean trobat = false;
        for (int i = 0; i < repositori.size() && !trobat; i++) {
            if (s.equals(repositori.get(i).getUsername())){

                u = repositori.get(i);
                trobat=true;
            }
        }
        return  u;
    }

    public String passwordEncoder(String s) {
        return new BCryptPasswordEncoder().encode(s);
    }
}
