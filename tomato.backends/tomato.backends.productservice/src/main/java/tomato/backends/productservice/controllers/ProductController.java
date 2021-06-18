package tomato.backends.productservice.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tomato.backends.productservice.models.Product;
import tomato.backends.productservice.services.ProductService;

import java.util.List;

@RequestMapping(path = "/products")
@RequiredArgsConstructor
@RestController
@Slf4j
public class ProductController {
    private final ProductService productService;

    @GetMapping
    ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();

        log.error("Found {} products", products.size());

        return ResponseEntity.ok(products);
    }
}
