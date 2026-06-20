package pet.project.PetAdopa.Service;

import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import pet.project.PetAdopa.Repository.ProductRepository;
import pet.project.PetAdopa.Units.Product;
@Service
public class ProductService{
    //@Autowired
    private final ProductRepository productRepository; 

    public ProductService(ProductRepository productRepository){
        this.productRepository=productRepository;
    }

    public Product saveProduct(String name, String type, String description, MultipartFile file) throws IOException {
        byte[] imageBytes = null;
        if (file != null && !file.isEmpty()) {
            imageBytes = file.getBytes();
        }
        
        Product product = new Product(name, type, description, imageBytes);
        return productRepository.save(product);
    }
}
