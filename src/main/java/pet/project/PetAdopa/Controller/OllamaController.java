package pet.project.PetAdopa.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import pet.project.PetAdopa.Service.OllamaService;
@RestController
public class OllamaController{

    //@Autowired
    final OllamaService ollamaService;
    
    public OllamaController(OllamaService ollamaService){
        this.ollamaService=ollamaService;
    }
    @PostMapping("/api/chat")
    public String chat(@RequestBody String message) {
        return ollamaService.askPetQuestion(message);
    }
}
