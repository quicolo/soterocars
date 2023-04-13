package es.tuespiral.soterocars.aaplantillas.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.tuespiral.soterocars.aaplantillas.order.Order;
import es.tuespiral.soterocars.aaplantillas.orderproduct.OrderProductService;

@RestController
@RequestMapping("products")
public class ProductRestController {
	
	@Autowired
	private ProductService productService;
	@Autowired
	private OrderProductService ordProdService;
	
	
	@GetMapping("/")
	// Devuelve todos los productos desde la ruta: http://localhost:8080/products/
	public ResponseEntity<Iterable<Product>> findAll() {	
		return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
	}
	
	// Devuelve el producto con ID 1 desde la ruta: http://localhost:8080/products/1
	@GetMapping("/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id) throws ProductNotFoundException {
		return new ResponseEntity<>(productService.findById(id), HttpStatus.OK);
	}
	
	// Igual que el anterior pero usando un parámetro en la URL tipo nombre=valor
	// Devuelve el producto con ID 1 desde la ruta: http://localhost:8080/products/product?id=1
	@GetMapping("/product")
	public ResponseEntity<Product> findByIdWithParam(@RequestParam Long id) throws ProductNotFoundException {
		return findById(id);
	}
	
	// Creación de un producto desde la ruta: http://localhost:8080/products/
	@PostMapping("/")
	public ResponseEntity<Product> create(@RequestBody Product p) throws ProductException {
		Product product = productService.createProduct(p.getName(), p.getDescription(), p.getPrice());
		return new ResponseEntity<>(product, HttpStatus.CREATED);
	}
	
	// Modificación de un producto desde la ruta: http://localhost:8080/products/
	@PutMapping
	public ResponseEntity<Product> update(@RequestBody Product p) throws ProductException {
		Product product = productService.updateProduct(p.getId(), p.getName(), p.getDescription(), p.getPrice());
		return new ResponseEntity<>(product, HttpStatus.OK);
	}
	
	// Borrado de un producto con ID 3 desde la ruta: http://localhost:8080/products/3
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) throws ProductException  {
		productService.deleteProduct(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	// Devuelve los pedidos en los que aparece el producto con ID 1 desde la ruta: http://localhost:8080/products/product/1/orders
	@GetMapping("/product/{id}/orders")
	public ResponseEntity<List<Order>> findOrdersByIdProduct(@PathVariable Long id) {
		return new ResponseEntity<>(ordProdService.findOrdersByProductId(id), HttpStatus.OK);
	}
	
	
}
