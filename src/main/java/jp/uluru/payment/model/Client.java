package jp.uluru.payment.model;

import java.security.Principal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "clients")
@XmlRootElement
public class Client implements Principal{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@NotNull
	@Column(length = 255)
	private String name;

	@NotNull
	@Column(name = "api_token_test", length = 255)
	private String apiTokenTest;

	@NotNull
	@Column(name = "api_token_live", length = 255)
	private String apiTokenLive;

	@NotNull
	@Column(name = "is_active")
	private boolean isActive;

	@NotNull
	@Column(name = "created_at")
	private Date createdAt;

	@NotNull
	@Column(name = "updated_at")
	private Date updatedAt;

	public Client() {

	}

	public Client(String name, String apiTokenTest, String apiTokenLive) {
		super();
		this.name = name;
		this.apiTokenTest = apiTokenTest;
		this.apiTokenLive = apiTokenLive;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getApiTokenTest() {
		return apiTokenTest;
	}

	public void setApiTokenTest(String apiTokenTest) {
		this.apiTokenTest = apiTokenTest;
	}

	public String getApiTokenLive() {
		return apiTokenLive;
	}

	public void setApiTokenLive(String apiTokenLive) {
		this.apiTokenLive = apiTokenLive;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

}
