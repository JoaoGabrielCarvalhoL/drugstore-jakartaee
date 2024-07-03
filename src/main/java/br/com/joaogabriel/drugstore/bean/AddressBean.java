package br.com.joaogabriel.drugstore.bean;

import java.io.Serializable;

import br.com.joaogabriel.drugstore.entity.Address;
import br.com.joaogabriel.drugstore.entity.User;
import br.com.joaogabriel.drugstore.mapper.AddressMapper;
import br.com.joaogabriel.drugstore.ws.payload.AddressResponse;
import br.com.joaogabriel.drugstore.ws.resource.AddressResource;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

@Named
@ViewScoped
public class AddressBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private AddressResource addressResource = new AddressResource();
	private Address address = new Address();
	private User user = new User();
	private AddressMapper mapper = new AddressMapper();
	private String zipCode;
	
	public void findAddressByZipCode() {
		AddressResponse response = addressResource.getAddressByCep(zipCode);
		mapper.toAddress(response);
	}

	public AddressResource getAddressResource() {
		return addressResource;
	}

	public void setAddressResource(AddressResource addressResource) {
		this.addressResource = addressResource;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public AddressMapper getMapper() {
		return mapper;
	}

	public void setMapper(AddressMapper mapper) {
		this.mapper = mapper;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	

}
