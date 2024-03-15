package br.com.joaogabriel.drugstore.entity;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_supplier")
public class Supplier {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String nationalRegisterLegalEntities;
	
	@Embedded
	private Contact contact;

	@ManyToOne
	private Address address;
	
	@OneToMany(mappedBy = "supplier")
	private List<Product> products;
	
	public Supplier() { }
	
	public Supplier(String name, String nationalRegisterLegalEntities) {
		this.name = name;
		this.nationalRegisterLegalEntities = nationalRegisterLegalEntities;
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

	public String getNationalRegisterLegalEntities() {
		return nationalRegisterLegalEntities;
	}

	public void setNationalRegisterLegalEntities(String nationalRegisterLegalEntities) {
		this.nationalRegisterLegalEntities = nationalRegisterLegalEntities;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	public List<Product> getProducts() {
		return products;
	}
	
	public void setProducts(List<Product> products) {
		this.products = products;
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
		Supplier other = (Supplier) obj;
		return Objects.equals(id, other.id);
	}
	
	
   
	
}
