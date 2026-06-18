package pet.project.PetAdopa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
@RestController
public class OllamaController{

    @Autowired
    OllamaService ollamaService;

    @PostMapping("/api/chat")
    public String chat(@RequestBody String message) {
        return ollamaService.askPetQuestion(message);
    }
}
