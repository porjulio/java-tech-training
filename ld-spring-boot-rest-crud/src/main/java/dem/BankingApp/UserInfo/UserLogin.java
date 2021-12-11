package dem.BankingApp.UserInfo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name="USERLOGIN")
public class UserLogin {
	@Id
	@Column(name="USER_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private @NotBlank Long userID;
	@Column(name="USERNAME")
	private @NotBlank String userName;
	@Column (name="PASSWORD")
	private @NotBlank String userPassword;

	public UserLogin() {
		super();
	}

	public UserLogin(@NotBlank Long userID, @NotBlank String userName, @NotBlank String userPassword) {
		super();
		this.userID = userID;
		this.userName = userName;
		this.userPassword = userPassword;
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

	public boolean isPresent() {
		// TODO Auto-generated method stub
		return false;
	}

}