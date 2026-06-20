package pet.project.PetAdopa.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pet.project.PetAdopa.Units.Product;
//@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}