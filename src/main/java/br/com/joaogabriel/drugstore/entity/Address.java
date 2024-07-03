package br.com.joaogabriel.drugstore.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import br.com.joaogabriel.drugstore.model.enumerations.AddressType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_address")
public class Address implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

	@Column(nullable = false)
	private String zipCode;
	
	@Column(nullable = false)
	private String publicPlace;
	
	@Column(nullable = false)
	private String complement;
	
	@Column(nullable = false)
	private String neighborhood;
	
	@Column(nullable = false)
	private String locality;
	
	@Column(nullable = false)
	private String federativeUnit;
	
	@Column(nullable = false)
	private String directRemoteDialing;
	
	@Enumerated(EnumType.STRING)
	private AddressType addressType;
	
	@Column(nullable = true )
	private String houseNumber;
	
	@OneToMany(mappedBy = "address")
	private List<SimplePerson> persons;
	
	public Address() {
		
	}

	public Address(String zipCode, String publicPlace, String complement, String neighborhood, String locality,
			String federativeUnit, String directRemoteDialing, 
			AddressType addressType, String houseNumber) {
		this.zipCode = zipCode;
		this.publicPlace = publicPlace;
		this.complement = complement;
		this.neighborhood = neighborhood;
		this.locality = locality;
		this.federativeUnit = federativeUnit;
		this.directRemoteDialing = directRemoteDialing;
		this.addressType = addressType;
		this.houseNumber = houseNumber;
	}

	public Address(String zipCode, String publicPlace, String complement, String neighborhood, String locality,
			String federativeUnit, String directRemoteDialing) {
		this.zipCode = zipCode;
		this.publicPlace = publicPlace;
		this.complement = complement;
		this.neighborhood = neighborhood;
		this.locality = locality;
		this.federativeUnit = federativeUnit;
		this.directRemoteDialing = directRemoteDialing;
	}
	
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getPublicPlace() {
		return publicPlace;
	}

	public void setPublicPlace(String publicPlace) {
		this.publicPlace = publicPlace;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getFederativeUnit() {
		return federativeUnit;
	}

	public void setFederativeUnit(String federativeUnit) {
		this.federativeUnit = federativeUnit;
	}

	public String getDirectRemoteDialing() {
		return directRemoteDialing;
	}

	public void setDirectRemoteDialing(String directRemoteDialing) {
		this.directRemoteDialing = directRemoteDialing;
	}

	public AddressType getAddressType() {
		return addressType;
	}

	public void setAddressType(AddressType addressType) {
		this.addressType = addressType;
	}
	
	public List<SimplePerson> getPersons() {
		return persons;
	}
	
	public void setPersons(List<SimplePerson> persons) {
		this.persons = persons;
	}
	
	public String getHouseNumber() {
		return houseNumber;
	}
	
	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
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
		Address other = (Address) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", zipCode=" + zipCode + ", publicPlace=" + publicPlace + ", complement="
				+ complement + ", neighborhood=" + neighborhood + ", locality=" + locality + ", federativeUnit="
				+ federativeUnit + ", directRemoteDialing=" + directRemoteDialing + ", addressType=" + addressType
				+ ", persons=" + persons + "]";
	}
	
}
