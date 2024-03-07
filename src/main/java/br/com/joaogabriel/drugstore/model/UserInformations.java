package br.com.joaogabriel.drugstore.model;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_user_informations")
public class UserInformations {

	@Id
	@GeneratedValue()
	private UUID id;
	
	@Column(nullable = false)
	private String internetProtocol;
	
	@Column(nullable = false)
	private String userAgent;
	
	@Column(nullable = false)
	private String locale;
	
	@OneToOne(mappedBy = "userInformations")
	private User user;
	
	public UserInformations() { }
	
	public UserInformations(String internetProtocol, String userAgent, String locale) {
		this.internetProtocol = internetProtocol; 
		this.userAgent = userAgent; 
		this.locale = locale;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getInternetProtocol() {
		return internetProtocol;
	}

	public void setInternetProtocol(String internetProtocol) {
		this.internetProtocol = internetProtocol;
	}

	public String getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	
}
