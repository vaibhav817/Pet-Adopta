package pet.project.PetAdopa.Repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pet.project.PetAdopa.Entity.Product;
//@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
     @Override
     List<Product> findAll();
}