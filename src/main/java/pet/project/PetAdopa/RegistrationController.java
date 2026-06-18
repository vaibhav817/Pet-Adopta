package pet.project.PetAdopa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;

@Controller
public class RegistrationController {
    @Autowired
    private CustomerService custService;
    @Autowired
    private SellerService sellerService;

    @PostMapping("/register")
    public String getRegisterPage(@RequestParam String fullName,
                                  @RequestParam String role,
                                  @RequestParam String email,
                                  @RequestParam String phone, @RequestParam String password,
                                   @RequestParam String confirmPassword 
                                  ,@RequestParam String state,
                                   @RequestParam String streetAddress,
                                   @RequestParam String city){
        if(role.equalsIgnoreCase("Seller")){
            sellerService.saveNewSeller(fullName, email, phone, password, confirmPassword, role, state, streetAddress, city);
            //return "Seller registered successfully";
              return "redirect:/seller_dashboard";
        }
        custService.registerCustomer(fullName, role, email, phone, password, confirmPassword, state, streetAddress, city);
        return "redirect:/front_page";
    }
}
    