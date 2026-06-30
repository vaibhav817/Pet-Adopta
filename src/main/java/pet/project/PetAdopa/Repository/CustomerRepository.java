package pet.project.PetAdopa.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import pet.project.PetAdopa.Entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Customer findByEmail(String email);
}
