package pet.project.PetAdopa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import pet.project.PetAdopa.Entity.Customer;
import pet.project.PetAdopa.Entity.Seller;
import pet.project.PetAdopa.Service.CustomerService;
import pet.project.PetAdopa.Service.SellerService;

@Controller
public class loginController {
    
    @Autowired
    private CustomerService customerService;

    @Autowired
    private SellerService sellerService;

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password, 
                        @RequestParam String role , HttpSession session, Model model) {
        if (role == null || role.isBlank()) {
            model.addAttribute("errorMessage", "Please select a role.");
            return "login_Page_buyer"; 
        }

        // Normalize string to lowercase to avoid case-matching errors
        switch(role.trim().toLowerCase()){
            case "buyer":
                Customer customer = customerService.findByEmail(email);
                
                // CRITICAL FIX: Changed to password.equals(customer.getPassword()) 
                // This prevents an Error 500 crash if the customer's DB password is null.
                if (customer != null && password.equals(customer.getPassword())) {
                    session.setAttribute("loggedInUser", customer);
                    session.setAttribute("userRole", "buyer");
                    return "redirect:/front_page";    
                } else {
                    return "redirect:/login?error=invalid_credentials";
                }

            case "seller":
                Seller seller = sellerService.findByEmail(email);
                
                // CRITICAL FIX: Changed here too to protect against null DB passwords for sellers.
                if (seller != null && password.equals(seller.getPassword())) {
                    session.setAttribute("loggedInUser", seller);
                    session.setAttribute("userRole", "seller");
                    return "redirect:/front_page"; 
                } else {
                    return "redirect:/login?error=invalid_credentials";
                }

            default:
                return "redirect:/login?error=unknown_role";
        }
    }
    
}
