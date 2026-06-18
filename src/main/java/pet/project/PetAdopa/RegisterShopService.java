package pet.project.PetAdopa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class RegisterShopService {
    @Autowired
    private RegisterShopRepository registerShopRepository;

    public RegisterShop registerShop(String storeName, String locationTiming, Double latitude, Double longitude) {
        RegisterShop shop = new RegisterShop(storeName, locationTiming, latitude, longitude);
        return registerShopRepository.save(shop);
    }
}
