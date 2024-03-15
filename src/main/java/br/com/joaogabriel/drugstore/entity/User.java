package br.com.joaogabriel.drugstore.entity;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import br.com.joaogabriel.drugstore.model.enumerations.RoleType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "tb_user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
	@Column(nullable = false, unique = true)
	private String username;

	@Column(nullable = false, unique = true)
	private String email;
	
	@Enumerated(EnumType.STRING)
	private RoleType role;
	
	@Column(nullable = false)
	private String hashPassword;
	
	@Column(nullable = true)
	private String hashPasswordReset;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = true)
	private LocalDateTime hashPasswordResetIn;
	
	@Column(nullable = true)
	private Boolean isVerified;
	
	@Column(nullable = false)
	private Boolean isTwoFactorAuthentication;
	
	@Column(nullable = true)
	private Boolean isActive;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private SimplePerson person;
	
	@OneToOne(cascade = CascadeType.ALL)
	private UserInformations userInformations = new  UserInformations();;
	
	public User() { }

	public User(UUID id, String username, String email, RoleType role, String hashPassword, Boolean isVerified,
			Boolean isTwoFactorAuthentication, Boolean isActive, SimplePerson person,
			UserInformations userInformations) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.role = role;
		this.hashPassword = hashPassword;
		this.isVerified = isVerified;
		this.isTwoFactorAuthentication = isTwoFactorAuthentication;
		this.isActive = isActive;
		this.person = person;
		this.userInformations = userInformations;
	}
	
	public User(String username, String email, RoleType role, String hashPassword, Boolean isActive,
			SimplePerson person, UserInformations userInformations) {
		super();
		this.username = username;
		this.email = email;
		this.role = role;
		this.hashPassword = hashPassword;
		this.isActive = isActive;
		this.person = person;
		this.userInformations = userInformations;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public RoleType getRole() {
		return role;
	}

	public void setRole(RoleType role) {
		this.role = role;
	}

	public String getHashPassword() {
		return hashPassword;
	}

	public void setHashPassword(String hashPassword) {
		this.hashPassword = hashPassword;
	}

	public String getHashPasswordReset() {
		return hashPasswordReset;
	}

	public void setHashPasswordReset(String hashPasswordReset) {
		this.hashPasswordReset = hashPasswordReset;
	}

	public LocalDateTime getHashPasswordResetIn() {
		return hashPasswordResetIn;
	}

	public void setHashPasswordResetIn(LocalDateTime hashPasswordResetIn) {
		this.hashPasswordResetIn = hashPasswordResetIn;
	}

	public Boolean getIsVerified() {
		return isVerified;
	}

	public void setIsVerified(Boolean isVerified) {
		this.isVerified = isVerified;
	}

	public Boolean getIsTwoFactorAuthentication() {
		return isTwoFactorAuthentication;
	}

	public void setIsTwoFactorAuthentication(Boolean isTwoFactorAuthentication) {
		this.isTwoFactorAuthentication = isTwoFactorAuthentication;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public SimplePerson getPerson() {
		return person;
	}

	public void setPerson(SimplePerson person) {
		this.person = person;
	}

	public UserInformations getUserInformations() {
		return userInformations;
	}

	public void setUserInformations(UserInformations userInformations) {
		this.userInformations = userInformations;
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
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", email=" + email + ", role=" + role + ", hashPassword="
				+ hashPassword + ", hashPasswordReset=" + hashPasswordReset + ", hashPasswordResetIn="
				+ hashPasswordResetIn + ", isVerified=" + isVerified + ", isTwoFactorAuthentication="
				+ isTwoFactorAuthentication + ", isActive=" + isActive + ", person=" + person + ", userInformations="
				+ userInformations + "]";
	}
	
	
	
}
