package tomato.backends.productservice.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tomato.backends.productservice.models.Product;
import tomato.backends.productservice.repositories.ProductRepository;
import tomato.backends.productservice.services.ProductService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
