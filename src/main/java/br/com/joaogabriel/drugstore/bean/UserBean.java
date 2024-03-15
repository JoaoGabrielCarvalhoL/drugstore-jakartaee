package br.com.joaogabriel.drugstore.bean;

import java.io.Serializable;

import br.com.joaogabriel.drugstore.entity.Address;
import br.com.joaogabriel.drugstore.entity.Contact;
import br.com.joaogabriel.drugstore.entity.SimplePerson;
import br.com.joaogabriel.drugstore.entity.User;
import br.com.joaogabriel.drugstore.entity.UserInformations;
import br.com.joaogabriel.drugstore.mapper.AddressMapper;
import br.com.joaogabriel.drugstore.service.UserService;
import br.com.joaogabriel.drugstore.service.impl.UserServiceImpl;
import br.com.joaogabriel.drugstore.ws.payload.AddressResponse;
import br.com.joaogabriel.drugstore.ws.resource.AddressResource;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.servlet.http.HttpServletRequest;

@Named
@ViewScoped
public class UserBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String zipCode;
	private SimplePerson person = new SimplePerson();;
	private Address address = new Address();
	private Contact contact = new Contact();
	private User user = new User();
	private FacesContext facesContext;
	
	private AddressResource addressResource = new AddressResource();
	private AddressMapper mapper = new AddressMapper();
	private UserService userService = new UserServiceImpl();
	
	@Inject
	public UserBean(FacesContext facesContext) {
		this.facesContext = facesContext;
	}
	
	public UserInformations retrieveUserInformationsByRequest() {
		HttpServletRequest httpServletRequest = (HttpServletRequest)	 facesContext.getExternalContext().getRequest();
		String agent = httpServletRequest.getHeader("User-Agent");
		String ip = httpServletRequest.getRemoteAddr();
		String locale = httpServletRequest.getLocale().toString();
		
		System.out.println(agent +  " " +  ip + " " + locale);
		return new UserInformations(ip, agent, locale);
	}
	
	public void findAddressByZipCode() {
		AddressResponse response = addressResource.getAddressByCep(zipCode);
		Address address = mapper.toAddress(response);
		this.address = address;
		
	}
	
	public void save() {
		System.out.println(user);
		person.setAddress(address);
		person.setContact(contact);
		user.setPerson(person);
		user.setUserInformations(retrieveUserInformationsByRequest());
		this.userService.save(this.user);
		cleanObjects();
	}
	
	public void remove() {
		
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public String getZipCode() {
		return zipCode;
	}
	
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public AddressResource getAddressResource() {
		return addressResource;
	}

	public void setAddressResource(AddressResource addressResource) {
		this.addressResource = addressResource;
	}

	public AddressMapper getMapper() {
		return mapper;
	}

	public void setMapper(AddressMapper mapper) {
		this.mapper = mapper;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public SimplePerson getPerson() {
		return person;
	}

	public void setPerson(SimplePerson person) {
		this.person = person;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}
	
	
	public void cleanObjects() {
		this.contact = new Contact();
		this.address = new Address();
		this.person = new SimplePerson();
		this.user = new User();
	}
	

}
