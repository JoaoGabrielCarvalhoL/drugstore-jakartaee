package br.com.joaogabriel.drugstore.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.PastOrPresent;

@Entity
@Table(name = "tb_simple_person")
public class SimplePerson {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

	@Column(nullable = false)
	private String firstName;

	@Column(nullable = false)
	private String lastName;

	@Column(nullable = false, unique = true)
	private String individualCertificate;

	@Column(nullable = false, unique = true)
	private String generalRegistration;

	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	@PastOrPresent
	private LocalDate birthDate;

	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime createdIn;

	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime updatedIn;

	/*
	@ManyToMany
	@JoinTable(name = "addresses_persons", joinColumns = @JoinColumn(name = "simplePerson_id"), inverseJoinColumns = @JoinColumn(name = "address_id"))
	*/
	@ManyToOne(cascade = CascadeType.ALL)
	private Address address;
	
	@Embedded
	private Contact contact;

	public SimplePerson() {
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getIndividualCertificate() {
		return individualCertificate;
	}

	public void setIndividualCertificate(String individualCertificate) {
		this.individualCertificate = individualCertificate;
	}

	public String getGeneralRegistration() {
		return generalRegistration;
	}

	public void setGeneralRegistration(String generalRegistration) {
		this.generalRegistration = generalRegistration;
	}

	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public LocalDateTime getCreatedIn() {
		return createdIn;
	}

	private void setCreatedIn(LocalDateTime createdIn) {
		this.createdIn = createdIn;
	}

	public LocalDateTime getUpdatedIn() {
		return updatedIn;
	}

	private void setUpdatedIn(LocalDateTime updatedIn) {
		this.updatedIn = updatedIn;
	}
	
	public Contact getContact() {
		return contact;
	}
	
	public void setContact(Contact contact) {
		this.contact = contact;
	}

	@PrePersist
	private void setupCreatedIn() {
		this.setCreatedIn(LocalDateTime.now());
	}

	@PreUpdate
	public void setupUpdatedIn() {
		this.setUpdatedIn(LocalDateTime.now());
	}

	@Override
	public String toString() {
		return "SimplePerson [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", individualCertificate=" + individualCertificate + ", generalRegistration=" + generalRegistration
				+ ", birthDate=" + birthDate + ", createdIn=" + createdIn + ", updatedIn=" + updatedIn + ", address="
				+ address + ", contact=" + contact + "]";
	}
	
	
}
