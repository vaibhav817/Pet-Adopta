package pet.project.PetAdopa;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product saveProduct(String name, String type, String description, MultipartFile file) throws IOException {
        byte[] imageBytes = null;
        if (file != null && !file.isEmpty()) {
            imageBytes = file.getBytes();
        }
        
        Product product = new Product(name, type, description, imageBytes);
        return productRepository.save(product);
    }
}
