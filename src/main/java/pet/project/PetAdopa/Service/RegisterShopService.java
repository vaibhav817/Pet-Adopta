package pet.project.PetAdopa.Service;

//import org.springframework.beans.factory.annotation.Autowired;
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
}
