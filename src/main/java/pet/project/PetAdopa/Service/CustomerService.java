package pet.project.PetAdopa.Service;


import org.springframework.stereotype.Service;

import pet.project.PetAdopa.Repository.CustomerRepository;
import pet.project.PetAdopa.Units.Customer;

@Service
public class CustomerService {
    //@Autowired
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository=customerRepository;
    }

    public void saveNewCustomer(String name, String email, String  phoneNumber, String password, String role , String State, String Street, String City) {
        Customer customer = new Customer(name, email, phoneNumber, password, role , State, Street, City);
        customerRepository.save(customer);
    }
    public boolean authenticateBuyer(String email, String password, String role){
        Customer customer = customerRepository.findByEmail(email);
        return customer != null && customer.getPassword().equals(password) && customer.getRole().equals(role);
    }
    public void registerCustomer(String name, String role, String email, String number, String password, String passwordConfirm , String State, String Street, String City) {
        if (!password.equals(passwordConfirm)) {
            throw new IllegalArgumentException("Passwords do not match");
        }
        Customer customer = new Customer(name, email, number, password, role, State, Street, City);
        customerRepository.save(customer);
    }
    public Customer findByEmail(String email) {
        return customerRepository.findByEmail(email);
    }
}
