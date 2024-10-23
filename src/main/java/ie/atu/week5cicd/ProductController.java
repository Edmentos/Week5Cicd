package ie.atu.week5cicd;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
    public List<Product> newProduct(@RequestBody Product product)
    {
        //Business logic to add this to a database
        ProductService myProduct = new ProductService();
        myList = myProduct.addProduct(product);
        //Return a list of all the products from the database
        return myList;
    }
}
