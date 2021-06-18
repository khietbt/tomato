package tomato.backends.productservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tomato.backends.productservice.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
}
