package pet.project.PetAdopa.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pet.project.PetAdopa.Units.Seller;

//@Repository
public interface SellerRepository extends JpaRepository<Seller, Long> {
    Seller findByEmail(String email);
    //List<Seller> findAll(); // gets all sellers with lat/lng
}
