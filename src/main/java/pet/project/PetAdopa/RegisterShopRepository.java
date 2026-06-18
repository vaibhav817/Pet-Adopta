package pet.project.PetAdopa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterShopRepository extends JpaRepository<RegisterShop, Long> {
}