package dem.BankingApp.UserRepository;


import org.springframework.data.jpa.repository.JpaRepository;

import dem.BankingApp.UserInfo.UserLogin;
public interface UserLoginRepository extends JpaRepository<UserLogin, Long>{
}
