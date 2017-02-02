package jp.uluru.payment.model;

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
@Table(name = "banks")
@XmlRootElement
public class Bank {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@NotNull
	@Column(name = "user_id")
	private int userId;

	@NotNull
	@Column(name = "bank_code", length = 255)
	private String bankCode;

	@NotNull
	@Column(name = "bank_name", length = 255)
	private String bankName;

	@NotNull
	@Column(name = "branch_code", length = 255)
	private String branchCode;

	@NotNull
	@Column(name = "branch_name", length = 255)
	private String branchName;

	@NotNull
	@Column(name = "account_type")
	private int accountType;

	@NotNull
	@Column(name = "account_no", length = 8)
	private String accountNo;

	@NotNull
	@Column(name = "account_name", length = 255)
	private String accountName;

	@NotNull
	@Column(name = "bank_type")
	private int bankType;

	@NotNull
	@Column(name = "japanpost_code_no", length = 255)
	private String japanPostCodeNo;

	@NotNull
	@Column(name = "japanpost_account_no", length = 255)
	private String japanPostAccountNo;

	@NotNull
	@Column(name = "created_at")
	private Date createdAt;

	@NotNull
	@Column(name = "updated_at")
	private Date updatedAt;

	public Bank() {

	}

	public Bank(int userId, String bankCode, String bankName, String branchCode, String branchName, int accountType,
			String accountNo, String accountName, int bankType) {
		super();
		this.userId = userId;
		this.bankCode = bankCode;
		this.bankName = bankName;
		this.branchCode = branchCode;
		this.branchName = branchName;
		this.accountType = accountType;
		this.accountNo = accountNo;
		this.accountName = accountName;
		this.bankType = bankType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public int getAccountType() {
		return accountType;
	}

	public void setAccountType(int accountType) {
		this.accountType = accountType;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public int getBankType() {
		return bankType;
	}

	public void setBankType(int bankType) {
		this.bankType = bankType;
	}

	public String getJapanPostCodeNo() {
		return japanPostCodeNo;
	}

	public void setJapanPostCodeNo(String japanPostCodeNo) {
		this.japanPostCodeNo = japanPostCodeNo;
	}

	public String getJapanPostAccountNo() {
		return japanPostAccountNo;
	}

	public void setJapanPostAccountNo(String japanPostAccountNo) {
		this.japanPostAccountNo = japanPostAccountNo;
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
