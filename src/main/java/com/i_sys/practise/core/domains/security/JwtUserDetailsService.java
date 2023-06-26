package com.i_sys.practise.core.domains.security;

import com.i_sys.practise.core.domains.security.jwt.JwtUserFactory;
import com.i_sys.practise.core.domains.users.repositories.IUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {
    private static final Logger log = LoggerFactory.getLogger(JwtUserDetailsService.class.getName());
    private final IUserRepository userRepository;

    @Autowired
    public JwtUserDetailsService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("Call Method of JwtUserDetailsService: loadUserByUsername(" + username + ")");
        var user = userRepository.findByLogin(username);

        if (user == null)
        {
            throw new UsernameNotFoundException("The user with the specified login was not found in the system!");
        }

        var jwtUser = JwtUserFactory.create(user);
        log.info("Method of JwtUserDetailsService: loadUserByUsername(" + username + ") successfully completed");

        return jwtUser;
    }
}
