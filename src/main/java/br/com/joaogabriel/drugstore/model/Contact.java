package br.com.joaogabriel.drugstore.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Contact {

	@Column(nullable = false)
	private String cellphone;
	
	@Column(nullable = true)
	private String telephone;
	
	public Contact() {}
	
	public Contact(String cellphone, String telephone) {
		this.cellphone = cellphone;
		this.telephone = telephone;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	
}
