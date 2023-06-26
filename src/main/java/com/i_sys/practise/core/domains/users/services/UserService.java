package com.i_sys.practise.core.domains.users.services;

import com.i_sys.practise.core.domains.roles.repositories.IRoleRepository;
import com.i_sys.practise.core.domains.users.repositories.IUserRepository;
import com.i_sys.practise.data.roles.Role;
import com.i_sys.practise.data.users.User;
import com.i_sys.practise.web.exceptions.NotFoundException;
import com.i_sys.practise.web.exceptions.ValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class UserService implements IUserService {
    private static final Logger log = LoggerFactory.getLogger(UserService.class.getName());
    private final IUserRepository userRepository;
    private final IRoleRepository roleRepository;
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    public UserService(IUserRepository userRepository, IRoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public List<User> getAllUsers() throws Exception {
        log.info("Call Method of UserService: getAllUsers()");

        var result = userRepository.findAll();

        log.info("Method of UserService: getAllUsers() successfully completed");

        return result;
    }

    public User getUserById(UUID id) throws Exception {
        log.info("Call Method of UserService: getUserById(" + id + ")");

        var user = userRepository.findById(id).orElse(null);

        if (user == null) {
            throw new NotFoundException("The user with the specified id was not found in the system!");
        }

        log.info("Method of UserService: getUserById(" + id + ") successfully completed");

        return user;
    }

    public User getUserByLogin(String login) throws UsernameNotFoundException {
        log.info("Call Method of UserService: getUserByLogin(" + login + ")");

        var user = userRepository.findByLogin(login);

        if (user == null) {
            throw new UsernameNotFoundException("The user with the specified login was not found in the system!");
        }

        log.info("Method of UserService: getUserByLogin(" + login + ") successfully completed");

        return user;
    }

    public void createUser(User user) throws Exception {
        log.info("Call Method of UserService: createUser(" + user + ")");
        var role = roleRepository.findByName("user");

        if (user == null || user.getLogin() == null || user.getPassword() == null) {
            throw new ValidationException("User or user's data are null!");
        }

        if (userRepository.findByLogin(user.getLogin()) != null) {
            throw new ValidationException("User with this login has already registered!");
        }

        if (role == null) {
            throw new Exception("role user is not found in system!");
        }

        userRepository.save(new User(user.getLogin(), passwordEncoder.encode(user.getPassword()),
                new ArrayList<>(Arrays.asList(role))));

        log.info("Call Method of UserService: createUser(" + user + ") successfully completed");
    }

    public void deleteUser(UUID id) throws Exception {
        log.info("Call Method of UserService: deleteUser(" + id + ")");

        var result = userRepository.findById(id).orElse(null);

        if (result == null) {
            throw new NotFoundException("The user with the specified id was not found in the system!");
        }

        userRepository.delete(result);
        log.info("Method of UserService: deleteUser(" + id + ") successfully completed");
    }
}
