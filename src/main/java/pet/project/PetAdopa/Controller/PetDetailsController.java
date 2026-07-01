package pet.project.PetAdopa.Controller;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import pet.project.PetAdopa.Entity.PetDetails;
import pet.project.PetAdopa.Service.PetDetailsService;



@Controller
public class PetDetailsController {
    
    public final PetDetailsService petDetailsService;
    
    public PetDetailsController(PetDetailsService petDetailsService){
        this.petDetailsService=petDetailsService;
    }

    @PostMapping("/addNew/petDetails")
    
    public String postMethodName(@RequestParam String petName,@RequestParam int age,
        @RequestParam String species,
        @RequestParam double price,@RequestParam MultipartFile image) {
        try {
           if(!image.isEmpty()){
               byte[] imageBytes = image.getBytes();
               petDetailsService.addNewPet(petName, age, price, species,imageBytes);
           }
        }
        catch (IOException e) {
        e.printStackTrace();
    }
        return "redirect:/seller_dashboard";
    }
    @GetMapping("/api/pets")
    @ResponseBody
    public List<PetDetails> getAllPets() {
    return petDetailsService.getAllPets();
}

}
