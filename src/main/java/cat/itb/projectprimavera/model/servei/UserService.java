package cat.itb.projectprimavera.model.servei;

import cat.itb.projectprimavera.model.Usuari;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements CrudRepository<Usuari, String> {

        @NonNull
        private final List<Usuari> repositori = new ArrayList<>();
        public void afegir(Usuari e) {
            e.setPassword(passwordEncoder(e.getPassword()));
            repositori.add(e);
        }

        public List<Usuari> llistat() {
            return repositori;
        }

        @PostConstruct
        public void init() {
            repositori.addAll(
                    Arrays.asList(
                            new Usuari("user1", passwordEncoder("user1"), "user1"),
                            new Usuari("user2", passwordEncoder("user2"), "user2"),
                            new Usuari("ADMIN", passwordEncoder("ADMIN"), "ADMIN","ADMIN")));
        }

        public Usuari consultaPerId(String s) {
            Usuari u = null;
            boolean trobat = false;
            for (int i = 0; i < repositori.size() && !trobat; i++) {
                if (s.equals(repositori.get(i).getRol())){
                    u = repositori.get(i);
                    trobat=true;
                }
            }
            return  u;
        }

        public String passwordEncoder(String s) {
            return new BCryptPasswordEncoder().encode(s);
        }

        @NonNull
        @Override
        public <S extends Usuari> S save(@NonNull S s) {
            return null;
        }

        @NonNull
        @Override
        public <S extends Usuari> Iterable<S> saveAll(@NonNull Iterable<S> iterable) {
            return iterable;
        }

        @NonNull
        @Override
        public Optional<Usuari> findById(@NonNull String username) {
            return Optional.empty();
        }

        @Override
        public boolean existsById(@NonNull String s) {
            return false;
        }

        @NonNull
        @Override
        public Iterable<Usuari> findAll() {
            return null;
        }

        @NonNull
        @Override
        public Iterable<Usuari> findAllById(@NonNull Iterable<String> iterable) {
            return null;
        }

        @Override
        public long count() {
            return 0;
        }

        @Override
        public void deleteById(@NonNull String s) {

        }

        @Override
        public void delete(@NonNull Usuari usuari) {

        }

        @Override
        public void deleteAll(@NonNull Iterable<? extends Usuari> iterable) {

        }

        @Override
        public void deleteAll() {

        }
    }