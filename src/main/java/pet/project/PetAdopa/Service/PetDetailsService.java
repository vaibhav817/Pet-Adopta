package pet.project.PetAdopa.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import pet.project.PetAdopa.Entity.PetDetails;
import pet.project.PetAdopa.Repository.PetDetailsRepository;

@Service
public class PetDetailsService {

    public  final PetDetailsRepository petDetailsRepository;

    public PetDetailsService(PetDetailsRepository petDetailsRepository){
        this.petDetailsRepository=petDetailsRepository;
    }
    public PetDetails addNewPet(String petName,int age,double price,String species,
                                byte[] image){
        PetDetails pet = new PetDetails(petName,age,price,species,image);
        return petDetailsRepository.save(pet);
    }
    public List<PetDetails> getAllPets() {
        return petDetailsRepository.findAll();
    }
}
