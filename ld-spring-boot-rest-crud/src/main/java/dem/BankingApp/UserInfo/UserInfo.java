package dem.BankingApp.UserInfo;

import java.time.LocalDateTime;

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
	private Long userId;
	@Column(name="USER_NAME")
	private String userNameString;
	@Column (name="USER_PASSWORD")
	private String userPassword;
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
	
	public UserInfo() {
		super();
	}

	public UserInfo(Long userId, String userNameString, String userPassword, int numberOfAccounts,
			String accountNumberString, Float totalBalance, String contactNumber, LocalDateTime createDate) {
		super();
		this.userId = userId;
		this.userNameString = userNameString;
		this.userPassword = userPassword;
		this.createDate = createDate;
		this.numberOfAccounts = numberOfAccounts;
		this.accountNumberString = accountNumberString;
		this.totalBalance = totalBalance;
		this.contactNumber = contactNumber;
	}

	public Long getuserId() {
		return userId;
	}

	public void setuserId(Long userId) {
		this.userId = userId;
	}

	public String getUserNameString() {
		return userNameString;
	}

	public void setUserNameString(String userNameString) {
		this.userNameString = userNameString;
	}
	
	public String getUserPassword() {
		return userPassword;
	}
	
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public Object getCreateDate() {
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

