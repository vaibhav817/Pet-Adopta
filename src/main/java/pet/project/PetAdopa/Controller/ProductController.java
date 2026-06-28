package pet.project.PetAdopa.Controller;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pet.project.PetAdopa.Service.ProductService;
import pet.project.PetAdopa.Units.Product;
@Controller
public class ProductController {
    //@Autowired
    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService=productService;
    }

    @PostMapping("/seller/addProduct")
    public String addProduct(@RequestParam("productName") String productName,
                             @RequestParam("productType") String productType,
                             @RequestParam("productDescription") String productDescription,
                             @RequestParam("productImage") MultipartFile productImage,
                             RedirectAttributes redirectAttributes) {
        try {
            productService.saveProduct(productName, productType, productDescription, productImage);
            redirectAttributes.addFlashAttribute("message", "Product listed successfully!");
        } catch (IOException | IllegalStateException e) { // multicatch for IO / storage issues
            redirectAttributes.addFlashAttribute("error", "Failed to save product image: " + e.getMessage());
        } catch (org.springframework.web.multipart.MultipartException e) { // invalid upload
            redirectAttributes.addFlashAttribute("error", "Invalid file upload: " + e.getMessage());
        } catch (org.springframework.dao.DataAccessException e) { // DB errors
            redirectAttributes.addFlashAttribute("error", "Database error: " + e.getMessage());
        }catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Failed to upload product: " + e.getMessage());
        }
        
        // Redirect back to dashboard to see changes or status
        return "redirect:/seller_dashboard";
    }
    @GetMapping("/api/products")
    @ResponseBody
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }
}
