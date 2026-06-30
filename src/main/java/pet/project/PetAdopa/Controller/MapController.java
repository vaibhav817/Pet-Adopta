package pet.project.PetAdopa.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

import pet.project.PetAdopa.Entity.Seller;
import pet.project.PetAdopa.Repository.SellerRepository;

public class MapController {

    //@Autowired
    private final SellerRepository sellerRepository;
    
    public MapController(SellerRepository sellerRepository){
        this.sellerRepository=sellerRepository;
    }
    @GetMapping("/api/sellers/locations")
    public List<Seller> getSellerLocations() {
    return sellerRepository.findAll();
    }
}
