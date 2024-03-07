package br.com.joaogabriel.drugstore.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import br.com.joaogabriel.drugstore.model.enumerations.ContractualModelType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "tb_employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
	@Column(nullable = false)
	private String pis;
	
	@Temporal(TemporalType.DATE)
	private LocalDate admissionDate;
	
	@Column(nullable = false)
	private String responsibility;
	
	@Enumerated(EnumType.STRING)
	private ContractualModelType contractualModel;
	
	@Column(nullable = false, precision = 10, scale = 2)
	private BigDecimal salaryBase;
	
	@Column(nullable = false)
	private Integer weekHoours;
	
	@Column(nullable = false)
	private String jobFunctions;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Address workplace;
	
	@Column(nullable = false)
	private Integer entryTime;
	
	@Column(nullable = false)
	private Integer departureTime;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private SimplePerson person;
	
	@Column(nullable = false)
	@Lob
	private byte[] photo;
	
	@OneToMany(mappedBy = "employee")
	private List<Sale> sales;
	
	public Employee() {}

	public Employee(String pis, LocalDate admissionDate, String responsibility, ContractualModelType contractualModel,
			BigDecimal salaryBase, Integer weekHoours, String jobFunctions, Address workplace, Integer entryTime,
			Integer departureTime, SimplePerson person) {
		super();
		this.pis = pis;
		this.admissionDate = admissionDate;
		this.responsibility = responsibility;
		this.contractualModel = contractualModel;
		this.salaryBase = salaryBase;
		this.weekHoours = weekHoours;
		this.jobFunctions = jobFunctions;
		this.workplace = workplace;
		this.entryTime = entryTime;
		this.departureTime = departureTime;
		this.person = person;
	}

	
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getPis() {
		return pis;
	}

	public void setPis(String pis) {
		this.pis = pis;
	}

	public LocalDate getAdmissionDate() {
		return admissionDate;
	}

	public void setAdmissionDate(LocalDate admissionDate) {
		this.admissionDate = admissionDate;
	}

	public String getResponsibility() {
		return responsibility;
	}

	public void setResponsibility(String responsibility) {
		this.responsibility = responsibility;
	}

	public ContractualModelType getContractualModel() {
		return contractualModel;
	}

	public void setContractualModel(ContractualModelType contractualModel) {
		this.contractualModel = contractualModel;
	}

	public BigDecimal getSalaryBase() {
		return salaryBase;
	}

	public void setSalaryBase(BigDecimal salaryBase) {
		this.salaryBase = salaryBase;
	}

	public Integer getWeekHoours() {
		return weekHoours;
	}

	public void setWeekHoours(Integer weekHoours) {
		this.weekHoours = weekHoours;
	}

	public String getJobFunctions() {
		return jobFunctions;
	}

	public void setJobFunctions(String jobFunctions) {
		this.jobFunctions = jobFunctions;
	}

	public Address getWorkplace() {
		return workplace;
	}

	public void setWorkplace(Address workplace) {
		this.workplace = workplace;
	}

	public Integer getEntryTime() {
		return entryTime;
	}

	public void setEntryTime(Integer entryTime) {
		this.entryTime = entryTime;
	}

	public Integer getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(Integer departureTime) {
		this.departureTime = departureTime;
	}

	public SimplePerson getPerson() {
		return person;
	}

	public void setPerson(SimplePerson person) {
		this.person = person;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	public byte[] getPhoto() {
		return photo;
	}
	
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(id, other.id);
	}

}
