package com.i_sys.practise.web.controllers.authentication;

import com.i_sys.practise.core.domains.security.jwt.JwtTokenProvider;
import com.i_sys.practise.core.domains.users.repositories.IUserRepository;
import com.i_sys.practise.web.controllers.authentication.dto.AuthenticationRequestDto;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.HashMap;

//@RestController
//@RequestMapping(value = "/api/v1/auth/")
//public class AuthenticationRestControllerV1 {
//    private final AuthenticationManager authenticationManager;
//
//   private final JwtTokenProvider jwtTokenProvider;
//
//    private final IUserRepository userRepository;
//
//    @Autowired
//    public AuthenticationRestControllerV1(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider, IUserRepository userRepository) {
//        this.authenticationManager = authenticationManager;
//        this.jwtTokenProvider = jwtTokenProvider;
//        this.userRepository = userRepository;
//    }
//
//    @PostMapping("login")
//    public ResponseEntity login(@RequestBody AuthenticationRequestDto requestDto) {
//        try {
//            String username = requestDto.login;
//            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, requestDto.password));
//            var user = userRepository.findByLogin(username);
//
//            if (user == null) {
//                throw new UsernameNotFoundException("User with username: " + username + " not found");
//            }
//
//            String token = jwtTokenProvider.createToken(username, user.GetRoles());
//
//            Map<Object, Object> response = new HashMap<>();
//            response.put("username", username);
//            response.put("token", token);
//
//            return ResponseEntity.ok(response);
//        } catch (AuthenticationException e) {
//            throw new BadCredentialsException("Invalid username or password");
//        }
//    }
//}