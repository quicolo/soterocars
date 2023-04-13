package es.tuespiral.soterocars.aaplantillas.order;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import es.tuespiral.soterocars.aaplantillas.customer.Customer;
import es.tuespiral.soterocars.aaplantillas.orderproduct.OrderProduct;
import es.tuespiral.soterocars.aaplantillas.product.Product;
import lombok.Data;

@Entity
@Table(name="ORDERS")
public class Order {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
	@Column(name="ORDER_DATE", nullable=false)
	private LocalDate orderDate;
	
	@Column(name="ORDER_STATUS", nullable=true)
	private String status;
	
	@ManyToOne
	@JsonIgnore	
	private Customer customer;

	@OneToMany(mappedBy="order")
	private List<OrderProduct> orderProducts = new ArrayList<>();
	
	public void setOrderProducts(List<OrderProduct> orderProducts) {
		this.orderProducts = orderProducts;
	}
	
	public List<OrderProduct> getOrderProducts() {
		return orderProducts;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
}
