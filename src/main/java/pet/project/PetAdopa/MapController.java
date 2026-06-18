package pet.project.PetAdopa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

public class MapController {
    @Autowired
    private  SellerRepository sellerRepository;

    @GetMapping("/api/sellers/locations")
    public List<Seller> getSellerLocations() {
    return sellerRepository.findAll();
    }
}
