package es.tuespiral.soterocars.aaplantillas.orderproduct;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import es.tuespiral.soterocars.aaplantillas.order.Order;
import es.tuespiral.soterocars.aaplantillas.product.Product;

@Entity
@Table(name="ORDERS_PRODUCTS")
public class OrderProduct {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
	private int quantity;
	
	@ManyToOne
	@JsonIgnore
    private Product product;
	
    @ManyToOne
    @JsonIgnore
    private Order order;
 
	public OrderProduct(Order order, Product product, int quantity) {
		super();
		this.order = order;
		this.product = product;
		this.quantity = quantity;
	}
    
	public OrderProduct() {}
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "OrderProduct [id=" + id + ", orderId=" + order.getId() + ", productId=" + product.getId() + ", quantity=" + quantity + "]";
	}


}
