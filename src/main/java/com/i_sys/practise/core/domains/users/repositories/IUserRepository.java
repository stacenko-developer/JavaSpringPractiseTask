package com.i_sys.practise.core.domains.users.repositories;

import com.i_sys.practise.data.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface IUserRepository extends JpaRepository<User, UUID> {
    User findByLogin(String login);
}
