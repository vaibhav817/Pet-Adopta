package pet.project.PetAdopa.Controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pet.project.PetAdopa.Entity.RegisterShop;
import pet.project.PetAdopa.Service.RegisterShopService;
@Controller
public class RegisterShopController {
    //@Autowired
    private final RegisterShopService registerShopService;

    public RegisterShopController(RegisterShopService registerShopService){
        this.registerShopService=registerShopService;
    }

    @PostMapping("/map/registerLocation")
    public String registerLocation(@RequestParam("storeName") String storeName,
                                   @RequestParam("locationTiming") String locationTiming,
                                   @RequestParam("latitude") Double latitude,
                                   @RequestParam("longitude") Double longitude,
                                   RedirectAttributes redirectAttributes) {
        try {
            registerShopService.registerShop(storeName, locationTiming, latitude, longitude);
            redirectAttributes.addFlashAttribute("message", "Shop location registered successfully!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Failed to register location: " + e.getMessage());
        }

        // Redirect back to dashboard 
        return "redirect:/seller_dashboard";
    }
    @GetMapping("/api/Shops")
    @ResponseBody 
    public List<RegisterShop> getAllProducts() {
        return registerShopService.findAllShop();
    }
}
