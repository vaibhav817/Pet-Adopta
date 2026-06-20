package pet.project.PetAdopa.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;
import pet.project.PetAdopa.Service.CustomerService;
import pet.project.PetAdopa.Units.Customer;


@RestController
public class CustomerController {

   
    private final CustomerService custService;
   //@Autowired
   public CustomerController(CustomerService custService){
    this.custService=custService;
   }

    /*@PostMapping("/register")
    public String getSaveNewCustomer(@RequestParam String name,@RequestParam String email,@RequestParam String phoneNumber,@RequestParam String password,@RequestParam String role, @RequestParam String state, @RequestParam String street, @RequestParam String city){ 
        //Customer(name,email,phoneNumber,password,role);
        custService.saveNewCustomer(name,email,phoneNumber,password,role,state,street,city);
        //custService.saveNewCustomer(Customer customer);
        return "Customer registered successfully";
    }*/
    @GetMapping("/register")
    public String getRegisterPage(){
        return "register_page";
    }
    @GetMapping("/login_Page_buyer")
    public String getLoginPageBuyer(){
         return "login_page_buyer";
    }
    @PostMapping("/loginBuyer")
    public String loginBuyer(@RequestParam String email,@RequestParam String password, @RequestParam String role){
        boolean isAuthenticated = custService.authenticateBuyer(email, password, role);
        if (isAuthenticated) {
            return "Buyer logged in successfully";
        } else {
            return "Invalid email or password";
        }
    }
    @GetMapping("/Customer/Dashboard")
    public String getCustomerDashboard(HttpSession session , Model model){
         Customer customer = (Customer) session.getAttribute("customer");
        if (customer == null){
            return "redirect:/login_Page_buyer";
        }
       
        ((Model) model).addAttribute("customer",customer);
        
        
        return "front_page";
    }
    /*@GetMapping("/logout")
    public String getLogoutMethod(HttpSession session) {
        //for session ending  and redirection to login page or we can says to logout page
        session.invalidate();
        return "redirect:/logout";
    }*/
    @GetMapping("/ViewProfile")
    public String getViewProfile(HttpSession session, Model model){
        Customer customer = (Customer) session.getAttribute("customer");
        if (customer == null){
            return "redirect:/login_Page_buyer";}
        else return "view profile"; 
    }
    
}
