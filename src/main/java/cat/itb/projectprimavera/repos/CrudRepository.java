package cat.itb.projectprimavera.repos;

import cat.itb.projectprimavera.model.Usuari;
import org.springframework.data.repository.CrudRepository;

interface RepositoriUsuaris extends CrudRepository<Usuari,String> {
}

