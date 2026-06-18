package pet.project.PetAdopa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
@Controller
public class RegisterShopController {
    @Autowired
    private RegisterShopService registerShopService;

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
}
