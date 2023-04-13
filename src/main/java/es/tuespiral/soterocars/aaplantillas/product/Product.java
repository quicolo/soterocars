package es.tuespiral.soterocars.aaplantillas.product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import es.tuespiral.soterocars.aaplantillas.orderproduct.OrderProduct;
import lombok.NonNull;

@Entity	
@Table(name="PRODUCTS")
public class Product {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
	@NonNull
	private String name;
	
	@Column(length=500, nullable=true)
	private String description;
	
	@Column
	private BigDecimal price;

	@OneToMany(mappedBy="product")
	private List<OrderProduct> orderProducts = new ArrayList<>();	
	
	public Product () {}
	
	public Product(String name, String description, double price) {
		this.name = name;
		this.description = description;
		this.price = BigDecimal.valueOf(price);
	}

	public Product(@NonNull String name, @NonNull String description, @NonNull BigDecimal price) {
		this.name = name;
		this.description = description;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", orderProducts=" + orderProducts + "]";
	}
	
//	public List<Order> getOrders() {
//		return orderProducts.stream()
//				.map(op -> op.getOrder())
//				.collect(Collectors.toList());
//	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public List<OrderProduct> getOrderProducts() {
		return orderProducts;
	}

	public void setOrderProducts(List<OrderProduct> orderProducts) {
		this.orderProducts = orderProducts;
	}
	
	
}
