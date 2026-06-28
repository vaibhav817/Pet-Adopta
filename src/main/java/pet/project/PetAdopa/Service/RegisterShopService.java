package pet.project.PetAdopa.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import pet.project.PetAdopa.Repository.RegisterShopRepository;
import pet.project.PetAdopa.Units.RegisterShop;
@Service
public class RegisterShopService {
    //@Autowired
    private final RegisterShopRepository registerShopRepository;

    public RegisterShopService( RegisterShopRepository registerShopRepository){
        this.registerShopRepository=registerShopRepository;
    }

    public RegisterShop registerShop(String storeName, String locationTiming, Double latitude, Double longitude) {
        RegisterShop shop = new RegisterShop(storeName, locationTiming, latitude, longitude);
        return registerShopRepository.save(shop);
    }

    public List<RegisterShop> findAllShop(){
        return registerShopRepository.allShop();
    }
}
