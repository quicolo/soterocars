package es.tuespiral.soterocars.aaplantillas.product;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
	// Búsquedas por una propiedad
	List<Product> findByName(String name);
	List<Product> findByNameIgnoreCase(String name);
	List<Product> findDistinctByNameIgnoreCase(String name);
	List<Product> findByNameOrderByPriceAsc(String name);
	List<Product> findByPrice(BigDecimal price);
	
	// Búsquedas por más de una propiedad
	List<Product> findByNameAndPrice(String name, BigDecimal price);
	List<Product> findByNameOrPrice(String name, BigDecimal price);
	
	// Búsquedas por rangos
	List<Product> findByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice);
	List<Product> findByPriceGreaterThanEqual(BigDecimal minPrice);
	List<Product> findByPriceLessThan(BigDecimal maxPrice);
	
	// Búsquedas por rangos con orden
	List<Product> findByPriceBetweenOrderByPriceAsc(BigDecimal minPrice, BigDecimal maxPrice);
	List<Product> findByPriceLessThanOrderByPriceDesc(BigDecimal maxPrice);
}
