package pet.project.PetAdopa.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;



@Controller
public class PageController {
    
    @RequestMapping("front_page")
    public String getFrontPage(){
        return "front_page";
    }
    @RequestMapping("/home")
    public String home() {
        return "front_page";
    }
    @RequestMapping("/PetAdoption")
    public String getPetAdopa() {
        return "Pet_Adoption";
    }
    @RequestMapping("/Pet_Adoption")
    public String getPetAdoption() {
        return "Pet_Adoption";
    }
    @RequestMapping("/Petfood")
    public String getFood() {
        return "Petfood ";
    }
    @RequestMapping("/Pet_food")
    public String getPetFood() {
        return "Petfood ";
    }
    @RequestMapping("/NameGenerator")
    public String getNameGenerator() {
        return "Name_Generator";
    }
    @RequestMapping("/Name_Generator")
    public String getNameGeneratorMethod() {
        return "Name_Generator";
    }
    @RequestMapping("/HealthAndSafety")
    public String getHealthAndCare(){
        return "Health_and_Safety";
    }
    @RequestMapping("/Health_and_Safety")
    public String getHealthAndSafety(){
        return "Health_and_Safety";
    }
    @RequestMapping("/Map")
    public String getMap() {
        return "Map";
    }
    @RequestMapping("/map")
    public String getMapMethod() {
        return "Map";
    }
    
    @RequestMapping("/Registration")
    public String requestMethodName() {
        return "Registration";
    }
    @RequestMapping("/login_Page_buyer")
    public String getLoginPageBuyer() {
        return "login_Page_buyer";
    }
    @GetMapping("/login")
    public String getMethodName() {
        return "login_Page_buyer";
    }
    @GetMapping("/seller_dashboard")
    public String getSellerFrontPage() {
        return "seller_dashboard";
    }@RequestMapping("/cart")
    public String getCart() {
        System.out.println("=======> SUCCESS: Spring Boot received the request for /cart!");
        return "Cart";
    }
    @RequestMapping("/Cart")
    public String getCartMethod() {
        System.out.println("=======> SUCCESS: Spring Boot received the request for /cart!");
        return "Cart";
    }
    @GetMapping("/logout")
    public String getLogout(HttpSession session) {
        session.invalidate();
        //return "redirect:/login_Page_buyer";
        return "login_Page_buyer";
    }
    @GetMapping("/seller_front_page")
    public String showSellerDashboard(HttpSession session) {
        String role = (String) session.getAttribute("userRole");
        
        if (role == null || !role.equalsIgnoreCase("Seller")) {
            return "login_Page_buyer"; 
        }
        
        return "seller_front_page"; // Make sure you have a 'seller_dashboard_page.html' file
    }
}
