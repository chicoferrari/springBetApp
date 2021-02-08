package app.lottery.user;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, String> {

    User findByUserMail(final String userMail);
    
}