package cat.itb.projectprimavera.controlador;
import cat.itb.projectprimavera.model.Canco;
import cat.itb.projectprimavera.model.Usuari;
import cat.itb.projectprimavera.model.servei.CancoService;
import cat.itb.projectprimavera.model.servei.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Controlador {

    String nom;
    @Autowired
    private UserService servei;
    @Autowired
    private CancoService serveiCanco;

    @GetMapping("/")
    public String inici(Model m){
        m.addAttribute("llistaCanco",serveiCanco.llistat());
        m.addAttribute("Cançó",new Canco());
        return "home";
    }

    @RequestMapping( value ="/delete/{name}", method = RequestMethod.POST)
    public String removeCanco(@PathVariable("name") String canco){

        serveiCanco.removeCancobyName(canco);
        return "redirect:/";
    }

    @GetMapping("/userList")
    public String llistar(Model m){
        m.addAttribute("llistaUsuaris",servei.llistat());
        return "llistatUsuaris";
    }

    @GetMapping("/home")
    public String llistarCanco(Model m){
        m.addAttribute("llistaCanco",serveiCanco.llistat());
        m.addAttribute("Cançó",new Canco());
        return "home";
    }

    @GetMapping("/registration")
    public String showRegistrationForm(WebRequest request, Model model) {
        model.addAttribute("usuari", new Usuari());
        return "register";
    }

    @RequestMapping("/afegir")
    public String afegirCanco(Model model) {
        model.addAttribute("Cançó", new Canco());
        return "afegirCanco";
    }

    @PostMapping("/afegirCanco")
    //empleatForm és el nom de l'objecte que es recull al formulari, el CommandObject (bean)
    //https://www.thymeleaf.org/doc/tutorials/2.1/thymeleafspring.html#handling-the-command-object
    public String AfegirCanco(@ModelAttribute("Cançó") Canco e){
        serveiCanco.afegir(e);
        return "redirect:/";
    }

    @PostMapping("/registration")
    //empleatForm és el nom de l'objecte que es recull al formulari, el CommandObject (bean)
    //https://www.thymeleaf.org/doc/tutorials/2.1/thymeleafspring.html#handling-the-command-object
    public String afegirSubmit(@ModelAttribute("usuari") Usuari e){
        e.setRol("USER");
        servei.afegir(e);
        return "redirect:/list";
    }

    @RequestMapping( value ="/update/{name}", method = RequestMethod.POST)
    public String updateCanco(@PathVariable("name") String canco, Model m){
        nom = canco;
        m.addAttribute("Cançó",serveiCanco.consultaPerNom(canco));
        return "/updateCanco";
    }

    @PostMapping("/updateCanco")
    //empleatForm és el nom de l'objecte que es recull al formulari, el CommandObject (bean)
    //https://www.thymeleaf.org/doc/tutorials/2.1/thymeleafspring.html#handling-the-command-object
    public String updateCancopost(@ModelAttribute("Cançó") Canco e){
        serveiCanco.updateCanco(e, nom);
        return "redirect:/";
    }
}