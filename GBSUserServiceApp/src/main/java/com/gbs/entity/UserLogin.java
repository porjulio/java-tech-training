package com.gbs.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name="USERS")
public class UserLogin {
	
	@Column(name="USER_ID")
	private @NotBlank Long userID;
	@Id
	@Column(name="USER_NAME")
	private @NotBlank String userName;
	@Column (name="USER_PASSWORD")
	private @NotBlank String userPassword;
	@Column(name="CREATION_DATE")
	LocalDateTime createDate = LocalDateTime.now();
	@Column(name="NUMBER_OF_ACCOUNTS")
	private int numberOfAccounts;
	@Column(name="ACCOUNT_NUMBER")
	private String accountNumberString;
	@Column(name="TOTAL_BALANCE")
	private Float totalBalance;
	@Column(name="CONTACT_NUMBER")
	private String contactNumber;
	
	
	public UserLogin() {
		super();
	}


	public UserLogin(@NotBlank Long userID, @NotBlank String userName, @NotBlank String userPassword,
			LocalDateTime createDate, int numberOfAccounts, String accountNumberString, Float totalBalance,
			String contactNumber) {
		super();
		this.userID = userID;
		this.userName = userName;
		this.userPassword = userPassword;
		this.createDate = createDate;
		this.numberOfAccounts = numberOfAccounts;
		this.accountNumberString = accountNumberString;
		this.totalBalance = totalBalance;
		this.contactNumber = contactNumber;
	}


	public Long getUserID() {
		return userID;
	}


	public void setUserID(Long userID) {
		this.userID = userID;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getUserPassword() {
		return userPassword;
	}


	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}


	public LocalDateTime getCreateDate() {
		return createDate;
	}


	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}


	public int getNumberOfAccounts() {
		return numberOfAccounts;
	}


	public void setNumberOfAccounts(int numberOfAccounts) {
		this.numberOfAccounts = numberOfAccounts;
	}


	public String getAccountNumberString() {
		return accountNumberString;
	}


	public void setAccountNumberString(String accountNumberString) {
		this.accountNumberString = accountNumberString;
	}


	public Float getTotalBalance() {
		return totalBalance;
	}


	public void setTotalBalance(Float totalBalance) {
		this.totalBalance = totalBalance;
	}


	public String getContactNumber() {
		return contactNumber;
	}


	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}



}