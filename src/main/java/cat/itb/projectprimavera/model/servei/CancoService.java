package cat.itb.projectprimavera.model.servei;

import cat.itb.projectprimavera.model.Canco;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CancoService {

    private List<Canco> repositori = new ArrayList<>();

    public void afegir(Canco e) {
        repositori.add(e);
    }
    public java.lang.Object llistat() {
        return repositori;
    }

    @PostConstruct
    public void init() {
        repositori.addAll(
                Arrays.asList(
                        new Canco("Basket Case", "Green day"),
                        new Canco("Numb", "Linkin Park"),
                        new Canco("Fills de la nit", "Smoking Souls")
                ));}

    public Canco consultaPerNom(String s) {
        Canco u = null;
        boolean trobat = false;
        for (int i = 0; i < repositori.size() && !trobat; i++) {
            if (s.equals(repositori.get(i).getNomCanco())){

                u = repositori.get(i);
                trobat=true;
            }
        }
        return  u;
    }

    public void removeCancobyName(String s){
        Canco u = null;
        boolean trobat = false;
        for (int i = 0; i < repositori.size() && !trobat; i++) {
            if (s.equals(repositori.get(i).getNomCanco())){
                u = repositori.get(i);
                trobat=true;
            }
        }
        repositori.remove(u);
    }

    public void updateCanco(Canco e, String nom ){
        Canco u = null;
        boolean trobat = false;
        for (int i = 0; i < repositori.size() && !trobat; i++) {
            if (nom.equals(repositori.get(i).getNomCanco())){
                repositori.get(i).setNomCanco(e.getNomCanco());
                repositori.get(i).setGrupCanco(e.getGrupCanco());
            }
        }
    }
}