package pet.project.PetAdopa.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pet.project.PetAdopa.Units.RegisterShop;


public interface RegisterShopRepository extends JpaRepository<RegisterShop, Long> {
   List<RegisterShop> allShop();
}