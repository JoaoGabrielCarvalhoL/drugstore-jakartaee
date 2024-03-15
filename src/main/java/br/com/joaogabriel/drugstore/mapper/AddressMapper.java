package br.com.joaogabriel.drugstore.mapper;

import br.com.joaogabriel.drugstore.entity.Address;
import br.com.joaogabriel.drugstore.ws.payload.AddressResponse;

public class AddressMapper {
	
	public Address toAddress(AddressResponse addressResponse) {
		return new Address(addressResponse.getZipCode(), addressResponse.getPublicPlace(), addressResponse.getComplement(), 
				addressResponse.getNeighborhood(), addressResponse.getLocality(), addressResponse.getFederativeUnit(), addressResponse.getDirectRemoteDialing());
	}
}
