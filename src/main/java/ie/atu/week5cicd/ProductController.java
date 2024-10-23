package ie.atu.week5cicd;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {
    private ProductService myProduct;


    public ProductController(ProductService myProduct) {
        this.myProduct = myProduct;
    }
    private List<Product> myList = new ArrayList<>();

    @PostMapping("/newProduct")
    public List<Product> newProduct(@Valid @RequestBody Product product)
    {
        return myProduct.addProduct(product);
    }
    @PutMapping("/{id}")
    public List<Product> updateProduct(@PathVariable int id, @RequestBody Product product)
    {
        return myProduct.putProduct(product,id);
    }

    @DeleteMapping("/{id}")
    public List<Product> deleteProduct(@PathVariable int id)
    {

        return myProduct.deleteProduct(id);
    }
}
