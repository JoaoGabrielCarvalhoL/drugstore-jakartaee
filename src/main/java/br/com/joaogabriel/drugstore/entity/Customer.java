package br.com.joaogabriel.drugstore.entity;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "tb_customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private SimplePerson simplePerson;
	
	@Temporal(TemporalType.DATE)
	private LocalDate registerDate;
	
	@OneToMany(mappedBy = "customer")
	private List<Sale> sales;
	
	public Customer() {}

	public Customer(SimplePerson simplePerson, LocalDate registerDate, List<Sale> sales) {
		super();
		this.simplePerson = simplePerson;
		this.registerDate = registerDate;
		this.sales = sales;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public SimplePerson getSimplePerson() {
		return simplePerson;
	}

	public void setSimplePerson(SimplePerson simplePerson) {
		this.simplePerson = simplePerson;
	}

	public LocalDate getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(LocalDate registerDate) {
		this.registerDate = registerDate;
	}

	public List<Sale> getSales() {
		return sales;
	}

	public void setSales(List<Sale> sales) {
		this.sales = sales;
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
		Customer other = (Customer) obj;
		return Objects.equals(id, other.id);
	}
	
	

}
