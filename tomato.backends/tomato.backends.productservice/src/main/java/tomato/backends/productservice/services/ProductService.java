package tomato.backends.productservice.services;

import tomato.backends.productservice.models.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
}
