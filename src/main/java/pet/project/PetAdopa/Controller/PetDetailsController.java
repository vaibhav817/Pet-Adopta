package pet.project.PetAdopa.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class PetDetailsController {
    
    public final PetDetailsService petDetailsService;

    @PostMapping("path")
    public String postMethodName() {
        return petDetailsService.addNewPet();
    }

}
