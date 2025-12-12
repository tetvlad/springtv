package std.tetcoshvili.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import std.tetcoshvili.api.entity.sec.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);


}
