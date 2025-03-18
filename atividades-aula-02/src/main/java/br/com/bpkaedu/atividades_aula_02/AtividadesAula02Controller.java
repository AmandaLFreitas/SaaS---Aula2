package br.com.bpkaedu.atividades_aula_02;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/api")
public class AtividadesAula02Controller {
    @GetMapping("/curso")
    public Map<String, Object> getCourseDetails() {
        Map<String, Object> course = new HashMap<>();
        course.put("Amanda", "Engenharia de Software");
        course.put("duracao", "4 anos");
        course.put("instituicao", "Biopark Educaçao");
        course.put("modalidade", "Presencial");
        return course;
    }


    @GetMapping("/localizacao")
    public Map<String, String> getServerLocation() {
        Map<String, String> location = new HashMap<>();
        try {
            InetAddress ip = InetAddress.getLocalHost();
            location.put("ip", ip.getHostAddress());
            location.put("hostname", ip.getHostName());
        } catch (UnknownHostException e) {
            location.put("erro", "Nao foi possivel obter a localização do servidor");
        }
        return location;
    }


    @GetMapping("/data-hora")
    public Map<String, String> getServerDateTime() {
        Map<String, String> dateTime = new HashMap<>();
        dateTime.put("data-hora", LocalDateTime.now().toString());
        return dateTime;
    }
}


@Controller
@RequestMapping("/pagina")
class PageController {
    @GetMapping("/hello")
    public String helloPage(Model model) {
        model.addAttribute("mensagem", "Hello-World");
        return "index";
    }
}
