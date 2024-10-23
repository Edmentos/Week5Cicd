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
        //Business logic to add this to a database
        //ProductService myProduct = new ProductService();
        //myList = myProduct.addProduct(product);
        //Return a list of all the products from the database
        return myProduct.addProduct(product);
    }
    @PutMapping("/{id}")
    public ResponseEntity<List> updateProduct(@PathVariable int id, @RequestBody Product product)
    {
        for(int i = 0; i< myList.size(); i++){
            if(myList.get(i).getId() == id){
                myList.set(i, product);
            }
        }
        return ResponseEntity.ok(myList);
    }

    @DeleteMapping("deleteProduct/{id}")
    public ResponseEntity deleteProduct(@PathVariable long id){int num = (int) id;

        for (int count = 0; count < myList.size(); count++)
        {
            if (myList.get(count).getId() == num){myList.remove(count);}
        }
        return ResponseEntity.ok(myList);
    }
}
