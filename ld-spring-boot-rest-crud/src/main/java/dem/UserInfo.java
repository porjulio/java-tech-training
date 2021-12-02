package dem;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USERS")
public class UserInfo {
	@Id
	@Column(name="USER_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String userIdString;
	@Column(name="USER_NAME")
	private String userNameString;
	@Column(name="CREATION_DATE")
	private String creationDateString;
	@Column(name="NUMBER_OF_ACCOUNTS")
	private Integer numberOfAccounts;
	@Column(name="ACCOUNT_NUMBER")
	private String accountNumberString;
	@Column(name="TOTAL_BALANCE")
	private Float totalBalance;
	@Column(name="CONTACT_NUMBER")
	private String contactNumber;
	
	public UserInfo() {
		super();
	}

	public UserInfo(String userIdString, String userNameString, String creationDateString, Integer numberOfAccounts,
			String accountNumberString, Float totalBalance, String contactNumber) {
		super();
		this.userIdString = userIdString;
		this.userNameString = userNameString;
		this.creationDateString = creationDateString;
		this.numberOfAccounts = numberOfAccounts;
		this.accountNumberString = accountNumberString;
		this.totalBalance = totalBalance;
		this.contactNumber = contactNumber;
	}

	public String getUserIdString() {
		return userIdString;
	}

	public void setUserIdString(String userIdString) {
		this.userIdString = userIdString;
	}

	public String getUserNameString() {
		return userNameString;
	}

	public void setUserNameString(String userNameString) {
		this.userNameString = userNameString;
	}

	public String getCreationDateString() {
		return creationDateString;
	}

	public void setCreationDateString(String creationDateString) {
		this.creationDateString = creationDateString;
	}

	public Integer getNumberOfAccounts() {
		return numberOfAccounts;
	}

	public void setNumberOfAccounts(Integer numberOfAccounts) {
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

