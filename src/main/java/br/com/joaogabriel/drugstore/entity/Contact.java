package br.com.joaogabriel.drugstore.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Contact implements Serializable {
	
	private static final long serialVersionUID = 1L;

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

	@Override
	public String toString() {
		return "Contact [cellphone=" + cellphone + ", telephone=" + telephone + "]";
	}
	
	
}
