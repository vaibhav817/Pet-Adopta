package pet.project.PetAdopa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Long> {
    Seller findByEmail(String email);
    //List<Seller> findAll(); // gets all sellers with lat/lng
}
