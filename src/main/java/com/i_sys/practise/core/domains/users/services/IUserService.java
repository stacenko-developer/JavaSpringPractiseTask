package com.i_sys.practise.core.domains.users.services;

import com.i_sys.practise.data.users.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public interface IUserService {
    List<User> getAllUsers() throws Exception;

    User getUserById(UUID id) throws Exception;

    User getUserByLogin(String login) throws UsernameNotFoundException;

    User createUser(User user) throws Exception;

    void deleteUser(UUID id) throws Exception;
}
