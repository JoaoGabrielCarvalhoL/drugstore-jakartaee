package br.com.joaogabriel.drugstore.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "tb_product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
	@Column(nullable = false, length = 50)
	private String name;
	
	@Column(nullable = false)
	private String description;
	
	@Column(nullable = false)
	private String composition;

	@Column(nullable = true)
	private String observations;
	
	@Column(nullable = false)
	private Integer amount;
	
	@Column(nullable = false, precision = 10, scale = 2)
	private BigDecimal price;
	
	@Temporal(TemporalType.DATE)
	private LocalDate expirationDate;
	
	@Column(nullable = false)
	private Boolean isPerishable;
	
	@ManyToOne
	private Category category;
	
	@ManyToOne
	private Supplier supplier;
	
	public Product() {}

	public Product(String name, String description, String composition, String observations, Integer amount,
			BigDecimal price, LocalDate expirationDate, Boolean isPerishable, Category category, Supplier supplier) {
		super();
		this.name = name;
		this.description = description;
		this.composition = composition;
		this.observations = observations;
		this.amount = amount;
		this.price = price;
		this.expirationDate = expirationDate;
		this.isPerishable = isPerishable;
		this.category = category;
		this.supplier = supplier;
	}



	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public LocalDate getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(LocalDate expirationDate) {
		this.expirationDate = expirationDate;
	}

	public Boolean getIsPerishable() {
		return isPerishable;
	}

	public void setIsPerishable(Boolean isPerishable) {
		this.isPerishable = isPerishable;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	
	public Category getCategory() {
		return category;
	}
	
	public void setCategory(Category category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getComposition() {
		return composition;
	}

	public void setComposition(String composition) {
		this.composition = composition;
	}

	public String getObservations() {
		return observations;
	}

	public void setObservations(String observations) {
		this.observations = observations;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(id, other.id);
	}
	
	

}
