package app.lottery.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

	static User findByMail(String userMail) {
		return null;
	}
       
}