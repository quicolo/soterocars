package es.tuespiral.soterocars.aaplantillas.orderproduct;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.tuespiral.soterocars.aaplantillas.order.Order;

@Service
public class OrderProductService {
	@Autowired
	private OrderProductRepository repo;
	
	public List<OrderProduct> findByProductId(Long productId) {
		return repo.findByProductId(productId);
	}
	
	public List<Order> findOrdersByProductId(Long productId) {
		List<OrderProduct> list = repo.findByProductId(productId);
		return list.stream().map(elem -> elem.getOrder()).collect(Collectors.toList());

//      SOLUCIÓN CLÁSICA-IMPERATIVA
//		List<Order> listOrd = new ArrayList<>();
//		for(OrderProduct op : list) {
//			listOrd.add(op.getOrder());
//		}
//		return listOrd;
	}
}
