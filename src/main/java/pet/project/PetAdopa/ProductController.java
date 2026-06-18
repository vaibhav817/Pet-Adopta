package pet.project.PetAdopa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/seller/addProduct")
    public String addProduct(@RequestParam("productName") String productName,
                             @RequestParam("productType") String productType,
                             @RequestParam("productDescription") String productDescription,
                             @RequestParam("productImage") MultipartFile productImage,
                             RedirectAttributes redirectAttributes) {
        try {
            productService.saveProduct(productName, productType, productDescription, productImage);
            redirectAttributes.addFlashAttribute("message", "Product listed successfully!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Failed to upload product: " + e.getMessage());
        }
        
        // Redirect back to dashboard to see changes or status
        return "redirect:/seller_dashboard";
    }
}
