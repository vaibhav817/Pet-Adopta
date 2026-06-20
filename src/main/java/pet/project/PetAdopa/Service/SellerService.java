package pet.project.PetAdopa.Service;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pet.project.PetAdopa.Repository.SellerRepository;
import pet.project.PetAdopa.Units.Seller;

@Service
public class SellerService {
    //@Autowired
    private final SellerRepository sellerRepository;

    public SellerService(SellerRepository sellerRepository){
        this.sellerRepository=sellerRepository;
    }

    public void saveNewSeller(String name, String email, String phoneNumber, String password, String passwordConfirm,
                              String role,String state, String street, String city){
        if (!password.equals(passwordConfirm)) {
            throw new IllegalArgumentException("Passwords do not match");
        }
        Seller seller = new Seller(name, email, phoneNumber, password, role, state, street, city);
        sellerRepository.save(seller);
    }
    public boolean authenticateSeller(String email, String password, String role){
        Seller seller = sellerRepository.findByEmail(email);
        return seller != null && seller.getPassword().equals(password) && seller.getRole().equals(role);
    }   
    public Seller findByEmail(String email) {
        return sellerRepository.findByEmail(email);
    }
}
