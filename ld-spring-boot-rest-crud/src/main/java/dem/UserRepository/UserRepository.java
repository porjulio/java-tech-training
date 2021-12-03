package dem.UserRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import dem.UserInfo.UserInfo;
public interface UserRepository extends JpaRepository<UserInfo, Long>{

}
