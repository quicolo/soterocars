package es.tuespiral.soterocars.aaplantillas.orderproduct;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderProductRepository extends CrudRepository<OrderProduct, Long> {
	public List<OrderProduct> findByProductId(Long productId);
	
}