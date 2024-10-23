package ie.atu.week5cicd;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProductService {
    private List<Product> myList = new ArrayList<>();
    public List<Product> addProduct(Product product)
    {
        //Imagine we have a connection to the database
        myList.add(product);
        return myList;
    }
}
