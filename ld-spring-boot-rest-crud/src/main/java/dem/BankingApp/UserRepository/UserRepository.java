package dem.BankingApp.UserRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import dem.BankingApp.UserInfo.UserInfo;
public interface UserRepository extends JpaRepository<UserInfo, Long>{

}
